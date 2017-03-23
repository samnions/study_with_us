package com.sd.farmework.filter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.controller.WxUtilController;

public class LoginFilter implements Filter {
	private static Logger logger = Logger.getLogger(WxUtilController.class);
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
    	 
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        System.out.println("path=="+path);
        //sservletRequest.getH
        String code = servletRequest.getParameter("code");
        String requestType = servletRequest.getParameter("requestType");
        System.out.println("请求渠道code="+code);
        logger.info("请求渠道code="+code);
        // 从session里取员工工号信息
        Object obj=session.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
        Map<String, String> map = new HashMap<String, String>();
 		map.put("weixin/wxlg/rk", "storage.html");
 		map.put("weixin/wxlg/ck", "outwarehouselist.html");
 		map.put("weixin/wxlg/pd", "inventory.html");
 		map.put("weixin/wxlg/sh", "waitTask.html");
        List<String> paths =new  ArrayList<String>();
        paths.add(servletRequest.getContextPath()+"/login.html");
        paths.add("/resources/");
        paths.add("SysUserInfo/query.do");
      //  paths.add("weixin/");
        //创建类Constants.java，里面写的是无需过滤的页面
        for (int i = 0; i < paths.size(); i++) {
            if (path.indexOf(paths.get(i)) > -1) {
            	System.out.println("----come on");
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        } 
        
        // 登陆页面无需过滤
        if (obj == null) { 
        	 if(path.indexOf("/weixin/")==-1){
	           // 跳转到登陆页面
	           servletResponse.sendRedirect(servletRequest.getContextPath()+"/login.html");
	           PrintWriter out = response.getWriter();
	           String url = servletRequest.getContextPath() + "/login.html";
	           out.println("<script language=\"javascript\">");//利用js跳出iframe。
	           out.println("top.location=\"" + url + "\";");
	           out.println("</script>");
        	 }else{
        		 StringBuffer urlPath = new StringBuffer();
        		 for (String key : map.keySet()) {
        				if (path.indexOf(key) > -1) {
        					urlPath.append(servletRequest.getContextPath() + "/weixin/");
        					urlPath.append("login.html");
        					urlPath.append("?redirect_uri=");
        					urlPath.append(servletRequest.getContextPath() + "/weixin/");
        					urlPath.append(map.get(key));
        					urlPath.append("&code=");
        					urlPath.append(code);
        					break;
        				}
        		 }
        		 if(StringUtil.isNullOrBlank(urlPath.toString())){
        			// 已经登陆,继续此次请求
        	        chain.doFilter(request, response);
        		 }else{
        			 System.out.println("url1:"+urlPath.toString());
            		 logger.info("url1:"+urlPath.toString());
            		 servletResponse.sendRedirect(urlPath.toString()); 
            		 return;
        		 }
        		 //servletResponse.sendRedirect(servletRequest.getContextPath() + "/weixin/login.html?redirect_uri="+path); 
        		 
        	 }
       } 
        if(path.indexOf("/weixin/")>-1){
			if (obj == null) { 
				StringBuffer urlPath = new StringBuffer();
	       		 for (String key : map.keySet()) {
	       				if (path.indexOf(key) > -1) {
	       					urlPath.append(servletRequest.getContextPath() + "/weixin/");
        					urlPath.append("login.html");
        					urlPath.append("?redirect_uri=");
        					urlPath.append(servletRequest.getContextPath() + "/weixin/");
        					urlPath.append(map.get(key));
        					urlPath.append("&code=");
        					urlPath.append(code);
        					break;
	       				}
	       		 }
	       		if(StringUtil.isNullOrBlank(urlPath.toString())){
        			// 已经登陆,继续此次请求
        	        chain.doFilter(request, response);
        		 }else{
        			 System.out.println("url2:"+urlPath.toString());
     	       		 logger.info("url2:"+urlPath.toString());
     	       		 servletResponse.sendRedirect(urlPath.toString()); 
            		 return;
        		 }
				//servletResponse.sendRedirect(servletRequest.getContextPath() + "/weixin/login.html?redirect_uri="+path);
			} else{
				StringBuffer urlPath = new StringBuffer();
				if(path.indexOf("weixin/wxlg/rk")>-1){
					urlPath.append(servletRequest.getContextPath() + "/weixin/");
					urlPath.append("storage.html");
					servletResponse.sendRedirect(urlPath.toString()); 
				}else if(path.indexOf("weixin/wxlg/ck")>-1){
					urlPath.append(servletRequest.getContextPath() + "/weixin/");
					urlPath.append("outwarehouselist.html");
					servletResponse.sendRedirect(urlPath.toString()); 
				}else if(path.indexOf("weixin/wxlg/pd")>-1){
					urlPath.append(servletRequest.getContextPath() + "/weixin/");
					urlPath.append("inventory.html");
					servletResponse.sendRedirect(urlPath.toString()); 
				}else if(path.indexOf("weixin/wxlg/sh")>-1){
					urlPath.append(servletRequest.getContextPath() + "/weixin/");
					urlPath.append("waitTask.html");
					servletResponse.sendRedirect(urlPath.toString()); 
				}else{
					// 已经登陆,继续此次请求
		            chain.doFilter(request, response);
				}	
	       }
        }else{
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }
       

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

}