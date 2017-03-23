package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.BaseMapper; 

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskMapper  extends BaseMapper{ 
	public List<BaseInfo> queryAllApprovenTaskList(BaseInfo obj);
	public List<BaseInfo> queryRemainderTaskList(BaseInfo obj);
	public void updateNextApprovenPerosn(BaseInfo ojb);
}