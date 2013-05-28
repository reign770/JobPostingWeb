<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册成功！</title>
<link href="/JobPostingsWeb/css/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>
<script src="/JobPostingsWeb/js/jquery-1.8.3.min.js"></script>
<script src="/JobPostingsWeb/css/bootstrap/js/bootstrap.js"></script>
<script type="application/javascript">
$(function(){
		$('#myModal').modal('show');
		var FUNC=[function(){
			$('#myModal').modal('hide');
		},function(){
			location.href="/JobPostingsWeb/c_login.jsp";
			
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
    		<h5>注册成功</h5>
   		</div>
    	<div class="modal-body">
    		<p>
    			<div  >
					恭喜您~注册成功了！<br />
					校方工作人员会尽快对您的账户进行审核，并与您联系，届时您可以登录系统开始使用。
   		
    			</div>
    
    		</p>
    	</div>
    	<div class="modal-footer">
    		<button class="btn btn-primary" id="confirm">确认</button>
   		 </div>
    </div>
    

</body>
</html>

