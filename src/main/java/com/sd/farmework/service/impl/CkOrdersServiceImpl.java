package com.sd.farmework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.ApprovenUtil;
import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.mapper.CkOrdersMapper;
import com.sd.farmework.mapper.RkOrdersMapper;
import com.sd.farmework.mapper.SysApprovenFunctionRuleMapper;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.mapper.SysApprovenTaskMapper;
import com.sd.farmework.mapper.SysApprovenTaskedMapper;
import com.sd.farmework.pojo.CkOrdersInfo;
import com.sd.farmework.pojo.CkOrdersInfoDetail;
import com.sd.farmework.pojo.RkOrdersInfo;
import com.sd.farmework.pojo.RkOrdersInfoDetail;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.CkOrdersService;

/**
 * 出库管理
 * 
 * @author 秦波
 * @date:2017年1月5日 下午3:26:10
 */
@Service
public class CkOrdersServiceImpl extends BaseInfoServiceImpl implements
		CkOrdersService {

	private static Logger logger = Logger.getLogger(CkOrdersServiceImpl.class);
	@Autowired
	private SysApprovenRulePersonMapper ruleMapper;
	@Autowired
	private SysApprovenTaskMapper sysApprovenTaskMapper;
	@Autowired
	private SysApprovenTaskedMapper sysApprovenTaskedMapper;
	@Autowired
	private SysApprovenFunctionRuleMapper sysApprovenFunctionRuleMapper;
	@Autowired
	private SysApprovenRulePersonMapper SysApprovenRulePersonMapper;
	@Autowired
	private CkOrdersMapper ckOrdersMapper;
	@Autowired
	private CkOrdersMapper baseMapper;
	@Autowired
	private RkOrdersMapper rkOrdersMapper;

	public CkOrdersMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(CkOrdersMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public List<BaseInfo> queryCKDetailList(BaseInfo obj) {
		return this.baseMapper.queryCKDetailList(obj);
	}

	@Override
	public String queryseq() {
		return this.baseMapper.queryseq();
	}

	@Override
	public void setstatus(BaseInfo obj) {
		this.baseMapper.setstatus(obj);
	}

	@Override
	public List<CkOrdersInfo> wxckqueryList(CkOrdersInfo obj) {
		// TODO Auto-generated method stub
		return this.baseMapper.wxckqueryList(obj);
	}

	@Override
	public List<CkOrdersInfo> queryCkShenHe(BaseInfo obj) {
		// TODO Auto-generated method stub
		return this.baseMapper.queryCkShenHe(obj);
	}

	@Override
	public Integer queryCkShenHeCount(BaseInfo obj) {
		// TODO Auto-generated method stub
		return this.baseMapper.queryCkShenHeCount(obj);
	}

	@Override
	public Integer queryCkShenHeCounted(BaseInfo obj) {
		// TODO Auto-generated method stub
		return this.baseMapper.queryCkShenHeCounted(obj);
	}

	@Override
	public List<CkOrdersInfo> queryCkShenHeed(BaseInfo obj) {
		// TODO Auto-generated method stub
		return this.baseMapper.queryCkShenHeed(obj);
	}

	@Override
	public List queryCKDetailListByCkId(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryCKDetailListByCkId(obj);
	}

	@Override
	public void updateByRecNo(BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.updateByRecNo(obj);
	}
	@Override
	public CkOrdersInfo qureyInfoByReNo(BaseInfo obj) {
		// TODO Auto-generated method stub
		return this.baseMapper.qureyInfoByReNo(obj);
	}
	@Override
	public Map addCkApproven(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		
		String approvenFunctionId = (String)request.getAttribute("approvenFunctionId");
		RkOrdersInfo reOrdersInfo = (RkOrdersInfo)request.getAttribute("reOrdersInfo");
		String rkid=(String) request.getAttribute("rkid");
		List rkdetail =(List) request.getAttribute("rkdetail");
		reOrdersInfo= (RkOrdersInfo) httpSessionProvider.fillBaseInfo(reOrdersInfo, sessionUserInfo);
		this.rkOrdersMapper.ckOperation(reOrdersInfo);
		String seq=this.baseMapper.queryseq();
		CkOrdersInfo ckinfo=new CkOrdersInfo();
		ckinfo.setCkId(seq);
		ckinfo.setCkReceiptNo(String.valueOf(System.currentTimeMillis()));
		//修改需要出库基本信息
		this.baseMapper.setstatus(ckinfo);
		CkOrdersInfo ckOrdersInfo = (CkOrdersInfo) this.baseMapper.queryById(ckinfo);
		
		
		for (int i = 0; i < rkdetail.size(); i++) {
			CkOrdersInfoDetail rkdetail1= (CkOrdersInfoDetail) rkdetail.get(i);
			rkdetail1.setCkId(seq);
			rkdetail1=(CkOrdersInfoDetail) httpSessionProvider.fillBaseInfo(rkdetail1, sessionUserInfo);
			this.baseMapper.add(rkdetail1);
		}
		RkOrdersInfo rkorders=new RkOrdersInfo();
		CkOrdersInfo ckorders=new CkOrdersInfo();
		rkorders.setOrderStatus("N");
		rkorders.setRkId(rkid);
		
		//修改订单的是否正在出库的状态
		this.rkOrdersMapper.updateorderstatus(rkorders);
		
		//添加审批人
		SysApprovenRulePerson person=new SysApprovenRulePerson();
		person.setApprovenRuleId("0000000001");
		List list=this.SysApprovenRulePersonMapper.queryList(person);
		String approvenname="";
		for (int i = 0; i < list.size(); i++) {
			person=(SysApprovenRulePerson) list.get(i);
			if(i==list.size()-1){
				approvenname+=person.getApprovenUserName();
			}else{
				approvenname+=person.getApprovenUserName()+",";
			}
		}
		ckorders.setApprovenPerson(approvenname);
		ckorders.setCkId(seq);
		ckorders= (CkOrdersInfo) httpSessionProvider.fillBaseInfo(ckorders, sessionUserInfo);
		this.baseMapper.update(ckorders);
		//审批开始
		 //sys_approven_task
		 SysApprovenTask sysTaskP =new SysApprovenTask();
		 //任务名称
		 sysTaskP.setTaskName(ckOrdersInfo.getReceiptNo()+"-"+ckinfo.getCkReceiptNo());
		 //业务表名
		 sysTaskP.setSourceTable("Ck_Orders_Info");
		 //业务表主键名称
		 sysTaskP.setSourceTablePkColumnName("ck_Id");
		 //业务表主键对应值
		 sysTaskP.setSourceTablePkColumnValue(seq);
		 //审批工具类
		 ApprovenUtil appr = new ApprovenUtil();
		 //请假调休审批 0000000001 sys_approven_function_rule
		 sysTaskP = (SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTaskP, sessionUserInfo);
		 Map map= appr.addApprovenTask(session, request, response, approvenFunctionId,sysTaskP,sysApprovenTaskMapper,ruleMapper,sysApprovenFunctionRuleMapper);
		 if(!map.get("code").equals("000")){
			 throw new Exception(map.get("code").toString());
		 }
		 return map;
	}

	@Override
	public Map doApproven(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, SysApprovenTask obj,
			String approvenFunctionId) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 审批功能编号
			ApprovenUtil appr = new ApprovenUtil();
			map = appr.doApproven(session, request, response,
					obj, sysApprovenTaskMapper, sysApprovenTaskedMapper,
					approvenFunctionId);
			List<BaseInfo> sysApprovenTaskList = (List<BaseInfo>) map
					.get("sysApprovenTaskList");
			// 审核通过
			CkOrdersInfo objP = new CkOrdersInfo();
			objP.setCkId(map.get("sourceId").toString());
			// 查询出库单的信息
			CkOrdersInfo queryByIdCkInfo = (CkOrdersInfo) ckOrdersMapper
					.queryById(objP);
			// 审核不通过
			if ("2".equals(obj.getApprovenResult())) {
				// 1，修改出库单的的状态
				objP.setStatus("2");
				objP.setApprovenTime("123");//不为空即可
				ckOrdersMapper.update(objP);
				for (int i = 0; i < sysApprovenTaskList.size(); i++) {
					sysApprovenTaskMapper.delete(sysApprovenTaskList.get(i));
				}
				// 2，修改入库订单状态
				RkOrdersInfo rkOrdersInfo = new RkOrdersInfo();
				rkOrdersInfo.setReceiptNo(queryByIdCkInfo.getReceiptNo());
				rkOrdersInfo.setOrderStatus("Y");
				rkOrdersMapper.updateOrderstatusByReceiptNo(rkOrdersInfo);
			} else {
				if (sysApprovenTaskList == null || sysApprovenTaskList.size() == 0) {
					// 1.先修改出库订单的状态
					objP.setStatus("1");
					objP.setApprovenTime("123");//不为空即可
					ckOrdersMapper.update(objP);
					// 2.修改入库订单状态
					RkOrdersInfo rkOrdersInfo = new RkOrdersInfo();
					rkOrdersInfo.setReceiptNo(queryByIdCkInfo.getReceiptNo());
					rkOrdersInfo.setOrderStatus("Y");
					rkOrdersMapper.updateOrderstatusByReceiptNo(rkOrdersInfo);
					// 3.再修改入库订单上物资的数量(此步骤为查询出库订单上的物资信息)
					List detailList = ckOrdersMapper.queryCKDetailListByCkId(objP);
					// 4.通过入库单据号查询入库ID 查询入库的id 再通过入库id 查询入库物资信息 子查询（查询入库物资信息）
					List queryByReceiptNoList = rkOrdersMapper
							.queryByReceiptNo(rkOrdersInfo);
					for (int i = 0; i < detailList.size(); i++) {
						CkOrdersInfoDetail ckOrdersInfoDetail = (CkOrdersInfoDetail) detailList
								.get(i);
						for (int j = 0; j < queryByReceiptNoList.size(); j++) {
							RkOrdersInfoDetail rkOrdersInfoDetail = (RkOrdersInfoDetail) queryByReceiptNoList
									.get(j);
							if (ckOrdersInfoDetail.getStockNo().equals(
									rkOrdersInfoDetail.getStockNo())) {
								RkOrdersInfoDetail rkOrdersInfoDetail1 = new RkOrdersInfoDetail();
								rkOrdersInfoDetail1.setRealNum(ckOrdersInfoDetail
										.getrealNum());
								rkOrdersInfoDetail1.setDetailId(rkOrdersInfoDetail
										.getDetailId());
								rkOrdersMapper.updateNum(rkOrdersInfoDetail1);
							}
						}
					}
				}
			}
			map.put("code", "000");
			map.put("msg", "success");
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", "001");
			map.put("msg", "fail");
			return map;
		}
		
	}

}
