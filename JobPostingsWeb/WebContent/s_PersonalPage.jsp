<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh">
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
<script>
  $(function(){

	});
</script>
</head>
<body>
<div class="myLayout">
    <div class="navs">
        <div id="barPart">
            <div>
        		<span id="headicon"><img src="/JobPostingsWeb/img/12883156763984.jpg" style="height:32px"/></span>
      			<span id="username"><h5>easyOffer</h5></span>
            </div>
            <span id="notification" class="badge badge-info">${unreadedNumber}</span>
        </div>
    	<ul class="nav nav-list layer1">
           <li class="nav-header"><i class="icon-chevron-down"></i>个人信息</li>
           	<li><a href="#" onclick="addTab('我的简历','studentInfo_showStudentInfo?studentId=${account}')">我的简历</a></li>
           	<li><a href="#" onclick="addTab('修改密码','../s_editPassword.jsp')">修改密码</a></li>
          	<li><a href="#" onclick="addTab('简历修改','studentInfo_showBrief.action')">简历修改</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>校园招聘</li>
           	<li><a href="#" onclick="addTab('找工作','recruitment_execute.action')">找工作</a></li>
           	<li><a href="#" onclick="addTab('我关注的招聘','recruitment_concern.action?pageNumber=1&pageSize=10')">我关注的招聘</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>消息中心</li>
           	<li><a href="#" onclick="addTab('消息通知','notification_execute.action?pageNumber=1&pageSize=10')">消息通知</a></li>
           	<li><a href="#" onclick="addTab('职位邀请','invitation_execute.action?pageNumber=1&pageSize=10')">职位邀请</a></li>
           	<li><a href="#" onclick="addTab('投递反馈','feedback_execute.action?pageNumber=1&pageSize=10')">投递反馈</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>学校动态</li>
           	<li><a href="#" onclick="addTab('就业新闻','s_newsOfStudents.html')">就业新闻</a></li>
           <li class="nav-header"><i class="icon-chevron-down"></i>企业</li>
            <li><a href="#" onclick="addTab('我关注的企业','enterprise_concernEnterpriseHome.action?pageNumber=1&pageSize=9')">我关注的企业</a></li>
            <li><a href="#" onclick="addTab('查找企业','enterprise_findEnterpriseHome.action?pageNumber=1&pageSize=10')">查找企业</a></li>
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
    addTab('index','../index.html')
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
	
	function closeTab(title){
		$("#tabs").tabs('close',title);
	};
</script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
</body>
</html>