<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看学生信息</title>
<link href="css/a_dataCalculatingAndOutput.css" rel="stylesheet" media="screen"/>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="css/bootstrap/js/bootstrap.js"></script>
<script src="js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.3/datagrid-detailview.js"></script>
<script type="application/javascript">

$(function () {
	    $('#dg').datagrid({ 
		view: detailview,  
        detailFormatter:function(index,row){ 
		    return '<div class="ddv">'+
						'<div id="basicInfoContent" class="row">'+	
       						'<dl class="dl-horizontal span5">'+
    							'<dt>学号</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.studentId+'"/></dd>'+
            					'<dt>姓名</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.name+'"/></dd>'+
    							'<dt>性别</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.sex+'"/></dd>'+
    							'<dt>出生日期</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.birthday+'"/></dd>'+
    							'<dt>民族</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.nation+'"/></dd>'+
    							'<dt>学历</dt>'+
    							'<dd><input type="text" disabled="disabled" value="'+row.degree+'"/></dd>'+
    						'</dl>'+
    						'<dl class="dl-horizontal span7">'+
            				'<dt>电话号码</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.telephone+'"/></dd>'+
							'<dt>身份证号码</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.idNum+'"/></dd>'+
							'<dt>毕业日期</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.graduationDate+'"/></dd>'+
							'<dt>平均绩点</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.gpa+'"/></dd>'+
							'<dt>班级名称</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.className+'"/></dd>'+
							'<dt>年级</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.grade+'"/></dd>'+
							'<dt>专业</dt>'+
							'<dd><input type="text" disabled="disabled" value="'+row.major+'"/></dd>'+
							'</dl>'+
        				'</div>	'+
//         				'<div id="verfityBtnDiv" class="row">'+
//         					'<dl class="dl-horizontal span5">'+
// 								'<dd><input type="button" id="verfyPassBtn"  name="verfyPassBtn" onclick="javascript:alert("da")" class="btn btn-primary btn-large" value="审核通过" /></dd>'+
//         					'</dl>'+
//         					'<dl class="dl-horizontal span7">'+
//         					'<dd><a href="javascript:void(0)" id="verfyUnPassBtn" name="verfyUnPassBtn" class="btn btn-primary btn-small">审核未通过</a></dd>'+
//     						'</dl>'+
//         				'</div>'
					'</div>';  
        },   
        columns:[[ 
            {field:'studentId',title:'学号',width:100},  
            {field:'name',title:'姓名',width:100},
            {field:'sex',title:'性别',width:100},
			{field:'birthday',title:'出生日期',width:100},  
            {field:'nation',title:'民族',width:100}, 
			{field:'degree',title:'学历',width:100},  
            {field:'telephone',title:'电话号码',width:100},
			{field:'idNum',title:'身份证号码',width:100},  
            {field:'graduationDate',title:'毕业日期',width:100}, 
			{field:'gpa',title:'平均绩点',width:100},  
            {field:'className',title:'班级名称',width:100},
            {field:'grade',title:'年级',width:100},
            {field:'major',title:'专业',width:100}
        ]],
		pagination:true
    });  
});
</script>
</head>
<body style="background:#ECEFF1;">
<div class="myLayout">
   <div id="positionsContent">
 	<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" data-options="href:''"> 
    	<table id="dg"  
     		pageSize="15"
     		pageList="[2,15]"
     		url="initStudentInfo">
        	<tbody>  
    		</tbody>  
       </table> 
    </div>  
    </div>  
</div>
</body>
</html>