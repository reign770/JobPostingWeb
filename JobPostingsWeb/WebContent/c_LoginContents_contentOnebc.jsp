<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="application/javascript">
$(function(){
	total1=${pageBeanOne.allRow};
});
	
</script>
 <s:iterator value="pageBeanOne.list" status="sts">
 	<li class="well well-small" onclick="contentOneClick(this)">
		<a data-toggle="modal"  data-target="#modal">
			<span class="news-contents-list-time pull-left"><fmt:formatDate value="${releaseDate }" pattern="yyyy-MM-dd"/></span>
			<span class="news-contents-list-title pull-right">
			<span class="title" >${title }</span>
                        	
			<i class="icon-chevron-right"></i>
			</span>
			<input class="hiddenContent" type="hidden" value="${info }"/>
		 </a>
	</li>
 </s:iterator>
