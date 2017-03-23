package com.sd.farmework.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sd.farmework.common.PropertiesConstant;
import com.sd.farmework.common.util.SqlDateUtil;
import com.sd.farmework.controller.JDBCPostgresqlUtil;
import com.sd.farmework.pojo.CgOrdersInfo;
import com.sd.farmework.pojo.RemoteObject;
import com.sd.farmework.pojo.RemoteObjectDetail;
import com.sd.farmework.service.CgOrdersInfoService;




public class MyTimerTask {
	private static int num = 0;
	@Autowired
	private  PropertiesConstant propertiesConstant;
	private JDBCPostgresqlUtil oracleUtil = new JDBCPostgresqlUtil();
	@Autowired
	private CgOrdersInfoService cgOrdersInfoService;
	
	public void run(){
		num++;
		System.out.println("第"+num+"次开始自动执行获取数据");
		String sql = SqlDateUtil.getSql(null, null);
		System.out.println("参数sql语句="+sql);
		
		CgOrdersInfo inputDto = null;
		try {
			//获取采购订单基础信息
			oracleUtil.setPropertiesConstant(propertiesConstant);
			List<RemoteObject> list = oracleUtil.getDataInfo(sql);
			System.out.println("订单基础数据查询完成list="+list.toString());

			List queryList = cgOrdersInfoService.weiCharQueryList(null);	
			System.out.println("系统数据库订单数据查询完成queryList="+queryList.toString());
			
			//校验存在与否
			for (int j = 0; j < queryList.size(); j++) {
				CgOrdersInfo obj = (CgOrdersInfo)queryList.get(j);
				for (int i = 0; i < list.size(); i++) {
					RemoteObject remoteObj = (RemoteObject)list.get(i);
					if(obj.getOrderNo().equals(remoteObj.getOrderNo())){
						list.remove(remoteObj);
						//queryObjList.add(remoteObj);
						System.out.println("当前订单在系统数据库存在OrderNo="+remoteObj.getOrderNo());
					}
				}
			}
			System.out.println("处理后的数据list="+list.toString());

			for (RemoteObject remoteObject : list) {
				System.out.println("订单编号："+remoteObject.getOrderNo());
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
				
				System.out.println("inputDto="+inputDto.toString());
				System.out.println("订单号OrderNo="+remoteObject.getOrderNo());
				String detailSql = SqlDateUtil.getDetailSql(remoteObject.getOrderNo());
				System.out.println("查询详情订单detailSql="+detailSql);

				List<RemoteObjectDetail> detailList = oracleUtil.getDataDetail(detailSql);
				
				//先插入主表数据
				cgOrdersInfoService.addData(inputDto,detailList);
				System.out.println("当前插入数据完成");
			}
			
			
			System.out.println("全部数据完成");
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
