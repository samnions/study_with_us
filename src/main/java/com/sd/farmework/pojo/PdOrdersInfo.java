package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * null
 * @author Administrator 
 * 
 */ 
public class PdOrdersInfo extends BaseInfo{ 
	//单据号 
	private String receiptNo; 
	//单据日期 
	private String receiptDate; 
	//盘点日期 
	private String inventoryDate; 
	//仓库 
	private String warehouse; 
	//部门 
	private String department; 
	//库管员 
	private String stockManager; 
	//盘点人 
	private String inventoryPerson; 
	//备注 
	private String remark; 
	//调整人 
	private String adjustPerson; 
	//最高库存 
	private String maxStock; 
	//最低库存 
	private String minStock; 
	//主键id 
	private String pdId; 
	//安全库存 
	private String securityStock; 
	//再订购点 
	private String reorderPoint; 
	//打印次数 
	private String printNum; 
	//条形码 
	private String barCode; 
	//状态 
	private String status;
	private String status1;
	//上传状态
	private String uploadStatus;
	int index = 0;
	int maxPage =0;
	
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
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
	//审批人 
	private String approvenPerson; 
	//审批时间 
	private String approvenTime; 
	//制单人 
	private String createUserName; 
	//制单时间 
	private String createTime; 
	//最后修改人 
	private String lastUpdateUserName; 
	//最后修改时间 
	private String lastUpdateTime; 
    public PdOrdersInfo(){
	}
    public PdOrdersInfo(String receiptNo,String receiptDate,String inventoryDate,String warehouse,String department,String stockManager,String inventoryPerson,String remark,String adjustPerson,String maxStock,String minStock,String pdId,String securityStock,String reorderPoint,String printNum,String barCode,String status,String approvenPerson,String approvenTime,String createUserName,String createTime,String lastUpdateUserName,String lastUpdateTime){
		this.receiptNo=receiptNo;
		this.receiptDate=receiptDate;
		this.inventoryDate=inventoryDate;
		this.warehouse=warehouse;
		this.department=department;
		this.stockManager=stockManager;
		this.inventoryPerson=inventoryPerson;
		this.remark=remark;
		this.adjustPerson=adjustPerson;
		this.maxStock=maxStock;
		this.minStock=minStock;
		this.pdId=pdId;
		this.securityStock=securityStock;
		this.reorderPoint=reorderPoint;
		this.printNum=printNum;
		this.barCode=barCode;
		this.status=status;
		this.approvenPerson=approvenPerson;
		this.approvenTime=approvenTime;
		this.createUserName=createUserName;
		this.createTime=createTime;
		this.lastUpdateUserName=lastUpdateUserName;
		this.lastUpdateTime=lastUpdateTime;
	}
    public PdOrdersInfo(String receiptDate,String inventoryDate,String warehouse,String department,String stockManager,String inventoryPerson,String remark,String adjustPerson,String maxStock,String minStock,String pdId,String securityStock,String reorderPoint,String printNum,String barCode,String status,String approvenPerson,String approvenTime,String createUserName,String createTime,String lastUpdateUserName,String lastUpdateTime){
		this.receiptDate=receiptDate;
		this.inventoryDate=inventoryDate;
		this.warehouse=warehouse;
		this.department=department;
		this.stockManager=stockManager;
		this.inventoryPerson=inventoryPerson;
		this.remark=remark;
		this.adjustPerson=adjustPerson;
		this.maxStock=maxStock;
		this.minStock=minStock;
		this.pdId=pdId;
		this.securityStock=securityStock;
		this.reorderPoint=reorderPoint;
		this.printNum=printNum;
		this.barCode=barCode;
		this.status=status;
		this.approvenPerson=approvenPerson;
		this.approvenTime=approvenTime;
		this.createUserName=createUserName;
		this.createTime=createTime;
		this.lastUpdateUserName=lastUpdateUserName;
		this.lastUpdateTime=lastUpdateTime;
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
	public void setInventoryDate(String inventoryDate){ 
		this.inventoryDate=inventoryDate;
	}
	public String getInventoryDate(){ 
		return this.inventoryDate;
	}
	public void setWarehouse(String warehouse){ 
		this.warehouse=warehouse;
	}
	public String getWarehouse(){ 
		return this.warehouse;
	}
	public void setDepartment(String department){ 
		this.department=department;
	}
	public String getDepartment(){ 
		return this.department;
	}
	public void setStockManager(String stockManager){ 
		this.stockManager=stockManager;
	}
	public String getStockManager(){ 
		return this.stockManager;
	}
	public void setInventoryPerson(String inventoryPerson){ 
		this.inventoryPerson=inventoryPerson;
	}
	public String getInventoryPerson(){ 
		return this.inventoryPerson;
	}
	public void setRemark(String remark){ 
		this.remark=remark;
	}
	public String getRemark(){ 
		return this.remark;
	}
	public void setAdjustPerson(String adjustPerson){ 
		this.adjustPerson=adjustPerson;
	}
	public String getAdjustPerson(){ 
		return this.adjustPerson;
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
	public void setPdId(String pdId){ 
		this.pdId=pdId;
	}
	public String getPdId(){ 
		return this.pdId;
	}
	public void setSecurityStock(String securityStock){ 
		this.securityStock=securityStock;
	}
	public String getSecurityStock(){ 
		return this.securityStock;
	}
	public void setReorderPoint(String reorderPoint){ 
		this.reorderPoint=reorderPoint;
	}
	public String getReorderPoint(){ 
		return this.reorderPoint;
	}
	public void setPrintNum(String printNum){ 
		this.printNum=printNum;
	}
	public String getPrintNum(){ 
		return this.printNum;
	}
	public void setBarCode(String barCode){ 
		this.barCode=barCode;
	}
	public String getBarCode(){ 
		return this.barCode;
	}
	public void setStatus(String status){ 
		this.status=status;
	}
	public String getStatus(){ 
		return this.status;
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
	@Override
	public String toString() {
		return "PdOrdersInfo[receiptNo=" + receiptNo+",receiptDate=" + receiptDate+",inventoryDate=" + inventoryDate+",warehouse=" + warehouse+",department=" + department+",stockManager=" + stockManager+",inventoryPerson=" + inventoryPerson+",remark=" + remark+",adjustPerson=" + adjustPerson+",maxStock=" + maxStock+",minStock=" + minStock+",pdId=" + pdId+",securityStock=" + securityStock+",reorderPoint=" + reorderPoint+",printNum=" + printNum+",barCode=" + barCode+",status=" + status+",approvenPerson=" + approvenPerson+",approvenTime=" + approvenTime+",createUserName=" + createUserName+",createTime=" + createTime+",lastUpdateUserName=" + lastUpdateUserName+",lastUpdateTime=" + lastUpdateTime+"]";
	}
}