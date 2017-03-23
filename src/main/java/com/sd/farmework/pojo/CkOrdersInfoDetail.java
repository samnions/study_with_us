package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * null
 * @author Administrator 
 * 
 */ 
public class CkOrdersInfoDetail extends BaseInfo{ 
	//修改人 
	private String updateUserName; 
	//修改人ID 
	private String updateUserId; 
	//修改时间 
	private String updateTime; 
	//主键id 
	private String detailId; 
	//出库单ID 
	private String ckId; 
	//存货编码 
	private String stockNo; 
	//存货名称 
	private String stockName; 
	//规格 
	private String standard; 
	//型号 
	private String dModel; 
	//单位 
	private String unit; 
	//应发数量 
	private String shouldSentNum; 
	//实发数量 
	private String realNum; 
	//单价 
	private String price; 
	//金额 
	private String amount; 
	//入库日期 
	private String storageDate; 
	//是否赠品 
	private String isGifts; 
	//备注 
	private String remark; 
	//创建人 
	private String createUserName; 
	//创建人ID 
	private String createUserId; 
	//创建时间 
	private String createTime; 
    public CkOrdersInfoDetail(){
	}
    public CkOrdersInfoDetail(String updateUserName,String updateUserId,String updateTime,String detailId,String ckId,String stockNo,String stockName,String standard,String dModel,String unit,String shouldSentNum,String realNum,String price,String amount,String storageDate,String isGifts,String remark,String createUserName,String createUserId,String createTime){
		this.updateUserName=updateUserName;
		this.updateUserId=updateUserId;
		this.updateTime=updateTime;
		this.detailId=detailId;
		this.ckId=ckId;
		this.stockNo=stockNo;
		this.stockName=stockName;
		this.standard=standard;
		this.dModel=dModel;
		this.unit=unit;
		this.shouldSentNum=shouldSentNum;
		this.realNum=realNum;
		this.price=price;
		this.amount=amount;
		this.storageDate=storageDate;
		this.isGifts=isGifts;
		this.remark=remark;
		this.createUserName=createUserName;
		this.createUserId=createUserId;
		this.createTime=createTime;
	}
    public CkOrdersInfoDetail(String updateUserId,String updateTime,String detailId,String ckId,String stockNo,String stockName,String standard,String dModel,String unit,String shouldSentNum,String realNum,String price,String amount,String storageDate,String isGifts,String remark,String createUserName,String createUserId,String createTime){
		this.updateUserId=updateUserId;
		this.updateTime=updateTime;
		this.detailId=detailId;
		this.ckId=ckId;
		this.stockNo=stockNo;
		this.stockName=stockName;
		this.standard=standard;
		this.dModel=dModel;
		this.unit=unit;
		this.shouldSentNum=shouldSentNum;
		this.realNum=realNum;
		this.price=price;
		this.amount=amount;
		this.storageDate=storageDate;
		this.isGifts=isGifts;
		this.remark=remark;
		this.createUserName=createUserName;
		this.createUserId=createUserId;
		this.createTime=createTime;
	}
	public void setDetailId(String detailId){ 
		this.detailId=detailId;
	}
	public String getDetailId(){ 
		return this.detailId;
	}
	public void setCkId(String ckId){ 
		this.ckId=ckId;
	}
	public String getCkId(){ 
		return this.ckId;
	}
	public void setStockNo(String stockNo){ 
		this.stockNo=stockNo;
	}
	public String getStockNo(){ 
		return this.stockNo;
	}
	public void setStockName(String stockName){ 
		this.stockName=stockName;
	}
	public String getStockName(){ 
		return this.stockName;
	}
	public void setStandard(String standard){ 
		this.standard=standard;
	}
	public String getStandard(){ 
		return this.standard;
	}
	public void setDModel(String dModel){ 
		this.dModel=dModel;
	}
	public String getDModel(){ 
		return this.dModel;
	}
	public void setUnit(String unit){ 
		this.unit=unit;
	}
	public String getUnit(){ 
		return this.unit;
	}
	public void setShouldSentNum(String shouldSentNum){ 
		this.shouldSentNum=shouldSentNum;
	}
	public String getShouldSentNum(){ 
		return this.shouldSentNum;
	}
	public void setrealNum(String realNum){ 
		this.realNum=realNum;
	}
	public String getrealNum(){ 
		return this.realNum;
	}
	public void setPrice(String price){ 
		this.price=price;
	}
	public String getPrice(){ 
		return this.price;
	}
	public void setAmount(String amount){ 
		this.amount=amount;
	}
	public String getAmount(){ 
		return this.amount;
	}
	public void setStorageDate(String storageDate){ 
		this.storageDate=storageDate;
	}
	public String getStorageDate(){ 
		return this.storageDate;
	}
	public void setIsGifts(String isGifts){ 
		this.isGifts=isGifts;
	}
	public String getIsGifts(){ 
		return this.isGifts;
	}
	public void setRemark(String remark){ 
		this.remark=remark;
	}
	public String getRemark(){ 
		return this.remark;
	}
	@Override
	public String toString() {
		return "CkOrdersInfoDetail[updateUserName=" + updateUserName+",updateUserId=" + updateUserId+",updateTime=" + updateTime+",detailId=" + detailId+",ckId=" + ckId+",stockNo=" + stockNo+",stockName=" + stockName+",standard=" + standard+",dModel=" + dModel+",unit=" + unit+",shouldSentNum=" + shouldSentNum+",realNum=" + realNum+",price=" + price+",amount=" + amount+",storageDate=" + storageDate+",isGifts=" + isGifts+",remark=" + remark+",createUserName=" + createUserName+",createUserId=" + createUserId+",createTime=" + createTime+"]";
	}
}