<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位详情</title>
<link href="/JobPostingsWeb/css/c_positionDetail.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
</head>

<body>
<div class="myLayout">
	
	<div class="span10" id="positionInfo">
		<div class="basicInfo">
    		<div class="page-header"><h2>基本信息</h2></div>
			<div id="basicInfoContent" class="row">	
       			<dl class="dl-horizontal span8">
    				<dt>职位名称：</dt>
    				<dd>${recruitment.postingName}</dd>
    				<dt>工作城市：</dt>
    				<dd>${recruitment.workingPlace}</dd>
    				<dt>招聘人数：</dt>
    				<dd>${recruitment.recruitmentCount}</dd>
    				<dt>每月薪水：</dt>
    				<dd>${recruitment.salary}</dd>
            		<dt>工作经验：</dt>
    				<dd>${recruitment.workExperience}</dd>
    				<dt>性别要求：</dt>
    				<dd>${recruitment.sex}</dd>
    				<dt>年龄要求：</dt>
    				<dd>${recruitment.age}</dd>
    				<dt>外语要求：</dt>
    				<dd>${recruitment.foreignLanguage}</dd>
    				<dt>学历要求：</dt>
    				<dd>${recruitment.degree}</dd>
    				<dt>截止日期：</dt>
    				<dd><fmt:formatDate value="${recruitment.deadline}" pattern="yyyy-MM-dd"/></dd>
    				<dt>所属行业：</dt>
    				<dd>${recruitment.industry.jobType}</dd>
    				
    			</dl>
                <button class="btn btn-info pull-right" >修改</button>
                <button class="btn btn-danger pull-right" >停止招聘</button>
        	</div>	
		</div>
        
        
        
    	<div class="additionalInfo">
    		<div class="page-header"><h2>岗位描述</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1">${recruitment.qualification}</p>
       	 	</div>
    		<div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1">${recruitment.responsibilities}</p>
       		</div>
       		
        </div>
        
        
        
    </div>
    
    <div class="span10" id="publisher">
    	<div class="page-header"><h4>职位发布人</h4></div>
    	<span id="headicon" class="pull-left"><img src="/JobPostingsWeb/img/12883156763984.jpg" class="img-polaroid" style="height:100px"/></span>
      	<span id="username"><a href="#"><h4>${recruitment.enterprise.enterpriseName}</h4></a></span>
     	<button class="btn btn-info">加关注</button>
    </div> 
    
</div>
</body>
</html>
