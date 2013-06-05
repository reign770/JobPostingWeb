<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
$('#pagination').pagination({
		total:${pageBean.allRow}
});
</script>  
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
			  		<td><a href="#" onclick="window.parent.addTab('${apply.recruitment.postingName}',
						'/JobPostingsWeb/enterprise/c_PositionDetail_load?recruitmentId=${apply.recruitment.recruitmentId}')">
					${apply.recruitment.postingName}</a></td>
			  		<td><a href="#" onclick="window.parent.addTab('${apply.recruitment.enterprise.enterpriseName}',
	                         '../enterprise/s_CompanyPage_loadOfS.action?enterpriseId=${apply.recruitment.enterprise.enterpriseId}')">
	                ${apply.recruitment.enterprise.enterpriseName }</a></td>
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
