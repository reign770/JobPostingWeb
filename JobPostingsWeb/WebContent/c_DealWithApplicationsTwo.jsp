<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>处理申请</title>
<link href="/JobPostingsWeb/css/c_dealWithApplicationsTwo.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" rel="stylesheet" media="screen"/>
<link href="/JobPostingsWeb/js/jquery-easyui-1.3.3/themes/icon.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script src="/JobPostingsWeb/js/jquery-easyui-1.3.3/datagrid-detailview.js"></script>
<script type="application/javascript">
var selections=[];
$(function () {
		//更改状态按钮失效
	    $('#btn-change').menubutton('disable');
		//表格
	    $('#dg').datagrid({ 
		view: detailview,  
        detailFormatter:function(index,row){ 
		    return "<iframe width='100%' height='500px'  class='myIframe' frameborder='0' scrolling='auto'  src='/JobPostingsWeb/student/studentInfo_showStudentInfo.action?studentId="+row.studentId+"'></iframe>";
			 
        },  
		toolbar:'#tb',
		remoteSort:false,
		rownumbers:true,
        columns:[[ 
			/*{field:'rowindex',order:'asc'},*/
			{field:'choose',title:'Choose',width:100,checkbox:true},
			{field:'applyId',title:"申请ID"},
			{field:'applyDate',title:'申请时间',sortable:'true',order:'desc'},
			{field:'postingName',title:'申请职位'},
			{field:'state',title:'申请状态'},
			{field:'name',title:'姓名'},
			{field:'studentId',title:'学号'},
	        {field:'sex',title:'性别'},
	        {field:'major',title:'专业'},
	        {field:'grade',title:'年级'},
	        {field:'class',title:'班级'},
			{field:'birth',title:'出生年月'},  
	        {field:'nation',title:'民族'}, 
			{field:'eduBackground',title:'学历'},  
	        {field:'gpa',title:'GPA',sortable:'true',order:'desc',width:100}, 
	        {field:'content',title:'content',width:200}
			
        ]],
		pagination:true,
		url:'/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_load.action',
		queryParams: {
			recruitmentId:'${recruitmentId }'
		},
		pageList:[1,2,10,30],
		onSelect:function(rowIndex, rowData){
			$('#btn-change').menubutton('enable');
		},
		onUnselect:function(rowIndex, rowData){
			var array=$(this).datagrid('getSelections');
			console.log(array);
			if(array.length==0){
			 	$('#btn-change').menubutton('disable');
			}	
		},
		onLoadSuccess:function(data){ 
			
		}
		
    });
	  
		/*查看范围*/
	    $('#all').click(function(){
	    	
	    	$('#dg').datagrid({url:'/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_load.action'});
	    	
	    });
	    $('#processing').click(function(){
	    	
	    	$('#dg').datagrid({url:'/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_loadProcessing.action'});
	    	
	    });
	    $('#resumepass').click(function(){
	    	
	    	$('#dg').datagrid({url:'/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_loadResumepass.action'});
	    	
	    });
	    $('#writepass').click(function(){
	    	
	    	$('#dg').datagrid({url:'/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_loadWritepass.action'});
	    	
	    });
	    $('#interviewpass').click(function(){
	    	
	    	$('#dg').datagrid({url:'/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_loadInterviewpass.action'});
	    	
	    });
	    $('#signed').click(function(){
	    	
	    	$('#dg').datagrid({url:'/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_loadSigned.action'});
	    	
	    });
	    /*更改状态*/
	    $('#toRejected').click(function(){
			var array=$("#dg").datagrid('getSelections');
	    	var selections="";
	    	var studentIds="";
	    	var i=0
	    	for(i;i<array.length;i++){
	    		
	    			selections=selections+array[i].applyId+":";
	    			studentIds=studentIds+array[i].studentId+":";
	    	
	    	}
			$.ajax({
				   type: "POST",
				   url: "/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_changeToRejected",
				   dataType:'json',
				   data: {
					   selections:selections,
					   studentIds:studentIds,
					   enterpriseId:${user.enterpriseId}
				   },
				   success: function(data){
				     alert( data.msg );
				     $("#dg").datagrid('reload');
				   }
				});
			
	    });
		$('#toResumepass').click(function(){
			var array=$("#dg").datagrid('getSelections');
	    	var selections="";
	    	var studentIds="";
	    	var i=0
	    	for(i;i<array.length;i++){
	    		
	    			selections=selections+array[i].applyId+":";
	    			studentIds=studentIds+array[i].studentId+":";
	    	
	    	}
			$.ajax({
				   type: "POST",
				   url: "/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_changeToResumepass",
				   dataType:'json',
				   data: {
					   selections:selections,
					   studentIds:studentIds,
					   enterpriseId:${user.enterpriseId}
				   },
				   success: function(data){
				     alert( data.msg );
				     $("#dg").datagrid('reload');
				   }
				});
			
	    });
	    $('#toWritepass').click(function(){
	    	
	    	var array=$("#dg").datagrid('getSelections');
	    	var selections="";
	    	var i=0
	    	for(i;i<array.length;i++){
	    		
	    			selections=selections+array[i].applyId+":";
	    	
	    	}
			$.ajax({
				   type: "POST",
				   url: "/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_changeToWritepass",
				   dataType:'json',
				   data: {
					   selections:selections,
				   },
				   success: function(data){
				     alert( data.msg );
				     $("#dg").datagrid('reload');
				   }
				});
			
	    	
	    });
	    $('#toInterviewpass').click(function(){
	    	
	    	var array=$("#dg").datagrid('getSelections');
	    	var selections="";
	    	var i=0
	    	for(i;i<array.length;i++){
	    		
	    			selections=selections+array[i].applyId+":";
	    	
	    	}
			$.ajax({
				   type: "POST",
				   url: "/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_changeToInterviewpass",
				   dataType:'json',
				   data: {
					   selections:selections,
				   },
				   success: function(data){
				     alert( data.msg );
				     $("#dg").datagrid('reload');
				   }
				});
			
	    	
	    });
	    $('#toSigned').click(function(){
	    	
	    	var array=$("#dg").datagrid('getSelections');
	    	var selections="";
	    	var i=0
	    	for(i;i<array.length;i++){
	    		
	    			selections=selections+array[i].applyId+":";
	    	
	    	}
			$.ajax({
				   type: "POST",
				   url: "/JobPostingsWeb/enterprise/json_c_DealWithApplicationsTwo_changeToSigned",
				   dataType:'json',
				   data: {
					   selections:selections,
				   },
				   success: function(data){
				     alert( data.msg );
				     $("#dg").datagrid('reload');
				   }
				});
			
	    	
	    });  
});
</script>
</head>

