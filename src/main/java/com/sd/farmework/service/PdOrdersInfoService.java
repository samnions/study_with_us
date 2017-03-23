package com.sd.farmework.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.pojo.PdOrdersInfo;
import com.sd.farmework.pojo.SysApprovenTask;



public interface PdOrdersInfoService extends BaseInfoService{

	List wxqueryList(PdOrdersInfo obj);

	String querySeq();
	
	List wxqueryListpd(PdOrdersInfo obj);
	
	
	    List<PdOrdersInfo> queryPdShenHe(BaseInfo obj);
		Integer queryPdShenHeCount(BaseInfo obj);
		
		Integer queryPdShenHeCounted(BaseInfo obj);
		List<PdOrdersInfo> queryPdShenHeed(BaseInfo obj);
		PdOrdersInfo qureyInfoByReNo(BaseInfo obj);
		void updateByRecNo(BaseInfo obj);
		/**
		 * 添加盘点审批流
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public Map addPdApproven(HttpSession session ,HttpServletRequest request,
				HttpServletResponse response)throws Exception;
		/**
		 * 做审核操作
		 * @param session
		 * @param request
		 * @param response
		 * @param obj
		 * @param approvenFunctionId
		 * @return
		 * @throws Exception
		 */
		public Map doApproven(HttpSession session, HttpServletRequest request,HttpServletResponse response,SysApprovenTask obj,String approvenFunctionId) throws Exception;
}
