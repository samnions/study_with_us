package com.sd.farmework.common;

import com.sd.farmework.common.util.StringUtil;

public class BaseInfo {
	private int currPage=1;
	private int totalCount;
	private int pageSize=5;
	private int pageCount;
	private int startRecod;
	
	public int getStartRecod() {
		
		return (currPage-1)*pageSize;
	}
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		
		if(getTotalCount()%pageSize!=0){
			pageCount=((getTotalCount()/pageSize)+1);
			}else{
				pageCount=(getTotalCount()/pageSize);
			}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
 
	private String remark;
	//状态（Y正常,N禁用）
	private String status;
	
	private String createTime;
    private String createUserId;
    private String createUserName;
    private String createTeamId;
    private String createTeamName;
    private String createDepartId;
    private String createDepartName;
    private String createUnitId;
    private String createUnitName;   
    
    private String lastUpdateTime;
    private String lastUpdateUserId;
    private String lastUpdateUserName;
    private String lastUpdateTeamId;
    private String lastUpdateTeamName;
    private String lastUpdateDepartId;
    private String lastUpdateDepartName;
    private String lastUpdateUnitId;
    private String lastUpdateUnitName;   
 

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTeamId() {
		return createTeamId;
	}

	public void setCreateTeamId(String createTeamId) {
		this.createTeamId = createTeamId;
	}

	public String getCreateTeamName() {
		return createTeamName;
	}

	public void setCreateTeamName(String createTeamName) {
		this.createTeamName = createTeamName;
	}

	public String getCreateUnitId() {
		return createUnitId;
	}

	public void setCreateUnitId(String createUnitId) {
		this.createUnitId = createUnitId;
	}

	public String getCreateUnitName() {
		return createUnitName;
	}

	public void setCreateUnitName(String createUnitName) {
		this.createUnitName = createUnitName;
	}

	public String getLastUpdateTeamId() {
		return lastUpdateTeamId;
	}

	public void setLastUpdateTeamId(String lastUpdateTeamId) {
		this.lastUpdateTeamId = lastUpdateTeamId;
	}

	public String getLastUpdateTeamName() {
		return lastUpdateTeamName;
	}

	public void setLastUpdateTeamName(String lastUpdateTeamName) {
		this.lastUpdateTeamName = lastUpdateTeamName;
	}

	public String getLastUpdateUnitId() {
		return lastUpdateUnitId;
	}

	public void setLastUpdateUnitId(String lastUpdateUnitId) {
		this.lastUpdateUnitId = lastUpdateUnitId;
	}

	public String getLastUpdateUnitName() {
		return lastUpdateUnitName;
	}

	public void setLastUpdateUnitName(String lastUpdateUnitName) {
		this.lastUpdateUnitName = lastUpdateUnitName;
	}

	public String getCreateDepartId() {
		return createDepartId;
	}

	public void setCreateDepartId(String createDepartId) {
		this.createDepartId = createDepartId;
	}

	public String getCreateDepartName() {
		return createDepartName;
	}

	public void setCreateDepartName(String createDepartName) {
		this.createDepartName = createDepartName;
	}

	public String getLastUpdateDepartId() {
		return lastUpdateDepartId;
	}

	public void setLastUpdateDepartId(String lastUpdateDepartId) {
		this.lastUpdateDepartId = lastUpdateDepartId;
	}

	public String getLastUpdateDepartName() {
		return lastUpdateDepartName;
	}

	public void setLastUpdateDepartName(String lastUpdateDepartName) {
		this.lastUpdateDepartName = lastUpdateDepartName;
	}

	public String getCreateTime() {
		
		if(StringUtil.isNotNullOrBlank(createTime)){
			if(createTime.length()==21){
				createTime = createTime.substring(0,19);
			}
		}
		
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getLastUpdateUserName() {
		return lastUpdateUserName;
	}

	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	public void setStartRecod(int startRecod) {
		this.startRecod = startRecod;
	}
	
	
}
