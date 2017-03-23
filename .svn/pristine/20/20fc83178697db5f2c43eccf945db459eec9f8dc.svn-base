package com.sd.farmework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.pojo.CgOrdersInfo;
import com.sd.farmework.pojo.CgOrdersInfoDetail;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.CgOrdersInfoDetailService;
import com.sd.farmework.service.CgOrdersInfoService;
import com.sd.farmework.service.SysApprovenRulePersonService;
 
@Controller
@Scope("prototype")
@RequestMapping(value = "/cgOrders")
public class CgOrdersInfoController {
	
	@Autowired
	private CgOrdersInfoService cgOrdersInfoService;
	@Autowired
	private CgOrdersInfoDetailService cgOrdersInfoDetailService;
	@Autowired
	private SysApprovenRulePersonService sysApprovenRulePersonService;
	
	/**
	 * 采购订单列表 
	 */
	@RequestMapping(value = "/PurchaseOrderlist")
	public String PurchaseOrderList(Model model,CgOrdersInfo cgOrdersInfo) {
		try {
			int index = 0;
			int maxPage =0;
			index = (cgOrdersInfo.getCurrPage()-1)*cgOrdersInfo.getPageSize()+1;
			maxPage = cgOrdersInfo.getCurrPage()*cgOrdersInfo.getPageSize();
			cgOrdersInfo.setIndex(index);
			cgOrdersInfo.setMaxPage(maxPage);
			
			List queryList = cgOrdersInfoService.queryList(cgOrdersInfo);
			
			int count = cgOrdersInfoService.queryCount(cgOrdersInfo);

			if(count%cgOrdersInfo.getPageSize()==0){
				
				count=count/cgOrdersInfo.getPageSize();
				
			}else{
				
				count=count/cgOrdersInfo.getPageSize()+1;
			}
		
			
			model.addAttribute("cgOrdersInfo", cgOrdersInfo);
			model.addAttribute("totalCount", count);
			model.addAttribute("currPage", cgOrdersInfo.getCurrPage());
			model.addAttribute("infoList", queryList);
			return "purchaseOrder/purchaseOrderlist";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 采购订单详情
	 */
	@RequestMapping(value = "/PurchaseOrderDetail")
	public String PurchaseOrderDetail(Model model,CgOrdersInfo cgOrdersInfo) {
		
		try {
			BaseInfo cgOrder = cgOrdersInfoService.queryById(cgOrdersInfo);
			
			List cgDtalList = cgOrdersInfoService.queryByOrderNo(cgOrdersInfo);
			model.addAttribute("cgOrder", cgOrder);
			model.addAttribute("cgDtalList", cgDtalList);
			model.addAttribute("currPage", cgOrdersInfo.getCurrPage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "purchaseOrder/purchaseOrderDetail";
	}
	/**
	 * 采购订单上传
	 */
	@RequestMapping(value = "/upPurchaseOrder")
	public String upPurchaseOrder(Model model) {

		
		
		return "redirect:PurchaseOrderlist.do";
	}
	
	
	/**
	 * 微信首页
	 * @param model
	 * @return 
	 */
	@RequestMapping(value = "/weIndex")
	public String weIndex(Model model) {

		
		return "weixin/index";
	}
	/**
	 * 微信入库列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/weQueryRkInfolist")
	public void weQueryRkInfolist(Model model,CgOrdersInfo cgOrdersInfo,HttpServletResponse response,HttpSession session,HttpServletRequest request) {
			
		try {
			HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
			 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
			 cgOrdersInfo=(CgOrdersInfo) httpSessionProvider.fillBaseInfo(cgOrdersInfo, sessionUserInfo);
			 cgOrdersInfo.setCreateUserId(sessionUserInfo.getUserId());
			 cgOrdersInfo.setCreateTeamId(sessionUserInfo.getCreateTeamId());
			 cgOrdersInfo.setCreateTeamName(sessionUserInfo.getCreateTeamName());
			 cgOrdersInfo.setCreateDepartId(sessionUserInfo.getCreateDepartId());
			 cgOrdersInfo.setCreateDepartName(sessionUserInfo.getCreateDepartName());
			 cgOrdersInfo.setCreateUnitId(sessionUserInfo.getCreateUnitId());
			 cgOrdersInfo.setCreateUnitName(sessionUserInfo.getCreateUnitName());
			List queryList = cgOrdersInfoService.weiCharQueryList(cgOrdersInfo);	
			//控制采购订单库存状态 start ------------
			List detailList = cgOrdersInfoDetailService.queryList(null);
			for (int i = 0; i < queryList.size(); i++) {
				CgOrdersInfo orders = (CgOrdersInfo)queryList.get(i);
				for (int j = 0; j < detailList.size(); j++) {
					CgOrdersInfoDetail detail = (CgOrdersInfoDetail)detailList.get(j);
					if(orders.getOrderNo().equals(detail.getOrderNo())){
						if(Integer.parseInt(detail.getNum())<=0){
							orders.setStorageStatus("N");//无库存
						}else{
							orders.setStorageStatus("Y");//有库存
						}
					}
				}
			}
			//控制采购订单库存状态 end ------------
			
			response.getWriter().print(JSONArray.fromObject(queryList));
			model.addAttribute("orderInfo", queryList);
			System.out.println(JSONArray.fromObject(queryList));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 微信入库列表
	 */
	@RequestMapping(value = "/wePurchaseOrderDetail")
	public void wePurchaseOrderDetail(SysApprovenRulePerson obj,Model model,CgOrdersInfo cgOrdersInfo,HttpServletResponse response) {
		try {
			BaseInfo cgOrder = cgOrdersInfoService.queryById(cgOrdersInfo);
			CgOrdersInfo c = (CgOrdersInfo) cgOrder;
			CgOrdersInfoDetail cgOrderi = new CgOrdersInfoDetail();
			cgOrderi.setOrderNo(cgOrdersInfo.getOrderNo());
			List cgDtalList = cgOrdersInfoService.queryByOrderNo(cgOrderi);
			
			List<CgOrdersInfoDetail> orderList = new ArrayList<CgOrdersInfoDetail>();
			for (int i = 0; i < cgDtalList.size(); i++) {
				CgOrdersInfoDetail cgOrdersInfoDetail =(CgOrdersInfoDetail) cgDtalList.get(i);
				if("0".equals(cgOrdersInfoDetail.getNum())){
					orderList.add(cgOrdersInfoDetail);
				}
			}
			if(orderList.size()!=0){
				for (CgOrdersInfoDetail cgOrdersInfoDetail : orderList) {
					cgDtalList.remove(cgOrdersInfoDetail);
				}
			}
			obj.setApprovenRuleId("0000000002");
			List<BaseInfo> approvePersonList = sysApprovenRulePersonService.queryList(obj);
			
			response.setCharacterEncoding("UTF-8");
			JSONArray array = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("rulePerson", JSONArray.fromObject(approvePersonList));
			JSONObject json1 = new JSONObject();
			json1.put("name", "采购单据号：<b>"+c.getOrderNo()+"<//b>");
			json1.put("list1", JSONArray.fromObject(c));
			json1.put("list", JSONArray.fromObject(cgDtalList));
			JSONObject json2 = new JSONObject();
			json2.put("name", "单据生成时间：<b>"+c.getCreateTime()+"</b>");
			json2.put("list1", JSONArray.fromObject(new ArrayList()));
			json2.put("list", JSONArray.fromObject(new ArrayList()));
			array.add(json);
			array.add(json1);
			array.add(json2);
			response.getWriter().print(array.toString());
			System.out.println("------------------------------------------------start");
			System.out.println(array.toString());
			System.out.println("------------------------------------------------end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
