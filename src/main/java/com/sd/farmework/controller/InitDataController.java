package com.sd.farmework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.PropertiesConstant;
import com.sd.farmework.common.util.SqlDateUtil;
import com.sd.farmework.controller.JDBCPostgresqlUtil;
import com.sd.farmework.pojo.CgOrdersInfo;
import com.sd.farmework.pojo.RemoteObject;
import com.sd.farmework.pojo.RemoteObjectDetail;
import com.sd.farmework.service.CgOrdersInfoService;



/**
 * 采购订单数据初始化
 * @author 王超超
 * 2017-1-06
 * 
 */

@Scope("prototype")
@RequestMapping(value="/adminUtil")
@Controller
public class InitDataController {

	private static Logger logger = Logger.getLogger(InitDataController.class);
	@Autowired
	private CgOrdersInfoService cgOrdersInfoService;
	@Autowired
	private  PropertiesConstant propertiesConstant;
	private JDBCPostgresqlUtil oracleUtil = new JDBCPostgresqlUtil();

	
	@ResponseBody
	@RequestMapping(value = "/getCgOrdersData", method = RequestMethod.GET) 
	public Object  getCgOrdersData(HttpServletRequest request,String startTime,String endTime) throws Exception{
		 
		//System.out.println("初始化数据startTim="+startTime+"\t endTime="+endTime);
		logger.info("初始化数据startTim="+startTime+"\t endTime="+endTime);
		String sql = SqlDateUtil.getSql(startTime, endTime);
		//System.out.println("sql="+sql);
		logger.info("sql="+sql);
		Map map =new HashMap();
		CgOrdersInfo inputDto = null;
		try {
			//获取采购订单基础信息
			oracleUtil.setPropertiesConstant(propertiesConstant);
			List<RemoteObject> list = oracleUtil.getDataInfo(sql);

			System.out.println("订单基础数据查询完成list="+list.toString());
			logger.info("订单基础数据查询完成list="+list.toString());

			List queryList = cgOrdersInfoService.weiCharQueryList(null);	
			//System.out.println("系统数据库订单数据查询完成queryList="+queryList.toString());
			logger.info("系统数据库订单数据查询完成queryList="+queryList.toString());
			
			
			//校验存在与否
			for (int j = 0; j < queryList.size(); j++) {
				CgOrdersInfo obj = (CgOrdersInfo)queryList.get(j);
				for (int i = 0; i < list.size(); i++) {
					RemoteObject remoteObj = (RemoteObject)list.get(i);
					if(obj.getOrderNo().equals(remoteObj.getOrderNo())){
						list.remove(remoteObj);
						//queryObjList.add(remoteObj);
						//System.out.println("当前订单在系统数据库存在OrderNo="+remoteObj.getOrderNo());
						logger.info("当前订单在系统数据库存在OrderNo="+remoteObj.getOrderNo());
					}
				}
			}
			
			
			
			System.out.println("处理后的数据list="+list.toString());
			logger.info("处理后的数据list="+list.toString());

			for (RemoteObject remoteObject : list) {
				//System.out.println("订单编号："+remoteObject.getOrderNo());
				logger.info("订单编号："+remoteObject.getOrderNo());
				inputDto = new CgOrdersInfo();
				inputDto.setCompany(remoteObject.getCompany());		//公司
				inputDto.setBusinessProcess(remoteObject.getBusinessProcess());//业务流程
				inputDto.setCgZz(remoteObject.getCgZz());			//采购组织
				inputDto.setOrderNo(remoteObject.getOrderNo());		//订单编号
				inputDto.setSupplyShop(remoteObject.getSupplyShop());		//供应商
				inputDto.setPurchasePerson(remoteObject.getPurchasePerson());	//采购员
				inputDto.setPurchaseTeam(remoteObject.getPurchaseTeam());	//采购部门
				inputDto.setIsTh(remoteObject.getIsTh());			//是否退货
				inputDto.setOrderDate(remoteObject.getOrderDate());		//订单日期
				inputDto.setBatchNo("");		//批次号
				inputDto.setRemark(remoteObject.getRemark());			//备注
				inputDto.setCreateUserName(remoteObject.getCreateUserName());	//创建人姓名
				inputDto.setLastUpdateUserName(remoteObject.getUpdateUserName());
				//inputDto.setUpdateUserName(remoteObject.getUpdateUserName());	//修改人姓名
				inputDto.setApprovenPerson(remoteObject.getApprovenPerson());	//审批人
				inputDto.setApprovenDate(remoteObject.getApprovenDate());	//审批日期
				inputDto.setOrderStauts(remoteObject.getOrderStauts());	//订单状态
				
				//System.out.println("inputDto="+inputDto.toString());
				//System.out.println("订单号OrderNo="+remoteObject.getOrderNo());
				logger.info("inputDto="+inputDto.toString());
				logger.info("订单号OrderNo="+remoteObject.getOrderNo());
				String detailSql = SqlDateUtil.getDetailSql(remoteObject.getOrderNo());
				//System.out.println("查询详情订单detailSql="+detailSql);
				logger.info("查询详情订单detailSql="+detailSql);

				List<RemoteObjectDetail> detailList = oracleUtil.getDataDetail(detailSql);
				
				//先插入主表数据
				cgOrdersInfoService.addData(inputDto,detailList);
				//System.out.println("当前插入数据完成");
				logger.info("当前插入数据完成");
				
			}
			map.put("code", "000");
			map.put("msg", "操作成功");
			//System.out.println("全部数据完成");
			logger.info("全部数据完成");
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
		
	}
	

	 
 }