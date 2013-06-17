<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
        		<span id="headicon"><img src="img/12883156763984.jpg" style="height:32px"/></span>
      			<span id="username"><h6>就业处</h6></span>
            </div>
<!--             <span id="notification" class="badge badge-info">2</span> -->
        </div>
    	<ul class="nav nav-list layer1">
           	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('审核企业信息','../a_verigyEnterprise.jsp')"><i class="icon-chevron-right"></i>审核企业信息</a></li>
          	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('导入学生信息','../a_import.html')"><i class="icon-chevron-right"></i>导入学生信息</a></li>
           	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('查看学生信息','../a_queryStudent.jsp')"><i class="icon-chevron-right"></i>查看学生信息</a></li>
           	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('修改学生信息','../a_modifyStudent.jsp')"><i class="icon-chevron-right"></i>修改学生信息</a></li>
           	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('发布就业新闻','../a_postNews.jsp')"><i class="icon-chevron-right"></i>发布就业新闻</a></li>
          	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('统计数据','../a_dataCalculatingAndOutput.jsp')"><i class="icon-chevron-right"></i>统计数据</a></li>
          	<li class="ohno"><a href="javascript:void(0)" onclick="addTab('修改密码','../a_modifyPasswd.html')"><i class="icon-chevron-right"></i>修改密码</a></li>
		</ul>
    </div>
    <div class="contents">
    	<div class="tabs easyui-tabs" fit="true" id="tabs">
        </div>
    </div>
</div>

<script type="application/javascript">
	var index=0
	function addTab(title,url) {
		var tab=$('#tabs').tabs('exists',title);
		if(tab){
			
			$('#tabs').tabs('select',title);
			}else{
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
    addTab('首页','index.html')
		$(".nav-header").toggle(function(){
		$(this).nextUntil('.nav-header').css("display","block");
		$(this).find("i").attr("class","icon-chevron-up");
	},function(){
		$(this).nextUntil('.nav-header').css("display","none");
		$('.ohno').css("display","block");
		$(this).find("i").attr("class","icon-chevron-down");
	});
	});
	
</script>
<script src="css/bootstrap/js/bootstrap.js"></script>
</body>
</html>
