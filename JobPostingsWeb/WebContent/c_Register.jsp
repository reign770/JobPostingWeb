<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link href="/JobPostingsWeb/css/c_register.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap-fileupload/bootstrap-fileupload.min.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/css/datetimepicker.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/css/bootstrap-fileupload/bootstrap-fileupload.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

<script type="application/javascript">
$(function(){
	$('#username').focusout(function(){
		if($.trim($(this).val())!=""){
			$.ajax({
			   type: "POST",
			   url: "/JobPostingsWeb/enterprise/json_c_Register_checkIfExist",
			   dataType:'json',
			   data: {
				   enterpriseAccount:$(this).val()
			   },
			   success: function(data){
				   message=data.msg;
				   if(message=='true'){
					   $("#usernameOKAlert").css("display","block");
					   $("#usernameNOAlert").css("display","none");
				   }else{
					   $("#usernameNOAlert").css("display","block");
					   $("#usernameOKAlert").css("display","none");
				   }
				  
			     
			   }
			});
		}
	});
	
	$('.fileupload').fileupload({
		uploadtype:'image'
	});
	//json设置公司性质
	var enterpriseProperties = $("#enterpriseProperty");
	enterpriseProperties.empty();//清空select下拉框
    $.getJSON("/JobPostingsWeb/enterpriseProperty.json", function(json){
    		for(var i=0;i<json.enterpriseProperties.length;i++){
            	$("<option value='" + json.enterpriseProperties[i]+ "'>" + json.enterpriseProperties[i] + "</option>").appendTo(enterpriseProperties);//动态添加Option子项
        	}
    	});
	
  //检验数据
    $("form").submit(function(){
    	var result=true;
    	$(":text,:file,:password").each(function(){
    			if($.trim($(this).val())==""){
    				alert("请填写所有信息!");
    				result=false;
    				return false;
    			}else{
    				return true;
    			}
    		});
    	if(result==true){
    	 $('#myModal').modal('show');
    	}
    	
    	return result;
		
    });
	//timepicker
	$(".form_datetime").datetimepicker({
		minView:'month',
		format: 'yyyy-mm-dd',
		autoclose:"true",
		todayHighlight:true,
		language:"zh-CN"
		});
	
	
});
</script>
</head>

<body>
<div class="myLayout">
<form action="/JobPostingsWeb/enterprise/c_Register.action" method="post" enctype="multipart/form-data">
	<div id="content">
		<div class="basicInfo">
        	<div class="page-header"><h2>账户信息</h2></div>
			<div class="row">	
       			<dl class="dl-horizontal span8">
                	<dt>用户名</dt>
    				<dd>：<input type="text" name="enterprise.enterpriseAccount" id="username"/>
    				    <div class="alert alert-success  fade in" id="usernameOKAlert">
    						<button type="button" class="close" data-dismiss="alert">&times;</button>
    						<strong>Warning!</strong> 账号可以使用。
    					</div>
    					 <div class="alert alert-error fade in" id="usernameNOAlert">
    						<button type="button" class="close" data-dismiss="alert">&times;</button>
    						<strong>Warning!</strong> 账号已经被抢注了，请重新换一个。
    					</div>
    				 </dd>
    				<dt>密码</dt>
    				<dd>：<input type="password" name="enterprise.password" id="password"/> </dd>
                 </dl>
            
        	</div>	
    		<div class="page-header"><h2>基本信息</h2></div>
			<div id="basicInfoContent" class="row">	
       			<dl class="dl-horizontal span8">
                	<dt>企业名称</dt>
    				<dd>：<input type="text" name="enterprise.enterpriseName"/></dd>
    				<dt>创建时间</dt>
    				<dd>：
    					<div class="input-append date form_datetime">
							<input size="16" type="text"  readonly name="enterprise.foundDate">
    						<span class="add-on"><i class="icon-th"></i></span>
						</div>
    				 </dd>
            		<dt>企业性质</dt>
    				<dd>：<select id="enterpriseProperty" name="enterprise.enterpriseProperty">
    					 
    					</select>
					</dd>
    				<dt>注册资金</dt>
    				<dd>：<input type="text" name="enterprise.registeredFund"/></dd>
            		<dt>公司地址</dt>
    				<dd>：<input type="text" name="enterprise.address"/></dd>
            		<dt>联系人</dt>
    				<dd>：<input type="text" name="enterprise.linkman"/></dd>
            		<dt>联系人电话</dt>
    				<dd>：<input type="text" name="enterprise.phone"/></dd>
            		<dt>传真</dt>
    				<dd>：<input type="text" name="enterprise.fax"/></dd>
            		<dt>公司网址</dt>
    				<dd>：<input type="text" name="enterprise.webSite"/></dd>
    				<dt>企业法人</dt>
    				<dd>：<input type="text" name="enterprise.enterpriseLegalPerson"/></dd>
    				<dt>企业规模</dt>
    				<dd>：<input type="text" name="enterprise.enterpriseScale"/></dd>
            		<dt>营业执照编号</dt>
    				<dd>：<input type="text" name="enterprise.businessLicenseId"/></dd>
    			</dl>
           		<div id="basicInfoHeadIcon" >
            		
                   
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                   		 	<div class="fileupload-new thumbnail" style="width: 200px;">  <img src="/JobPostingsWeb/img/12883156763984.jpg" width="200px" height="200px"/></div>
                  
                        	<div class="fileupload-preview fileupload-exists thumbnail" style="width: 200px; max-height: 250px; line-height: 20px;"></div>
							<div class="input-append" id="imgButtons">
								<span class="btn btn-file">
									<span class="fileupload-new">选择头像</span>
									<span class="fileupload-exists">改变</span>
									<input type="file" name="image" />
								</span>
								<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">移除</a>
							</div>
						</div>
		 	
            	</div>
        	</div>	
            
            
			
		</div>
    	<div class="additionalInfo">
    		<div class="page-header"><h2>简介</h2></div>
			<div id="additionalInfoContent" class="row">	
            	<textarea rows="5" class="offset1" name="enterprise.brief">无</textarea>
        	</div>
		</div>
    	<div id="buttons" class="row" >
    	<input type="submit" class="btn btn-primary" value="    注 册    "/>
    	
    	</div>
    </div>
    
    
    
    <div id="myModal" class="modal hide fade" data-backdrop="static">
    <div class="modal-header">
    <h5>注册中...</h5>
    </div>
    <div class="modal-body">
    <p>
    	<div style="text-align: center;" >
			<img src="/JobPostingsWeb/img/loading.gif" alt=""  />    		
    	</div>
    
    </p>
    </div>
    <div class="modal-footer">
    	<br />
    </div>
    </div>
    
    
</form>
</div>

</body>
</html>

