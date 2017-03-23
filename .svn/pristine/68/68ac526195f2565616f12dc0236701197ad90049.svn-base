package com.sd.farmework.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sd.farmework.common.PropertiesConstant;
import com.sd.farmework.pojo.RemoteObject;
import com.sd.farmework.pojo.RemoteObjectDetail;

/**
 * 连接oracle数据库
 *  @author wangchaochao
 *  
 *  2016-10-21
 */
@Controller
public class JDBCPostgresqlUtil {
	 
	private  PropertiesConstant propertiesConstant;
	 
	public PropertiesConstant getPropertiesConstant() {
		return propertiesConstant;
	}




	public void setPropertiesConstant(PropertiesConstant propertiesConstant) {
		this.propertiesConstant = propertiesConstant;
	}



	private static Logger logger = Logger.getLogger(JDBCPostgresqlUtil.class);
	 
	

	public  Connection initConfig(){
		
		logger.info("-------- oracle JDBC Connection Testing ------------");
		 
		 try {
			 
             Class.forName("oracle.jdbc.OracleDriver");

	     } catch (ClassNotFoundException e) {
	
	    	 logger.info("Where is your oracle JDBC Driver? "
	                             + "Include in your library path!");
	             e.printStackTrace();
	             return null;
	     }
		 
		 logger.info("oracle JDBC Driver Registered!");
		 Connection connection = null;
		 try {

            
			 connection = DriverManager.getConnection(
					 propertiesConstant.getUrl(), propertiesConstant.getUserName(),
            		 propertiesConstant.getPassWord());
             logger.info("connection:"+connection);

	     } catch (SQLException e) {
	    	 logger.info("Connection Failed! Check output console");
             e.printStackTrace();
             return null;
	     }
		 return connection;
	}
	
	
	
	 
	 //查询多条数据
	 public  List<RemoteObject> getDataInfo(String sql){
		 System.out.println("获取订单基础信息sql="+sql);
		 Connection connection = initConfig();
		 List<RemoteObject> resultList = null;
		 if (connection != null) {
			 logger.info("You made it, take control your database now!");
			 resultList = new ArrayList<RemoteObject>();
			 try {
				 //System.out.println(sql);
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);
				RemoteObject  respObj= null;
				while (rs.next()){
					respObj = new RemoteObject();
					respObj.setOrderNo(rs.getString(1).trim());
					respObj.setCompany(rs.getString(2).trim());
					respObj.setBusinessProcess(rs.getString(3).trim());
					respObj.setCgZz(rs.getString(4).trim());
					respObj.setSupplyShop(rs.getString(5).trim());
					respObj.setPurchasePerson(rs.getString(6).trim());
					respObj.setPurchaseTeam(rs.getString(7).trim());
					respObj.setIsTh(rs.getString(8).trim());
					respObj.setOrderDate(rs.getString(9).trim());
					respObj.setRemark(rs.getString(10).trim());
					respObj.setCreateUserName(rs.getString(11).trim());
					respObj.setUpdateUserName(rs.getString(12).trim());
					respObj.setApprovenPerson(rs.getString(13).trim());
					respObj.setApprovenDate(rs.getString(14).trim());
					respObj.setOrderStauts(rs.getString(15).trim());
					
					resultList.add(respObj);
				} 
				rs.close();
				st.close();
				connection.close();
				logger.info("查询数据完成!resultList="+resultList.toString());
				logger.info("总记录!"+resultList.size()+"条记录");
				//logger.info("查询数据完成!resultList="+resultList.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
	     } else {
	         logger.info("Failed to make connection!");
	         return null;
	     }
		 
		 return resultList;
	 }
	 
	 
	 
	 public  List<RemoteObjectDetail> getDataDetail(String sql){
		 //System.out.println("获取订单详情sql="+sql);
		 logger.info("获取订单详情sql="+sql);
		 Connection connection = initConfig();
		 List<RemoteObjectDetail> resultList = null;
		 if (connection != null) {
			 logger.info("You made it, take control your database now!");
			 resultList = new ArrayList<RemoteObjectDetail>();
			 try {
				 //System.out.println(sql);
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);
				RemoteObjectDetail  respObj= null;
				while (rs.next()){
					respObj = new RemoteObjectDetail();
					respObj.setOrderNo(rs.getString(1).trim());
					respObj.setStockNo(rs.getString(2).trim());
					respObj.setStockName(rs.getString(3).trim());
					respObj.setStandard(rs.getString(4).trim());
					respObj.setUnit(rs.getString(5).trim());
					respObj.setNum(rs.getString(6).trim());
					respObj.setTaxationPrice(rs.getString(7).trim());
					respObj.setPrice(rs.getString(8).trim());
					respObj.setDiscountRate(rs.getString(9).trim());
					respObj.setAmount(rs.getString(10).trim());
					respObj.setTaxationType(rs.getString(11).trim());
					respObj.setTaxationRate(rs.getString(12).trim());
					respObj.setSum(rs.getString(13).trim());
					respObj.setCreateUserId(rs.getString(14).trim());
					resultList.add(respObj);
				} 
				rs.close();
				st.close();
				connection.close();
				System.out.println("查询详情数据完成!resultList="+resultList.toString());
				logger.info("查询详情数据完成!resultList="+resultList.toString());
				logger.info("总记录!"+resultList.size()+"条记录");
				//logger.info("查询数据完成!resultList="+resultList.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
	     } else {
	         logger.info("Failed to make connection!");
	         return null;
	     }
		 
		 return resultList;
	 }
	 
	
}
