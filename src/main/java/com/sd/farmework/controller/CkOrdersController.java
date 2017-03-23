package com.sd.farmework.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.util.DateUtil;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.CkOrdersInfo;
import com.sd.farmework.pojo.CkOrdersInfoDetail;
import com.sd.farmework.pojo.RkOrdersInfo;
import com.sd.farmework.pojo.RkOrdersInfoDetail;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysApprovenTasked;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.CkOrdersService;
import com.sd.farmework.service.RkOrdersService;
import com.sd.farmework.service.SysApprovenTaskService;


/**
 * 入库管理
 * author 秦波
 * 2017年1月5日 下午3:38:34
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/CkAdmin")
public class CkOrdersController {
	private static Logger logger = Logger.getLogger(CkOrdersController.class);
	@Autowired
	private CkOrdersService ckorder;
	@Autowired
	private RkOrdersService rkorder;
	@Autowired
	private SysApprovenTaskService sysApprovenTaskService;
	
	private String approvenFunctionId="00001";
	
	
	@RequestMapping(value = "/queryCkInfolist")
	public String  querylist(Model model,CkOrdersInfo ckOrdersInfo,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		
		
		String tag=request.getParameter("tag");
		if(StringUtil.isExisted(tag, "1")){
			
			try {
				 HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
				 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
				 ckOrdersInfo=(CkOrdersInfo) httpSessionProvider.fillBaseInfo(ckOrdersInfo, sessionUserInfo);

				ckOrdersInfo.setStatus("0");
				int index = 0;
				int maxPage =0;
				index = (ckOrdersInfo.getCurrPage()-1)*ckOrdersInfo.getPageSize()+1;
				maxPage = ckOrdersInfo.getCurrPage()*ckOrdersInfo.getPageSize();
				ckOrdersInfo.setIndex(index);
				ckOrdersInfo.setMaxPage(maxPage);
				
				int count = ckorder.queryCkShenHeCount(ckOrdersInfo);
				
				if(count%ckOrdersInfo.getPageSize()==0){
					count=count/ckOrdersInfo.getPageSize();
				}else{
					count=count/ckOrdersInfo.getPageSize()+1;
				}
				List ckOrderlist = this.ckorder.queryCkShenHe(ckOrdersInfo);
				model.addAttribute("totalCount", count);
				model.addAttribute("currPage", ckOrdersInfo.getCurrPage());
				model.addAttribute("ckInfo", ckOrderlist);
				model.addAttribute("obj", ckOrdersInfo);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "testApproven/outboundApproven";
			
		}else if(StringUtil.isExisted(tag, "2")){
			
			try {
				 HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
				 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
				 ckOrdersInfo=(CkOrdersInfo) httpSessionProvider.fillBaseInfo(ckOrdersInfo, sessionUserInfo);

				ckOrdersInfo.setStatus("1");
				ckOrdersInfo.setStatus1("2");
			
				int index = 0;
				int maxPage =0;
				index = (ckOrdersInfo.getCurrPage()-1)*ckOrdersInfo.getPageSize()+1;
				maxPage = ckOrdersInfo.getCurrPage()*ckOrdersInfo.getPageSize();
				ckOrdersInfo.setIndex(index);
				ckOrdersInfo.setMaxPage(maxPage);
				
				int count = ckorder.queryCkShenHeCounted(ckOrdersInfo);
				
				if(count%ckOrdersInfo.getPageSize()==0){
					count=count/ckOrdersInfo.getPageSize();
				}else{
					count=count/ckOrdersInfo.getPageSize()+1;
				}
				List ckOrderlist = this.ckorder.queryCkShenHeed(ckOrdersInfo);
				model.addAttribute("totalCount", count);
				model.addAttribute("currPage", ckOrdersInfo.getCurrPage());
				model.addAttribute("ckInfo", ckOrderlist);
				model.addAttribute("obj", ckOrdersInfo);
				
			}
			 catch (Exception e) {
				e.printStackTrace();
			}

			return "testApproven/outboundApprovened";
		}else {
			
			try {
				 HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
				 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
				 ckOrdersInfo=(CkOrdersInfo) httpSessionProvider.fillBaseInfo(ckOrdersInfo, sessionUserInfo);
				 
				List ckOrderlist=this.ckorder.queryList(ckOrdersInfo);
				ckOrdersInfo.setTotalCount(ckorder.queryCount(ckOrdersInfo));
				model.addAttribute("totalCount",ckOrdersInfo.getPageCount());
			    model.addAttribute("currPage", ckOrdersInfo.getCurrPage());
				model.addAttribute("ckInfo",ckOrderlist);
				model.addAttribute("obj",ckOrdersInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "outbound/outboundlist";
		}	
		
		
	}
	@RequestMapping(value = "/queryCkInfoDetail")
	public String  queryCkInfoDetail(SysApprovenTask obj,Model model,CkOrdersInfo reOrdersInfo,CkOrdersInfoDetail reOrdersInfoDetail,HttpServletRequest request){
		String tag=request.getParameter("tag");
		try {
			reOrdersInfo=(CkOrdersInfo) this.ckorder.queryById(reOrdersInfo);
			obj.setApprovenFunctionId(approvenFunctionId);
			obj.setSourceTablePkColumnValue(reOrdersInfo.getCkId());
			List<BaseInfo> list=sysApprovenTaskService.queryAllApprovenTaskList(obj);
			//将时间转换成正确的格式
			for (int i = 0; i < list.size(); i++) {
				SysApprovenTask tmp = (SysApprovenTask)list.get(i);
				String taskName = tmp.getTaskName();
				if(StringUtil.isNotNullOrBlank(taskName)){
					String[] taskNameArray = taskName.split("-");
					if(taskNameArray.length>1){
						tmp.setTaskName(taskNameArray[1]);
					}
				}
				Date date = DateUtil.getDateFromString(tmp.getApprovenSendTime());
				tmp.setApprovenSendTime(DateUtil.getDateString(date));
			}
			model.addAttribute("testList", list);
			model.addAttribute("reOrdersInfo", reOrdersInfo);
			List ckOrderMarketlist=this.ckorder.queryCKDetailList(reOrdersInfoDetail);
			model.addAttribute("ckOrderMarket", ckOrderMarketlist);
			model.addAttribute("obj",reOrdersInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtil.isExisted(tag, "1")){
			return "testApproven/outboundApprovenDetail";
			
		}else if(StringUtil.isExisted(tag, "2")){
			return "testApproven/outboundApprovenedDetail";
		}else {
			return "outbound/outboundDetail";
		}	
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/wxckqueryList")
	public Object wxckqueryList(Model model,CkOrdersInfo reOrdersInfo) throws Exception{
			reOrdersInfo.setPageSize((int)999999999);
			List ckOrderlist=this.ckorder.wxckqueryList(reOrdersInfo);
			return ckOrderlist;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/queryCkInfolistForwx")
	public void queryCkInfolistForwx(Model model,CkOrdersInfo reOrdersInfo,HttpServletResponse response,HttpServletRequest request,HttpSession session) throws Exception{
		
		 HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		 reOrdersInfo=(CkOrdersInfo) httpSessionProvider.fillBaseInfo(reOrdersInfo, sessionUserInfo);

		
		reOrdersInfo.setPageSize((int)999999999);
			//reOrdersInfo.setStatus("2");
			List ckOrderlist=this.ckorder.queryList(reOrdersInfo);
			response.setCharacterEncoding("UTF-8");
			JSONObject json = new JSONObject();
			json.put("list", JSONArray.fromObject(ckOrderlist));
			response.getWriter().print(json.toString());
	}
	@ResponseBody
	@RequestMapping(value = "/queryCkInfoDetailForwx")
	public void  queryCkInfoDetailForwx(HttpServletResponse response,Model model,CkOrdersInfo reOrdersInfo,CkOrdersInfoDetail reOrdersInfoDetail) throws Exception{
			reOrdersInfo=(CkOrdersInfo) this.ckorder.queryById(reOrdersInfo);
			List ckOrderMarketlist=this.ckorder.queryCKDetailList(reOrdersInfoDetail);
			response.setCharacterEncoding("UTF-8");
			JSONObject json=new JSONObject();
			JSONObject json2=new JSONObject();
			JSONArray array=new JSONArray();
			List list=new ArrayList();
			List date=new ArrayList();
			json.put("name", "出库单号:<b>"+reOrdersInfo.getCkReceiptNo()+"</b>");
			json.put("list1", JSONArray.fromObject(reOrdersInfo));
			CkOrdersInfoDetail ckinfodetail=new CkOrdersInfoDetail();
			for(int i=0;i<ckOrderMarketlist.size();i++){
				ckinfodetail=(CkOrdersInfoDetail) ckOrderMarketlist.get(i);
				if(ckinfodetail.getrealNum()!="0"){
					date.add(ckinfodetail);
				}
			}
			json.put("list", JSONArray.fromObject(date));
			json2.put("name","单据时间:<b>"+reOrdersInfo.getCreateTime()+"</b>");
			json2.put("list1", list);
			json2.put("list", list);
			array.add(json);
			array.add(json2);
			response.getWriter().write(array.toString());
	}
	@ResponseBody
	@RequestMapping(value = "/ckOperation")
	public Object ckOperation(HttpSession session,HttpServletResponse response,HttpServletRequest request, Model model,RkOrdersInfo reOrdersInfo,RkOrdersInfoDetail reOrdersInfoDetail) throws IOException{
		Map map=new HashMap();
		try {
			//生成出库单
				String rkid=request.getParameter("rkId");
				request.setAttribute("approvenFunctionId", approvenFunctionId);
				request.setAttribute("reOrdersInfo", reOrdersInfo);
				request.setAttribute("rkid", rkid);
				List rklist=new ArrayList();
				String realNum[]=request.getParameterValues("realNum");
				String stockNo[]=request.getParameterValues("stockNo");
				String stockName[]=request.getParameterValues("stockName");
				String standard[]=request.getParameterValues("standard");
				String dModel[]=request.getParameterValues("dModel");
				String unit[]=request.getParameterValues("unit");
				String receivableNum[]=request.getParameterValues("receivableNum");
				String price[]=request.getParameterValues("price");
				String amount[]=request.getParameterValues("amount");
				String storageDate[]=request.getParameterValues("storageDate");
				String isGifts[]=request.getParameterValues("isGifts");
				String remark[]=request.getParameterValues("remark");
				String remain[]=request.getParameterValues("remain");
				CkOrdersInfoDetail rkInfo;
				for(int i=0;i<realNum.length;i++){
					rkInfo=new CkOrdersInfoDetail();
					rkInfo.setrealNum(realNum[i]);
					rkInfo.setStockNo(stockNo[i]);
					rkInfo.setStockName(stockName[i]);
					rkInfo.setStandard(standard[i]);
					rkInfo.setDModel(dModel[i]);
					rkInfo.setUnit(unit[i]);
					rkInfo.setShouldSentNum(receivableNum[i]);
					rkInfo.setPrice(price[i]);
					rkInfo.setAmount(amount[i]);
					rkInfo.setStorageDate(storageDate[i]);
					rkInfo.setIsGifts(isGifts[i]);
					rkInfo.setRemark(remark[i]);
					rklist.add(rkInfo);
				}
				request.setAttribute("rkdetail", rklist);
				map=this.ckorder.addCkApproven(session, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
