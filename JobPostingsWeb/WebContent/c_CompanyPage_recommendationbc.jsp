<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="application/javascript">
$(function () {
	totalOfRecommendation=${pageBean3.allRow}
});
</script>

				  <s:iterator value="pageBean3.list">
    						<li class="span5" style="margin-left: 5px;">
    							<div class="thumbnail">
   								 	<img src="${headImage }" alt="" >
    							 	<div class="caption">
    							 		<p style="word-break: break-all;">${name }</p>
   								 	</div>
    							</div>
    						</li>
    					</s:iterator>
				