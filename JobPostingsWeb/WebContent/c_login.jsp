<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="/JobPostingsWeb/css/login.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
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
});
 
</script>
</head>

<body data-target="#news-nav" data-spy="scroll" data-offset="-1270">
<div class="myLayout">
	<div id="main">
		<div id="loginPanel">
        	<div class="btn-group roleChooser" data-toggle="buttons-radio">
    			<button class="btn active">学生</button>
    			<button class="btn">学校</button>
   				<button class="btn">企业</button>
   			</div>
        	<form id="loginForm" action="/JobPostingsWeb/enterprise/c_login.action" method="post">
            	<input type="text" class="text" name="enterprise.enterpriseAccount" placeholder="用户名">
                <input type="password" class="password" name="enterprise.password" placeholder="密码">
                    
                 <div class="formAction">
                <input type="submit"  value="    登录    " class="btn login">
                <input type="button" value="    注册    " class="btn register">
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
                	<img alt="" src="/JobPostingsWeb/img/footer.jpg">
                </div>
    			<div class="item"><img alt="" src="/JobPostingsWeb/img/footer.jpg"></div>
    			<div class="item"><img alt="" src="/JobPostingsWeb/img/footer.jpg"></div>
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
