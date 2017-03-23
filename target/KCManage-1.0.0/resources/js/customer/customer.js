
var str = "";
var arrayobj = new Array();

function checkin(e) {
	if (e.checked) {
		arrayobj.push(e.id);
	} else {
		$.each(arrayobj, function(index, item) {
			// index是索引值（即下标） item是每次遍历得到的值；
			if (item == e.id) {
				arrayobj.splice(index, 1);
			}
		});
	}
}
function checkall(e) {
	if (e.checked) {
		$("input[name='incheck']").attr("checked", true);
		var inche = $("input[name='incheck']");
		for (var i = 0; i < inche.length; i++) {
			var newid = inche[i].id;
			arrayobj.push(newid);
		}
	} else {
		$("input[name='incheck']").attr("checked", false);
		var inche = $("input[name='incheck']");
		for (var i = 0; i < inche.length; i++) {
			var newid = inche[i].id;
			$.each(arrayobj, function(index, item) {
				// index是索引值（即下标） item是每次遍历得到的值；
				if (item == newid) {
					arrayobj.splice(index, 5);
				}
			});
		}
	}
};

function haveparma() {
	if (arrayobj.length == 1) {
		window.location = "/NfCrmManager/customer/queryCustomertoApplygift.do?customer_id="
				+ arrayobj[0];
	} else {
		swal({title: "系统提示",text: "请选择一个客户！！",type: "fail",showCancelButton: false,confirmButtonColor: "#DD6B55",confirmButtonText: "确定"
		},
		function(){
		});
	}
}

function tosee(tag) {
	if (arrayobj.length >0) {
	for(var j=0;j<arrayobj.length;j++){
		str+=arrayobj[j]+"##";
	}
	var data = {
		param : str,
		tag : tag
	};
	$.ajax({
				type : "GET",
				url : "/NfCrmManager/customer/updatebatch.do",
				data : data,
				success : function(msg) {
					var adscription=$("input[name='employeeId']").val();
					if (msg == "tosee") {
						swal({title: "系统提示",text: "转带看客户成功！！",type: "success",showCancelButton: false,confirmButtonColor: "#DD6B55",confirmButtonText: "确定"
		        		},
		        		function(){
		        			window.location = "/NfCrmManager/customer/queryCustomerInfo.do?tag="
								+ tag+"&adscription_id="+adscription;
		        		});
					} else if (msg == "publi") {
						swal({title: "系统提示",text: "转公共客户成功！！",type: "success",showCancelButton: false,confirmButtonColor: "#DD6B55",confirmButtonText: "确定"
		        		},
		        		function(){
		        			window.location = "/NfCrmManager/customer/queryCustomerInfo.do?tag="
								+ tag;
		        		});
					}else if (msg == "histo") {
						swal({title: "系统提示",text: "转成交客户成功！！",type: "success",showCancelButton: false,confirmButtonColor: "#DD6B55",confirmButtonText: "确定"
		        		},
		        		function(){
		        			window.location = "/NfCrmManager/customer/queryCustomerInfo.do?tag="
								+ tag+"&adscription_id="+adscription;
		        		});
					}else if (msg == "priva") {
						swal({title: "系统提示",text: "转私有客户成功！！",type: "success",showCancelButton: false,confirmButtonColor: "#DD6B55",confirmButtonText: "确定"
		        		},
		        		function(){
		        			window.location = "/NfCrmManager/customer/queryCustomerInfo.do?tag="
								+ tag+"&adscription_id="+adscription;
		        		});
					}
					
				},
				error : function(rec) {
					console.info("网络异常,请稍后再试");
				}
			});
	} else {
		swal("请至少选择一个客户！！");
	}
}

function report(){
	
	var str = "";
	if (arrayobj.length >= 1) {
		for(var i =0; i<arrayobj.length ; i++){
			str+=arrayobj[i]+",";
		}
		var data = {
				param : str,
			};
		$.ajax({
			type : "POST",
			url : "/NfCrmManager/customer/report.do",
			data : data,
			success : function(msg) {
				
				if (msg == "t") {
					 swal("报备成功");
				} else if (msg == "f") {
					 swal("报备失败");
				} else if(msg == "ff"){
					swal("有一个以上报备失败");
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) 
			{ 
				console.info("网络异常,请稍后再试");
			} 
		});
	} else {
		swal({title: "系统提示",text: "请选择一个客户！！",type: "fail",showCancelButton: false,confirmButtonColor: "#DD6B55",confirmButtonText: "确定"
		},
		function(){
		});
	}
	
}
function exportFile(){

	location.href="/NfCrmManager/exportExcelFile/exportFile.do";

}