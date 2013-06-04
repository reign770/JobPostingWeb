<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="application/javascript">
$(function () {
	totalOfRecommendation=${pageBean.allRow};
	
	recommendToggleInit();
});
</script>

				  <s:iterator value="pageBean.list" status="sts">
					<li class="span3" style="margin-left: 5px;">
    					<div class="thumbnail" >
   							<img src="${headImage }" alt="" />
    						<i class="icon-ok pull-left"></i>
    						<p style="word-break: break-all;">${name }</p>
    						<input type="hidden" value="${studentId}" />
   							<p>
   								<a href="javascript:void(0)" class="btn btn-primary" onclick="window.parent.addTab('${name }'+'的简历','/JobPostingsWeb/student/studentInfo_showStudentInfo.action?studentId=${studentId}')">查看简历</a>
   							</p>
   							
    					</div>
    				</li>
				  </s:iterator>
				  <s:if test="pageBean.list.size==0">
				  		木有人才了...哈哈哈哈哈哈~~
				  </s:if>
				