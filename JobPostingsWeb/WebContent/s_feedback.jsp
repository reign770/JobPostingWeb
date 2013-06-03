<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知</title>
<link href="/JobPostingsWeb/css/s_notificationsOfStudents.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<style type="text/css">
.notificationcontent{
    font-family:微软雅黑;
    font-size:15px;
	height: auto;
    width: auto;
    margin-left: 10px;
    overflow: hidden;
    /* padding-left: 10%; */
	display:none;
}
</style>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="application/javascript">
$(function () {
	var action ='feedback_jobapplyfeedback.action';
	var content = "";
 	$('#pagination').pagination({
 		total:${pageBean.allRow},
 		pageSize:${pageBean.pageSize},
		pageList: [10],
		onSelectPage:
			  function(pageNumber,pageSize){
	   		  $("#info").panel('refresh', 
	   		  action+'?pageSize='+pageSize+'&&pageNumber='+pageNumber);
	   		  }
	});
});
</script>
</head>
<body style="background:#ECEFF1;">
<div class="myLayout"> 
	<div class="tab-content" style="margin-top: 80px;">
		<div id="info" class="tab-pane active easyui-panel" style="background:#ECEFF1;"> 
			  <table class="table table-hover table-condensed"
			  		  style="font-size: 16px;">
			  <thead>
			  	<tr class="info">
			  		<th>#</th>
			  		<th>职位名称</th>
			  		<th>公司</th>
			  		<th>地点</th>
			  		<th>投递反馈</th>
			  		<th>投递时间</th>
			  	</tr>
			  </thead>
 			  <s:iterator value="pageBean.list" status="sts" var="apply">
 			    <s:if test="state %4 ==0">
			  		<tr class="warning">
			  	</s:if>
			  	<s:elseif test="state %4 ==1">
			  		<tr class="error">
			  	</s:elseif>
			  	<s:elseif test="state %4 ==2">
			  		<tr class="info">
			  	</s:elseif>
			  	<s:else>
			  		<tr class="success">
			  	</s:else>
			  		<td>${sts.index+1}</td>
			  		<td><a href="#">${apply.recruitment.postingName}</a></td>
			  		<td><a href="#">${apply.recruitment.enterprise.enterpriseName }</a></td>
			  		<td>${apply.recruitment.workingPlace }</td>
			  		<td>
			  			<span class="badge badge-info">
			  			<s:if test="state == 0">
			  				处理中
			  			</s:if>
			  			<s:elseif test="state == 1">
			  				简历通过
			  			</s:elseif>
			  			<s:elseif test="state == 2">
			  				笔试通过
			  			</s:elseif>
			  			<s:elseif test="state == 3">
			  				面试通过
			  			</s:elseif>
			  			<s:else>
			  				已签约
			  			</s:else>
			  			</span>	
			  		</td>
			  		<td>${apply.applyDate}</td>
			  	</tr>	          
			  </s:iterator>
	     </table>
        </div>
		<div id="pagination" class="easyui-pagination" >  
        </div>
	</div>
</div>  
</body>
</html>