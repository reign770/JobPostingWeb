<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<script>
$('#pagination').pagination({
		total:${pageBean.allRow}
});
/* $('.content .check').click(function(){
	$(this).parents('.media').siblings('.notificationcontent').slideToggle();
	}); */
</script> 
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