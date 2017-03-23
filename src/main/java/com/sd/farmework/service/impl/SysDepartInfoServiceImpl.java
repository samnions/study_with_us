package com.sd.farmework.service.impl; 

import java.util.List;

import com.sd.farmework.pojo.SysDepartInfo;
import com.sd.farmework.service.SysDepartInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.mapper.SysDepartInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * 团队组织机构表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysDepartInfoServiceImpl extends BaseInfoServiceImpl implements SysDepartInfoService{ 
    @Autowired
    private SysDepartInfoMapper baseMapper;
    public SysDepartInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysDepartInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public List<SysDepartInfo> getDepartInfoByParentId(
			SysDepartInfo sysDepartInfo) {
		// TODO Auto-generated method stub
		return baseMapper.getDepartInfoByParentId(sysDepartInfo);
	}
	@Override
	public int getDepartInfoByParentIdCount(SysDepartInfo sysDepartInfo) {
		// TODO Auto-generated method stub
		return baseMapper.getDepartInfoByParentIdCount(sysDepartInfo);
	}
	@Override
	public void addUnitDepart(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addUnitDepart(sysdepartInfo);
	}
	@Override
	public void addUnitRole(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addUnitRole(sysdepartInfo);
	}
	@Override
	public void addUnit(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addUnit(sysdepartInfo);
	}
	@Override
	public void addDepart(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addDepart(sysdepartInfo);
	}
	@Override
	public void addDepartTeam(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addDepartTeam(sysdepartInfo);
	}
	@Override
	public void addDepartRole(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addDepartRole(sysdepartInfo);
	}
	@Override
	public void addTeam(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addTeam(sysdepartInfo);
	}
	@Override
	public void addTeamRole(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addTeamRole(sysdepartInfo);
	}
	@Override
	public void addRoleUnitRole(SysDepartInfo sysdepartInfo) {
		// TODO Auto-generated method stub
		baseMapper.addRoleUnitRole(sysdepartInfo);
	}
	
	
	
    
}