<body style="background:#ECEFF1;">
<div class="myLayout">
	
    
   <div id="positionsContent">
   
  
 	<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden; background:transparent; border:none;" > 
    	<table id="dg">
        	<tbody></tbody>  
        </table>
        <div id="tb">
        	<table>
        		<tr>
        			<td><a href="/JobPostingsWeb/enterprise/c_DealWithApplicationsOne_load.action" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'">返回选择职位</a> </td>
					<td><span class="datagrid-btn-separator "></span></td>
					<td><a href="#" class="easyui-linkbutton" id="all" data-options="toggle:true,group:'g1',plain:true,selected:true">所有</a></td>
   					<td><a href="#" class="easyui-linkbutton" id="processing" data-options="toggle:true,group:'g1',plain:true">未处理</a> </td>
        			<td><a href="#" class="easyui-linkbutton" id="resumepass" data-options="toggle:true,group:'g1',plain:true">简历筛选通过</a></td> 
       	 			<td><a href="#" class="easyui-linkbutton" id="writepass" data-options="toggle:true,group:'g1',plain:true">笔试通过</a></td> 
        			<td><a href="#" class="easyui-linkbutton" id="interviewpass" data-options="toggle:true,group:'g1',plain:true">面试通过</a></td> 
        			<td><a href="#" class="easyui-linkbutton" id="signed" data-options="toggle:true,group:'g1',plain:true">已签约</a> </td>
   					<td><span class="datagrid-btn-separator "></span></td>
   					<td><a id="btn-change" href="#" class="easyui-menubutton" data-options="menu:'#submenu',iconCls:'icon-edit'">接受/拒绝</a></td>  
       				<div id="submenu" style="width:150px;"> 
       					<div id="toRejected">拒绝</div> 
       					<div class="menu-sep"></div>  
        				<div id="toResumepass">简历筛选通过 </div>  
        				<div id="toWritepass">笔试通过</div>  
        				<div id="toInterviewpass">面试通过 </div>  
        				<div id="toSigned">已签约</div>  
    				</div>  
   				</tr>
        	</table>
		</div> 
        
    </div>  
    </div>  


</div>
</body>
</html>
