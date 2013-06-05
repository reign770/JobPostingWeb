<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知</title>
<link href="/JobPostingsWeb/css/s_enterprise_result.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="application/javascript">
$(function (){
	var flag = 0;//1为高级搜索,0为简单搜索
	var action = "enterprise_getSearchResult.action";
	var queryWord;//搜索关键字
	var place;//工做地点
	var property;//企业性质
	var pageNum;
	$('#myTab a').click(function (e) {
    	e.preventDefault();
    	$(this).tab('show');
    });
	$('#searchingBar .label').toggle(function(){
			$('#searchingBar .rows').css("display","block");
			$(this).html('普通搜索<i class="icon-chevron-up"></i>');
			flag = 1;
		},function(){
			$('#searchingBar .rows').css("display","none");
			$(this).html('筛选<i class="icon-chevron-down"></i>');
			flag = 0;
	});
	$('#pagination').pagination({
		total:${pageBean.allRow},
		pageSize:${pageBean.pageSize},
		pageList: [10],
		onSelectPage:
		  function(pageNumber,pageSize){
			  pageNum = pageNumber;
			  var url =action+'?pageSize='+pageSize+'&&pageNumber='+pageNumber
	   		  +'&&addition.queryWord='+queryWord;
			  if(flag ==1)
				  url=url+'&&addition.property='+property+'&&addition.address='+place;
	   		  $("#contents").panel('refresh',url);
   		  }
    });
	 $('#search').live('click',function(){
		change();
	});
	$('#place').change(function(){
		change();
	});
	$('#property').change(function(){
		change();
	});
	function change(){
		queryWord = $('#queryWord').val();
		place =$('#place').val();
		property = $('#property').val();
	    $("#pagination").pagination("select",1);
	}; 
});
</script>
</head>

<body style="background:#ECEFF1;">
<div class="myLayout">
	<div class="navbar" id="searchingBar">
    	<div  id="searchingBarContent">
    		<input type="text" id="queryWord" class="input-medium search-query" placeholder="请输入公司的名称">
			<button id="search" class="btn btn-info">搜索公司</button>
        </div>
        <div class="rows">
        	<span class="span4">
        		<label class="pull-left">公司地址:</label>
       			<select id="place" class="pull-right">
       				<option value="">不限</option>
					<option value="重庆">重庆</option>
					<option value="四川">四川</option>
					<option value="北京">北京</option>
					<option value="上海">上海</option>
					<option value="广东">广东</option>
					<option value="湖南">湖南</option>
				</select>
       		</span>
        	<span class="span4 offset1">
        		<label class="pull-left">公司性质:</label>
       			<select id="property" class="pull-right" >
       				<option value="">不限</option>
					<option value="国有企业">国有企业</option>
					<option value="外资">外资</option>
					<option value="合资">合资</option>
					<option value="私营">私营</option>
					<option value="股份制">股份制</option>
					<option value="非盈利">非盈利</option>
				</select>
       		</span>
        </div>
        <span class="label label-info">筛选<i class="icon-chevron-down"></i></span>
    </div>
    
    
	<div id="jobsContent">
 		<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''"> 
    	 <s:iterator value="pageBean.list" status="sts" var="ent">
    		<div class="content well-small">
         		<div class="media">
                	<a href="#" class="pull-left">
    					<img class="media-object img-polaroid" src="${logo }" style="height: 75px;width: 75px;" >
               		</a>
    				<div class="media-body">
   						<a href="#" onclick="window.parent.addTab('${enterpriseName}',
	                         '../enterprise/s_CompanyPage_loadOfS.action?enterpriseId=${enterpriseId}')">
	                     <h4 class="media-heading">${enterpriseName }</h4></a>
                   		 性质：${enterpriseName}&nbsp;&nbsp;&nbsp;所在地区：${address}<br />
                                            公司规模：${enterpriseScale}人&nbsp;&nbsp;职位：${recruitments.size()}个<br />
                                            评论：${evaluations.size()}条
     				</div>
   			 	</div>
        	</div>
        </s:iterator>
    	</div>  
	    <div id="pagination" class="easyui-pagination">  
	    </div>  
    </div>
</div>
</body>
</html>
