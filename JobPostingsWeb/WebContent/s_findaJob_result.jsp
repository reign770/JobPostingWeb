<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>       
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知</title>
<link href="/JobPostingsWeb/css/s_findaJob_result.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="application/javascript">
$(function () {
	var flag = 0;//1为高级搜索,0为简单搜索
	var action = "recruitment_getSearchResult.action";
	var queryWord;//搜索职位
	var postingName;//职位名称
	var workingPlace;//工做地点
	var salary;//工资
	var property;//企业性质
	var industryId;
	$('#myTab a').click(function (e) {
    	e.preventDefault();
    	$(this).tab('show');
    });
	$('#searchingBar .label').toggle(function(){
			$('#searchingBar .rows').css("display","block");
			$(this).html('简单搜索<i class="icon-chevron-up"></i>');
			flag = 1;
		},function(){
			$('#searchingBar .rows').css("display","none");
			$(this).html('高级搜索<i class="icon-chevron-down"></i>');
			flag = 0;
		});
 	$('#pagination').pagination({
 		total:${pageBean.allRow},
 		pageSize:${pageBean.pageSize},
		pageList: [1],
		onSelectPage:
			  function(pageNumber,pageSize){
			  pageNum = pageNumber;
			  var url =action+'?pageSize='+pageSize+'&&pageNumber='+pageNumber
	   		  +'&&addition.queryWord='+queryWord+'&&addition.workingPlace='+workingPlace;
			  if(flag ==1)
				  url=url+'&&addition.salary='+salary+'&&addition.postingName='+postingName
		   		  +'&&addition.enterpriseProperty='+property+'&&addition.industryId='+industryId;
			  
	   		  $("#contents").panel('refresh',url);
	   		  }
	});
 	$('#search').live('click',function(){
 		queryWord = $('#queryWord').val();
 		workingPlace =$('#workingPlace').val();
 		salary =$('#salary').val();
 		postingName =$('#postingName').val();
 		property = $('#property').val();
 		industryId = $('#industry').val();
 	    $("#pagination").pagination("select",1);
 	});
});
</script>
</head>

<body style="background:#ECEFF1;">
<div class="myLayout">
	<div class="navbar" id="searchingBar">
		<div  id="searchingBarContent">
    		<input id="queryWord" type="text" class="input-medium search-query" placeholder="请输入关键字">
        	<input id="workingPlace" type="text" class="input-medium search-query" placeholder="请输入城市名称">
			<button  id="search" class="btn btn-info">搜索职位</button>
		</div>
        <div class="rows">
        	<span class="span4">
        		<label class="pull-left">每月薪水:</label>
       			<select id="salary" class="pull-right">
					<option value="-1">不限</option>
					<option value="1000">1000以上</option>
					<option value="2000">2000以上</option>
					<option value="3000">3000以上</option>
					<option value="4000">5000以上</option>
					<option value="7000">7000以上</option>
					<option value="10000">10000以上</option>
				</select>
       		</span>
        	<span class="span4 offset1">
        		<label class="pull-left">职位类别:</label>
       			<select id="postingName" class="pull-right" >
       				<option value="">不限</option>
					<option value="程序员">程序员</option>
					<option value="软件架构师">软件架构师</option>
					<option value="系统分析师">系统分析师</option>
					<option value="项目经理">项目经理</option>
				</select>
       		</span>
        </div>
       <div class="rows">
        	<span class="span4">
        		<label class="pull-left">所属行业:</label>
       			<select id="industry" class="pull-right">
					<option value="">不限</option>
					<s:iterator value="industries">
					   <option value="${industryId}">${jobType}</option>
					</s:iterator>
				</select>
       		</span>
      		<span class="span4 offset1">
        		<label class="pull-left">企业类型：</label>
       			<select id="property" class="pull-right" >
					<option value="">不限</option>
					<option value="国有企业">国有企业</option>
					<option value="外资">外资</option>
					<option value="合资">合资</option>
					<option value="股份制">股份制</option>
					<option value="非盈利">非盈利</option>
				</select>
       		</span>
        </div>
        <span class="label label-info">高级搜索<i class="icon-chevron-down"></i></span>
    </div>
    
    
	<div id="jobsContent">
 		<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''">
    	</div>
    	<div id="pagination" class="easyui-pagination">  
        </div> 
    </div>  
 
</div>
</body>
</html>