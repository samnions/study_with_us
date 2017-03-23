/*
   * 注意：
   * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
   * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
   * 3. 完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
   *
   * 如有问题请通过以下渠道反馈：
   * 邮箱地址：weixin-open@qq.com
   * 邮件主题：【微信JS-SDK反馈】具体问题
   * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
   */
     
 	// window.shareType="1"; 表示入库；window.shareType="2";表示出库；window.shareType="3";表示盘点，在每个页面初始化赋值这个参数
	$.ajax({ 
            type: "GET",
            url: "../weixinUtil/getJsSdkData.do?type="+window.shareType+"&orderNo="+sessionStorage.orderNo,
            data:"",
            async: false,
            dataType: "json",
            success: function(data){
                     window.data=data;
                     
            },error:function(rec){
           	      console.info("网络异常,请稍后再试");
            }
        });

  wx.config({
      debug: false,
      appId: data.appId,
      timestamp: data.timestamp,
      nonceStr: data.nonceStr,
      signature: data.signature,
      jsApiList: [
'checkJsApi',
'scanQRCode'
      ]
  }); 

  /*
   * 注意：
   * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
   * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
   * 3. 完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
   *
   * 如有问题请通过以下渠道反馈：
   * 邮箱地址：weixin-open@qq.com
   * 邮件主题：【微信JS-SDK反馈】具体问题
   * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
   */
  wx.ready(function () {
    // 9.1.2 扫描二维码并返回结果
    document.querySelector('#scanQRCode1').onclick = function () {
    	var orderNo = sessionStorage.orderNo;
    	//以下注释掉的代码不要删除！！！，   在这编写业务逻辑代码，让整个流程串起来
	     wx.scanQRCode({
	        needResult: 1,
	        desc: 'scanQRCode desc',
	        success: function (res) {
//	          alert(JSON.stringify(res));
	        	 var result = res.resultStr; 
	        	 var strs= new Array(); //定义一数组 
	        	 results=result.split("="); 
	          var data = {
	          		  poid: results[1]
	            };
    	
	        $.ajax({ 
            type: "POST",
            url: "../weixinUtil/queryProductInfoByID.do",
            data:data,
            async: false,
            success: function(data){
    			sessionStorage.orderNo =orderNo;
    			if(typeof(sessionStorage.productObj)=="undefined" || sessionStorage.productObj=="[]"){
    				var arrayObj = new Array(); 
        			arrayObj.push(data);
        			var str = JSON.stringify(arrayObj); 
        			sessionStorage.productObj=str;
        			window.location.href="../weixin/saoyisaoInputwarehouse.html";
    			}else{
    				var arrayObj = new Array();
    				var json = JSON.parse(data);
    				
    				var arrayStr = sessionStorage.productObj;
    				var jsonArrayStr = JSON.parse(arrayStr);
    				var f = false;
    				var bb = "";
    				for (var i = 0; i < jsonArrayStr.length; i++) {
    					var object = JSON.parse(jsonArrayStr[i]);
    					
    					if(json.productObj.stockNo==object.productObj.stockNo){
    						f = true;
    						bb = jsonArrayStr[i];
    					}else{
    						arrayObj.push(jsonArrayStr[i]);
    					}
    					if(i==(jsonArrayStr.length-1) && f){
    						arrayObj.push(bb);
    					}
    					if(i==(jsonArrayStr.length-1) && !f){
    						arrayObj.push(data);
    					}
    					var str = JSON.stringify(arrayObj); 
    					sessionStorage.setItem("productObj", str); 
					}
    				window.location.href="../weixin/saoyisaoInputwarehouse.html";
    			}
    		
            },error:function(rec){
           	      console.info("网络异常,请稍后再试");
            }
        });
	        }
	      });
    	
    	
    };
   
   
  
  });
  wx.error(function (res) {
  });
  
  function GetQueryString(name)
  {
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
 }