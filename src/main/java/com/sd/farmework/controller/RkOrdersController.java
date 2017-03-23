package com.sd.farmework.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.sd.farmework.mapper.RkOrdersMapper;
import com.sd.farmework.pojo.CgOrdersInfo;
import com.sd.farmework.pojo.CkOrdersInfo;
import com.sd.farmework.pojo.RkOrdersInfo;
import com.sd.farmework.pojo.RkOrdersInfoDetail;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.pojo.SysApprovenTask;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.CgOrdersInfoService;
import com.sd.farmework.service.RkOrdersService;
import com.sd.farmework.service.SysApprovenRulePersonService;
import com.sd.farmework.service.SysApprovenTaskService;

/**
 * 入库管理 author 秦波 2017年1月5日 下午3:38:34
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/RkAdmin")
public class RkOrdersController {

	private static Logger logger = Logger.getLogger(RkOrdersController.class);
	@Autowired
	private RkOrdersService rkorder;
	@Autowired
	private CgOrdersInfoService cgOrdersInfoService;
	@Autowired
	private SysApprovenTaskService sysApprovenTaskService;
	@Autowired
	private SysApprovenRulePersonService sysApprovenRulePersonService;
	
	private String approvenFunctionId="00002";

	@ResponseBody
	@RequestMapping(value = "/wxqueryRkInfolist")
	public Object  wxquerylist(Model model,RkOrdersInfo reOrdersInfo,HttpServletRequest request,HttpServletResponse response)throws Exception{
			
		
			List queryList=this.rkorder.queryRkInfo(reOrdersInfo);
			return queryList;
	
		
	}
	@ResponseBody
	@RequestMapping(value = "/wxqueryRkInfoDetaillist")
	public Object wxqueryRkInfoDetaillist(Model model,RkOrdersInfo rkOrdersInfo,HttpServletRequest request,HttpServletResponse response,RkOrdersInfoDetail reOrdersInfoDetail)throws Exception{
		Map map=new HashMap();	
	
		map.put("WXPO", this.rkorder.wxqueryRkInfoDetaillist(rkOrdersInfo));
			
			return map;
	
		
	}
	
	
	@RequestMapping(value = "/queryRkInfolist")
	public String querylist(Model model, RkOrdersInfo reOrdersInfo,
			HttpServletRequest request,HttpSession session,HttpServletResponse response) {

		
		
		String tag = request.getParameter("tag");
		
		if (StringUtil.isExisted(tag, "1")) {
			try {
				HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
				 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
				 reOrdersInfo=(RkOrdersInfo) httpSessionProvider.fillBaseInfo(reOrdersInfo, sessionUserInfo);

				
				reOrdersInfo.setStatus("0");
				int index = 0;
				int maxPage =0;
				index = (reOrdersInfo.getCurrPage()-1)*reOrdersInfo.getPageSize()+1;
				maxPage = reOrdersInfo.getCurrPage()*reOrdersInfo.getPageSize();
				reOrdersInfo.setIndex(index);
				reOrdersInfo.setMaxPage(maxPage);
				
				int count = rkorder.queryRkShenHeCount(reOrdersInfo);
				if(count%reOrdersInfo.getPageSize()==0){
					count=count/reOrdersInfo.getPageSize();
				}else{
					count=count/reOrdersInfo.getPageSize()+1;
				}
				List rkOrderlist = this.rkorder.queryRkShenHe(reOrdersInfo);
				model.addAttribute("totalCount", count);
				model.addAttribute("currPage", reOrdersInfo.getCurrPage());
				model.addAttribute("rkInfo", rkOrderlist);
				model.addAttribute("obj", reOrdersInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
					return "testApproven/storageApproven";
		} else if (StringUtil.isExisted(tag, "2")) {
			try {
				HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
				 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
				 reOrdersInfo=(RkOrdersInfo) httpSessionProvider.fillBaseInfo(reOrdersInfo, sessionUserInfo);

				
				reOrdersInfo.setStatus("1");
				reOrdersInfo.setStatus1("2");
				int index = 0;
				int maxPage =0;
				index = (reOrdersInfo.getCurrPage()-1)*reOrdersInfo.getPageSize()+1;
				maxPage = reOrdersInfo.getCurrPage()*reOrdersInfo.getPageSize();
				reOrdersInfo.setIndex(index);
				reOrdersInfo.setMaxPage(maxPage);
				
				int count = rkorder.queryRkShenHeCounted(reOrdersInfo);
				if(count%reOrdersInfo.getPageSize()==0){
					count=count/reOrdersInfo.getPageSize();
				}else{
					count=count/reOrdersInfo.getPageSize()+1;
				}
				List rkOrderlist = this.rkorder.queryRkShenHeed(reOrdersInfo);
				model.addAttribute("totalCount", count);
				model.addAttribute("currPage", reOrdersInfo.getCurrPage());
				model.addAttribute("rkInfo", rkOrderlist);
				model.addAttribute("obj", reOrdersInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
					return "testApproven/storageApprovened";
			} else {
				try {
					HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
					 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
					 reOrdersInfo=(RkOrdersInfo) httpSessionProvider.fillBaseInfo(reOrdersInfo, sessionUserInfo);

					
					List rkOrderlist = this.rkorder.queryList(reOrdersInfo);
					reOrdersInfo.setTotalCount(rkorder.queryCount(reOrdersInfo));
					model.addAttribute("totalCount", reOrdersInfo.getPageCount());
					model.addAttribute("currPage", reOrdersInfo.getCurrPage());
					model.addAttribute("rkInfo", rkOrderlist);
					model.addAttribute("obj", reOrdersInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
					return "storage/storagelist";
		}

	}

	@RequestMapping(value = "/queryRkInfoDetail")
	public String queryRkInfoDetail(SysApprovenTask obj,Model model, RkOrdersInfo reOrdersInfo,
			RkOrdersInfoDetail reOrdersInfoDetail, HttpServletRequest request) {
		String tag = request.getParameter("tag");
		try {
			reOrdersInfo = (RkOrdersInfo) this.rkorder.queryById(reOrdersInfo);
			model.addAttribute("reOrdersInfo", reOrdersInfo);
			List rkOrderMarketlist = this.rkorder
					.queryRKDetailList(reOrdersInfoDetail);
			obj.setApprovenFunctionId(approvenFunctionId);
			
			obj.setSourceTablePkColumnValue(reOrdersInfo.getRkId());
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
				if(StringUtil.isNotNullOrBlank(tmp.getApprovenEndTime())){
					Date date1 = DateUtil.getDateFromString(tmp.getApprovenEndTime());
					tmp.setApprovenEndTime(DateUtil.getDateString(date1));
				}
			}
			Date date = DateUtil.getDateFromString(reOrdersInfo.getCreateTime());
			reOrdersInfo.setCreateTime(DateUtil.getDateString(date));
			
			
			model.addAttribute("testList", list);
			model.addAttribute("rkOrderMarket", rkOrderMarketlist);
			model.addAttribute("obj", reOrdersInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (StringUtil.isExisted(tag, "1")) {

			return "testApproven/storageApprovenDetail";

		} else if (StringUtil.isExisted(tag, "2")) {
			return "testApproven/storageApprovenedDetail";
		}  else {
			return "storage/storageDetail";
		}

			
		}



	@ResponseBody
	@RequestMapping(value = "/queryRkInfolistForwx")

	public Object  queryRkInfolistForwx(Model model,RkOrdersInfo reOrdersInfo,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws Exception{
			
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		 SysUserInfo sessionUserInfo=httpSessionProvider.getCurrentUserSession(session, request, response);
		 reOrdersInfo=(RkOrdersInfo) httpSessionProvider.fillBaseInfo(reOrdersInfo, sessionUserInfo);

		
		reOrdersInfo.setPageSize((int) 999999999);
			List rklist=new ArrayList();
			//查到所有的入库单
			List rkOrderlist = this.rkorder.queryList(reOrdersInfo);
			for (int i = 0; i < rkOrderlist.size(); i++) {
				RkOrdersInfo tmp = (RkOrdersInfo)rkOrderlist.get(i);
				Date date = DateUtil.getDateFromString(tmp.getCreateTime());
				tmp.setCreateTime(DateUtil.getDateString(date));
			}
			for(int i=0;i<rkOrderlist.size();i++){
				RkOrdersInfo rkdetail=(RkOrdersInfo) rkOrderlist.get(i);
				List rkOrderlist1=this.rkorder.queryRKDetailList(rkdetail);
				RkOrdersInfoDetail rkinfodetail=new RkOrdersInfoDetail();
				//如果物资条数为0,则此订单不显示
				if(rkOrderlist1.size()>0){
					//物资库存为零
					for(int j=0;j<rkOrderlist1.size();j++){
						rkinfodetail=(RkOrdersInfoDetail) rkOrderlist1.get(j);
						if(!rkinfodetail.getRealNum().equals("0")){
							rklist.add(rkdetail);
							break;
						}
					}
				}
			}
			return rklist;
	}

	@ResponseBody
	@RequestMapping(value = "/queryRkInfoDetailForwx")
	public void  queryRkInfoDetailForwx(SysApprovenRulePerson obj,HttpServletResponse response,Model model,RkOrdersInfo reOrdersInfo,RkOrdersInfoDetail reOrdersInfoDetail) throws Exception{
			reOrdersInfo = (RkOrdersInfo) this.rkorder.queryById(reOrdersInfo);
			model.addAttribute("reOrdersInfo", reOrdersInfo);
			reOrdersInfo.setPageSize((int)9999999);
			List rkOrderMarketlist=this.rkorder.queryRKDetailList(reOrdersInfoDetail);
			obj.setApprovenRuleId("0000000002");
			List<BaseInfo> approvePersonList = sysApprovenRulePersonService.queryList(obj);
			JSONObject json=new JSONObject();
			JSONObject json2=new JSONObject();
			JSONObject json1=new JSONObject();
			JSONArray array=new JSONArray();
			List list=new ArrayList();
			List date=new ArrayList();
			String crTime = reOrdersInfo.getCreateTime();
			if(StringUtil.isNotNullOrBlank(crTime)){
				reOrdersInfo.setCreateTime(crTime.substring(0, crTime.length()-2));
			}
			json1.put("approvePerson", approvePersonList);
			json.put("name", "单据号:<b>"+reOrdersInfo.getReceiptNo()+"</b>");
			json.put("list1", JSONArray.fromObject(reOrdersInfo));
			
			RkOrdersInfoDetail rkinfodetail=new RkOrdersInfoDetail();
			for(int i=0;i<rkOrderMarketlist.size();i++){
				rkinfodetail=(RkOrdersInfoDetail) rkOrderMarketlist.get(i);
				if(!rkinfodetail.getRealNum().equals("0")){
					date.add(rkinfodetail);
				}
			}
			response.setCharacterEncoding("UTF-8");
			json.put("list", JSONArray.fromObject(date));
			json2.put("name", "单据时间:<b>" + reOrdersInfo.getCreateTime()
					+ "</b>");
			
			json2.put("list1", list);
			json2.put("list", list);
			array.add(json1);
			array.add(json);
			array.add(json2);
			response.getWriter().write(array.toString());
	}	
	/**
	 * 入库
	 * 
	 * @param model
	 * @param reOrdersInfo
	 * @param reOrdersInfoDetail
	 * @return
	 */
	@RequestMapping(value = "/wxRkInfo")
	public void wxRkInfo(HttpSession session,Model model, HttpServletRequest request,
			CgOrdersInfo cgOrdersInfo,HttpServletResponse response) {

		
		System.out.println("------------------------------");
		String no = request.getParameter("no");
		String strHtml = request.getParameter("strHtml");
		if (StringUtil.isNotNullOrBlank(no)
				&& StringUtil.isNotNullOrBlank(strHtml)) {
			List<List> allList = new ArrayList<List>();
			try {
				String[] strHtmlArr = strHtml.split("---");
				for (int i = 0; i < strHtmlArr.length; i++) {
					List list = getData(strHtmlArr[i]);
					allList.add(list);
				}
				cgOrdersInfo.setOrderNo(no);
				BaseInfo cgOrder = cgOrdersInfoService.queryById(cgOrdersInfo);

				CgOrdersInfo c = (CgOrdersInfo) cgOrder;
				request.setAttribute("c", c);
				List cgDtalList = cgOrdersInfoService
						.queryByOrderNo(cgOrdersInfo);
				
				RkOrdersInfo rkOrdersInfo = new RkOrdersInfo();
				String dataNo = String.valueOf(System.currentTimeMillis());
				rkOrdersInfo.setReceiptNo(dataNo); 
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String time = format.format(date);
				rkOrdersInfo.setReceiptDate(time);
				rkOrdersInfo.setBusinessProcess(c.getBusinessProcess());
				rkOrdersInfo.setCgTeam(c.getPurchaseTeam());
				rkOrdersInfo.setPurchasePerson(c.getPurchasePerson());
				rkOrdersInfo.setSupplyShop(c.getSupplyShop());
				rkOrdersInfo.setRemark(c.getRemark());
				rkOrdersInfo.setStatus("0");
				rkOrdersInfo.setOrderNo(cgOrdersInfo.getOrderNo());
				
				Map map = new HashMap();
				 try {
					 request.setAttribute("approvenFunctionId", approvenFunctionId);
					 request.setAttribute("obj", rkOrdersInfo);
					 request.setAttribute("allList", allList);
					 
					 request.setAttribute("cgDtalList", cgDtalList);
					map = rkorder.addApproven(session, request, response);
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					if(e.getMessage().equals("001")){
					 
						map.put("code","001");
						map.put("msg","没有定义审批流程");
					}else{
						map.put("code",e.getMessage());
						map.put("msg","没有定义审批流程");
					}
				}
				
			///	rkorder.addRkCgOrderInfo(rkOrdersInfo,cgDtalList);
				JSONObject json = JSONObject.fromObject(map);
			 
				response.getWriter().print(json.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	List<String> getData(String a) {
		List list =new ArrayList();
		String regx = "<label class=\"name\">商品名称:([\\s\\S]*)</label>";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(a);
		int i= 0;
		while (m.find()) {
			String b = m.group(1).substring(0, m.group(1).indexOf("</label><label class=\"price\">"));
			System.out.println("商品名称:" +b );
			list.add(i,b);
		}
		i++;
		String[] split = a.split("///");
		list.add(i,split[1]);
		return list;
	}
}
