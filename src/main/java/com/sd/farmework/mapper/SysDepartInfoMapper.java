package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseMapper; 
import com.sd.farmework.pojo.SysDepartInfo;

/** 
 * 团队组织机构表
 * @author Administrator 
 * 
 */ 
public interface SysDepartInfoMapper  extends BaseMapper{
	public List<SysDepartInfo> getDepartInfoByParentId(SysDepartInfo sysDepartInfo);
	public int getDepartInfoByParentIdCount(SysDepartInfo sysDepartInfo);
	public void addUnit(SysDepartInfo sysdepartInfo);
	public void addUnitDepart(SysDepartInfo sysdepartInfo);
	public void addUnitRole(SysDepartInfo sysdepartInfo);
	
	public void addDepart(SysDepartInfo sysdepartInfo);
	public void addDepartTeam(SysDepartInfo sysdepartInfo);
	public void addDepartRole(SysDepartInfo sysdepartInfo);
	
	public void addTeam(SysDepartInfo sysdepartInfo);
	public void addTeamRole(SysDepartInfo sysdepartInfo);

	public void addRoleUnitRole(SysDepartInfo sysdepartInfo);
	
}