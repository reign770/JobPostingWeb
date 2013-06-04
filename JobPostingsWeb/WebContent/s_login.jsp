<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="css/login.css" rel="stylesheet" media="screen"/>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="css/bootstrap/js/bootstrap.js"></script>
<script type="application/javascript">
$(function(){
	//轮播配合新闻导航置顶
	/*$(window).scroll(function(){
		if($(window).scrollTop()>=639){
			$("#news .news_picCarousel").css("margin-top","30px");
		}
		else{
			$("#news .news_picCarousel").css("margin-top","0px");
		}
	
	 }); */
	//$('#news #news-nav').attr("data-offset-top","640px");
	//$('#news #news-nav').affix();
	//$('#news #news-content').scrollspy();
	var validateAction = "student/login_validateInfo.action";
	var postAction = "";
	 $('#news-nav li').click(function(event){
		event.preventDefault();
		value=$(this).find('a').text();
		var hr=$(this).find('a').attr("href");
		var anh=$(hr).offset().top;
		$("html,body").stop().animate({scrollTop:anh-50},500);
	}); 
	 $('#seeNews').click(function(event){
		$("html,body").stop().animate({scrollTop:640},500);
	}); 
	//轮播
	$('.carousel').carousel({
       interval: 2000
    });
	$("#alert").hide();
	//切换
	$('#student').click(function(){
		validateAction = 'student/login_validateInfo.action';
		action = 'student/login_execute.action';
		$('#loginForm').attr("action",action);
	});
	$('#enterprise').click(function(){
		validateAction = 'enterprise/login_validateInfo.action';
		action = 'student/login_execute.action';
		$('#loginForm').attr("action",action);
	});
	$('#admin').click(function(){
		validateAction = 'admin/login_validateInfo.action';
		action = 'admin/login_execute.action';
		$('#loginForm').attr("action",action);
	});
	//登录
	$("#btnlogin").click(function(event){
		if($("#account").val().trim() == ""){
			$("#msg").text("账户不能为空!");
			$("#alert").show();
		}
		else if($("#password").val().trim() == ""){
			$("#msg").text("密码不能为空!");
			$("#alert").show();
		}else {
			$.post(validateAction,
				{account:$("#account").val(), password:$("#password").val()},
				function(dataObj){ 
				if(dataObj.loginmessage == 'noaccount'){
					 $("#msg").text("该用户名不存在!");
					 $("#alert").show();
				}
				else if(dataObj.loginmessage =="wrongpassword"){
					 $("#msg").text("密码错误!");
					 $("#alert").show();					
				}
				else if(dataObj.loginmessage =="disable") {
					$("#msg").text("该账号已经停用!")
				}
				else{
					$("#msg").text("恭喜你登录成功!");
					$("#alert").show();
					$("#loginForm").submit();
				}
			});
		}
	});
});
 
</script>
</head>

<body data-target="#news-nav" data-spy="scroll" data-offset="-1270">
<div class="myLayout">
	<div id="main">
		<div id="loginPanel">
        	<div class="btn-group roleChooser" data-toggle="buttons-radio">
    			<button id="student"class="btn active">学生</button>
    			<button id="admin" class="btn">学校</button>
   				<button id="enterprise" class="btn">企业</button>
   			</div>
        	<form id="loginForm" action="student/login_execute.action" method="post">
            	<input id="account" type="text" class="text"  name="account" placeholder="用户名"/>
                <input id="password" type="password" class="password" name="password" placeholder="密码"/>
                <div id="alert" class="alert alert alert-error">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>登录错误!</strong><div id="msg"></div>
			    </div>
                <div class="formAction">
                <input type="button" id="btnlogin" value="    登录    " class="btn login"/>
                <input type="button" value="    注册    " class="btn register"/>
                </div>
            </form>
        </div>
        <a herf="#" id="seeNews"><h5>查看就业新闻</h5></a>
	</div>
   
	<div id="news" class="row">
      <div id="news-nav"  data-spy="affix" data-offset-top="639">
            <ul class="nav nav-pills">
   				<li class="span2"><a href="#jydt">就业动态</a></li>
         		<li class="span2"><a href="#qyxxk">企业信息库</a></li>
         		<li class="span2"><a href="#yctj">英才推荐</a></li>   
   			 </ul>
         
      </div>
      <div class="news_picCarousel">
        <div id="myCarousel" class="carousel slide">
   			 <ol class="carousel-indicators">
   			 	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    			<li data-target="#myCarousel" data-slide-to="1"></li>
    			<li data-target="#myCarousel" data-slide-to="2"></li>
   			 </ol>
    		<!-- Carousel items -->
   			 <div class="carousel-inner">
    			<div class="active item">
                	<img alt="" src="img/footer.jpg">
                </div>
    			<div class="item"><img alt="" src="img/footer.jpg"></div>
    			<div class="item"><img alt="" src="img/footer.jpg"></div>
    		</div>
   			 <!-- Carousel nav -->
   		 	 <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			 <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
     </div> 
     
      <div id="news-contents" class="span10 offset2" >
         <div id="jydt" class="news-contents-content well">
         	<div class="news-contents-title"><h3 style="font-family: 微软雅黑;font-weight: lighter;margin-left:20px;color: #5A5A5A;">就业动态</h3></div>
            <div class="news-contents-list">  
            	<ul class="unstyled">
                	<li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-18</span>
                         </a>
                    </li>
                    <li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-38</span>
                         </a>
                    </li><li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-48</span>
                         </a>
                    </li><li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-58</span>
                         </a>
                    </li>
                </ul>
            </div>
        </div>
        <div id="qyxxk" class="news-contents-content well">
         	<div class="news-contents-title"><h3 style="font-family: 微软雅黑;font-weight: lighter;margin-left:20px;color: #5A5A5A;">企业信息库</h3></div>
            <div class="news-contents-list">  
            	<ul class="unstyled">
                	<li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-18</span>
                         </a>
                    </li>
                    <li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-38</span>
                         </a>
                    </li><li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-48</span>
                         </a>
                    </li><li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-58</span>
                         </a>
                    </li>
                </ul>
            </div>
        </div>
        <div id="yctj" class="news-contents-content well">
         	<div class="news-contents-title"><h3 style="font-family: 微软雅黑;font-weight: lighter;margin-left:20px;color: #5A5A5A;">英才推荐</h3></div>
            <div class="news-contents-list">  
            	<ul class="unstyled">
                	<li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-18</span>
                         </a>
                    </li>
                    <li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-38</span>
                         </a>
                    </li><li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-48</span>
                         </a>
                    </li><li>
                    	<a href="#">
                        	<span class="news-contents-list-title">大大大大大大大大大大大大</span>
                            <span class="news-contents-list-time">5-58</span>
                         </a>
                    </li>
                </ul>
            </div>
        </div>
      </div>
    	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

	</div>
</div>

</body>
</html>
