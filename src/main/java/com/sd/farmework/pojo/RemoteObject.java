package com.sd.farmework.pojo;

import java.io.Serializable;

import com.sd.farmework.common.BaseInfo;

/**
 * 表数据
 * @author wangchaochao
 * 2016-10-21
 */
public class RemoteObject extends BaseInfo implements Serializable {

	private static final long serialVersionUID = -6754290874794683642L;
	
		//主键 
		private String cgId; 
		//公司 
		private String company; 
		//业务流程 
		private String businessProcess; 
		//采购组织 
		private String cgZz; 
		//订单编号 
		private String orderNo; 
		//供应商 
		private String supplyShop; 
		//采购员 
		private String purchasePerson; 
		//采购部门 
		private String purchaseTeam; 
		//是否退货 
		private String isTh; 
		//订单日期 
		private String orderDate; 
		//批次 
		private String batchNo; 
		//备注 
		private String remark; 
		//制单人 
		private String createUserName; 
		//制单时间 
		private String createTime; 
		//修订人 
		private String updateUserName; 
		//修订时间 
		private String updateTime; 
		//审批人 
		private String approvenPerson; 
		//审批日期 
		private String approvenDate; 
		//审批时间 
		private String approvenTime; 
		private String orderStauts;//表示订单的物资是否全部入库
		//最后修改时间 
		private String lastUpdateTime;
		@Override
		public String toString() {
			return "RemoteObject [cgId=" + cgId + ", company=" + company + ", businessProcess=" + businessProcess
					+ ", cgZz=" + cgZz + ", orderNo=" + orderNo + ", supplyShop=" + supplyShop + ", purchasePerson="
					+ purchasePerson + ", purchaseTeam=" + purchaseTeam + ", isTh=" + isTh + ", orderDate=" + orderDate
					+ ", batchNo=" + batchNo + ", remark=" + remark + ", createUserName=" + createUserName
					+ ", createTime=" + createTime + ", updateUserName=" + updateUserName + ", updateTime=" + updateTime
					+ ", approvenPerson=" + approvenPerson + ", approvenDate=" + approvenDate + ", approvenTime="
					+ approvenTime + ", orderStauts=" + orderStauts + ", lastUpdateTime=" + lastUpdateTime + "]";
		}
		public String getCgId() {
			return cgId;
		}
		public void setCgId(String cgId) {
			this.cgId = cgId;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getBusinessProcess() {
			return businessProcess;
		}
		public void setBusinessProcess(String businessProcess) {
			this.businessProcess = businessProcess;
		}
		public String getCgZz() {
			return cgZz;
		}
		public void setCgZz(String cgZz) {
			this.cgZz = cgZz;
		}
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getSupplyShop() {
			return supplyShop;
		}
		public void setSupplyShop(String supplyShop) {
			this.supplyShop = supplyShop;
		}
		public String getPurchasePerson() {
			return purchasePerson;
		}
		public void setPurchasePerson(String purchasePerson) {
			this.purchasePerson = purchasePerson;
		}
		public String getPurchaseTeam() {
			return purchaseTeam;
		}
		public void setPurchaseTeam(String purchaseTeam) {
			this.purchaseTeam = purchaseTeam;
		}
		public String getIsTh() {
			return isTh;
		}
		public void setIsTh(String isTh) {
			this.isTh = isTh;
		}
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		public String getBatchNo() {
			return batchNo;
		}
		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getCreateUserName() {
			return createUserName;
		}
		public void setCreateUserName(String createUserName) {
			this.createUserName = createUserName;
		}
		public String getCreateTime() {
			return createTime;
		}
		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}
		public String getUpdateUserName() {
			return updateUserName;
		}
		public void setUpdateUserName(String updateUserName) {
			this.updateUserName = updateUserName;
		}
		public String getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		public String getApprovenPerson() {
			return approvenPerson;
		}
		public void setApprovenPerson(String approvenPerson) {
			this.approvenPerson = approvenPerson;
		}
		public String getApprovenDate() {
			return approvenDate;
		}
		public void setApprovenDate(String approvenDate) {
			this.approvenDate = approvenDate;
		}
		public String getApprovenTime() {
			return approvenTime;
		}
		public void setApprovenTime(String approvenTime) {
			this.approvenTime = approvenTime;
		}
		public String getOrderStauts() {
			return orderStauts;
		}
		public void setOrderStauts(String orderStauts) {
			this.orderStauts = orderStauts;
		}
		public String getLastUpdateTime() {
			return lastUpdateTime;
		}
		public void setLastUpdateTime(String lastUpdateTime) {
			this.lastUpdateTime = lastUpdateTime;
		} 
	
	
	
	
	
    
    
}
