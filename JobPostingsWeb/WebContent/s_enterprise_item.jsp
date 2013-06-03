<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
$('#pagination').pagination({
		total:${pageBean.allRow}
});
</script>  
<s:iterator value="pageBean.list" status="sts" var="ent">
	<div class="content well-small">
	   		<div class="media">
	          	<a href="#" class="pull-left">
				<img class="media-object img-polaroid" src="${logo }" style="height: 50px;" >
	         		</a>
			<div class="media-body">
				<a href="#"><h4 class="media-heading">${enterpriseName }</h4></a>
	             		 性质：${enterpriseName}&nbsp;&nbsp;&nbsp;所在地区：${address}<br />
	                                      公司规模：${enterpriseScale}人&nbsp;&nbsp;职位：${recruitments.size()}个<br />
	                                      评论：${evaluations.size()}条
				</div>
	 	</div>
	</div>
</s:iterator>