package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.BaseMapper;

/** 
 * 已办任务表
 * @author Administrator 
 * 
 */ 
public interface SysApprovenTaskedMapper  extends BaseMapper{ 
	public List queryListByPageCk(BaseInfo obj);
	public List queryListByPagePd(BaseInfo obj);
}