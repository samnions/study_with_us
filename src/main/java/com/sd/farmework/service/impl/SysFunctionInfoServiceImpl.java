package com.sd.farmework.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.SysFunctionInfoMapper;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.service.SysFunctionInfoService;

/** 
 * 功能菜单信息表
 * @author Administrator 
 * 
 */ 
 @Service
public class SysFunctionInfoServiceImpl extends BaseInfoServiceImpl implements SysFunctionInfoService{ 
    @Autowired
    private SysFunctionInfoMapper baseMapper;
    public SysFunctionInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SysFunctionInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
	@Override
	public void add(SysFunctionInfo obj, String[] powers) throws Exception {
		// TODO Auto-generated method stub
		
		obj.setFunctionType("1");
		baseMapper.add(obj);
		String functionId =obj.getFunctionId();
		obj.setFunctionType("2");
  		for (int i = 0; i < powers.length; i++) {
  			System.out.println(powers[i]);
  			obj.setFunctionId(functionId);
 			obj.setDictionaryId(powers[i].split("&")[0]);
 			obj.setDictionaryName(powers[i].split("&")[1]);
 			obj.setFunctionType("2");
 			obj.setFunctionName(powers[i].split("&")[1]);
 			obj.setParentFunctionId(obj.getFunctionId());
 			System.out.println(obj);
			baseMapper.add(obj);
		}
	}
 
	@Override
	public List queryByPkparentFunctionId(String obj) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.queryByPkparentFunctionId(obj);
	}
	@Override
	public void update(SysFunctionInfo obj, String[] powers) throws Exception {
		// TODO Auto-generated method stub
		obj.setFunctionType("1");
		baseMapper.update(obj);
		obj.setParentFunctionId(obj.getFunctionId());
		baseMapper.delete(obj);
		String functionId =obj.getFunctionId();
		obj.setFunctionType("2");
  		for (int i = 0; i < powers.length; i++) {
  			System.out.println(powers[i]);
  			obj.setFunctionId(functionId);
 			obj.setDictionaryId(powers[i].split("&")[0]);
 			obj.setDictionaryName(powers[i].split("&")[1]);
 			obj.setFunctionType("2");
 			obj.setFunctionName(powers[i].split("&")[1]);
 			obj.setParentFunctionId(obj.getFunctionId());
			baseMapper.add(obj);
		}
	}
}