<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人才库</title>
<link href="/JobPostingsWeb/css/c_findStudents.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="application/javascript">
var classId=0;
$(function () {
	$('#pagination').hide();
	$('#pagination').pagination({
		pageList: [1,2,10,20,50,100],
		
	});
	$('#search').one('click',function(){
		$('#pagination').fadeIn('300');
	});
	$('#search').click(function(){
		classId=$('#classId').val();
		console.log(classId);
		$('#contents').panel('refresh', '/JobPostingsWeb/enterprise/bc_c_FindStudents_load_students.action?pageSize=10&pageNum=1&classId='+classId);
	});
	
	//json设置专业
	var majorId = $("#majorId");
	majorId.empty();//清空select下拉框
    $.getJSON("/JobPostingsWeb/MGC.json", function(json){
    	    
    		for(var i=0;i<json.majors.length;i++){
    			console.log(json.majors.length);
    			console.log("<option value='" + json.majors[i].majorId + "'>" + json.majors[i].majorName+ "</option>");
            	$("<option value='" + json.majors[i].majorId + "'>" + json.majors[i].majorName+ "</option>").appendTo(majorId);//动态添加Option子项
        	}
    		var classes=json.majors[0].classes;
    		classChoose.empty();//清空select下拉框
			for(var i=0;i<classes.length;i++){
            	$("<option value='" + classes[i].classId + "'>" + classes[i].className+ "</option>").appendTo(classChoose);//动态添加Option子项
			}
    		
    	});
	//联动
    var classChoose = $("#classId");
	
	$(majorId).change(function(){
		$.getJSON("/JobPostingsWeb/MGC.json", function(json){
    	    
    		for(var i=0;i<json.majors.length;i++){
    			if($.trim(json.majors[i].majorId)==$(majorId).val()){
    				var classes=json.majors[i].classes;
    				classChoose.empty();//清空select下拉框
    				for(var i=0;i<classes.length;i++){
    					console.log("<option value='" + classes[i].classId + "'>" + classes[i].className+ "</option>");
    	            	$("<option value='" + classes[i].classId + "'>" + classes[i].className+ "</option>").appendTo(classChoose);//动态添加Option子项
    				}
    				break;
    			}
    			
        	}
    	});
    });
	
});
</script>
</head>

<body style="background:#ECEFF1;">
<div class="myLayout">
	<div class="navbar" id="searchingBar">
			
        <div class="rows">
        	<span class="span4">
        		<label class="pull-left" >专业:</label>
       			<select class="pull-right span3" id="majorId">
				
				</select>
       		</span>
        	<span class="span4">
        		<label class="pull-left">班级:</label>
       			<select class="pull-right span3" id="classId" >
					
				</select>
       		</span>
       		<button type="button" class="btn btn-info" id="search">搜索学生</button>
        </div>
     
        
    </div>
    
    
	<div id="studentsContent">
 		<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''"> 
 	</div>  
    <div id="pagination" class="easyui-pagination" data-options="total:0,pageSize:10">  
    </div> 
    
	



</div>
</body>
</html>
