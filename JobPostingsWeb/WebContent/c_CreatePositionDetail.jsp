<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位详情</title>
<link href="/JobPostingsWeb/css/c_CreatePositionDetail.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/css/datetimepicker.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
$(function(){
	//json设置行业类型
	var industries = $("#industries");
	industries.empty();//清空select下拉框
    $.getJSON("/JobPostingsWeb/industry.json", function(json){
    		for(var i=0;i<json.industries.length;i++){
            	$("<option value='" + json.industries[i].industryId + "'>" + json.industries[i].jobType + "</option>").appendTo(industries);//动态添加Option子项
        	}
    	});
	//检验数据
    $("form").submit(function(){
		if($.trim($(":text").val())==""){
			alert("请填写所有信息!");
			return false;
		}
		
	});
	//timepicker
	$(".form_datetime").datetimepicker({
		minView:'month',
		format: 'yyyy-mm-dd',
		autoclose:"true",
		todayHighlight:true,
		language:"zh-CN"});
    
	
});
</script>
</head>

<body>
<div class="myLayout">
<form action="/JobPostingsWeb/enterprise/c_CreatePositionDetail_insert" method="post">	
	<div class="span10" id="positionInfo">
		<div class="basicInfo">
    		<div class="page-header"><h2>基本信息</h2></div>
			<div id="basicInfoContent" class="row">	
       			<dl class="dl-horizontal span8">
    				<dt>职位名称：</dt>
    				<dd><input type="text" name="recruitment.postingName" /></dd>
    				<dt>工作城市：</dt>
    				<dd><input type="text" name="recruitment.workingPlace" /></dd>
    				<dt>招聘人数：</dt>
    				<dd><input type="text" name="recruitment.recruitmentCount" /></dd>
    				<dt>每月薪水：</dt>
    				<dd><input type="text" name="recruitment.salary" /></dd>
            		<dt>工作经验：</dt>
    				<dd><input type="text" name="recruitment.workExperience" /></dd>
    				<dt>性别要求：</dt>
    				<dd>
    					<select id="sex" name="recruitment.sex">
    						<option value="不限">不限</option>
    						<option value="男">男</option>
    						<option value="女">女</option>
    					</select>
    				</dd>
    				<dt>年龄要求：</dt>
    				<dd><input type="text" name="recruitment.age" /></dd>
    				<dt>外语要求：</dt>
    				<dd><input type="text" name="recruitment.foreignLanguage" /></dd>
    				<dt>学历要求：</dt>
    				<dd><input type="text" name="recruitment.degree" /></dd>
    				<dt>截止日期：</dt>
    				<dd>
    				<div class="input-append date form_datetime">
						<input size="16" type="text"  readonly name="recruitment.deadline">
    					<span class="add-on"><i class="icon-th"></i></span>
					</div>
    				</dd>
    				<dt>所属行业：</dt>
    				<dd><select id="industries" name="recruitment.industry.industryId">
    					 
    					</select>
    				</dd>
    			</dl>
            
        	</div>	
		</div>
        
        
        
    	<div class="additionalInfo">
    		<div class="page-header"><h2>岗位描述</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5" name="recruitment.qualification"></textarea></p>
       		</div>
       		<div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5" name="recruitment.responsibilities" ></textarea></p>
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
