<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生简历</title>
<link href="/JobPostingsWeb/css/s_resume.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
</head>

<body>
<div class="myLayout well">
	<div class="basicInfo">
    	<div class="page-header"><h2>基本信息</h2></div>
		<div id="basicInfoContent" class="row">	
       		<dl class="dl-horizontal span8" style="font-size: 18px;">
    			<dt>姓名：</dt>
    			<dd>${student.name}</dd>
    			<br/>
            	<dt>性别：</dt>
    			<dd>${student.sex}</dd>
    			<br />
    			<dt>出生年月日：</dt>	
    			<dd><fmt:formatDate value="${student.birthday}" 
    			type="date" dateStyle="long"/>
    			</dd>
    			<br />
    			<dt>民族：</dt>
    			<dd>${student.nation}</dd>
    			<br />
    			<dt>学历：</dt>
    			<dd>${student.degree}</dd>
    			<br />
    			<dt>电话：</dt>
    			<dd>${student.telephone}</dd>
    			<br />
    			<dt>身份证号码：</dt>
    			<dd>${student.idNum}</dd>
    			<br />
    			<dt>联系地址：</dt>
    			<dd>${student.address}</dd>
    			<br />    			
    			<dt>毕业时间：</dt>
    			<dd><fmt:formatDate value="${student.graduationDate}" 
    			type="date" dateStyle="long"/>
				</dd>
    			<br />
    			<dt>平均绩点：</dt>
    			<dd>${student.gpa}</dd>
    			<br />
    			<dt>专业：</dt>
    			<dd>${student.schoolClass.major.majorName}</dd>
    			<br />
    			<dt>毕业学校：</dt>
    			<dd>${student.school}</dd>
    		</dl>
            <div id="basicInfoHeadIcon" >
            	<img src="/JobPostingsWeb/img/12883156763984.jpg" width="100" height="100"  class="img-polaroid"/>
            </div>
        </div>	
	</div>
    <div class="additionalInfo">
    	<div class="page-header"><h2>兴趣爱好</h2></div>
		<div id="additionalInfoContent" class="row">	
       		<p class="offset1" style="font-size: 20px;">
       			${student.brief.interests }
       		</p>
        </div>
	</div>
	<div class="additionalInfo">
    	<div class="page-header"><h2>主修课程</h2></div>
		<div id="additionalInfoContent" class="row">	
       		<p class="offset1" style="font-size: 20px;">
       			${student.brief.majorCourse}
       		</p>
        </div>
	</div>
		<div class="additionalInfo">
    	<div class="page-header"><h2>荣誉和奖励</h2></div>
    	<c:forTokens items="${student.brief.honor}" delims="," var="item">
			<div id="additionalInfoContent" class="row">	
	       		<p class="offset1" style="font-size: 20px;">${item}</p>
	        </div>
    	</c:forTokens>
	</div>
		<div class="additionalInfo">
    	<div class="page-header"><h2>经验与实习</h2></div>
    	<c:forTokens items="${student.brief.experience}" delims="," var="item">
			<div id="additionalInfoContent" class="row">	
	       		<p class="offset1" style="font-size: 20px;">${item}</p>
	        </div>
    	</c:forTokens>	
    </div>
	<div class="additionalInfo">
    	<div class="page-header"><h2>个人简介</h2></div>
		<div id="additionalInfoContent" class="row">	
       		<p class="offset1" style="font-size: 16px;">
       		 	${student.brief.resume}
       		</p>
        </div>
	</div>
<!--      <div class="comments">
     <div class="page-header"><h2>评论</h2></div>
     	<div class="commentRow">
			<div class="row">	
       			<div id="comments_user" class="span1">
            		<a href="#">
              			<img src="/JobPostingsWeb/img/12883156763984.jpg" width="50" height="50"  class="img-polaroid"/>
              			<p>名字</p>
             	 	</a>
           		 </div>
           	 	<div id="comments_content" class="span8">
              		<p>dadadadadada<br />sasasasasasas</p>
            	</div>
       		 </div>
         </div>
         
         <div class="addcommentRow">
			<div class="row">	
       			<div id="comments_user" class="span1">
            		<a href="#">
              			<img src="/JobPostingsWeb/img/12883156763984.jpg" width="50" height="50"  class="img-polaroid"/>
              			<p>名字</p>
             	 	</a>
           		 </div>
           	 	<div id="comments_addcontent" class="span9">
              		 <textarea rows="5" ></textarea>
            	</div> 
       		 </div>
             <div class="buttons row">	
                <input type="button" class="btn btn-primary offset2" value="    提交评论   "/>
             </div>
         </div> -->
         
	 </div>
</div>
</body>
</html>