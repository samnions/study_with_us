package com.sd.farmework.common.util;

import com.sd.farmework.pojo.SysLogInfo;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysLogInfoService;

public class OperationLogUtil {

	public static void writeLog(SysLogInfoService sysLogInfoService,String context,SysUserInfo userinfo){
		
		SysLogInfo sysLogInfo = new SysLogInfo();
		sysLogInfo.setOperatePersonId(userinfo.getUserId());
		sysLogInfo.setOperatePersonName(userinfo.getUserName());
		sysLogInfo.setFunctionName(context);
		try {
			
			sysLogInfoService.add(sysLogInfo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
