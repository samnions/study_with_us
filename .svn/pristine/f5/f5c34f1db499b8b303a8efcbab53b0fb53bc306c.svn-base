package com.sd.farmework.service.impl;

import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.BaseMapper;
import com.sd.farmework.service.BaseInfoService;

public class BaseInfoServiceImpl implements BaseInfoService {
	
	
	protected	BaseMapper baseMapper;

	public BaseMapper getBaseMapper() {
		
		return baseMapper;
	}

	/**
	 * 查询所有用户
	 */
	
	public List<BaseInfo> queryList(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		List list = null;
		try {
			list = getBaseMapper().queryList(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return list;
	}

	
	public void add(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		try {
			getBaseMapper().add(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	
	public void update(BaseInfo obj) throws Exception {
 		// TODO Auto-generated method stub
		try {
			getBaseMapper().update(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	
	public BaseInfo queryById(BaseInfo obj) throws Exception {
		BaseInfo objout = null;
		try {
			objout = getBaseMapper().queryById(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new Exception(e);
		}
		return objout;
	}

	
	public List<BaseInfo> query(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		List<BaseInfo> objout = null;
		try {
			objout = getBaseMapper().query(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	
	public int queryCount(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		
		int objout =0;
		try {
			objout = getBaseMapper().queryCount(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		return objout;
	}

	@Override
	public void addBatch(List list) throws Exception {
		// TODO Auto-generated method stub
		try {
			getBaseMapper().addBatch(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}

	@Override
	public void delete(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		try {
			getBaseMapper().delete(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<BaseInfo> queryListByPage(BaseInfo obj) throws Exception {
		// TODO Auto-generated method stub
		return getBaseMapper().queryListByPage(obj);
	}

	@Override
	public BaseInfo queryByPkId(String obj) throws Exception {
		// TODO Auto-generated method stub
		return getBaseMapper().queryByPkId(obj);
	}

	 


}
