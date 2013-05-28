<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册失败！</title>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script type="application/javascript">
$(function(){
		$('#myModal').modal('show');
		var FUNC=[function(){
			$('#myModal').modal('hide');
		},function(){
			location.href="/JobPostingsWeb/c_Register.jsp";
			
		}];
		$('#confirm').queue("fun",FUNC);
		$('#confirm').click(function(){
			$('#confirm').dequeue("fun");
			setInterval(function() {
				$('#confirm').dequeue("fun");
			}, 300);
			
			
			
		});
    
});
</script>
</head>

<body>
<div class="myLayout">

    
    
    
    <div id="myModal" class="modal hide fade" data-backdrop="static">
    	<div class="modal-header">
    		<h5>注册失败</h5>
   		</div>
    	<div class="modal-body">
    		<p>
    			<div  >
					注册出错了！<br />
					请重新再试~
   		
    			</div>
    
    		</p>
    	</div>
    	<div class="modal-footer">
    		<button class="btn btn-primary" id="confirm">重新注册</button>
   		 </div>
    </div>
    

</body>
</html>

