<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司主页</title>
<link href="/JobPostingsWeb/css/c_companyPage.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
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
   				<li class="span2"><a href="#comIntro">公司信息</a></li>
         		<li class="span2"><a href="#wantedInfo">招聘信息</a></li>
         		<li class="span2"><a href="#forum">讨论区</a></li>   
   			 </ul>
         
     </div>
   </div>
   <div id="comContent" class="well">
   		<div id="left" class="span7">
			<div id="comIntro">
				<dl class="dl-horizontal">
    				<dt>创建时间</dt>
    				<dd>：<fmt:formatDate value="${enterprise.foundDate}" pattern="yyyy-MM-dd"/> </dd>
            		<dt>企业性质</dt>
    				<dd>：${enterprise.enterpriseProperty}</dd>
    				<dt>注册资金</dt>
    				<dd>：${enterprise.registeredFund}</dd>
            		<dt>公司地址</dt>
    				<dd>：${enterprise.address}</dd>
            		<dt>联系人</dt>
    				<dd>：${enterprise.linkman}</dd>
            		<dt>联系人电话</dt>
    				<dd>：${enterprise.phone}</dd>
            		<dt>传真</dt>
    				<dd>：${enterprise.fax}</dd>
            		<dt>公司网址</dt>
    				<dd>：${enterprise.webSite}</dd>
    				<dt>企业法人</dt>
    				<dd>：${enterprise.enterpriseLegalPerson}</dd>
    				<dt>企业规模</dt>
    				<dd>：${enterprise.enterpriseScale}</dd>
            		<dt>营业执照编号</dt>
    				<dd>：${enterprise.businessLicenseId}</dd>
            		<dt>简介</dt>
    				<dd>：${enterprise.brief}</dd>
    			</dl>
				
			</div>
			<div id="wantedInfo">
				<s:iterator value="recruitments" status="sts">
					<div class="wantedInfocontent well-small">
         				<div class="media">
                			<a href="#" class="pull-left">
    							<img class="media-object img-polaroid" src="${enterprise.logo}" style="" >
               				</a>
    						<div class="media-body">
   								<a href="c_PositionDetail_load?recruitmentId=${recruitmentId }"><h4 class="media-heading">${postingName}</h4></a>
                   				<a href="#"><h6 class="media-heading">${enterprise.enterpriseName} </h6></a>
    			  				工作城市：${workingPlace } 每月薪水：${salary } 行业类别：${industry.jobType }
     						</div>
   			 			</div>
        			</div>
				</s:iterator>
			</div>
			<div id="forum">
				<s:iterator value="evaluations">
					<div class="commentRow">
						<div class="row">	
       						<div id="comments_user" class="span1">
            					<a href="#">
              						<img src="${student.headImage }" width="50" height="50"  class="img-polaroid"/>
              						<p>${student.name }</p>
             	 				</a>
           				 	</div>
           	 				<div id="comments_content" class="span5">
              					<p>content<br /><fmt:formatDate value="${pubdate}" pattern="yyyy-MM-dd"/></p>
            				</div>
       		 			</div>
        		 	</div>
         	</s:iterator>
         		
			</div>
   		</div>
   		<div id="right" class="span4">
    		<div id="friendLink">navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/>navContent<br/></div>
   		</div>
   </div>
   <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</div>
</body>
</html>
