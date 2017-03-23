package com.sd.farmework.controller;

import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysApprovenFunction;
import com.sd.farmework.pojo.SysApprovenFunctionRule;
import com.sd.farmework.pojo.SysApprovenRulePerson;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysApprovenFunctionRuleService;
import com.sd.farmework.service.SysApprovenFunctionService;
import com.sd.farmework.service.SysApprovenRulePersonService;
import com.sd.farmework.service.SysLogInfoService;
import com.sd.farmework.service.SysUserInfoService;


/**
 * 用户定制通用接口
 * @author 
 * 2016-09-05
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/approven")
public class SysApprovenController {
	private static Logger logger = Logger.getLogger(SysApprovenController.class);
	 
	
	@Autowired
	private SysApprovenFunctionRuleService sysApprovenFunctionRuleService;
	
	@Autowired
	private SysApprovenFunctionService sysApprovenFunctionService;
	@Autowired
	private SysApprovenRulePersonService sysApprovenRulePersonService;
	 
	@Autowired
	private SysUserInfoService sysUserInfoService;
	@Autowired
	private SysLogInfoService sysLogInfoService;
	/**
	 *  
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String  addUserPanel(SysUserInfo user,Model model){
		return "sysManage/approven/index";
	}
	 
	
	

	/**
	 * 查询所有审理业务类型
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/approvenFunctionDataList", method = RequestMethod.POST)
	public String approvenFunctionDataList(SysApprovenFunction obj, Model model,HttpServletResponse response) throws Exception {
		  
		List<BaseInfo> list = this.sysApprovenFunctionService.queryList(obj);
  
 		model.addAttribute("list", list);
 		response.setCharacterEncoding("utf-8");
 		response.getWriter().write(JSONArray.fromObject(list).toString());
 		
 		
		return null;
	}


	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/approvenFunctionList", method = RequestMethod.GET)
	public String approvenFunctionList(SysApprovenFunction obj, Model model) throws Exception {
		  
		 
		return "sysManage/approven/approvenFunctionList";
	}

	 
	
	/**
	 * 查询所有审理业务类型
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/approvenFunctionRuleDataList", method = RequestMethod.POST)
	public String approvenFunctionRuleDataList(SysApprovenFunctionRule obj, Model model,HttpServletResponse response) throws Exception {
		  
		List<BaseInfo> list = this.sysApprovenFunctionRuleService.queryList(obj);
 		model.addAttribute("list", list);
 		response.setCharacterEncoding("utf-8");
 		
 		response.getWriter().write(JSONArray.fromObject(list).toString());
 		
 		
		return null;
	}


	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/approvenFunctionRuleList", method = RequestMethod.GET)
	public String approvenFunctionRuleList(SysApprovenFunctionRule obj, Model model) throws Exception {
		  
		model.addAttribute("approvenFunctionId", obj.getApprovenFunctionId()) ;
		model.addAttribute("approvenFunctionName", obj.getApprovenFunctionName()) ;
		
		return "sysManage/approven/approvenFunctionRuleList";
	}

	/**
	 * 查询所有审理业务类型
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody 
	 
 	@RequestMapping(value = "/approvenFunctionRulePersonDataList", method = RequestMethod.POST)
	public String approvenFunctionRulePersonDataList(SysApprovenFunctionRule obj, Model model,HttpServletResponse response) throws Exception {
	 
		 //通过sys_approven_function_rule 表获取编号
		 
 		 int count =sysApprovenRulePersonService.queryCount(obj);
		 List  list= sysApprovenRulePersonService.queryListByPage(obj);
		
			Map map = new HashMap();
			map.put("total", count);
			map.put("rows", JSONArray.fromObject(list));
			JSONObject ojb =JSONObject.fromObject(map);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(ojb.toString());
 	 
 		 
 		
 		
		return null;
	}


	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */ 
	@RequestMapping(value = "/approvenFunctionRulePersonList", method = RequestMethod.GET)
	public String approvenFunctionRulePersonList(SysApprovenRulePerson obj, Model model) throws Exception {
		  
		model.addAttribute("approvenRuleId", obj.getApprovenRuleId()) ; 
		model.addAttribute("approvenRuleName", obj.getApprovenRuleName()) ; 
		model.addAttribute("approvenFunctionId", obj.getApprovenFunctionId()) ; 
		model.addAttribute("approvenFunctionName", obj.getApprovenFunctionName()) ; 
		
		return "sysManage/approven/approvenFunctionRulePersonList";
	}

	
	/**
	 * 添加用户页面
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addTurnTo", method = RequestMethod.GET)
	public String  addTurnTo(Model model,HttpServletRequest request,String approvenFunctionId,String approvenFunctionName,String approvenRuleId,String approvenRuleName,String type){
		
 
		model.addAttribute("approvenFunctionId", approvenFunctionId);
		model.addAttribute("approvenFunctionName", approvenFunctionName);
		model.addAttribute("approvenRuleId", approvenRuleId);
		model.addAttribute("approvenRuleName", approvenRuleName);
		model.addAttribute("type", type);
		
		if("rule".equals(type)){
			
			return "sysManage/approven/addApprovenFunctionRule";
		}else if("person".equals(type)){
			return "sysManage/approven/addApprovenFunctionRulePerson";

		}
		return "error";
	}
	 
	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/approvenFunctionRuleAdd", method = RequestMethod.POST)
	public String approvenFunctionRuleAdd(SysApprovenFunctionRule obj, Model model,HttpServletRequest request) throws Exception {
		sysApprovenFunctionRuleService.add(obj);
		 
		model.addAttribute("code","000");
		
		
		return addTurnTo(model,request,"","","","","");
	}
	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/approvenFunctionRulePersonAdd", method = RequestMethod.POST)
	public String approvenFunctionRulePersonAdd(SysApprovenRulePerson obj, Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
	 
		 
		HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
		obj=(SysApprovenRulePerson)httpSessionProvider.fillBaseInfo(obj, session, request, response);
		obj.setApprovenRuleId(StringUtil.fullNumberByLength(obj.getApprovenRuleId()));
		int count=	sysApprovenRulePersonService.queryPersonCount(obj);
		Map map = new HashMap();
		if(count==0){	
			sysApprovenRulePersonService.add(obj);
			map.put("code", "000");
			map.put("msg", "信息保存成功");
		}else{
			map.put("code", "001");
			map.put("msg", "已经是审批人了，请务重复添加");
		}
		response.setCharacterEncoding("utf-8");
		 
		PrintWriter out = response.getWriter();
		
		 
		JSONObject json =JSONObject.fromObject(map);
		out.write(json.toString());
		 
		out.close();
		 
		return null;
	}
	 
	/**
	 * 查询所有
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody 
	@RequestMapping(value = "/queryUserList", method = RequestMethod.POST)
	public String queryUserList(SysUserInfo user, Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		user.setCurrPage(page);
		user.setPageSize(rows);
		List<BaseInfo> list = this.sysUserInfoService.queryListByPage(user);
		user.setTotalCount(sysUserInfoService.queryCount(user));
		model.addAttribute("userList", list);
 		model.addAttribute("list", list);
 		JSONArray array=new JSONArray();
 		JSONObject json=new JSONObject();
 		json.put("total", user.getTotalCount());
 		json.put("rows", array.fromObject(list));
 		response.setCharacterEncoding("utf-8");
 		response.getWriter().write(json.toString());
		return null;
	}
	/**
	 * 删除审批人
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/approvenFunctionRulePersonDelete", method = RequestMethod.POST)
	public String approvenFunctionRulePersonDelete(SysApprovenRulePerson obj, Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
 		
		sysApprovenRulePersonService.deleteAndOrder(obj);
		JSONObject json=new JSONObject();
		Map map=new HashMap();	
		map.put("code","000");
		map.put("msg","删除成功");
		response.getWriter().write(json.toString());
		return null;
	}
	/**
	 * 删除审批规则
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/approvenFunctionRuleDelete", method = RequestMethod.POST)
	public String approvenFunctionRuleDelete(SysApprovenFunctionRule obj, Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
	 
 		
		sysApprovenFunctionRuleService.delete(obj);
		JSONObject json=new JSONObject();
		Map map=new HashMap();	
		map.put("code","000");
		map.put("msg","删除成功");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
		return null;
	}
	 
}
