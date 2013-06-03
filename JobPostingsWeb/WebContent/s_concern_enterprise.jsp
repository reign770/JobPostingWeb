<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关注企业</title>
<link href="/JobPostingsWeb/css/s_findaJob_result.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="application/javascript">
$(function () {
	    var action='enterprise_getConcernResult.action';
	    var pageNum=1;
		$(".imgInfo").hover(
				 function(){$(this).popover('show');},
				 function(){$(this).popover('hide');});
	    
		$(".concern").live('mouseover mouseout',function(event){
			 if(event.type == 'mouseover'){
			  $(this).text('取消关注');
			  $(this).attr("class","btn btn-warning concern");
			 }
			 else{
			  $(this).text('已关注');
			  $(this).attr("class","btn btn-primary concern");				 
			 }
			
			});
		$(".concern").live('click',function(){
			var item = $(this).parents('.item');
			var id =$(this).parents('.item').attr('id');
			$.post("enterprise_unconcern.action"
					,{enterpriseId:id}
					,function(data){
						console.log(data);
 						if(data.message=="unconcern_success"){
						 	$(item).fadeOut(1000,function(){
							 $('#pagination').pagination('select',pageNum); 
						 });
						} 
					},"json");
		});
		$('#pagination').pagination({
			total:${pageBean.allRow},
			pageSize:${pageBean.pageSize},
			pageList: [9],
			onSelectPage:
			  function(pageNumber,pageSize){
				  pageNum = pageNumber;
				  var url =action+'?pageSize='+pageSize+'&&pageNumber='+pageNumber
		   		  $("#contents").panel('refresh',url);
	   		  }
	    });
			
});
</script>
</head>

<body style="background:#ECEFF1;">
<div class="myLayout">
	<div class="navbar" id="searchingBar">
    	<div  id="searchingBarContent">
    		<a href="#"><h1>我关注的公司</h1></a>
        </div>
       
    </div>
    
	<div id="jobsContent">
 		<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''"> 
            <ul class="thumbnails">
              	  <s:iterator value="pageBean.list" var="ent" status="sts">
	                  <li id="${enterpriseId }" class="span4 item" style="margin-left:45px;">
	                    <div class="thumbnail" >
	                      <img  class="imgInfo" alt="300x200" data-src="holder.js/300x200" 
	                      style="width: 300px; height: 200px;" src="${logo }" 
	                      data-content="${brief }" ref="popover" 
	                      data-original-title="公司简介"
	                      data-placement="bottom">
	                      <div class="caption">
	                          <a href="#"><h3>${enterpriseName }</h3></a>
	                         <h5>企业性质：${enterpriseProperty }</h5>
	                         <h5>公司规模：${enterpriseScale }</h5>
	                         <h5>成立时间：<fmt:formatDate value="${foundDate}" type="date" pattern="yyyy"/>年</h5>
	                         <h5>公司网址：<a href="${webSite }" target="_blank">${webSite }</a></h5>
	                        <p><a class="btn btn-primary concern" href="#">已关注</a> 
	                        <a class="btn btn-danger" href="#">详细信息</a></p>
	                      </div>
	                    </div>
	                  </li>
                </s:iterator>
            </ul>
        </div>  
	    <div id="pagination" class="easyui-pagination" data-options="total:2000,pageSize:10,onSelectPage:function(pageNumber,pageSize){$('#contents').panel('refresh', 'show_content.php?page='+pageNumber);}">  
	    </div>  
    </div>
</div>
</body>
</html>

