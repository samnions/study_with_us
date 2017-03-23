package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * null
 * @author Administrator 
 * 
 */ 
public class RkOrdersInfo extends BaseInfo{ 
	//主键 
	private String rkId; 
	private String orderNo;
	//单据号 
	private String receiptNo; 
	//单据日期 
	private String receiptDate; 
	//仓库 
	private String warehouse; 
	//库存组织 
	private String stockTeam; 
	//业务流程 
	private String businessProcess; 
	//收发类别 
	private String dispatcherType; 
	//库管员 
	private String stockManager; 
	//采购部门 
	private String cgTeam; 
	//采购员 
	private String purchasePerson; 
	//供应商 
	private String supplyShop; 
	//备注 
	private String remark; 
	//状态 
	private String status; 
	private String status1;
	//是否退库 
	private String isTk; 
	//已生成设备卡片 
	private String createCard; 
	//制单时间 
	private String createTime; 
	//制单人 
	private String createUserName; 
	//签字人 
	private String signPerson; 
	//签字时间 
	private String signTime; 
	//审核人 
	private String approvenPerson; 
	//审核时间 
	private String approvenTime; 
	//最高库存 
	private String maxStock; 
	//最低库存 
	private String minStock; 
	//安全库存 
	private String securityStock; 
	//条形码 
	private String barCode; 
	//最后修改人 
	private String lastUpdateUserName; 
	//最后修改时间 
	private String lastUpdateTime; 
	//打印次数 
	private String printNum; 
	//是否正在审核（是/否）
	private String orderStatus;
	//是否上传
	private String uploadStatus;
	private int index = 0;
	private int maxPage =0;
	
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
    public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	public RkOrdersInfo(){
	}
    public RkOrdersInfo(String rkId,String receiptNo,String receiptDate,String warehouse,String stockTeam,String businessProcess,String dispatcherType,String stockManager,String cgTeam,String purchasePerson,String supplyShop,String remark,String status,String isTk,String createCard,String createTime,String createUserName,String signPerson,String signTime,String approvenPerson,String approvenTime,String maxStock,String minStock,String securityStock,String barCode,String lastUpdateUserName,String lastUpdateTime,String printNum){
		this.rkId=rkId;
		this.receiptNo=receiptNo;
		this.receiptDate=receiptDate;
		this.warehouse=warehouse;
		this.stockTeam=stockTeam;
		this.businessProcess=businessProcess;
		this.dispatcherType=dispatcherType;
		this.stockManager=stockManager;
		this.cgTeam=cgTeam;
		this.purchasePerson=purchasePerson;
		this.supplyShop=supplyShop;
		this.remark=remark;
		this.status=status;
		this.isTk=isTk;
		this.createCard=createCard;
		this.createTime=createTime;
		this.createUserName=createUserName;
		this.signPerson=signPerson;
		this.signTime=signTime;
		this.approvenPerson=approvenPerson;
		this.approvenTime=approvenTime;
		this.maxStock=maxStock;
		this.minStock=minStock;
		this.securityStock=securityStock;
		this.barCode=barCode;
		this.lastUpdateUserName=lastUpdateUserName;
		this.lastUpdateTime=lastUpdateTime;
		this.printNum=printNum;
	}
    public RkOrdersInfo(String receiptNo,String receiptDate,String warehouse,String stockTeam,String businessProcess,String dispatcherType,String stockManager,String cgTeam,String purchasePerson,String supplyShop,String remark,String status,String isTk,String createCard,String createTime,String createUserName,String signPerson,String signTime,String approvenPerson,String approvenTime,String maxStock,String minStock,String securityStock,String barCode,String lastUpdateUserName,String lastUpdateTime,String printNum){
		this.receiptNo=receiptNo;
		this.receiptDate=receiptDate;
		this.warehouse=warehouse;
		this.stockTeam=stockTeam;
		this.businessProcess=businessProcess;
		this.dispatcherType=dispatcherType;
		this.stockManager=stockManager;
		this.cgTeam=cgTeam;
		this.purchasePerson=purchasePerson;
		this.supplyShop=supplyShop;
		this.remark=remark;
		this.status=status;
		this.isTk=isTk;
		this.createCard=createCard;
		this.createTime=createTime;
		this.createUserName=createUserName;
		this.signPerson=signPerson;
		this.signTime=signTime;
		this.approvenPerson=approvenPerson;
		this.approvenTime=approvenTime;
		this.maxStock=maxStock;
		this.minStock=minStock;
		this.securityStock=securityStock;
		this.barCode=barCode;
		this.lastUpdateUserName=lastUpdateUserName;
		this.lastUpdateTime=lastUpdateTime;
		this.printNum=printNum;
	}
	public void setRkId(String rkId){ 
		this.rkId=rkId;
	}
	public String getRkId(){ 
		return this.rkId;
	}
	public void setReceiptNo(String receiptNo){ 
		this.receiptNo=receiptNo;
	}
	public String getReceiptNo(){ 
		return this.receiptNo;
	}
	public void setReceiptDate(String receiptDate){ 
		this.receiptDate=receiptDate;
	}
	public String getReceiptDate(){ 
		return this.receiptDate;
	}
	public void setWarehouse(String warehouse){ 
		this.warehouse=warehouse;
	}
	public String getWarehouse(){ 
		return this.warehouse;
	}
	public void setStockTeam(String stockTeam){ 
		this.stockTeam=stockTeam;
	}
	public String getStockTeam(){ 
		return this.stockTeam;
	}
	public void setBusinessProcess(String businessProcess){ 
		this.businessProcess=businessProcess;
	}
	public String getBusinessProcess(){ 
		return this.businessProcess;
	}
	public void setDispatcherType(String dispatcherType){ 
		this.dispatcherType=dispatcherType;
	}
	public String getDispatcherType(){ 
		return this.dispatcherType;
	}
	public void setStockManager(String stockManager){ 
		this.stockManager=stockManager;
	}
	public String getStockManager(){ 
		return this.stockManager;
	}
	public void setCgTeam(String cgTeam){ 
		this.cgTeam=cgTeam;
	}
	public String getCgTeam(){ 
		return this.cgTeam;
	}
	public void setPurchasePerson(String purchasePerson){ 
		this.purchasePerson=purchasePerson;
	}
	public String getPurchasePerson(){ 
		return this.purchasePerson;
	}
	public void setSupplyShop(String supplyShop){ 
		this.supplyShop=supplyShop;
	}
	public String getSupplyShop(){ 
		return this.supplyShop;
	}
	public void setRemark(String remark){ 
		this.remark=remark;
	}
	public String getRemark(){ 
		return this.remark;
	}
	public void setStatus(String status){ 
		this.status=status;
	}
	public String getStatus(){ 
		return this.status;
	}
	public void setIsTk(String isTk){ 
		this.isTk=isTk;
	}
	public String getIsTk(){ 
		return this.isTk;
	}
	public void setCreateCard(String createCard){ 
		this.createCard=createCard;
	}
	public String getCreateCard(){ 
		return this.createCard;
	}
	public void setSignPerson(String signPerson){ 
		this.signPerson=signPerson;
	}
	public String getSignPerson(){ 
		return this.signPerson;
	}
	public void setSignTime(String signTime){ 
		this.signTime=signTime;
	}
	public String getSignTime(){ 
		return this.signTime;
	}
	public void setApprovenPerson(String approvenPerson){ 
		this.approvenPerson=approvenPerson;
	}
	public String getApprovenPerson(){ 
		return this.approvenPerson;
	}
	public void setApprovenTime(String approvenTime){ 
		this.approvenTime=approvenTime;
	}
	public String getApprovenTime(){ 
		return this.approvenTime;
	}
	public void setMaxStock(String maxStock){ 
		this.maxStock=maxStock;
	}
	public String getMaxStock(){ 
		return this.maxStock;
	}
	public void setMinStock(String minStock){ 
		this.minStock=minStock;
	}
	public String getMinStock(){ 
		return this.minStock;
	}
	public void setSecurityStock(String securityStock){ 
		this.securityStock=securityStock;
	}
	public String getSecurityStock(){ 
		return this.securityStock;
	}
	public void setBarCode(String barCode){ 
		this.barCode=barCode;
	}
	public String getBarCode(){ 
		return this.barCode;
	}
	public void setLastUpdateUserName(String lastUpdateUserName){ 
		this.lastUpdateUserName=lastUpdateUserName;
	}
	public String getLastUpdateUserName(){ 
		return this.lastUpdateUserName;
	}
	public void setLastUpdateTime(String lastUpdateTime){ 
		this.lastUpdateTime=lastUpdateTime;
	}
	public String getLastUpdateTime(){ 
		return this.lastUpdateTime;
	}
	public void setPrintNum(String printNum){ 
		this.printNum=printNum;
	}
	public String getPrintNum(){ 
		return this.printNum;
	}
	@Override
	public String toString() {
		return "RkOrdersInfo[rkId=" + rkId+",receiptNo=" + receiptNo+",receiptDate=" + receiptDate+",warehouse=" + warehouse+",stockTeam=" + stockTeam+",businessProcess=" + businessProcess+",dispatcherType=" + dispatcherType+",stockManager=" + stockManager+",cgTeam=" + cgTeam+",purchasePerson=" + purchasePerson+",supplyShop=" + supplyShop+",remark=" + remark+",status=" + status+",isTk=" + isTk+",createCard=" + createCard+",createTime=" + createTime+",createUserName=" + createUserName+",signPerson=" + signPerson+",signTime=" + signTime+",approvenPerson=" + approvenPerson+",approvenTime=" + approvenTime+",maxStock=" + maxStock+",minStock=" + minStock+",securityStock=" + securityStock+",barCode=" + barCode+",lastUpdateUserName=" + lastUpdateUserName+",lastUpdateTime=" + lastUpdateTime+",printNum=" + printNum+"]";
	}
}