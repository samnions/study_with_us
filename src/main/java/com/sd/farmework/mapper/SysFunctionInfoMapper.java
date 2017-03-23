package com.sd.farmework.mapper; 

import java.util.List;

import com.sd.farmework.common.BaseMapper;

/** 
 * 功能菜单信息表
 * @author Administrator 
 * 
 */ 
public interface SysFunctionInfoMapper  extends BaseMapper{ 
		/**
		 * 通过父节点获取子节点信息
		 * @param user
		 * @return
		 * @throws Exception
		 */
		public List queryByPkparentFunctionId(String obj) throws Exception;
}