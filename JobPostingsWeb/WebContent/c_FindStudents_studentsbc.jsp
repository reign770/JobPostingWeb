<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="application/javascript">
$(function () {
	$('#pagination').pagination({
		total:${pageBean.allRow},
	    pageSize:${pageBean.pageSize},
	    onSelectPage:function(pageNumber,pageSize){
			$('#contents').panel('refresh', '/JobPostingsWeb/enterprise/bc_c_FindStudents_load_students.action?pageSize='+pageSize+'&pageNum='+pageNumber+'&classId=${classId}');
		}
	});
	
	
	
});
</script>

 		<s:iterator value="pageBean.list">
 			<div class="content well-small">
         		<div class="media">
                	<a href="#" class="pull-left">
    					<img class="media-object img-polaroid" src="${headImage }" style="" >
               		</a>
    				<div class="media-body">
   						<a onclick="window.parent.addTab('${name }'+'的简历','/JobPostingsWeb/student/studentInfo_showStudentInfo.action?studentId=${studentId}')"><h4 class="media-heading">${name }</h4></a>   
                   		<a href="#"><h6 class="media-heading">${sex }</h6></a>
    			
    					<strong>出生年月：</strong>	<fmt:formatDate value="${birthday}" type="date" dateStyle="long"/>
    					<strong>民族：</strong>${nation}
    					<strong>学历：</strong>${degree}
    					<strong>电话：</strong>${telephone}
    					<strong>身份证号码：</strong>${idNum}
    					<strong>联系地址：</strong>${address}
    					<strong>毕业时间：</strong><fmt:formatDate value="${graduationDate}" type="date" dateStyle="long"/>
						<strong>平均绩点：</strong>${gpa}
    					<strong>专业：</strong>${schoolClass.major.majorName}
    					<strong>毕业学校：</strong>${school}
     				</div>
   			 	</div>
        	</div>
 		</s:iterator>
    		
