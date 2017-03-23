/**
 * author:王超超
 * day:2016-11-19
 * @deprecated 组织架构
 */
$(document).ready(function() { 
	 
 	$('#sysdepartInfoId').tree({
	    onClick: function(node){
	        if(node.isVirtual=="0"){
	        	 var pnode = $('#sysdepartInfoId').tree('getParent', node.target);
	        	
	        	 	//alert(pnode.text);
	        		var s;
	        		var url="";
	        		var editUrl ="";
	        		if(node.id.length==6){
	        			window.type="6";
	        			url="../SysDepartInfo/addUnit.do";
	        			url+="?parentDepartId="+node.id;
	        			editUrl="../SysDepartInfo/editUnit.do";
	        			 s= [
	       	                  {field:'departId',title:'单位编号',width:100,align:'center'},
	    	                  {field:'departName',title:'单位名称',width:100,align:'center'},
	    	                  {field:'createTime',title:'创建时间',width:250,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
	    	              ];
	        			
	        		}else if(node.id.length==12){
	        			window.type="12";
	        		 url="../SysDepartInfo/addDepart.do";
	        		 url+="?parentDepartId="+node.id+"&unitName="+pnode.text+"&unitId="+pnode.id;
	        		 editUrl ="../SysDepartInfo/editDepart.do"; 
	        		  s= [
       	                  {field:'departId',title:'部门编号',width:180,align:'center'},
    	                  {field:'unitName',title:'单位名称',width:100,align:'center'},
    	                  {field:'departName',title:'部门名称',width:100,align:'center'},
    	                  {field:'createTime',title:'创建时间',width:250,align:'center'},
    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
    	              ];
	        		}else if(node.id.length==18){
	        			window.type="18";
	        			var ppnode = $('#sysdepartInfoId').tree('getParent', pnode.target);
	    	        	ppnode = $('#sysdepartInfoId').tree('getParent', ppnode.target);
	        			url="../SysDepartInfo/addTeam.do";
	        			url+="?parentDepartId="+node.id+"&departName="+pnode.text+"&unitName="+ppnode.text+"&unitId="+ppnode.id;
	        			editUrl ="../SysDepartInfo/editTeam.do"; 
	        			 s= [
	       	                  {field:'departId',title:'班组编号',width:200,align:'center'},
	    	                  {field:'unitName',title:'单位名称',width:100,align:'center'},
	    	                  {field:'departName1',title:'部门名称',width:100,align:'center',
	    	                	  formatter:function(value,row,index){
	    	                		  return pnode.text;
	    	                  }},
	    	                  {field:'departName',title:'班组名称',width:100,	align:'center'},
	    	                  
	    	                  {field:'createTime',title:'创建时间',width:250,align:'center'},
	    	                  {field:'createUserName',title:'创建人',width:150,align:'center'}
	    	              ];
	        			
	        		} else{
	        			return ;
	        		}
	        		var reqUrl ='../SysDepartInfo/getDepartInfoByParentId.do?parentDepartId='+node.id;

	        		
		        	$(function(){
		        			 $('#listId').datagrid({ 
		        				 //title:'问题列表', 
		        			        iconCls:'icon-edit',//图标 
		        			        width: 800, 
		        			        height: '200', 
		        			        nowrap: false, 
		        			        striped: true, 
		        			        border: true, 
		        			        collapsible:false,//是否可折叠的 
		        			        fit: true,//自动大小 
		        			        url:reqUrl, 
		        			        //sortName: 'code', 
		        			        //sortOrder: 'desc', 
		        			        remoteSort:false,  
		        			        pageSize: 15,//每页显示的记录条数，默认为10 
		        			        pageList: [15,30,45],//可以设置每页记录条数的列表
		        			        idField:'questionId', 
		        			        singleSelect:true,//是否单选 
		        			        pagination:true,//分页控件 
		        			        rownumbers:true,//行号 
		        					 columns:[s],
		        	        onClickRow: function(index, data) {
		        	        	var row = $('#listId').datagrid('getSelected');
		        	        	window.parent.document.getElementById('centerIframe').src='../approven/approvenFunctionRuleList.do?approvenFunctionId='+row.approvenFunctionId+"&approvenFunctionName="+row.approvenFunctionName;
		        	        } ,
		        	        toolbar: [{ 
		        	            text: '添加', 
		        	            iconCls: 'icon-add', 
		        	            handler: function() {
		        	            	var height =500;
		        	            	var width =550;
		        	            	if(window.type=="6"){
		        	            	  height =300;
			        	              width =440;
		        	            	}
		        	            	window.parent.window.openWindow(url,width,height);
		        	            	
		        	            } 
		        	        },{ 
		        	            text: '修改', 
		        	            iconCls: 'icon-edit', 
		        	            handler: function() { 
		        	            	var row = $('#listId').datagrid('getSelected');
		        	            	var height =500;
		        	            	var width =550;
		        	            	if(window.type=="6"){
		        	            	  height =300;
			        	              width =440;
		        	            	}
		        	            	var urld = editUrl +"?departId="+row.departId+"&departName1="+pnode.text;
		        	             
		        	            	window.parent.window.openWindow(urld,width,height);
		        	            	
 		        	            } 
		        	        }]
		        	    });	
		        				//设置分页控件 
		        			    var p = $('#listId').datagrid('getPager'); 
		        			    $(p).pagination({ 
		        			        method : 'POST',
		        			        loading:true,
		        			        beforePageText: '第',//页数文本框前显示的汉字 
		        			        afterPageText: '页    共 {pages} 页', 
		        			        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		        			        onBeforeRefresh:function(){
		        			            $(this).pagination('loading');
		        			            alert('before refresh');
		        			            $(this).pagination('loaded');
		        			        },
		        			        onRefresh:function(){
		        			        	   $(this).pagination('loading');
		        				            alert('before onRefresh');
		        				            $(this).pagination('loaded');
		        			        	
		        			        }
		        			    });  
		        			    
		        			    $(p).pagination('loading');
		        	});
	        }else{
	        }
	    }
	});	
}); 


		
	
 
