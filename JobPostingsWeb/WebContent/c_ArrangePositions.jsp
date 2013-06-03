<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理招聘信息</title>
<link href="/JobPostingsWeb/css/c_dealWithApplicationsOne.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>


<script type="application/javascript">
$(function () {
	$('#pagination').pagination({
		pageList: [1,2,10,20,50,100]
	});
	
});

function stopRecruitingClick(rID,btn){
	$.ajax({
		   type: "POST",
		   url: "/JobPostingsWeb/enterprise/json_c_ArrangePositions_stopRecruiting",
		   dataType:'json',
		   data: {
			   recruitmentId:rID+""
		   },
		   success: function(data){
		     if(data.msg!=null&&$.trim(data.msg)=="success" ){
		     	$(btn).text("已停止招聘");
		    	$(btn).attr("disabled","disabled");
		     }else{
		    	 alert("出错，请重新再试！");
		     }
		   },
		   error: function(){
			    $(btn).text("停止招聘");
		    	$(btn).removeAttr("disabled");
			   alert("出错，请重新再试！");
		   }
		});
}
</script>
</head>

<body style="background:#ECEFF1;">
<div class="myLayout">
	
    
   <div id="positionsContent">
 	<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''"> 
    	<s:iterator value="pageBean.list" status="sts">
			<div class="content well-small">
         		
         			<h4 class="media-heading" class="pull-left">
         				${postingName}
         			</h4>
         			<button class="btn btn-info pull-right" type="button" onclick="window.parent.addTab('${postingName}','/JobPostingsWeb/enterprise/c_PositionDetail_load?recruitmentId=${recruitmentId }')">查看详细信息</button>
                	<button class="btn btn-danger pull-right" type="button" id="stopRecruiting" onclick="stopRecruitingClick(${recruitmentId},this)">停止招聘</button>
         	
         			<br />
         		 	<strong>    职位名称：</strong>${postingName} 
    				<strong>    工作城市：</strong>${workingPlace} 
    				<strong>    招聘人数：</strong>${recruitmentCount} 
    				<strong>    每月薪水：</strong>${salary} 
    				 <br />
            		<strong>    工作经验：</strong>${workExperience} 
    				<strong>    性别要求：</strong>${sex} 
    				<strong>    年龄要求：</strong>${age} 
    				<strong>    外语要求：</strong> ${foreignLanguage} 
    				 <br />
    				<strong>    学历要求：</strong>${degree} 
    				<strong>    截止日期：</strong> <fmt:formatDate value="${deadline}" pattern="yyyy-MM-dd"/>
    				<strong>    所属行业： </strong>${industry.jobType} 
         		    <strong>    发布时间：</strong> <fmt:formatDate value="${releaseDate}" pattern="yyyy-MM-dd"/>
         			
                   	
    			  		
     		</div>
		</s:iterator>
        
        
    </div>  
    <div id="pagination" class="easyui-pagination" data-options="total:${pageBean.allRow},pageSize:${pageBean.pageSize},onSelectPage:function(pageNumber,pageSize){$('#contents').panel('refresh', 'bc_c_ArrangePositions_load_recruitment.action?pageSize='+pageSize+'&&pageNum='+pageNumber);}">  
    </div>  


</div>
</body>
</html>
