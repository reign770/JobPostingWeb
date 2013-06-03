<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$('#pagination').pagination({
		total:${pageBean.allRow}
});
</script>  
 <s:iterator value="pageBean.list" status="sts">
	        	 <div class="content well-large">
	         		<div class="media" id="${invitationId}">
	                	<a href="#" class="pull-left">
	    					<img class="media-object img-polaroid" src="${recruitment.enterprise.logo}" style="" >
	                	</a>
						<h6><a class="enterpriseName" href="#">${recruitment.enterprise.enterpriseName}</a>邀请你投递<a class="postingName" 
						href="#">${recruitment.postingName}</a>职位</h6>
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