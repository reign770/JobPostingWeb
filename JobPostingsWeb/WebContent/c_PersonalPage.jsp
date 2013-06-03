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
        		<span id="headicon"><img src="${user.logo}" style="height:32px"/></span>
      			<span id="username"><h6>${user.enterpriseName}</h6></span>
            </div>
            <span id="notification" class="badge badge-info">2</span>
        </div>
    	<ul class="nav nav-list layer1">
           
         	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('公司首页','/JobPostingsWeb/enterprise/c_CompanyPage_load.action')"><i class="icon-chevron-right"></i>公司主页</a></li>
           	<div class="divider ohno"></div>
           	<li class="nav-header"><i class="icon-chevron-down"></i>账户管理</li>
           		<li><a href="javascript:void(0)" onclick="addTab('修改密码','/JobPostingsWeb/enterprise/c_ModifyInfos_load.action')">修改密码</a></li>
          		<li><a href="javascript:void(0)" onclick="addTab('修改企业信息','/JobPostingsWeb/enterprise/c_ModifyInfos_load.action')">修改企业信息</a></li>
           	<div class="divider ohno"></div>
           	<li class="nav-header"><i class="icon-chevron-down"></i>招聘管理</li>
           		<li><a href="javascript:void(0)" onclick="addTab('发布招聘信息','/JobPostingsWeb/enterprise/c_CreatePositionDetail_load.action')">发布招聘信息</a></li>
           		<li><a href="javascript:void(0)" onclick="addTab('处理招聘信息','/JobPostingsWeb/enterprise/c_DealWithApplicationsOne_load.action')">处理招聘</a></li>
           		<li><a href="javascript:void(0)" onclick="addTab('管理招聘信息','/JobPostingsWeb/enterprise/c_ArrangePositions_load.action')">管理招聘信息</a></li>
           	<div class="divider ohno"></div>
           	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('人才库','/JobPostingsWeb/c_FindStudents.jsp')"><i class="icon-chevron-right"></i>人才库</a></li>
          
          
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
	function closeTab(title) {
		$('#tabs').tabs('close',title);
	}
	function addTab(title,url) {
		var tab=$('#tabs').tabs('exists',title);
		if(tab){
			//存在的话 打开
			alert("窗口已经被打开！")
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
		$('.ohno').css("display","block");
		$(this).find("i").attr("class","icon-chevron-down");
	});
	});
	
</script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
</body>
</html>
