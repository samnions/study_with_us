package com.sd.farmework.controller; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.MD5Util;
import com.sd.farmework.common.SessionProvider;
import com.sd.farmework.common.WxConstant;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.common.util.WeixinUtil;
import com.sd.farmework.pojo.SysFunctionInfo;
import com.sd.farmework.pojo.SysRoleInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysFunctionInfoService;
import com.sd.farmework.service.SysRoleInfoService;
import com.sd.farmework.service.SysUserInfoService;
/** 
 * 组织架构表
 * @author Administrator 
 * 
 */ 
 @Controller
 @Scope("prototype")
 @RequestMapping(value="/SysUserInfo")
public class SysUserInfoController{ 
    @Autowired
    private SysUserInfoService SysUserInfoService;
    @Autowired
    private SysFunctionInfoService sysFunctionInfoService;
    @Autowired
    private SysRoleInfoService sysRoleInfoService;   
    //@Autowired
    private WxConstant wxConstant = new WxConstant();
    
    /**
    * 添加
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  add(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model){
		try {
			
	    	SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo.getLoginPwd()));
	    	HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
	    	SysUserInfo=(SysUserInfo)	httpSessionProvider.fillBaseInfo(SysUserInfo, session, request, response);
			
			SysUserInfoService.add(SysUserInfo);	
			Map map = new HashMap();
			
			map.put("code", "000");
			map.put("msg", "success");
			JSONObject obj = JSONObject.fromObject(map);
			response.getWriter().write(obj.toString());
			response.getWriter().close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 修改
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    /**
     * 修改
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/update",method = RequestMethod.POST)
     public String  update(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model,String oldloginPwd){
 		try {
 			if(!oldloginPwd.equals(SysUserInfo.getLoginPwd())){
 				SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo.getLoginPwd()));
 			}
 	    	HttpSessionProvider httpSessionProvider = new HttpSessionProvider();
 	    	SysUserInfo=(SysUserInfo)	httpSessionProvider.fillBaseInfo(SysUserInfo, session, request, response);
 	    	
 	    	SysUserInfoService.update(SysUserInfo);	
 			Map map =new HashMap();
 			map.put("code", "000");
 			map.put("msg", "success");
 			JSONObject obj = JSONObject.fromObject(map);
 			response.getWriter().write(obj.toString());
 			response.getWriter().close();
 		} catch (Exception e) {
 		// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return null;
 	}
    @RequestMapping(value = "/editSysUserInfo",method = RequestMethod.GET)
    public String  editSysUserInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model,String userId){
        try {
			SysUserInfo sysUserInfo=(SysUserInfo) SysUserInfoService.queryByPkId(userId);
			 model.addAttribute("sysUserInfo", sysUserInfo);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	return "sysManage/sysUserInfo/editSysUserInfo";
    }
    /**
    * 修改
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String  delete(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model){
		try {
			SysUserInfoService.delete(SysUserInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 查询不分页列表
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    public String  queryList(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model){
		try {
			SysUserInfoService.queryList(SysUserInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
    * 查询分页列表
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/queryListByPage",method = RequestMethod.POST)
    public String  queryListByPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model){
		try {
			SysUserInfoService.queryCount(SysUserInfo);	
			SysUserInfoService.queryListByPage(SysUserInfo);	
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    /**
     * 查询分页列表
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/queryListByPageIndex",method = RequestMethod.GET)
     public String  queryListByPageIndex(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo sysUserInfo,Model model){
    	try {
 			List list=SysUserInfoService.queryListByPage(sysUserInfo);
 			sysUserInfo.setTotalCount(SysUserInfoService.queryCount(sysUserInfo));
			model.addAttribute("list",list);
			model.addAttribute("obj",sysUserInfo);
			model.addAttribute("currPage",sysUserInfo.getCurrPage());
			model.addAttribute("totalCount",sysUserInfo.getPageCount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
 		return "sysManage/sysUserInfo/list";
 	}
     /**
      * 查询分页列表
      * @param session
      * @param request
      * @param response
      * @param SysApprovenFunction
      * @param model
      * @return
      */
      @RequestMapping(value = "/mianContent",method = RequestMethod.GET)
      public String  mianContent(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model){
     	 
    	  HttpSessionProvider p =new HttpSessionProvider();
    	  SysUserInfo sysUserInfo =  p.getCurrentUserSession(session, request, response);
  		
    	  model.addAttribute("userName", sysUserInfo.getUnitName());
    	  return "main";
  	}
    
      
    /**
    * 登录
    * @param session
    * @param request
    * @param response
    * @param SysApprovenFunction
    * @param model
    * @return
    */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String  query(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model){
    	try {
	    	SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo.getLoginPwd()));
			List<BaseInfo> list=	SysUserInfoService.query(SysUserInfo);	
			System.out.println(list);
			String msg = "000";
			if(list.size()==0){
				msg = "001";
				request.getRequestDispatcher("../index.html").forward(request, response);
				return null;
			}else if(list.size()>1){
				msg = "002";
				request.getRequestDispatcher("../index.html").forward(request, response);
				return null;
			}else{
				SysUserInfo sysUserInfo =  (SysUserInfo)list.get(0);
				session.setAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY, sysUserInfo);
				model.addAttribute("userInfo",sysUserInfo);
				
