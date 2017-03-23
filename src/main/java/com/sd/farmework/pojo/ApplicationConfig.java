package com.sd.farmework.pojo;

/**
 * 系统配置
 * @category 2016-11-30
 * @author 王超超 
 */
public class ApplicationConfig {
	
	/*
	 * 短信服务配置
	 */
	public String SENDMsgApiUrl;//api地址
	public String SDGMAccount;//账号
	public String SDGMPwd;//密码
	public String SDGMSupplier;
	public String SDGMMsg;
	public String SDGMSendMsg;
	public String SDGMChannel;//通道号

	




	public String getSENDMsgApiUrl() {
		return SENDMsgApiUrl;
	}
	public void setSENDMsgApiUrl(String sENDMsgApiUrl) {
		SENDMsgApiUrl = sENDMsgApiUrl;
	}
	public String getSDGMAccount() {
		return SDGMAccount;
	}
	public void setSDGMAccount(String sDGMAccount) {
		SDGMAccount = sDGMAccount;
	}
	public String getSDGMPwd() {
		return SDGMPwd;
	}
	public void setSDGMPwd(String sDGMPwd) {
		SDGMPwd = sDGMPwd;
	}
	public String getSDGMSupplier() {
		return SDGMSupplier;
	}
	public void setSDGMSupplier(String sDGMSupplier) {
		SDGMSupplier = sDGMSupplier;
	}
	public String getSDGMMsg() {
		return SDGMMsg;
	}
	public void setSDGMMsg(String sDGMMsg) {
		SDGMMsg = sDGMMsg;
	}
	public String getSDGMSendMsg() {
		return SDGMSendMsg;
	}
	public void setSDGMSendMsg(String sDGMSendMsg) {
		SDGMSendMsg = sDGMSendMsg;
	}
	public String getSDGMChannel() {
		return SDGMChannel;
	}
	public void setSDGMChannel(String sDGMChannel) {
		SDGMChannel = sDGMChannel;
	}

	
}
