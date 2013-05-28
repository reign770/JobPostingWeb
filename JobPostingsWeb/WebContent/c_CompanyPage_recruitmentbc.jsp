<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="application/javascript">
$(function () {
	totalOfRecruitment=${pageBean1.allRow};
});
</script>

				  <s:iterator value="recruitments" status="sts">
					<div class="wantedInfocontent well-small">
         				<div class="media">
                			<a href="#" class="pull-left">
    							<img class="media-object img-polaroid" src="${enterprise.logo}" style="" >
               				</a>
    						<div class="media-body">
   								<a href=" javascript:void(0)" onclick="window.parent.addTab('${postingName}','/JobPostingsWeb/enterprise/c_PositionDetail_load?recruitmentId=${recruitmentId }')">
   									<h4 class="media-heading">${postingName}</h4>
   								</a>
                   				<a href="#"><h6 class="media-heading">${enterprise.enterpriseName} </h6></a>
    			  				工作城市：${workingPlace } 每月薪水：${salary } 行业类别：${industry.jobType }
     						</div>
   			 			</div>
        			</div>
				  </s:iterator>
				