<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位详情</title>
<link href="/JobPostingsWeb/css/c_CreatePositionDetail.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/css/datetimepicker.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/JobPostingsWeb/css/bootstrap timepicker/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="/JobPostingsWeb/js/jquery.form.min.js"></script>
<script type="text/javascript">
/*英才推荐分页参数（现在没用分页，以后用的话可以直接用）*/
var pageSize1=10;
var	pageNum1=1;
var totalOfRecommendation;


var chooseNum=0;//邀请的人数
var chooseIDs="";//邀请的学生ID串

function loadRecommendation(pS,pN){
	$.ajax({
		   type: "POST",
		   url: "bc_c_CreatePositionDetail_loadRecommendation_recommendation.action",
		   dataType:'html',
		   data: {
			   pageSize:pS,
			   pageNum:pN,
			   industryId:$('#industries').val()
		   },
		   success: function(data){
			 $('#myModal1 #friendLink #movecontent').append(data);
		     pageNum1++;
		   },
		   error:function(data){
			   alert("推荐加载失败，抱歉！");
		   }
		});
}

function recommendToggleInit(){
	var chooseNum=0;
	$('#myModal1 #friendLink li').unbind("click");
	$('#myModal1 #friendLink li').toggle(function(){
		
		$(this).find(".icon-ok").css("display","block");
		chooseNum=chooseNum+1;
		if(chooseNum<=0){
			$('#invite').attr("disabled","disabled");
		}else{
			$('#invite').removeAttr("disabled");
			$('#invite').attr("enable","enable");
		}
		//console.log(chooseNum+" ");
	},function(){
		$(this).find(".icon-ok").css("display","none");
		chooseNum=chooseNum-1;
		if(chooseNum<=0){
			$('#invite').attr("disabled","disabled");
		}else{
			$('#invite').removeAttr("disabled");
			$('#invite').attr("enable","enable");
		}
		//console.log(chooseNum+" ");
	});
}

function inviteClick(){

	$('#myModal1 #friendLink li').has('.icon-ok:visible').each(function(){
		chooseIDs=chooseIDs+$(this).find("input:hidden").val()+":";
	});
	
	$.ajax({
		   type: "POST",
		   url: "json_c_CreatePositionDetail_doInvitation.action",
		   dataType:'json',
		   data: {
			   chooseIds:chooseIDs,
			   recruitmentId:4
		   },
		   success: function(data){
			 if($.trim(data.msg)=="success"){
				 alert("邀请成功！");
				 location.href="/JobPostingsWeb/c_CreatePositionDetail.jsp";
			 }else{
				 alert("出错啦，抱歉！请重试");
			 }
		   },
		   error:function(data){
			   alert("出错啦，抱歉！请重试");
		   }
		});
}

$(function(){
	//json设置行业类型
	var industries = $("#industries");
	industries.empty();//清空select下拉框
    $.getJSON("/JobPostingsWeb/industry.json", function(json){
    		for(var i=0;i<json.industries.length;i++){
            	$("<option value='" + json.industries[i].industryId + "'>" + json.industries[i].jobType + "</option>").appendTo(industries);//动态添加Option子项
        	}
    	});
	//检验数据
    $("form").submit(function(){
    	var result=false;
    	$("input").each(function(){
    			if($.trim($(this).val())==""){
    				alert("请填写所有信息!");
    				result=false;
    				return false;
    			}else{
    				result=true;
    				return true;
    			}
    		});
    	if(result==true){
    		$(this).ajaxSubmit({
    			dataType:"json",
    			success:function(data){
    				if($.trim(data.msg)=="success"){
    					$('#myModal1').modal('show');
    					loadRecommendation(pageSize1,pageNum1);
    				}else{
    					$('#myModal2').modal('show');
    				}
    			},
    			error:function(){
    				$('#myModal2').modal('show');
    			}
    		}); 
    	}
    	return false;
		
    });
	//timepicker
	$(".form_datetime").datetimepicker({
		minView:'month',
		format: 'yyyy-mm-dd',
		autoclose:"true",
		todayHighlight:true,
		language:"zh-CN"
		});
	
	recommendToggleInit();
    
	$('#invite').click(function(){
		
	});
	$('#NOinvite').click(function(){
		location.href="/JobPostingsWeb/c_CreatePositionDetail.jsp";
	});
	
});
</script>
</head>

