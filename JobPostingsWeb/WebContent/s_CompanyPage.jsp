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
	/*招聘信息分页参数（从第二页开始）*/
	var pageSize1=1;
	var	pageNum1=2;
	var totalOfRecruitment=${pageBean1.allRow};
	/*英才推荐信息分页参数（从第二页开始）
	var pageSize3=10;
	var	pageNum3=2;
	var totalOfRecommendation=${pageBean3.allRow};*/
	//加载招聘信息
	function loadRecruitment(pS,pN){
		$.ajax({
			   type: "POST",
			   url: "bc_c_CompanyPage_loadRecruitments_recruitment.action",
			   dataType:'html',
			   data: {
				   pageSize:pS,
				   pageNum:pN
			   },
			   success: function(data){
				 $('#wantedInfo #more label').show();
				 $('#wantedInfo #more img').hide();   
			     $("#infos").append(data);
			     pageNum1++;
			   },
			   error:function(data){
				    $('#wantedInfo #more label').show();
					$('#wantedInfo #more img').hide();  
				   alert("加载失败，请重试！");
			   }
			});
	}
	//英才推荐滚动
	var Top=0;//定义一个向上移动的距离，这个数值和你图片或DIV的高度相等
	var Bottom=0;
	var Time=500;//定义一个速度
	
	function move(h){
		$("#movecontent").animate({"margin-top":Top,"margin-bottom":Bottom},Time);//animate方法，只能对数值型的值进行渐变
		Top+=-6;
		Bottom+=6;
		if(Top<=-h)//判断当总高度大于你DIV或者图片总高度
		{
			Top=0;//把距离设置回0
			Bottom=0;
			Time=300;//加快移动速度
		}
		else
		{
			Time=400;//否则减慢速度
		}
	} 
    
$(function(){
	$('#comNav li').click(function(event){
		event.preventDefault();
		var hr=$(this).find('a').attr("href");
		var anh=$(hr).offset().top;
		$("html,body").stop().animate({scrollTop:anh-50},500);
	}); 
	$('#wantedInfo #more').click(function(){
		if(pageNum1<=Math.ceil(totalOfRecruitment/pageSize1)){
			$('#wantedInfo #more label').hide();
			$('#wantedInfo #more img').show();
			loadRecruitment(pageSize1,pageNum1);
		}else{
			$('#wantedInfo #more label').html("已经到最后啦");
		}
	});
	 
	/*滚动*/
	var Mheight=$("#movecontent").height();
	var myar=setInterval('move('+Mheight+')', 80);
	
	
    /* $("#friendLink").hover(function() {
    	console.log("hover!");
     	clearInterval(myar); 
     	}, 
     	function() { 
     		myar = setInterval('move()', 80) ;
        }); *///当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始
});
</script>
</head>

<body data-spy="scroll" data-target="#navContent" data-offset="-300">
<div class="myLayout">

	<div id="comBar">
      <span id="headicon"><img src="${enterprise.logo}" class="img-polaroid" style="height:200px"/></span>
      <span id="username"><h2>${enterprise.enterpriseName}  </h2></span>
      <button class="btn btn-info">加关注</button>
      <span id="username"><h2>${enterprise.enterpriseName}  </h2></span>
      <s:if test="isConcerned == true">
      	<button class="btn btn-info">取消关注</button>
      </s:if>
      <s:else>
      	<button class="btn btn-info">加关注</button>
      </s:else>
      
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
    				<dd>：<a href="http://${enterprise.webSite}"></a>${enterprise.webSite}</dd>
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
				<div id="infos">
				  <s:iterator value="recruitments" status="sts">
					<div class="wantedInfocontent well-small">
         				<div class="media">
                			<a href="#" class="pull-left">
    							<img class="media-object img-polaroid" src="${enterprise.logo}" style="" >
               				</a>
    						<div class="media-body">
   								<a href=" javascript:void(0)" onclick="window.parent.addTab('${postingName}','/JobPostingsWeb/enterprise/c_PositionDetail_load?recruitmentId=${recruitmentId }')">
   									<h4 class="media-heading">${postingName}</h4>
   								</a>
                   				<a href="#"><h6 class="media-heading">${enterprise.enterpriseName} </h6></a>
    			  				工作城市：${workingPlace } 每月薪水：${salary } 行业类别：${industry.jobType }
     						</div>
   			 			</div>
        			</div>
				  </s:iterator>
				</div>
				<span class="label label-info" id="more">
					<label>更多</label>
					<img src="/JobPostingsWeb/img/loading.gif" alt="" style="display:none;" />
				</span>
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
         		 <div class="addcommentRow">
			<div class="row">	
       			<div id="comments_user" class="span1">
            		<a href="#">
              			<img src="${student.headImage }" width="50" height="50"  class="img-polaroid"/>
              			<p>${student.name }</p>
             	 	</a>
           		 </div>
           	 	<div id="comments_addcontent" class="span9">
              		 <textarea rows="5" ></textarea>
            	</div> 
       		 </div>
             <div class="buttons row">	
                <input type="button" class="btn btn-primary offset2" value="    提交评论   "/>
             </div>
         </div>
         		
         		
			</div>
   		</div>
   </div>
   <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</div>
</body>
</html>
