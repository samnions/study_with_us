package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.service.SysApprovenRulePersonService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysApprovenRulePersonMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 审批规则对应审批人表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysApprovenRulePersonServiceImpl extends BaseInfoServiceImpl implements SysApprovenRulePersonService{ 
    @Autowired
    private SysApprovenRulePersonMapper baseMapper;
    public SysApprovenRulePersonMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysApprovenRulePersonMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public int queryPersonCount(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.queryPersonCount(obj);
	}
	@Override
	public void deleteAndOrder(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		this.baseMapper.delete(obj);
		List<BaseInfo>list=this.baseMapper.queryList(obj);
		if(list!=null&&list.size()>0){
			this.baseMapper.updateBatch(list);
		}
		
	}
}