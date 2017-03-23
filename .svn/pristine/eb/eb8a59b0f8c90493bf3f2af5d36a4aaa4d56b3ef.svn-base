package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.service.SysApprovenTaskService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysApprovenTaskMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 审批待办任务表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenTaskServiceImpl extends BaseInfoServiceImpl implements SysApprovenTaskService{ 
    @Autowired
    private SysApprovenTaskMapper baseMapper;
    public SysApprovenTaskMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenTaskMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List<BaseInfo> queryAllApprovenTaskList(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryAllApprovenTaskList(obj);
	}
	@Override
	public List<BaseInfo> queryRemainderTaskList(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryRemainderTaskList(obj);
	}
	@Override
	public void updateNextApprovenPerosn(BaseInfo obj) {
		// TODO Auto-generated method stub
		  baseMapper.updateNextApprovenPerosn(obj);
	}
    
}