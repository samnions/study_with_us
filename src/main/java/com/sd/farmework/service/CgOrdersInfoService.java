package com.sd.farmework.service;

import java.util.List;

import com.sd.farmework.common.BaseInfo;



/**
 * 入库管理
 * @author Administrator
 * 2017年1月5日15:46:02
 */

 
public interface CgOrdersInfoService extends BaseInfoService{

	List queryByOrderNo(BaseInfo obj);
	List weiCharQueryList(BaseInfo obj);
	void updateRkCgOrderDetailInfo(BaseInfo obj);
	void updateRkCgOrdeInfoStauts(BaseInfo obj);
	void updateNum(BaseInfo obj);
	void addData(BaseInfo obj,List list)  throws Exception;
}
