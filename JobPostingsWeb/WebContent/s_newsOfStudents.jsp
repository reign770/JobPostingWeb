<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生新闻</title>
<link href="/JobPostingsWeb/css/s_newsOfStudents.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="application/javascript">
$(function () {
	var action ='recruitment_concernIndustry.action';
	var content = "#contents";//刷新区域
 	$("#industry").click(function(){
 		action = 'recruitment_concernIndustry.action';
 		$('#pagination').pagination('select',1);
 	});
 	
 	$("#enterprise").click(function(){
		action = 'recruitment_concernEnterprise.action';
		$('#pagination').pagination('select',1);
 	});
 	
 	$('#pagination').pagination({
 		total:${pageBean.allRow},
 		pageSize:${pageBean.pageSize},
		pageList: [10],
		onSelectPage:
			  function(pageNumber,pageSize){
	   		  $(content).panel('refresh', 
	   		  action+'?pageSize='+pageSize+'&&pageNumber='+pageNumber);
	   		  }
	});	
 	
});
</script>
</head>
<body style="background:#ECEFF1;">
<div class="myLayout">
  <div id="newsNav">
   	 <div id="navContent">
            <div class="btn-group" data-toggle="buttons-radio">
   				<button id="industry"  class="btn btn-info active">关注的领域</button>
         		<button id="enterprise" class="btn btn-info">关注的公司</button>
   			</div>
     </div>
 </div>

 <div id="newsContent">
 	<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''">
	<s:iterator value="pageBean.list" status="sts">
		<div class="content well-small">
		  		<div class="media">
		         	<a href="#" class="pull-left">
				<img class="media-object img-polaroid" src="${enterprise.logo }" style="height: 60px;" >
		        		</a>
			<div class="media-body">
				<a href="#"><h4 class="media-heading">${postingName}</h4></a>
		            		<a href="#"><h6 class="media-heading">${enterprise.enterpriseName}</h6></a>
		  		工作城市：${workingPlace}&nbsp;&nbsp;&nbsp;
		  		每月薪水:
		  		<s:if test="salary ==-1">
		  			面议
		  		</s:if>
		  		<s:else>
		  			${salary }左右
		  		</s:else>
		  		&nbsp;&nbsp;&nbsp;
		  		行业：${industry.jobType}
				</div>
			</div>
		  	</div>
	</s:iterator> 
    </div>  
    <div id="pagination" class="easyui-pagination">  
    </div>  
 </div>
</div>
</body>
</html>