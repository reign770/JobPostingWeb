<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<script>
$('#pagination').pagination({
		total:${pageBean.allRow}
});
</script>
<s:iterator value="pageBean.list" status="sts">
<div class="content well-small">
  		<div class="media">
         	<a href="#" class="pull-left">
		<img class="media-object img-polaroid" src="${enterprise.logo }" style="height: 80px; width: 80px;">
        		</a>
	<div class="media-body">
		<a href="#" onclick="window.parent.addTab('${postingName}',
						'/JobPostingsWeb/enterprise/c_PositionDetail_load?recruitmentId=${recruitmentId}')">
					<h4 class="media-heading">${postingName}</h4></a>
            		<a href="#" onclick="window.parent.addTab('${enterprise.enterpriseName}',
	                         '../enterprise/s_CompanyPage_loadOfS.action?enterpriseId=${enterprise.enterpriseId}')">
	                <h6 class="media-heading">${enterprise.enterpriseName}</h6></a>
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