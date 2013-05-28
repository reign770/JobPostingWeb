<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>personalPage</title>
<link href="/JobPostingsWeb/css/personalPage.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/menu.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
</head>
<body>
<div class="myLayout">
    <div class="navs">
        <div id="barPart">
            <div>
        		<span id="headicon"><img src="/JobPostingsWeb/img/12883156763984.jpg" style="height:32px"/></span>
      			<span id="username"><h6>${user.enterpriseName}</h6></span>
            </div>
            <span id="notification" class="badge badge-info">2</span>
        </div>
    	<ul class="nav nav-list layer1">
           
         
           <li class="nav-header"><i class="icon-chevron-down"></i>学生</li>
           	<li><a href="javascript:void(0)" onclick="addTab('a','/JobPostingsWeb/s_resume.html')">学生简历</a></li>
          	<li><a href="javascript:void(0)" onclick="addTab('a_revise','/JobPostingsWeb/s_resume_revise.html')">学生简历修改</a></li>
           	<li><a href="javascript:void(0)" onclick="addTab('newsOfStudents','/JobPostingsWeb/s_newsOfStudents.html')">学生新闻</a></li>
           	<li><a href="javascript:void(0)" onclick="addTab('notificationsOfStudents','/JobPostingsWeb/s_notificationsOfStudents.html')">通知页面</a></li>
           	<li><a href="javascript:void(0)" onclick="addTab('findaJob','/JobPostingsWeb/s_findaJob.html')">找工作</a></li>
          	<li><a href="javascript:void(0)" onclick="addTab('findaJob_result','/JobPostingsWeb/s_findaJob_result.html')">找工作结果</a></li>
          	<li><a href="javascript:void(0)" onclick="addTab('s_checkPositionDetail','/JobPostingsWeb/s_checkPositionDetail.html')">查看职位详情</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>学校</li>
           	<li><a href="javascript:void(0)" onclick="addTab('import','/JobPostingsWeb/a_import.html')">文件导入</a></li>
           	<li><a href="javascript:void(0)" onclick="addTab('school_dataCalculatingAndOutput','/JobPostingsWeb/a_dataCalculatingAndOutput.html')">学校查看学生信息&数据统计&数据导出</a></li>
           
           <li class="nav-header"><i class="icon-chevron-down"></i>企业</li>
            <li><a href="javascript:void(0)" onclick="addTab('dealWithApplicationsOne','/JobPostingsWeb/enterprise/c_DealWithApplicationsOne_load.action')">处理职位申请——选职位</a></li>
           	<li><a href="javascript:void(0)" onclick="addTab('dealWithApplicationsTwo','/JobPostingsWeb/c_dealWithApplicationsTwo.html')">处理职位申请</a></li>
           	<li><a href="javascript:void(0)" onclick="addTab('positionDetail_create','/JobPostingsWeb/enterprise/c_CreatePositionDetail_load.action')">创建招聘信息</a></li>
           	<li><a href="javascript:void(0)" onclick="addTab('companypage','/JobPostingsWeb/enterprise/c_CompanyPage_load.action')">公司首页</a></li> 
           	<li><a href="javascript:void(0)" onclick="addTab('c_positionDetail','/JobPostingsWeb/c_positionDetail.html')">职位详情</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>c</li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>c</li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>c</li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>c</li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
           <li><a href="javascript:void(0)">首页</a></li>
		</ul>
    </div>
    <div class="contents">
    	<div class="tabs easyui-tabs" fit="true" id="tabs">
        	
        </div>
      
        	<!--<iframe width='100%' height='100%'  id='iframe' frameborder='0' scrolling='auto'  src='b.html'></iframe>-->
     
    </div>
    
</div>


<script type="application/javascript">
	var index=0
	function addTab(title,url) {
		var tab=$('#tabs').tabs('exists',title);
		if(tab){
			//存在的话 打开
			$('#tabs').tabs('select',title);
			}else{
			//不存在的话 新建一个
				index++;
				$("#tabs").tabs('add',{
					title:title,
					content:"<iframe width='100%' height='100%'  class='myIframe' frameborder='0' scrolling='auto'  src='"+url+"'></iframe>",
					closable:true
				});
			}
		
	}
$(function(){
	$("#tabs").tabs();
    addTab('index','/JobPostingsWeb/index.html')
		//菜单的点击
		$(".nav-header").toggle(function(){
		$(this).nextUntil('.nav-header').css("display","block");
		$(this).find("i").attr("class","icon-chevron-up");
		/*$(this).parent("li").siblings(".haveSub[class='haveSub active']").attr("class","haveSub"); 
		$(this).parent("li").siblings(".noSub[class='noSub active']").attr("class","noSub");
		$(this).parent("li").attr("class","haveSub active");*/
	},function(){
		$(this).nextUntil('.nav-header').css("display","none");
		$(this).find("i").attr("class","icon-chevron-down");
	});
	});
	
</script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
</body>
</html>
