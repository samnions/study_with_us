package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.service.SysApprovenTaskedService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysApprovenTaskedMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 已办任务表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenTaskedServiceImpl extends BaseInfoServiceImpl implements SysApprovenTaskedService{ 
    @Autowired
    private SysApprovenTaskedMapper baseMapper;
    public SysApprovenTaskedMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenTaskedMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List queryListByPageCk(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryListByPageCk(obj);
	}
	@Override
	public List queryListByPagePd(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryListByPagePd(obj);
	}
}