<body>
<div class="myLayout">
<form action="/JobPostingsWeb/enterprise/json_c_CreatePositionDetail_insert" method="post">	
	<div class="span10" id="positionInfo">
		<div class="basicInfo">
    		<div class="page-header"><h2>基本信息</h2></div>
			<div id="basicInfoContent" class="row">	
       			<dl class="dl-horizontal span8">
    				<dt>职位名称：</dt>
    				<dd><input type="text" name="recruitment.postingName" /></dd>
    				<dt>工作城市：</dt>
    				<dd><input type="text" name="recruitment.workingPlace" /></dd>
    				<dt>招聘人数：</dt>
    				<dd><input type="text" name="recruitment.recruitmentCount" /></dd>
    				<dt>每月薪水：</dt>
    				<dd><input type="text" name="recruitment.salary" /></dd>
            		<dt>工作经验：</dt>
    				<dd><input type="text" name="recruitment.workExperience" /></dd>
    				<dt>性别要求：</dt>
    				<dd>
    					<select id="sex" name="recruitment.sex">
    						<option value="不限">不限</option>
    						<option value="男">男</option>
    						<option value="女">女</option>
    					</select>
    				</dd>
    				<dt>年龄要求：</dt>
    				<dd><input type="text" name="recruitment.age" /></dd>
    				<dt>外语要求：</dt>
    				<dd><input type="text" name="recruitment.foreignLanguage" /></dd>
    				<dt>学历要求：</dt>
    				<dd><input type="text" name="recruitment.degree" /></dd>
    				<dt>截止日期：</dt>
    				<dd>
    				<div class="input-append date form_datetime">
						<input size="16" type="text"  readonly name="recruitment.deadline">
    					<span class="add-on"><i class="icon-th"></i></span>
					</div>
    				</dd>
    				<dt>所属行业：</dt>
    				<dd><select id="industries" name="recruitment.industry.industryId">
    					 
    					</select>
    				</dd>
    			</dl>
            
        	</div>	
		</div>
        
        
        
    	<div class="additionalInfo">
    		<div class="page-header"><h2>岗位描述</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5" name="recruitment.qualification">无</textarea></p>
       		</div>
       		<div class="page-header"><h2>职责要求</h2></div>
			<div id="additionalInfoContent" class="row">	
       			<p class="offset1"> <textarea rows="5" name="recruitment.responsibilities" >无</textarea></p>
       	 	</div>
		</div>
        
        <div id="buttons" class="row" >
    		<input type="submit" class="btn btn-primary" value="    发 布    "/>
    		<input type="button" class="btn btn-primary offset1" value="    取 消    "/>
    	</div>
    	
    	
    	<div id="myModal1" class="modal hide fade" data-backdrop="static">
    		<div class="modal-header">
    			<h5>创建成功</h5>
   			</div>
    		<div class="modal-body">
    			<p>
    				<div  >
						恭喜您~新的招聘信息创建成功了！<br />
   						<div id="friendLink" class="row-fluid">
   							<div class="page-header"><h4>英才推荐<small>下面是您可能感兴趣的人才，赶快邀请他们来投简历吧~</small></h4></div>
				   			 <ul class="thumbnails" style="overflow: hidden;">
				    			<div id="movecontent">
				    				
    								
					  			</div>
    						</ul>
						</div>	
    				</div>
    			</p>
    		</div>
    		<div class="modal-footer">
    			<button class="btn btn-primary" disabled="disabled" id="invite" type="button" onclick="inviteClick()">邀请</button>
    			<button class="btn btn-primary" id="NOinvite" type="button">不邀请，返回</button>
   			</div>
    	</div>
    	<div id="myModal2" class="modal hide fade" data-backdrop="static">
    		<div class="modal-header">
    			<h5>创建失败</h5>
   			</div>
    		<div class="modal-body">
    			<p>
    				<div  >
						创建出错了！请返回尝试重新提交<br />
    				</div>
    			</p>
    		</div>
    		<div class="modal-footer">
    			<button class="btn btn-primary" id="confirm" type="button" id="NOinvite" onclick="$('#myModal2').modal('hide');">返回</button>
   			</div>
    	</div>
        
        
        
    </div>
    
</form>    
</div>
</body>
</html>
