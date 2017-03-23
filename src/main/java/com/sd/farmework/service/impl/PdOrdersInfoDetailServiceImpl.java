package com.sd.farmework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sd.farmework.mapper.PdOrdersInfoDetailMapper;
import com.sd.farmework.service.PdOrdersInfoDetailService;

public class PdOrdersInfoDetailServiceImpl extends BaseInfoServiceImpl
		implements PdOrdersInfoDetailService {

	@Autowired
	private PdOrdersInfoDetailMapper baseMapper;

	public PdOrdersInfoDetailMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(PdOrdersInfoDetailMapper baseMapper) {
		this.baseMapper = baseMapper;
	}
}
