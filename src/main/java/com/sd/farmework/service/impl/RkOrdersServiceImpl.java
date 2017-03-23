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
import com.sd.farmework.mapper.CgOrdersInfoMapper;
import com.sd.farmework.mapper.RkOrdersMapper;
import com.sd.farmework.mapper.SysApprovenFunctionRuleMapper;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper;
import com.sd.farmework.mapper.SysApprovenTaskMapper;
import com.sd.farmework.mapper.SysApprovenTaskedMapper;
import com.sd.farmework.pojo.CgOrdersInfo;
import com.sd.farmework.pojo.CgOrdersInfoDetail;
import com.sd.farmework.pojo.RkOrdersInfo;
import com.sd.farmework.pojo.RkOrdersInfoDetail;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.RkOrdersService;
import com.sd.farmework.service.SysApprovenTaskService;
import com.sd.farmework.service.SysApprovenTaskedService;

/**
 * 出库管理
 * 
 * @author 秦波
 * @date:2017年1月5日 下午3:26:10
 */
@Service
public class RkOrdersServiceImpl extends BaseInfoServiceImpl implements
		RkOrdersService {

	private static Logger logger = Logger.getLogger(RkOrdersServiceImpl.class);
	@Autowired
	private SysApprovenRulePersonMapper ruleMapper;
	@Autowired
	private SysApprovenTaskMapper sysApprovenTaskMapper;
	@Autowired
	private SysApprovenTaskedMapper sysApprovenTaskedMapper;
	@Autowired
	private SysApprovenFunctionRuleMapper sysApprovenFunctionRuleMapper;

	@Autowired
	private CgOrdersInfoMapper cgOrdersInfoMapper;
	
	@Autowired
	private RkOrdersMapper baseMapper;

	public RkOrdersMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(RkOrdersMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public List<BaseInfo> queryRKDetailList(BaseInfo obj) {
		return this.baseMapper.queryRKDetailList(obj);
	}

	@Override
	public String querySqe() {
		// TODO Auto-generated method stub
		return baseMapper.querySqe();
	}

	@Override
	public void addRkCgOrderInfo(BaseInfo obj, List list) {

		// TODO Auto-generated method stub
		baseMapper.addRkCgOrderInfo(obj);

		baseMapper.addRkCgOrderDetailInfo((BaseInfo) list.get(0));

	}

	@Override
	public void addRkCgOrderDetailInfo(BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.addRkCgOrderDetailInfo(obj);
	}

	@Override
	public void ckOperation(BaseInfo obj) {
		this.baseMapper.ckOperation(obj);
	}

	@Override
	public void ckDetailOperation(BaseInfo obj) {
		this.baseMapper.ckDetailOperation(obj);
	}

	@Override
	public void subnum(BaseInfo obj) {
		this.baseMapper.subnum(obj);
	}

	@Override
	public List<RkOrdersInfo> wxqueryList(RkOrdersInfo rkOrdersInfo) {
		// TODO Auto-generated method stub
		return this.baseMapper.wxqueryList(rkOrdersInfo);
	}

	@Override
	public RkOrdersInfo wxqueryRkInfoDetaillist(RkOrdersInfo rkOrdersInfo) {
		// TODO Auto-generated method stub
		return this.baseMapper.wxqueryRkInfoDetaillist(rkOrdersInfo);
	}

	@Override
	public List<RkOrdersInfo> queryRkInfo(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryRkInfo(obj);
	}

	@Override
	public void updateorderstatus(BaseInfo obj) {
		this.baseMapper.updateorderstatus(obj);

	}

	@Override
	public List<RkOrdersInfoDetail> wxShqueryRkInfoDetaillist(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.wxShqueryRkInfoDetaillist(obj);
	}

	@Override
	public RkOrdersInfo qureyOrderNo(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.qureyOrderNo(obj);
	}

	@Override
	public List<RkOrdersInfo> queryRkShenHe(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryRkShenHe(obj);
	}

	@Override
	public Integer queryRkShenHeCount(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryRkShenHeCount(obj);
	}

	@Override
	public Integer queryRkShenHeCounted(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryRkShenHeCounted(obj);
	}

	@Override
	public List<RkOrdersInfo> queryRkShenHeed(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryRkShenHeed(obj);
	}

	@Override
	public void updateOrderstatusByReceiptNo(BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.updateOrderstatusByReceiptNo(obj);
	}

	@Override
	public List queryByReceiptNo(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryByReceiptNo(obj);
	}

	@Override
	public void updateNum(BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.updateNum(obj);
	}

	@Override
	public void updateByRecNo (BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.updateByRecNo (obj);
	}
	@Override
	public RkOrdersInfo qureyInfoByReNo(BaseInfo obj) {
		// TODO Auto-generated method stub
		return this.baseMapper.qureyInfoByReNo(obj);
	}
	@Override
	public Map addApproven(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String approvenFunctionId = (String) request
				.getAttribute("approvenFunctionId");
		RkOrdersInfo obj = (RkOrdersInfo) request.getAttribute("obj");
		List cgDtalList = (List) request.getAttribute("cgDtalList");
		List<List> allList = (List) request.getAttribute("allList");

		HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
		SysUserInfo sessionUserInfo = httpSessionProvider
				.getCurrentUserSession(session, request, response);
		obj = (RkOrdersInfo) httpSessionProvider.fillBaseInfo(obj,
				sessionUserInfo);
		// start
		baseMapper.addRkCgOrderInfo(obj);
		for (int i = 0; i < cgDtalList.size(); i++) {
			CgOrdersInfoDetail CgOrdersInfoDetail = (CgOrdersInfoDetail) cgDtalList
					.get(i);
			for (int j = 0; j < allList.size(); j++) {
				if (CgOrdersInfoDetail.getStockName().equals(
						allList.get(j).get(0))) {
					if (!"0".equals(allList.get(j).get(1).toString().trim())) {
						RkOrdersInfoDetail rkOrdersInfoDetail = new RkOrdersInfoDetail();
						rkOrdersInfoDetail.setRkId(obj.getRkId());
						rkOrdersInfoDetail.setStockNo(CgOrdersInfoDetail
								.getStockNo());
						rkOrdersInfoDetail.setStockName(CgOrdersInfoDetail
								.getStockName());
						rkOrdersInfoDetail.setStandard(CgOrdersInfoDetail
								.getStandard());
						rkOrdersInfoDetail
								.setUnit(CgOrdersInfoDetail.getUnit());
						rkOrdersInfoDetail.setRealNum(allList.get(j).get(1)
								.toString());
						rkOrdersInfoDetail.setPrice(CgOrdersInfoDetail
								.getPrice());
						rkOrdersInfoDetail.setAmount(String.valueOf(Double
								.valueOf(CgOrdersInfoDetail.getPrice())
								* Integer.parseInt(allList.get(j).get(1)
										.toString())));
						rkOrdersInfoDetail.setCreateUserName("111");
						rkOrdersInfoDetail.setCreateUserId("1111");
						baseMapper.addRkCgOrderDetailInfo(rkOrdersInfoDetail);
					}

					/**
					 * 未审核通过时 新建出库订单 将数量变为相应的数据
					 * 
					 */
					// int aNum =
					// Integer.parseInt(CgOrdersInfoDetail.getNum())-Integer.parseInt(allList.get(i).get(1).toString());
					// CgDetail.setNum(allList.get(i).get(1).toString());
					// CgDetail.setDetailId(CgOrdersInfoDetail.getDetailId());
					// cgOrdersInfoService.updateRkCgOrderDetailInfo(CgDetail);
				}
			}
		}
		CgOrdersInfo c = (CgOrdersInfo) request.getAttribute("c");
		c.setOrderStauts("N");
		cgOrdersInfoMapper.updateRkCgOrdeInfoStauts(c);
		// end
		// 审批开始
		// sys_approven_task
		SysApprovenTask sysTaskP = new SysApprovenTask();
		// 任务名称
		sysTaskP.setTaskName(c.getOrderNo()+"-"+obj.getReceiptNo());
		// 业务表名
		sysTaskP.setSourceTable("Rk_Orders_Info");
		// 业务表主键名称
		sysTaskP.setSourceTablePkColumnName("rk_Id");
		// 业务表主键对应值
		sysTaskP.setSourceTablePkColumnValue(obj.getRkId() + "");

		// 审批工具类
		ApprovenUtil appr = new ApprovenUtil();
		// 请假调休审批 0000000001 sys_approven_function_rule
		sysTaskP = (SysApprovenTask) httpSessionProvider.fillBaseInfo(sysTaskP,
				sessionUserInfo);
		Map map = appr.addApprovenTask(session, request, response,
				approvenFunctionId, sysTaskP, sysApprovenTaskMapper,
				ruleMapper, sysApprovenFunctionRuleMapper);
		if (!map.get("code").equals("000")) {
			throw new Exception(map.get("code").toString());
		}
		return map;

	}

	@Override
	public Map<String, Object> doApproven(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysApprovenTask obj, SysApprovenTaskService sysApprovenTaskService,
			SysApprovenTaskedService sysApprovenTaskedService,
			String approvenFunctionId) throws Exception {

		// 审批功能编号map
		Map<String, Object> map = new HashMap();
		try {
			ApprovenUtil appr = new ApprovenUtil();
			map = appr.doApproven(session, request, response, obj,
					sysApprovenTaskMapper, sysApprovenTaskedMapper,
					approvenFunctionId);
			List<BaseInfo> sysApprovenTaskList = (List<BaseInfo>) map
					.get("sysApprovenTaskList");
			// 审核通过
			RkOrdersInfo objP = new RkOrdersInfo();
			objP.setRkId(map.get("sourceId").toString());
			// 查询入库订单 approvenTaskObj
			RkOrdersInfo qureyOrderNo = this.baseMapper.qureyOrderNo(objP);
			// 审核不通过
			if ("2".equals(obj.getApprovenResult())) {
				objP.setStatus("2");
				objP.setOrderStatus("B");
				// 修改入库订单的审核状态
				this.baseMapper.update(objP);
				for (int i = 0; i < sysApprovenTaskList.size(); i++) {
					sysApprovenTaskMapper.delete(sysApprovenTaskList.get(i));
				}
				CgOrdersInfo cgOrdersInfo = new CgOrdersInfo();
				cgOrdersInfo.setOrderStauts("Y");
				cgOrdersInfo.setOrderNo(qureyOrderNo.getOrderNo());
				cgOrdersInfoMapper.updateRkCgOrdeInfoStauts(cgOrdersInfo);

				} else {
				if(sysApprovenTaskList==null||sysApprovenTaskList.size()==0){
					objP.setStatus("1");
					objP.setOrderStatus("Y");
					this.baseMapper.update(objP);
					// 写发送短信或者其他业务操作
					RkOrdersInfoDetail rkOrdersInfoDetail = new RkOrdersInfoDetail();
					rkOrdersInfoDetail.setRkId(objP.getRkId());
					List<RkOrdersInfoDetail> wxShqueryRkInfoDetaillist = this.baseMapper
							.wxShqueryRkInfoDetaillist(rkOrdersInfoDetail);
					for (int i = 0; i < wxShqueryRkInfoDetaillist.size(); i++) {
						RkOrdersInfoDetail rkOrdersInfoDetail2 = wxShqueryRkInfoDetaillist
								.get(i);
						CgOrdersInfoDetail cgOrdersInfoDetail = new CgOrdersInfoDetail();
						cgOrdersInfoDetail.setNum(rkOrdersInfoDetail2.getRealNum());
						cgOrdersInfoDetail.setStockNo(rkOrdersInfoDetail2
								.getStockNo());
						cgOrdersInfoMapper.updateNum(cgOrdersInfoDetail);
					}
					CgOrdersInfo cgOrdersInfo = new CgOrdersInfo();
					cgOrdersInfo.setOrderStauts("Y");
					cgOrdersInfo.setOrderNo(qureyOrderNo.getOrderNo());
					cgOrdersInfoMapper.updateRkCgOrdeInfoStauts(cgOrdersInfo);
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