				List functionInfoList = sysFunctionInfoService.queryList(null);
				
				SysUserInfo sysUserRole = new SysUserInfo();
				sysUserRole.setUserId(sysUserInfo.getUserId());
				List sysUserRoleList= 	sysRoleInfoService.queryFunction(sysUserRole);
				
				StringBuffer sb =new  StringBuffer();
				
				for (int i = 0; i < sysUserRoleList.size(); i++) {
					SysRoleInfo sysUserRoleI = (SysRoleInfo)sysUserRoleList.get(i);
					//sysUserRoleI.get
					sb.append(sysUserRoleI.getFunctionIds());
				}
				LinkedHashMap   functionMap  = new LinkedHashMap  ();
				for(int i =0 ;i<functionInfoList.size();i++){
					
					SysFunctionInfo sysFunctionInfo =(SysFunctionInfo)functionInfoList.get(i);
					String functionId = sysFunctionInfo.getFunctionId();
					String functionName = sysFunctionInfo.getFunctionName();
					if(functionId.length()==6){
						List childList = new  ArrayList();
						for (int j = 0; j < functionInfoList.size(); j++) {
							SysFunctionInfo sysFunctionInfoChild =(SysFunctionInfo)functionInfoList.get(j);
 							if(sb.toString().indexOf(","+sysFunctionInfoChild.getFunctionId()+",")>-1){
								if(sysFunctionInfoChild.getParentFunctionId().equals(functionId)){
									childList.add(sysFunctionInfoChild);
								} 
							
								if(childList.size()>0&&!functionMap.containsKey(functionId+","+functionName)){
									functionMap.put(functionId+","+functionName, childList);
								}
							}
						}
					}
				}
				model.addAttribute("functionMap",functionMap);
				
				
				 
