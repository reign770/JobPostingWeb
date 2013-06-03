<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改个人信息</title>
<link href="/JobPostingsWeb/css/c_register.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap-fileupload/bootstrap-fileupload.min.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/css/datetimepicker.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/css/bootstrap-fileupload/bootstrap-fileupload.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="/JobPostingsWeb/js/jquery.form.min.js"></script>
<script type="application/javascript">
$(function(){
	
	
	$('.fileupload').fileupload({
		uploadtype:'image'
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
    		$(this).ajaxSubmit({
    			dataType:"json",
    			success:function(data){
    				if(data.msg!=null&&$.trim(data.msg)=="success"){
    					$('#myModal').modal('hide');
    					$('#myModal1').modal('show');
    				}else{
    					$('#myModal').modal('hide');
    					$('#myModal2').modal('show');
    				}
    			},
    			error:function(){
    				$('#myModal').modal('hide');
    				$('#myModal2').modal('show');
    			}
    		}); 
    	}
    	
    	return false;
		
    });
//异步提交
    $('form').submit(function(){
		
		return false;
	});

	
	
});
</script>
</head>

<body>
<div class="myLayout">
<form action="/JobPostingsWeb/enterprise/json_c_ModifyInfos_update.action" method="post" >
	<div id="content">
		<div class="basicInfo">
        	<div class="page-header"><h2>账户信息</h2></div>
			<div class="row">	
       			<dl class="dl-horizontal span8">
                	<dt>用户名</dt>
    				<dd>：<sapn class="input-large uneditable-input" >${ enterprise.enterpriseAccount}</span> </dd>
    				<dt>新密码</dt>
    				<dd>：<input type="password" name="enterprise.password" id="password"/> </dd>
                 </dl>
            
        	</div>	
    		<div class="page-header"><h2>基本信息</h2></div>
			<div id="basicInfoContent" class="row">	
       			<dl class="dl-horizontal span8">
                	<dt>企业名称</dt>
    				<dd>：<input type="text" name="enterprise.enterpriseName" value="${enterprise.enterpriseName}"/></dd>
    				<dt>创建时间</dt>
    				<dd>：<sapn class="input-large uneditable-input" ><fmt:formatDate value="${enterprise.foundDate}" pattern="yyyy-MM-dd"/></sapn> </dd>
            		<dt>企业性质</dt>
    				<dd>：<sapn class="input-large uneditable-input" >${enterprise.enterpriseProperty}</sapn></dd>
    				<dt>注册资金</dt>
    				<dd>：<sapn class="input-large uneditable-input" >${enterprise.registeredFund}</sapn></dd>
            		<dt>公司地址</dt>
    				<dd>：<input type="text" name="enterprise.address" value="${enterprise.address}"/></dd>
            		<dt>联系人</dt>
    				<dd>：<input type="text" name="enterprise.linkman" value="${enterprise.linkman}"/></dd>
            		<dt>联系人电话</dt>
    				<dd>：<input type="text" name="enterprise.phone" value="${enterprise.phone}"/></dd>
            		<dt>传真</dt>
    				<dd>：<input type="text" name="enterprise.fax" value="${enterprise.fax}"/></dd>
            		<dt>公司网址</dt>
    				<dd>：<input type="text" name="enterprise.webSite" value="${enterprise.webSite}"/></dd>
    				<dt>企业法人</dt>
    				<dd>：<input type="text" name="enterprise.enterpriseLegalPerson" value="${enterprise.enterpriseLegalPerson}"/></dd>
    				<dt>企业规模</dt>
    				<dd>：<input type="text" name="enterprise.enterpriseScale" value="${enterprise.enterpriseScale}"/></dd>
            		<dt>营业执照编号</dt>
    				<dd>：<input type="text" name="enterprise.businessLicenseId" value="${enterprise.businessLicenseId}"/></dd>
    			</dl>
           		<div id="basicInfoHeadIcon" >
            		<img src="${enterprise.logo}" width="200px" height="200px"/></div>
				</div>
		 	
            	</div>
        	</div>	
            
            
			
		</div>
    	<div class="additionalInfo">
    		<div class="page-header"><h2>简介</h2></div>
			<div id="additionalInfoContent" class="row">	
            	<textarea rows="5" class="offset1" name="enterprise.brief">${enterprise.brief }</textarea>
        	</div>
		</div>
    	<div id="buttons" class="row" >
    	<input type="submit" class="btn btn-primary" value="    修改    "/>
    	
    	</div>
    </div>
    
    
    
    <div id="myModal" class="modal hide fade" data-backdrop="static">
    	<div class="modal-header">
    		<h5>修改中...</h5>
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
    
    
    	<div id="myModal1" class="modal hide fade" data-backdrop="static">
    		<div class="modal-header">
    			<h5>修改成功</h5>
   			</div>
    		<div class="modal-body">
    			<p>
    				<div  >
    				          修改成功了,点击确认返回其他页面
    				</div>
    			</p>
    		</div>
    		<div class="modal-footer">
    			<button class="btn btn-primary" type="button" onclick="window.parent.closeTab('修改企业信息')">确认</button>
   			</div>
    	</div>
    	<div id="myModal2" class="modal hide fade" data-backdrop="static">
    		<div class="modal-header">
    			<h5>修改失败</h5>
   			</div>
    		<div class="modal-body">
    			<p>
    				<div  >
						修改出错了！请返回尝试重新提交<br />
    				</div>
    			</p>
    		</div>
    		<div class="modal-footer">
    			<button class="btn btn-primary" id="confirm" type="button" onclick="$('#myModal2').modal('hide');">返回</button>
   			</div>
    
    
    </div>
    
    
</form>
</div>

</body>
</html>

