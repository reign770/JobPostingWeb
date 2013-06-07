<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="application/javascript">
$(function () {
	$('#pagination').pagination({
		total:${pageBean.allRow}
	});
});
</script>

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
        
   