				return "index";
			}
			//request.getRequestDispatcher("../index.html").forward(request, response);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    			e.printStackTrace();
				 
				try {
					String msg = "003";
					response.sendRedirect("../login.html");
					//request.getRequestDispatcher("../index.html").forward(request, response);
				 
					// TODO Auto-generated catch block
					 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
    	}
		 
	}
    /**
     * 登录
     * @param session
     * @param request
     * @param response
     * @param SysApprovenFunction
     * @param model
     * @return
     */
     @RequestMapping(value = "/wxLogin",method = RequestMethod.POST)
     public String  wxLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response,SysUserInfo SysUserInfo,Model model,String redirect_uri){
     	try {
 	    	SysUserInfo.setLoginPwd(MD5Util.GetMD5Code(SysUserInfo.getLoginPwd()));
 			List<BaseInfo> list=	SysUserInfoService.query(SysUserInfo);	
 			System.out.println(list);
 			String msg = "000";
 			if(list.size()==0){
 				msg = "001";
				JSONObject json = new JSONObject();
				json.accumulate("code", msg);
			    response.getWriter().write(json.toString());
			    response.getWriter().close();
  				return null;
 			}else if(list.size()>1){
 				msg = "002";
 				JSONObject json = new JSONObject();
				json.accumulate("code", msg);
			    response.getWriter().write(json.toString());
			    response.getWriter().close();
 				return null;
 			}else{
 				SysUserInfo sysUserInfo =  (SysUserInfo)list.get(0);
 				session.setAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY, sysUserInfo);
 				model.addAttribute("userInfo",sysUserInfo);
 				
 				List functionInfoList = sysFunctionInfoService.queryList(null);
 				
 				SysUserInfo sysUserRole = new SysUserInfo();
 				sysUserRole.setUserId(sysUserInfo.getUserId());
 				List sysUserRoleList= 	sysRoleInfoService.queryFunction(sysUserRole);
 				
 				StringBuffer sb =new  StringBuffer();
 				
 				for (int i = 0; i < sysUserRoleList.size(); i++) {
 					SysRoleInfo sysUserRoleI = (SysRoleInfo)sysUserRoleList.get(i);
 					//sysUserRoleI.get
 					sb.append(sysUserRoleI.getFunctionIds());
 				}
 				LinkedHashMap   functionMap  = new LinkedHashMap  ();
 				for(int i =0 ;i<functionInfoList.size();i++){
 					
 					SysFunctionInfo sysFunctionInfo =(SysFunctionInfo)functionInfoList.get(i);
 					String functionId = sysFunctionInfo.getFunctionId();
 					String functionName = sysFunctionInfo.getFunctionName();
 					if(functionId.length()==6){
 						List childList = new  ArrayList();
 						for (int j = 0; j < functionInfoList.size(); j++) {
 							SysFunctionInfo sysFunctionInfoChild =(SysFunctionInfo)functionInfoList.get(j);
  							if(sb.toString().indexOf(","+sysFunctionInfoChild.getFunctionId()+",")>-1){
 								if(sysFunctionInfoChild.getParentFunctionId().equals(functionId)){
 									childList.add(sysFunctionInfoChild);
 								} 
 							
 								if(childList.size()>0&&!functionMap.containsKey(functionId+","+functionName)){
 									functionMap.put(functionId+","+functionName, childList);
 								}
 							}
 						}
 					}
 				}
 				
 				//绑定用户openid--------start
 				if(StringUtil.isNullOrBlank(sysUserInfo.getWxOpenId())){//为空则说明没有绑定openid
 	 				try {
 	 					String code = request.getParameter("code");
 	 					String[] strCode = null;
 	 					if(StringUtil.isNullOrBlank(code)){
 	 						strCode = new String[]{" "," "};
 	 					}else{
 	 						strCode = code.split("=");
 	 					}
 	 					System.out.println("当前code="+strCode[1]);
 	 	 				Map<String, Object> map = WeixinUtil.getWeiXinOpenId(strCode[1],wxConstant);
 	 	 				String openid = String.valueOf(map.get("openid"));
 	 	 				System.out.println("当前用户的openid："+openid);
 	 					SysUserInfo paramUser = new SysUserInfo();
 	 	 				paramUser.setUserId(sysUserInfo.getUserId());
 	 	 				paramUser.setWxOpenId(openid);
						SysUserInfoService.updateUser(paramUser);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 				}
 				//-------end
 				
 				model.addAttribute("functionMap",functionMap);
 				msg = "000";
				JSONObject json = new JSONObject();
				json.accumulate("code", msg);
				json.accumulate("redirect_uri", redirect_uri);
			    response.getWriter().write(json.toString());
			    response.getWriter().close();
 				return null;
 			}
     	} catch (Exception e) {
     		// TODO Auto-generated catch block
     			e.printStackTrace();
 				 
 				try {
 					JSONObject json = new JSONObject();
 					json.accumulate("code", "003");
 				    response.getWriter().write(json.toString());
 				    response.getWriter().close();
 					// TODO Auto-generated catch block
 					 
 				} catch (IOException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
 				return null;
     	}
 		 
 	}
    
    @RequestMapping(value = "/addSysUserInfo",method = RequestMethod.GET)
    public String  addSysUserInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model,String userId){
        model.addAttribute("userId", userId);
    	return "sysManage/sysUserInfo/addSysUserInfo";
    }
    @RequestMapping(value = "/sysRoleInfo",method = RequestMethod.GET)
    public String  sysRoleInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model,String userId){
        model.addAttribute("userId", userId);
    	return "sysManage/sysUserInfo/sysRoleInfo";
    }
    
}