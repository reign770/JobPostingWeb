<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE HTML >
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知</title>
<link href="/JobPostingsWeb/css/s_notificationsOfStudents.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<style type="text/css">
.info-header{
	color:#5A5A5A;
	font-family: 微软雅黑;
	font-weight: normal;}
.additionalInfo textarea{
	width:80%;
	margin-left: 50px;
	margin-right: 10px;
	}
</style>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="application/javascript">
$(function () {
	var action ='invitation_unprocessInvitations.action';
	var href ='#unprocess'
	var content = "#content_1";
	var pageNum = 1;
	var invitationId,enterpriseName,postingName;
	var clickitem;
 	$('#myTab a').click(function (e) {
    	e.preventDefault();
    	$(this).tab('show');
     	href =$(this).attr('href');
    	if( href =='#unprocess'){
    		action = 'invitation_unprocessInvitations.action';
    		content="#content_1";
    	}else if( href == '#accept'){
    		action = 'invitation_acceptedInvitations.action'
    		content="#content_2";
    	}else {
    		action = 'invitation_ingoredInvitations.action';
    		content="#content_3";
    	}
    	$('#pagination').pagination('select',pageNum);
    });
 	//分页
 	$('#pagination').pagination({
 		total:${pageBean.allRow},
 		pageSize:${pageBean.pageSize},
		pageList: [10],
		onSelectPage:
			  function(pageNumber,pageSize){
			  pageNum = pageNumber;
	   		  $(content).panel('refresh', 
	   		  action+'?pageSize='+pageSize+'&&pageNumber='+pageNumber);
	   		  }
	});
 	//忽略邀请
 	$('.content .ignore').live('click',function(){
 		clickitem = $(this).parents('.content');
 		invitationId = $(this).parents('.media').attr('id');
 		ignore();
 		alert(pageNum*1.0);
 		$("#pagination").pagination("select",1);
 	});
 	//忽略邀请函数
 	function ignore(){
		$.post("invitation_ignore.action",
				   {invitationId:invitationId},
				   function(data){
					   if(data.message =="ignore_success")
				         clickitem.fadeOut(300);
				   });
 	};
 	//接受邀请
 	$('.content .accept').live('click',function(){
 		clickitem = $(this).parents('.content');
 		invitationId = $(this).parents('.media').attr('id');
 		enterpriseName = $(this).parent().siblings('h6').children('.enterpriseName').text();
 		postingName = $(this).parent().siblings('h6').children('.postingName').text();
 		$("#enterpriseName").text(enterpriseName);
 		$("#postingName").text(postingName); 
 	});
 	//邀请并投递简历
 	$("#apply").live('click',function(){
 		   var flag = 1;
 		   $.post("invitation_accept.action",
 				{invitationId:invitationId,
 			     content:$('#applycontent').val()},
 				function(data){
 					if(data.message =="accept_success"){
 						$("#accept_result h2").text("已成功接受邀请");
 					}
 					else{
 						$("#accept_result h2").text("你已经申请过该职位,已经忽略掉该信息!");
 						flag = 0;
 					}
 					$('#myModal').modal('hide');
 					$('#alert').modal('show');
 					clickitem.fadeOut(300);
 		   			$("#pagination").pagination("select",pageNum);
 				});
 	});
});
</script>
</head>

<body style="background:#ECEFF1;">
	<div class="modal hide fade in" id="myModal" style="display: none;">
            <div class="modal-header">
              <a data-dismiss="modal" class="close">×</a>
              <h3>接受职位邀请</h3>
            </div>
            <div class="modal-body">
              <h5>职位名称:&nbsp;&nbsp;</h5><div id="postingName"></div>
              <h5>企业名称:&nbsp;&nbsp;</h5><div id="enterpriseName"></div>
		    <div class="additionalInfo">
		    	<div class="info-header"><h3>请输入申请信息</h3></div>
				<div id="additionalInfoContent" class="row">	
		            <textarea id ="applycontent" rows="5" class="offset1" name="content"></textarea>
		        </div>
			</div>
      	    </div>
            <div class="modal-footer">
              <a data-dismiss="modal" class="btn" href="#">取消</a>
              <a class="btn btn-primary" href="#" id="apply">接受</a>
            </div>
    </div>
    <div class="modal hide fade in" id="alert" style="display: none;">
          <div class="modal-header">
            <a data-dismiss="modal" class="close">×</a>
            <h3>职位邀请</h3>
          </div>
          <div class="modal-body">
            <br>
            <div id="accept_result"><h2>已成功接受该职位邀请</h2></div>
    	  </div>
          <div class="modal-footer">
            <a data-dismiss="modal" class="btn" href="#">取消</a>
          </div>
    </div> 
<div class="myLayout"> 
	
  	<ul class="nav nav-tabs" id="myTab">
		<li class="active"><a href="#unprocess">等待处理的</a></li>
		<li><a href="#accept">已接受的邀请</a></li>
		<li><a href="#ignored">已忽略的邀请</a></li>
	</ul>

	<div class="tab-content">
		<div class="tab-pane active" id="unprocess"> 
		      <div id="content_1" class="easyui-panel">
 			  <s:iterator value="pageBean.list" status="sts">
	        	 <div class="content well-large">
	         		<div class="media" id="${invitationId}">
	                	<a href="#" class="pull-left">
	    					<img class="media-object img-polaroid" src="${recruitment.enterprise.logo}" style="" >
	                	</a>
						<h6><a class="enterpriseName" href="#" onclick="window.parent.addTab('${recruitment.enterprise.enterpriseName}',
	                         '../enterprise/s_CompanyPage_loadOfS.action?enterpriseId=${recruitment.enterprise.enterpriseId}')">
						${recruitment.enterprise.enterpriseName}</a>邀请你投递
						<a class="postingName" 
						href="#" onclick="window.parent.addTab('${recruitment.postingName}',
						'/JobPostingsWeb/enterprise/c_PositionDetail_load?recruitmentId=${recruitment.recruitmentId}')">${recruitment.postingName}</a>职位</h6>
	                    <div>
	                       <s:if test="state !=2">
	                       <button class=" btn btn-info accept" href="#myModal" data-toggle="modal">接受</button>
	                       </s:if>
	                       <s:if test="state == 0">
	                       <button class=" btn ignore">忽略</button>
	                       </s:if> 
	                    </div>  
	     			</div>
	        	</div>
	        </s:iterator>  
	        </div>
        </div>
     	<div class="tab-pane active" id="accept">
     		<div id="content_2" class="easyui-panel">
     		</div>
		</div>
		<div class="tab-pane active" id="ignored">
		    <div id="content_3" class="easyui-panel">
     		</div>
		</div>
		<div id="pagination" class="easyui-pagination">  
        </div>
	</div>
</div>  
</body>
</html>
