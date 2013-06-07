<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审核企业资质</title>
<link href="css/a_dataCalculatingAndOutput.css" rel="stylesheet" media="screen"/>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="css/bootstrap/js/bootstrap.js"></script>
<script src="js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.3/datagrid-detailview.js"></script>
<script type="application/javascript">

// $("#btnn").click(function(event){
// 	var validateAction="";
// 	$.post(validateAction,
// 			{account:$("#username").val(), password:$("#password").val()},
// 			function(dataObj){ 
// 			if(dataObj.loginmessage == 'noaccount'){
// 				 $("#msg").text("该用户名不存在!");
// 				 $("#alert").show();
// 			}
// 			else if(dataObj.loginmessage =="wrongpassword"){


function verifyEnterPass(data){
	//alert("Enterprise Pass");
	var validateAction="VerifyEnterprisePass";
	var accountId=data;
	$.post(validateAction,{enterpriseId:accountId},function(data){
		if(data.trim()=="successed"){
			$('#dg').datagrid("reload");
			
		}else{
			//do nothing	
		}
	});
}
	

function verifyEnterUnPass(data){
	//alert("Enterprise UnPass");
	var validateAction="VerifyEnterpriseUnPass";
	var accountId=data;
	$.post(validateAction,{enterpriseId:accountId},function(data){
		if(data.trim()=="successed"){
			$('#dg').datagrid("reload");
		}else{
			//do nothing	
		}
	});
}

$(function () {
	    $('#dg').datagrid({ 
		view: detailview,  
        detailFormatter:function(index,row){ 
		    return '<div class="ddv">'+
						'<div id="basicInfoContent" class="row">'+	
       						'<dl class="dl-horizontal span5">'+
    							'<dt>企业申请的账号</dt>'+
    							'<dd><input type="text" id="AccountId" disabled="disabled" value="'+row.enterpriseAccount+'"/></dd>'+
            					'<dt>企业名称</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.enterpriseName+'"/></dd>'+
    							'<dt>成立时间</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.foundDate+'"/></dd>'+
    							'<dt>企业性质</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.enterpriseProperty+'"/></dd>'+
    							'<dt>企业规模</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.enterpriseScale+'"/></dd>'+
    						'</dl>'+
    						'<dl class="dl-horizontal span7">'+
            				'<dt>企业地址</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.address+'"/></dd>'+
							'<dt>联系人</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.linkman+'"/></dd>'+
							'<dt>联系电话</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.phone+'"/></dd>'+
							'<dt>备注</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.brief+'"/></dd>'+
							'</dl>'+
        				'</div>	'+
        				'<div id="verfityBtnDiv" class="row">'+
        					'<dl class="dl-horizontal span5">'+
								'<dd><input type="button" id="verfyPassBtn"  class="btn btn-primary" value="审核通过" onclick="verifyEnterPass(\''+row.enterpriseAccount+'\')"  /></dd>'+
        					'</dl>'+
        					'<dl class="dl-horizontal span7">'+
        					'<dd><input type="button" id="verfyUnPassBtn"  class="btn btn-primary" value="审核未通过" onclick="verifyEnterUnPass(\''+row.enterpriseAccount+'\')"   /></dd>'+
    						'</dl>'+
        				'</div>'
					'</div>';  
        },   
        columns:[[ 
            {field:'enterpriseAccount',title:'申请的账号',width:100},  
            {field:'enterpriseName',title:'企业名称',width:100},
            {field:'bussinessLicenseId',title:'工商编号',width:100},
			{field:'foundDate',title:'成立时间',width:100},  
            {field:'enterpriseProperty',title:'企业性质',width:100}, 
			{field:'enterpriseScale',title:'企业规模',width:100},  
            {field:'registeredFund',title:'注册资金',width:100},
			{field:'address',title:'企业地址',width:100},  
            {field:'linkman',title:'联系人',width:100}, 
			{field:'phone',title:'联系电话',width:100},  
            {field:'brief',title:'备注',width:100}
        ]],
		pagination:true
		
    });  
		
});
</script>
</head>
<body style="background:#ECEFF1;">
<div class="myLayout">
   <div id="positionsContent">
 	<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''"> 
    	<table id="dg"  
     		pageSize="15"
     		pageList="[2,15]"
     		url="initEnterpriseInfo">
        	<tbody>  
    		</tbody>  
       </table> 
    </div>  
    </div>  
</div>
</body>
</html>
