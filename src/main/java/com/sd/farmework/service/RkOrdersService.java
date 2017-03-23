package com.sd.farmework.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.RkOrdersInfo;
import com.sd.farmework.pojo.RkOrdersInfoDetail;
import com.sd.farmework.pojo.SysApprovenTask;

/**
 * 入库管理
 * 
 * @author 秦波
 * @date:2017年1月5日 下午3:22:31
 */

public interface RkOrdersService extends BaseInfoService {
	public List<BaseInfo> queryRKDetailList(BaseInfo obj);

	public String querySqe();

	public void addRkCgOrderInfo(BaseInfo obj, List list);

	public void addRkCgOrderDetailInfo(BaseInfo obj);

	public void ckOperation(BaseInfo obj);

	public void ckDetailOperation(BaseInfo obj);

	public void subnum(BaseInfo obj);

	List<RkOrdersInfo> wxqueryList(RkOrdersInfo rkOrdersInfo);

	RkOrdersInfo wxqueryRkInfoDetaillist(RkOrdersInfo rkOrdersInfo);

	List<RkOrdersInfo> queryRkInfo(BaseInfo obj);

	public void updateorderstatus(BaseInfo obj);

	List<RkOrdersInfoDetail> wxShqueryRkInfoDetaillist(BaseInfo obj);

	RkOrdersInfo qureyOrderNo(BaseInfo obj);

	List<RkOrdersInfo> queryRkShenHe(BaseInfo obj);

	Integer queryRkShenHeCount(BaseInfo obj);

	Integer queryRkShenHeCounted(BaseInfo obj);

	List<RkOrdersInfo> queryRkShenHeed(BaseInfo obj);

	public void updateOrderstatusByReceiptNo(BaseInfo obj);

	List queryByReceiptNo(BaseInfo obj);

	public void updateNum(BaseInfo obj);


	public void updateByRecNo(BaseInfo obj);
	RkOrdersInfo qureyInfoByReNo(BaseInfo  obj);
	/**
	 * 添加审批流
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 * @return
	 */
	public Map addApproven(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception;


	/**
	 * 处理审批
	 * @param session
	 * @param request
	 * @param response
	 * @param obj
	 * @param sysApprovenTaskService
	 * @param sysApprovenTaskedService
	 * @param approvenFunctionId
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> doApproven(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			SysApprovenTask obj, SysApprovenTaskService sysApprovenTaskService,
			SysApprovenTaskedService sysApprovenTaskedService,
			String approvenFunctionId) throws Exception;

}
