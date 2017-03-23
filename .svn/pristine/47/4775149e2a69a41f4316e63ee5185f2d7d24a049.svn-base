package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.service.SysRoleInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysRoleInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 角色权限表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysRoleInfoServiceImpl extends BaseInfoServiceImpl implements SysRoleInfoService{ 
    @Autowired
    private SysRoleInfoMapper baseMapper;
    public SysRoleInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysRoleInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List<BaseInfo> queryFunction(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.queryFunction(obj);
	}
	@Override
	public void updatePower(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		baseMapper.updatePower(obj);
	}
    
    
}