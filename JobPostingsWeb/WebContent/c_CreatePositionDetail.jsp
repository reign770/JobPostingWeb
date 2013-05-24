<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位详情</title>
<link href="/JobPostingsWeb/css/c_CreatePositionDetail.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
</head>

<body>
<div class="myLayout">
<form>	
	<div class="span10" id="positionInfo">
		<div class="basicInfo">
    		<div class="page-header"><h2>基本信息</h2></div>
			<div id="basicInfoContent" class="row">	
       			<dl class="dl-horizontal span8">
    				<dt>职位名称：</dt>
    				<dd><input type="text" /></dd>
            		<dt>所属行业：</dt>
    				<dd><input type="text" /></dd>
    			</dl>
            
        	</div>	
		</div>
        
        
        
    	<div class="additionalInfo">
    		<div class="page-header"><h2>岗位描述</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5"></textarea></p>
       		</div>
       		<div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5"></textarea></p>
       	 	</div>
            <div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5"></textarea></p>
       	 	</div>
            <div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5"></textarea></p>
       	 	</div>
            <div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5"></textarea></p>
       	 	</div>
            <div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5"></textarea></p>
       	 	</div>
            <div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5"></textarea></p>
       	 	</div>
		</div>
        
        <div id="buttons" class="row" >
    		<input type="submit" class="btn btn-primary" value="    发 布    "/>
    		<input type="button" class="btn btn-primary offset1" value="    取 消    "/>
    	</div>
        
        
        
    </div>
    
</form>    
</div>
</body>
</html>
