<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生简历</title>
<link href="/JobPostingsWeb/css/s_resume_revise.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<style>
	.item{
		margin-bottom:15px;
		}
	.additionalInfoContent .item .btn{
	    margin-left:10px;
	}
</style>
<script>
	$(function(){
		    //添加主修课程
			$("#addcourse").click(function(){
				$("#course .additionalInfoContent").append("<div class='item'>"+
					"<input  name='resume.majorCourse' type='text' style='margin-bottom:0px;' placeholder='课程'>"+
                    "<input type='button' class='btn btn-danger' value='删除'></div>");
			});
		    //添加兴趣爱好 
		    $("#addinterest").click(function(){
				$("#interest .additionalInfoContent").append("<div class='item'>"+
						"<input  name='resume.interests' type='text' style='margin-bottom:0px;' placeholder='兴趣'>"+
	                    "<input type='button' class='btn btn-danger' value='删除'></div>");
		    });
		    //添加个人荣誉和奖励
		    $("#addhonor").click(function(){
		    	$("#honor .additionalInfoContent").append("<div class='item'>"+
						"<input class='span6' name='resume.honors' type='text' style='margin-bottom:0px;' placeholder='奖项和荣誉'>"+
	                    "<input type='button' class='btn btn-danger' value='删除'></div>");
		    });
		    //添加个人经历
		    $("#addexperience").click(function(){
		    	$("#experience .additionalInfoContent").append("<div class='item'>"+
						"<input class='span6' name='resume.experience' type='text' style='margin-bottom:0px;' placeholder='个人经历'>"+
	                    "<input type='button' class='btn btn-danger' value='删除'></div>");
		    });
		    //删除
		    $('.additionalInfoContent .btn-danger').live("click",function(){
		    	$(this).parent().html('');
		    });
		    //保存
		    $('#save').click(function(){
		    	$('#alert').modal('show');
		    });
		    $('#confirm').click(function(){
		    	$('#info').submit();
		    });
		});
</script>
</head>
<body>
<div class="modal hide fade in" id="alert" style="display: none;">
            <div class="modal-header">
              <a data-dismiss="modal" class="close">×</a>
              <h3>确定</h3>
            </div>
            <div class="modal-body">
              <h5>你确定你要修改并保存你的简历吗？</h5>
      	    </div>
            <div class="modal-footer">
              <a class="btn btn-primary" href="#" id="confirm">确定</a>
              <a data-dismiss="modal" class="btn btn-warning" href="#">取消</a>
            </div>
</div>
<div class="myLayout">
	<form  id='info' method="post"  action="studentInfo_modifyBrief.action">
	<div>	
            <div id="industry" class="additionalInfo">
            	<div class="page-header"><h2>就业意向</h2></div>
            	
            	<div class="additionalInfoContent" class="row" >
       			<select id="industry" name="jobIntentionId">
					<s:iterator value="industries" var="industry">
					   <s:if test="jobIntentionId == industryId">
					   <option value="${industryId}" selected>${jobType}</option>
					   </s:if>
					   <s:else>
					   <option value="${industryId}" >${jobType}</option>
					   </s:else>
					</s:iterator>
				</select>
                </div>
            </div>
            <div id="course" class="additionalInfo">
                <div class="page-header"><h2>主修课程</h2></div>
                <div class="additionalInfoContent" class="row" >
                   <s:iterator value="resume.majorCourse" status="sts" var="course">
                    <div class="item">	
                        <input  name="resume.majorCourse" type="text" style="margin-bottom:0px;" 
                        placeholder="课程" value="${course}">
                        <input  type="button" class="btn btn-danger" value="删除">
                    </div>
                   </s:iterator>
                </div>
                 <div class="add">
                	<input type="button" id="addcourse" class="btn btn-primary addIntrest" value="添加"/>
                </div>
            </div>
             <div id="interest" class="additionalInfo">
                <div class="page-header"><h2>兴趣爱好</h2></div>
                <div class="additionalInfoContent" class="row" >
                	<s:iterator value="resume.interests" var="interest">
	                     <div class="item">	
	                        <input  name="resume.interests" type="text" style="margin-bottom:0px;" 
	                        placeholder="兴趣" value="${interest}">
	                        <input  type="button" class="btn btn-danger" value="删除">
	                    </div>
                    </s:iterator>
                </div>
                 <div class="add">
                	<input id="addinterest" type="button" class="btn btn-primary addIntrest" value="添加">
                </div>
            </div>
            <div id="honor" class="additionalInfo">
                 <div class="page-header"><h2>个人奖项和荣誉</h2></div>
                       <div class="additionalInfoContent" class="row">
                       <s:iterator value="resume.honors" var="honor">
                        <div class="item">	
                            <input  class="span6" name="resume.honors" type="text" 
                            style="margin-bottom:0px;" placeholder="奖项和荣誉"
                            value="${honor}"/>
                            <input type="button" class="btn btn-danger" value="删除">
                        </div>
                       </s:iterator>
               	</div>
                 <div class="add">
                	<input id="addhonor" type="button" class="btn btn-primary" value="添加"/>
                </div>
            </div>
            <div id="experience" class=" additionalInfo">
                    <div class="page-header"><h2>个人经历</h2></div>
                        <div class="additionalInfoContent" class="row" >
                        <s:iterator value='resume.experience' var="exp">
	                        <div class="item">	
	                        <input  class="span6" name="resume.experience" type="text" style="margin-bottom:0px;" 
	                        placeholder="个人经历" value="${exp}"/>
	                        <input type='button' class="btn btn-danger" value="删除"/>
	                        </div>
                        </s:iterator>
                </div>
                <div class="add">
                	<input id="addexperience" type="button" class="btn btn-primary addIntrest" value="添加">
                </div>
            </div>
            <div id="resume" class=" additionalInfo">
                    <div class="page-header"><h2>个人简介</h2></div>
                        <div id="additionalInfoContent" class="row">
                        	<textarea rows="8" class="offset1" name="resume.resume">${resume.resume}</textarea>
                        </div>
                   </div>
            </div>
            <div id="buttons" class="row" >
                <input id="save"type="button" class="btn btn-primary" value="    保 存    "/>
                <input id="cancel" type="button" class="btn btn-primary offset1" value="    取 消    "/>
            </div>
    </form>
</div>
</body>
</html>
