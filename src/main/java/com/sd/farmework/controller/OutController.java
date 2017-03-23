package com.sd.farmework.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/outSystem")
public class OutController {

	@ResponseBody
	@RequestMapping(value="/out")
	public void out(HttpServletRequest request,HttpServletResponse response){
		
		request.getSession().invalidate();
		
		try {
			
			response.getWriter().print("f");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
