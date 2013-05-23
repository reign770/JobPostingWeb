<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司主页</title>
<link href="css/c_companyPage.css" rel="stylesheet" media="screen"/>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="css/bootstrap/js/bootstrap.js"></script>
<script type="application/javascript">
$(function(){
	$('#comNav li').click(function(event){
		event.preventDefault();
		var hr=$(this).find('a').attr("href");
		var anh=$(hr).offset().top;
		$("html,body").stop().animate({scrollTop:anh-50},500);
	}); 
});
</script>
</head>

<body data-spy="scroll" data-target="#navContent" data-offset="-300">
<div class="myLayout">

	<div id="comBar">
      <span id="headicon"><img src="${enterprise.logo}" class="img-polaroid" style="height:200px"/></span>
      <span id="username"><h2>${enterprise.enterpriseName} </h2></span>
      <button class="btn btn-info">加关注</button>
	</div>
    
    <div id="comNav">
   	 <div id="navContent" data-spy="affix" data-offset-top="300">
            <ul class="nav nav-pills">
   				<li class="span2"><a href="#comIntro">公司简介</a></li>
         		<li class="span2"><a href="#wantedInfo">招聘信息</a></li>
         		<li class="span2"><a href="#forum">讨论区</a></li>   
   			 </ul>
         
     </div>
   </div>
   <div id="comContent" class="well">
   		<div id="left" class="span7">
			<div id="comIntro">navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/></div>
			<div id="wantedInfo">navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/></div>
			<div id="forum">navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/></div>
   		</div>
   		<div id="right" class="span4">
    		<div id="friendLink">navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/></div>
   		</div>
   </div>
   <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</div>
</body>
</html>
