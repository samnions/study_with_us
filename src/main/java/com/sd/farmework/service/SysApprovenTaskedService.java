package com.sd.farmework.service; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;

/** 
 * 已办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskedService  extends BaseInfoService{ 
	public List queryListByPageCk(BaseInfo obj);
	public List queryListByPagePd(BaseInfo obj);
}