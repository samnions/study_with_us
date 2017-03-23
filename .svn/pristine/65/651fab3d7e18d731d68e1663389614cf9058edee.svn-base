package com.sd.farmework.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
@RequestMapping(value = "/menu")
public class MenuController {

	/**
	 * 用户管理 
	 */
	@RequestMapping(value = "/userInfolist", method = RequestMethod.GET)
	public String userInfolist(Model model) {

		return "systemmanagement/userlist";
	}
	
	/**
	 * 修改用户
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public String updateUser(Model model) {

		return "systemmanagement/updateUser";
	}

	/**
	 * 权限管理 
	 */
	@RequestMapping(value = "/permissmanger", method = RequestMethod.GET)
	public String permissmanger(Model model) {

		return "systemmanagement/permissionslist";
	}
	
	/**
	 *角色详情
	 */
	@RequestMapping(value = "/roleDetail", method = RequestMethod.GET)
	public String roleDetail(Model model) {

		return "systemmanagement/roledetail";
	}
	
	/**
	 *角色管理 
	 */
	@RequestMapping(value = "/roleManager", method = RequestMethod.GET)
	public String roleManager(Model model) {

		return "systemmanagement/rolelist";
	}
	
	
	/**
	 * 审批流设置 
	 */
	@RequestMapping(value = "/approvalManager", method = RequestMethod.GET)
	public String approvalManager(Model model) {

		return "systemmanagement/approven/index";
	}
	
	
	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
	public String updatePassword(Model model) {

		return "systemmanagement/updatePwd";
	}
	
	/**
	 * 采购订单列表 
	 */
	@RequestMapping(value = "/PurchaseOrderlist", method = RequestMethod.GET)
	public String PurchaseOrderList(Model model) {

		return "purchaseOrder/purchaseOrderlist";
	}
	/**
	 * 采购订单详情
	 */
	@RequestMapping(value = "/PurchaseOrderDetail", method = RequestMethod.GET)
	public String PurchaseOrderDetail(Model model) {

		return "purchaseOrder/purchaseOrderDetail";
	}
	/**
	 * 采购订单上传
	 */
	@RequestMapping(value = "/upPurchaseOrder", method = RequestMethod.GET)
	public String upPurchaseOrder(Model model) {

		return "redirect:PurchaseOrderlist.do";
	}
	
	
	/**
	 * 入库单列表
	 */
	@RequestMapping(value = "/Storagelist", method = RequestMethod.GET)
	public String Storagelist(Model model) {

		return "storage/storagelist";
	}
	/**
	 * 入库单列表详情
	 */
	@RequestMapping(value = "/StorageDetail", method = RequestMethod.GET)
	public String StorageDetail(Model model) {

		return "storage/storageDetail";
	}
	/**
	 * 入库订单上传
	 */
	@RequestMapping(value = "/upStorage", method = RequestMethod.GET)
	public String upStorage(Model model) {

		return "redirect:Storagelist.do";
	}

	/**
	 * 盘点单列表
	 */
	@RequestMapping(value = "/InventorySinglelist", method = RequestMethod.GET)
	public String InventorySinglelist(Model model) {

		return "inventorySingle/inventorySinglelist";
	}

	/**
	 * 盘点单列表详情
	 */
	@RequestMapping(value = "/InventorySingleDetail", method = RequestMethod.GET)
	public String InventorySingleDetail(Model model) {

		return "inventorySingle/inventorySingleDetail";
	}
	/**
	 * 盘点单上传
	 */
	@RequestMapping(value = "/upInventorySingle", method = RequestMethod.GET)
	public String upInventorySingle(Model model) {

		return "redirect:InventorySinglelist.do";
	}
	
	/**
	 * 出库单列表
	 */
	@RequestMapping(value = "/Outboundlist", method = RequestMethod.GET)
	public String Outboundlist(Model model) {

		return "outbound/outboundlist";
	}
	/**
	 * 出库单详情
	 */
	@RequestMapping(value = "/OutboundDetail", method = RequestMethod.GET)
	public String OutboundDetail(Model model) {

		return "outbound/outboundDetail";
	}
	/**
	 * 盘点单上传
	 */
	@RequestMapping(value = "/upOutbound", method = RequestMethod.GET)
	public String upOutbound(Model model) {

		return "redirect:Outboundlist.do";
	}
	
	/**
	 * 入库单审核
	 */
	@RequestMapping(value = "/StorageApproval", method = RequestMethod.GET)
	public String StorageApproval(Model model) {

		return "testApproven/storageApproven";
	}
	

	/**
	 * 盘点单审核
	 */
	@RequestMapping(value = "/InventorySingleApproval", method = RequestMethod.GET)
	public String InventorySingleApproval(Model model) {

		return "testApproven/InventoryApproven";
	}
	
	
	/**
	 * 出库单审核
	 */
	@RequestMapping(value = "/OutboundApproval", method = RequestMethod.GET)
	public String OutboundApproval(Model model) {

		return "testApproven/outboundApproven";
	}
	
	
	/**
	 * 入库审核详情
	 */
	@RequestMapping(value = "/StorageApprovaldetail", method = RequestMethod.GET)
	public String StorageApprovaldetail(Model model) {

		return "testApproven/storageApprovenDetail";
	}

	
	/**
	 * 盘点审核详情
	 */
	@RequestMapping(value = "/InventorySingleApprovaldetail", method = RequestMethod.GET)
	public String InventorySingleApprovaldetail(Model model) {

		return "testApproven/InventorySingleApprovenDetail";
	}

	
	/**
	 * 出库审核详情
	 */
	@RequestMapping(value = "/OutboundApprovaldetail", method = RequestMethod.GET)
	public String OutboundApprovaldetail(Model model) {

		return "testApproven/outboundApprovenDetail";
	}

	/**
	 * 已审核列表
	 */
	@RequestMapping(value = "/waitedApproval", method = RequestMethod.GET)
	public String waitedApproval(Model model) {

		return "testApproven/waitedTestApprovenFunctionList";
	}
	
	/**
	 * 已审核详情
	 */
	@RequestMapping(value = "/approvaldetail", method = RequestMethod.GET)
	public String approvaldetail(Model model) {

		return "testApproven/dataApprovenDetailList";
	}
	
	
	/**
	 * 审核操作
	 */
	@RequestMapping(value = "/approval", method = RequestMethod.GET)
	public String approval(Model model) {

		return "testApproven/TestApproven";
	}
	
	
	/**
	 * 待审核列表
	 */
	@RequestMapping(value = "/waitApproval", method = RequestMethod.GET)
	public String waitApproval(Model model) {

		return "testApproven/waitingTestApprovenFunctionList";
	}
	
}
