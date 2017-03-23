$(document).ready(function() { 
	
	

	$("#loginBtn").click(function(){
		var aParams = document.location.search.substr(1).split("&");
		var data={
				loginName:$("#loginName").val(),
				loginPwd:$("#loginPwd").val(),
				url:aParams[0],
				code:aParams[1]
		};
		
		$.ajax({ 
            type: "POST",
            url: "../SysUserInfo/wxLogin.do",
            data:data,
            async: false,
            dataType: "json",
            success: function(data){
            	if(data.code=="000"){
            		if(aParams[0]!=null&& aParams[0]!=""){
            			var str = aParams[0].split("=");
                    	window.location=str[1];
                    }else{
                    	window.location="../weixin/index.html";
                    }
            	}    
            },error:function(rec){
           	      console.info("网络异常,请稍后再试");
            }
        });
		
	});
}); 


		
	
 
