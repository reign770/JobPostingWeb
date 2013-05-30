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
	var action ='notification_unreaded.action';
	var href ='#unreaded'
	var content = "#content_1";
 	$('#myTab a').click(function (e) {
    	e.preventDefault();
    	$(this).tab('show');
     	href =$(this).attr('href');
    	if( href =='#unreaded'){
    		action = 'notification_unreaded.action';
    		content="#content_1";
    	}else{
    		action = 'notification_readed.action'
    		content="#content_2";
    	}
    	$('#pagination').pagination('select',1);
    });
 	$('#pagination').pagination({
 		total:${pageBean.allRow},
 		pageSize:${pageBean.pageSize},
		pageList: [2],
		onSelectPage:
			  function(pageNumber,pageSize){
	   		  $(content).panel('refresh', 
	   		  action+'?pageSize='+pageSize+'&&pageNumber='+pageNumber);
	   		  }
	});	
    $('.content .check').live("click",function(){
    	$(this).parents('.media').siblings('.notificationcontent').slideToggle();
 	});
    $('.content .read').live("click",function(){
    	var id = $(this).attr('id');
    	var item = $(this).parents(".content");
     	$.post("notification_read.action",
    			{notificationId:id},
    			 function(dataObj){
    				    if(dataObj.message == "readed_success"){
    					  	item.fadeOut(500);
    					  	$('#pagination').pagination('refresh');
    					  	$('#pagination').pagination('select',1);
    				    }
    			 }
    			); 
    });
 	
});
</script>
</head>
<body style="background:#ECEFF1;">
<div class="myLayout"> 
  	<ul class="nav nav-tabs" id="myTab">
		<li class="active"><a href="#unreaded">未读的通知</a></li>
		<li><a href="#readed">已读的通知</a></li>
	</ul> 
	<div class="tab-content">
		<div class="tab-pane active" id="unreaded"> 
		      <div id="content_1" class="easyui-panel">
 			  <s:iterator value="pageBean.list" status="sts">
	        	 <div class="content well-large">
	         		<div class="media">
	                	<a href="#" class="pull-left">
	    					<img class="media-object img-polaroid" src="${enterprise.logo}" style="" >
	                	</a>
						<h6><a href="#">${enterprise.enterpriseName}</a>给你发来通知,请<a href="#">
						及时接收</a>信息</h6>
	                    <div>
	                       <button class="btn check">查看</button>
            	           <s:if test="state == 0">
	                       <button class="btn btn-info read" id="${notificationId}">标记为已读</button>
	                       </s:if>
	                    </div>  
	     			</div>
	     			<div class="notificationcontent">
	     				<strong>发送时间:</strong>&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${postTime}" 
    			        type="date" dateStyle="full"/>
    			        <br/>
    			        <strong>内容:</strong><br/>
    			        &nbsp;&nbsp;&nbsp;&nbsp;
    			        ${content}
	     			</div>
	        	</div>
	        </s:iterator>  
	        </div>
        </div>
     	<div class="tab-pane active" id="readed">
     		<div id="content_2" class="easyui-panel">
     		</div>
		</div>
		<div id="pagination" class="easyui-pagination">  
        </div>
	</div>
</div>  
</body>
</html>