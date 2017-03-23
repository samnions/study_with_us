package com.sd.farmework.mapper;



import java.util.List;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.BaseMapper;
/**
 * 采购订单列表
 * @author xsj
 * 2017年1月5日15:32:35
 */
public interface CgOrdersInfoMapper extends BaseMapper {

	List queryByOrderNo(BaseInfo obj);
	List weiCharQueryList(BaseInfo obj);
	void updateRkCgOrderDetailInfo(BaseInfo obj);
	void updateRkCgOrdeInfoStauts(BaseInfo obj);
	void updateNum(BaseInfo obj);
	
 }
