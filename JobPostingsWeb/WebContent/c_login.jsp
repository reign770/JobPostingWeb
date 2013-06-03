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
var pageSize=2;
var pageNum1=1;//就业动态的页数
var pageNum2=1;//企业信息库的页数
var pageNum3=1;//英才推荐的页数
var total1=0;//就业动态的总页数
var total2=0;//企业信息库的总页数
var total3=0;//英才推荐的总页数

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
	
	//注册按钮链接
	$('.register').click(function(){
		location.href="/JobPostingsWeb/c_Register.jsp";
	
	})
	
	//新闻点击

	loadContentOne(pageSize,1); //加载就业动态
	loadContentTwo(pageSize,1); //加载企业信息库
	loadContentThree(pageSize,1); //加载英才推荐
	
	$(' #more1').click(function(){
		if(pageNum1<=Math.ceil(total1/pageSize)){
			loadContentOne(pageSize,pageNum1);
		}else{
			$('#more1 label').html("已经到最后啦");
		}
	});
	$(' #more2').click(function(){
		if(pageNum2<=Math.ceil(total2/pageSize)){
			loadContentTwo(pageSize,pageNum2);
		}else{
			$('#more2 label').html("已经到最后啦");
		}
	});
	$(' #more3').click(function(){
		if(pageNum3<=Math.ceil(total3/pageSize)){
		loadContentThree(pageSize,pageNum3);
		}else{
			$('#more3 label').html("已经到最后啦");
		}
	});
	
	
	/*表单ajax提交*/
	$('#loginForm').submit(function(){
		$(this).find(':submit').val("登录中...");
		$(this).find(':submit').attr("disabled","disabled");
		var username=$(this).find("#username").val();
		var password=$(this).find("#password").val();
		
		$.ajax({
			   type: "POST",
			   url: "/JobPostingsWeb/enterprise/json_c_Login_login.action",
			   dataType:'json',
			   data: {
				   account:username,
	               password:password
			   },
			   success: function(data){
					if($.trim(data.loginmessage)=="login_success"){
						location.href="/JobPostingsWeb/c_PersonalPage.jsp"
					}else if($.trim(data.loginmessage)=="noaccount"){
						alert("账户不存在");
						$('#loginForm').find(':submit').val("    登录    ");
						$('#loginForm').find(':submit').removeAttr("disabled");
					}else if($.trim(data.loginmessage)=="wrongpassword"){
						alert("密码错误");
						$('#loginForm').find(':submit').val("    登录    ");
						$('#loginForm').find(':submit').removeAttr("disabled");
					}else if($.trim(data.loginmessage)=="disable"){
						alert("账户失效");
						$('#loginForm').find(':submit').val("    登录    ");
						$('#loginForm').find(':submit').removeAttr("disabled");
					}
			   },
			   error:function(data){
				   $('#loginForm').find(':submit').val("    登录    ");
					$('#loginForm').find(':submit').removeAttr("disabled");
				   alert("失败，请重试！");
			   }
			});
		
		return false;
	});
	
	
	
	
});

function contentOneClick(obj){
	$('#modal #modalLabel').text($(obj).find('.title').text());
	$('#modal .modal-body').html($(obj).find('.hiddenContent').val());
}

function loadContentOne(pS,pN){
	//console.log(Math.ceil(total1/pageSize)+" 1  "+pageNum1);
	$('#more2 label').hide(); 
	 $('#more2 img').show();
	$.ajax({
		   type: "POST",
		   url: "/JobPostingsWeb/enterprise/bc_c_LoginContents_loadContentOne_contentOne.action",
		   dataType:'html',
		   data: {
			   pageSize:pS,
			   pageNum:pN
		   },
		   success: function(data){
			 $('#more1 label').show();
			 $('#more1 img').hide();   
		     $("#jydt ul").append(data);
		     pageNum1++;
		     //console.log(Math.ceil(total1/pageSize)+" 1<  "+pageNum1);
		   },
		   error:function(data){
			  $('#more1 label').show();
			  $('#more1 img').hide();  
			   alert("加载失败，请重试！");
		   }
		});
	
}

function loadContentTwo(pS,pN){
	//console.log(Math.ceil(total2/pageSize)+" 2  "+pageNum2);
	$('#more1 label').hide(); 
	 $('#more1 img').show();
	$.ajax({
		   type: "POST",
		   url: "/JobPostingsWeb/enterprise/bc_c_LoginContents_loadContentTwo_contentTwo.action",
		   dataType:'html',
		   data: {
			   pageSize:pS,
			   pageNum:pN
		   },
		   success: function(data){
			$('#more2 label').show();
			$('#more2 img').hide();     
		     $("#qyxxk ul").append(data);
		     pageNum2++;
		     //console.log(Math.ceil(total2/pageSize)+" 2<  "+pageNum2);
		   },
		   error:function(data){
			   $('#more2 label').show();
				$('#more2 img').hide(); 
			   alert("加载失败，请重试！");
		   }
		});
}

function loadContentThree(pS,pN){
	//console.log(Math.ceil(total3/pageSize)+" 3  "+pageNum3);
	$('#more3 label').hide(); 
	 $('#more3 img').show();
	$.ajax({
		   type: "POST",
		   url: "/JobPostingsWeb/enterprise/bc_c_LoginContents_loadContentThree_contentThree.action",
		   dataType:'html',
		   data: {
			   pageSize:pS,
			   pageNum:pN
		   },
		   success: function(data){
			 $('#more3 label').show();
			 $('#more3 img').hide();    
		     $("#yctj ul").append(data);
		     pageNum3++;
		     //console.log(Math.ceil(total3/pageSize)+" 3<  "+pageNum3);
		   },
		   error:function(data){
			   $('#more3 label').show();
			   $('#more3 img').hide(); 
			   alert("加载失败，请重试！");
		   }
		});
}
 
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
            	<input id="username" type="text" class="text" name="enterprise.enterpriseAccount" placeholder="用户名">
                <input id="password" type="password" class="password" name="enterprise.password" placeholder="密码">
                    
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
                	
                    
                    
                </ul>
                <span class="label label-info" id="more1">
					<label>更多</label>
					<img src="/JobPostingsWeb/img/loading.gif" alt="" style="display:none;" />
				</span>
            </div>
        </div>
        <div id="qyxxk" class="news-contents-content well">
         	<div class="news-contents-title"><h3 style="font-family: 微软雅黑;font-weight: lighter;margin-left:20px;color: #5A5A5A;">企业信息库</h3></div>
            <div class="news-contents-list">  
            	<ul class="unstyled">
                	
                </ul>
                <span class="label label-info" id="more2">
					<label>更多</label>
					<img src="/JobPostingsWeb/img/loading.gif" alt="" style="display:none;" />
				</span>
            </div>
        </div>
        <div id="yctj" class="news-contents-content well">
         	<div class="news-contents-title"><h3 style="font-family: 微软雅黑;font-weight: lighter;margin-left:20px;color: #5A5A5A;">英才推荐</h3></div>
            <div class="news-contents-list">  
            	<ul class="unstyled">
                
                </ul>
                <span class="label label-info" id="more3">
					<label>更多</label>
					<img src="/JobPostingsWeb/img/loading.gif" alt="" style="display:none;" />
				</span>
            </div>
        </div>
      </div>
    	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

	</div>
	<div id="modal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="modalLabel"></h3>
		</div>
		<div class="modal-body">
		
		</div>
		<div class="modal-footer">
		</div>
	</div>


</div>

</body>
</html>
