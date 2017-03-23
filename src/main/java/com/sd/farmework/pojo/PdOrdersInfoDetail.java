package com.sd.farmework.pojo; 

import com.sd.farmework.common.BaseInfo; 

/** 
 * null
 * @author Administrator 
 * 
 */ 
public class PdOrdersInfoDetail extends BaseInfo{ 
	//盘点单ID 
	private String pdId; 
	//存货编码 
	private String stockNo; 
	//存货名称 
	private String stockName; 
	//计量单位 
	private String unit; 
	//盘点前数量 
	private String beforeNum; 
	//盘点后数量 
	private String afterNum; 
	//创建人 
	private String createUserName; 
	//创建人ID 
	private String createUserId; 
	//创建时间 
	private String createTime; 
	//修改人 
	private String updateUserName; 
	//修改人ID 
	private String updateUserId; 
	//修改时间 
	private String updateTime; 
	//主键 
	private String detailId; 
    public PdOrdersInfoDetail(){
	}
    public PdOrdersInfoDetail(String pdId,String stockNo,String stockName,String unit,String beforeNum,String afterNum,String createUserName,String createUserId,String createTime,String updateUserName,String updateUserId,String updateTime,String detailId){
		this.pdId=pdId;
		this.stockNo=stockNo;
		this.stockName=stockName;
		this.unit=unit;
		this.beforeNum=beforeNum;
		this.afterNum=afterNum;
		this.createUserName=createUserName;
		this.createUserId=createUserId;
		this.createTime=createTime;
		this.updateUserName=updateUserName;
		this.updateUserId=updateUserId;
		this.updateTime=updateTime;
		this.detailId=detailId;
	}
    public PdOrdersInfoDetail(String stockNo,String stockName,String unit,String beforeNum,String afterNum,String createUserName,String createUserId,String createTime,String updateUserName,String updateUserId,String updateTime,String detailId){
		this.stockNo=stockNo;
		this.stockName=stockName;
		this.unit=unit;
		this.beforeNum=beforeNum;
		this.afterNum=afterNum;
		this.createUserName=createUserName;
		this.createUserId=createUserId;
		this.createTime=createTime;
		this.updateUserName=updateUserName;
		this.updateUserId=updateUserId;
		this.updateTime=updateTime;
		this.detailId=detailId;
	}
	public void setPdId(String pdId){ 
		this.pdId=pdId;
	}
	public String getPdId(){ 
		return this.pdId;
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
	public void setUnit(String unit){ 
		this.unit=unit;
	}
	public String getUnit(){ 
		return this.unit;
	}
	public void setBeforeNum(String beforeNum){ 
		this.beforeNum=beforeNum;
	}
	public String getBeforeNum(){ 
		return this.beforeNum;
	}
	public void setAfterNum(String afterNum){ 
		this.afterNum=afterNum;
	}
	public String getAfterNum(){ 
		return this.afterNum;
	}
	public void setDetailId(String detailId){ 
		this.detailId=detailId;
	}
	public String getDetailId(){ 
		return this.detailId;
	}
	@Override
	public String toString() {
		return "PdOrdersInfoDetail[pdId=" + pdId+",stockNo=" + stockNo+",stockName=" + stockName+",unit=" + unit+",beforeNum=" + beforeNum+",afterNum=" + afterNum+",createUserName=" + createUserName+",createUserId=" + createUserId+",createTime=" + createTime+",updateUserName=" + updateUserName+",updateUserId=" + updateUserId+",updateTime=" + updateTime+",detailId=" + detailId+"]";
	}
}