package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * null
 * @author Administrator 
 * 
 */ 
public class CgOrdersInfo extends BaseInfo{ 
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
//	//制单人 
//	private String createUserName; 
//	//制单时间 
//	private String createTime; 
//	//修订人 
//	private String updateUserName; 
//	//修订时间 
//	private String updateTime; 
	//审批人 
	private String approvenPerson; 
	//审批日期 
	private String approvenDate; 
	//审批时间 
	private String approvenTime; 
	private String orderStauts;//表示订单的物资是否全部入库
//	//最后修改时间 
//	private String lastUpdateTime; 
	private int index;
	private int maxPage;
	private String storageStatus;//库存状态
	
	public String getStorageStatus() {
		return storageStatus;
	}
	public void setStorageStatus(String storageStatus) {
		this.storageStatus = storageStatus;
	}
	public CgOrdersInfo(){
	}
    public CgOrdersInfo(String cgId,String company,String businessProcess,String cgZz,String orderNo,String supplyShop,String purchasePerson,String purchaseTeam,String isTh,String orderDate,String batchNo,String remark,String createUserName,String createTime,String updateUserName,String updateTime,String approvenPerson,String approvenDate,String approvenTime,String lastUpdateTime){
		this.cgId=cgId;
		this.company=company;
		this.businessProcess=businessProcess;
		this.cgZz=cgZz;
		this.orderNo=orderNo;
		this.supplyShop=supplyShop;
		this.purchasePerson=purchasePerson;
		this.purchaseTeam=purchaseTeam;
		this.isTh=isTh;
		this.orderDate=orderDate;
		this.batchNo=batchNo;
		this.remark=remark;
//		this.createUserName=createUserName;
//		this.createTime=createTime;
//		this.updateUserName=updateUserName;
//		this.updateTime=updateTime;
		this.approvenPerson=approvenPerson;
		this.approvenDate=approvenDate;
		this.approvenTime=approvenTime;
//		this.lastUpdateTime=lastUpdateTime;
	}
    public CgOrdersInfo(String company,String businessProcess,String cgZz,String orderNo,String supplyShop,String purchasePerson,String purchaseTeam,String isTh,String orderDate,String batchNo,String remark,String createUserName,String createTime,String updateUserName,String updateTime,String approvenPerson,String approvenDate,String approvenTime,String lastUpdateTime){
		this.company=company;
		this.businessProcess=businessProcess;
		this.cgZz=cgZz;
		this.orderNo=orderNo;
		this.supplyShop=supplyShop;
		this.purchasePerson=purchasePerson;
		this.purchaseTeam=purchaseTeam;
		this.isTh=isTh;
		this.orderDate=orderDate;
		this.batchNo=batchNo;
		this.remark=remark;
//		this.createUserName=createUserName;
//		this.createTime=createTime;
//		this.updateUserName=updateUserName;
//		this.updateTime=updateTime;
		this.approvenPerson=approvenPerson;
		this.approvenDate=approvenDate;
		this.approvenTime=approvenTime;
//		this.lastUpdateTime=lastUpdateTime;
	}
	public void setCgId(String cgId){ 
		this.cgId=cgId;
	}
	public String getCgId(){ 
		return this.cgId;
	}
	public void setCompany(String company){ 
		this.company=company;
	}
	public String getCompany(){ 
		return this.company;
	}
	public void setBusinessProcess(String businessProcess){ 
		this.businessProcess=businessProcess;
	}
	public String getBusinessProcess(){ 
		return this.businessProcess;
	}
	public void setCgZz(String cgZz){ 
		this.cgZz=cgZz;
	}
	public String getCgZz(){ 
		return this.cgZz;
	}
	public void setOrderNo(String orderNo){ 
		this.orderNo=orderNo;
	}
	public String getOrderNo(){ 
		return this.orderNo;
	}
	public void setSupplyShop(String supplyShop){ 
		this.supplyShop=supplyShop;
	}
	public String getSupplyShop(){ 
		return this.supplyShop;
	}
	public void setPurchasePerson(String purchasePerson){ 
		this.purchasePerson=purchasePerson;
	}
	public String getPurchasePerson(){ 
		return this.purchasePerson;
	}
	public void setPurchaseTeam(String purchaseTeam){ 
		this.purchaseTeam=purchaseTeam;
	}
	public String getPurchaseTeam(){ 
		return this.purchaseTeam;
	}
	public void setIsTh(String isTh){ 
		this.isTh=isTh;
	}
	public String getIsTh(){ 
		return this.isTh;
	}
	public void setOrderDate(String orderDate){ 
		this.orderDate=orderDate;
	}
	public String getOrderDate(){ 
		return this.orderDate;
	}
	public void setBatchNo(String batchNo){ 
		this.batchNo=batchNo;
	}
	public String getBatchNo(){ 
		return this.batchNo;
	}
	public void setRemark(String remark){ 
		this.remark=remark;
	}
	public String getRemark(){ 
		return this.remark;
	}
	public void setApprovenPerson(String approvenPerson){ 
		this.approvenPerson=approvenPerson;
	}
	public String getApprovenPerson(){ 
		return this.approvenPerson;
	}
	public void setApprovenDate(String approvenDate){ 
		this.approvenDate=approvenDate;
	}
	public String getApprovenDate(){ 
		return this.approvenDate;
	}
	public void setApprovenTime(String approvenTime){ 
		this.approvenTime=approvenTime;
	}
	public String getApprovenTime(){ 
		return this.approvenTime;
	}
//	public void setLastUpdateTime(String lastUpdateTime){ 
//		this.lastUpdateTime=lastUpdateTime;
//	}
//	public String getLastUpdateTime(){ 
//		return this.lastUpdateTime;
//	}
//
//    public String getCreateUserName() {
//		return createUserName;
//	}
//	public void setCreateUserName(String createUserName) {
//		this.createUserName = createUserName;
//	}
//	public String getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(String createTime) {
//		this.createTime = createTime;
//	}
//	public String getUpdateUserName() {
//		return updateUserName;
//	}
//	public void setUpdateUserName(String updateUserName) {
//		this.updateUserName = updateUserName;
//	}
//	public String getUpdateTime() {
//		return updateTime;
//	}
//	public void setUpdateTime(String updateTime) {
//		this.updateTime = updateTime;
//	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public String getOrderStauts() {
		return orderStauts;
	}
	public void setOrderStauts(String orderStauts) {
		this.orderStauts = orderStauts;
	}
	@Override
	public String toString() {
		return "CgOrdersInfo [cgId=" + cgId + ", company=" + company + ", businessProcess=" + businessProcess
				+ ", cgZz=" + cgZz + ", orderNo=" + orderNo + ", supplyShop=" + supplyShop + ", purchasePerson="
				+ purchasePerson + ", purchaseTeam=" + purchaseTeam + ", isTh=" + isTh + ", orderDate=" + orderDate
				+ ", batchNo=" + batchNo + ", remark=" + remark + ", approvenPerson=" + approvenPerson
				+ ", approvenDate=" + approvenDate + ", approvenTime=" + approvenTime + ", orderStauts=" + orderStauts
				+ ", index=" + index + ", maxPage=" + maxPage + "]";
	}
	
}