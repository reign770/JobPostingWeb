<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<link href="/JobPostingsWeb/css/s_resume.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script type="application/javascript">
$(function(){
	$("#updateForm").submit(function(){
		if($("#newpassword").val().trim() != $("#confirmpassword").val().trim()){
			$("#info").attr("class","alert alert-error");
			$("#info").text("两次输入密码不一样");
			return false;
		}
		else
		return true;
	});
	
	$("#confirmpassword").bind("input propertychange", function() {
		if($("#newpassword").val().trim() != $("#confirmpassword").val().trim()){
			$("#info").attr("class","alert alert-block");
			$("#info").text("两次输入密码不一样");    			
		}
		else{
			$("#info").attr("class","alert alert-success");
			$("#info").text("两次密码一致");    				
		}
	});
});
</script>
</head>

<body>
	<div class="myLayout">
		<div class="modal">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		    <h3>密码修改</h3>
		  </div>
		  <form id="updateForm" action="student/studentInfo_modifyPassword" 
		  	  method="post">
			  <div style="margin:auto;" align="center">
			    <div id="info" class="alert alert-info">
					请保证输入的两次密码一致
			    </div>
			    <div class="modal-body">
			          <label>新密码:<input type="password" placeholder="请输入新密码" id="newpassword" name="password"></label>
			          <label>新密码:<input type="password" placeholder="请再次新密码" id="confirmpassword" ></label>
			    </div>
			  </div>
			  <div class="modal-footer" >
			    <input type="submit" class="btn btn-primary btn-large" value="修改" style="font-size:12px; font-family:微软雅黑;">
			    <input type="reset" class="btn btn-warning btn-large" value="重置" style="font-size:12px; font-family:微软雅黑;">
			  </div>
		  </form>
		</div>
	</div>
</body>
</html>