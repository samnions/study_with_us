package com.sd.farmework.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.CgOrdersDetailMapper;
import com.sd.farmework.mapper.CgOrdersInfoMapper;
import com.sd.farmework.pojo.CgOrdersInfoDetail;
import com.sd.farmework.pojo.RemoteObjectDetail;
import com.sd.farmework.service.CgOrdersInfoDetailService;
import com.sd.farmework.service.CgOrdersInfoService;
/**
 * 采购管理
 * @author xsj
 * 2017年1月5日15:46:20
 */
@Service
public class CgOrdersInfoDetailServiceImpl   extends BaseInfoServiceImpl  implements CgOrdersInfoDetailService {

	private static Logger logger = Logger.getLogger(CgOrdersInfoDetailServiceImpl.class);
	
	
	@Autowired
	private CgOrdersDetailMapper baseMapper;
	public CgOrdersDetailMapper getBaseMapper() {
		return baseMapper;
	}
	public void setBaseMapper(CgOrdersDetailMapper baseMapper) {
		this.baseMapper = baseMapper;
	}


	



	
}
