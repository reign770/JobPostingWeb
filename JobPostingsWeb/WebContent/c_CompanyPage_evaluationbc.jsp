<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="application/javascript">
$(function () {
	totalOfRecommendation=${pageBean2.allRow}
});
</script>

				  <s:iterator value="pageBean2.list">
					<div class="commentRow">
						<div class="row">	
       						<div id="comments_user" class="span1">
            					<a href="#">
              						<img src="${student.headImage }" width="50" height="50"  class="img-polaroid"/>
              						<p>${student.name }</p>
             	 				</a>
           				 	</div>
           	 				<div id="comments_content" class="span5">
              					<p>${content}<br /><fmt:formatDate value="${pubdate}" pattern="yyyy-MM-dd"/></p>
            				</div>
       		 			</div>
        		 	</div>
         		</s:iterator>
				