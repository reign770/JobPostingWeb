<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>发布新闻</title>
    <link href="/JobPostingsWeb/js/editor/bootstrap-combined.css" rel="stylesheet">
    <link href="/JobPostingsWeb/js/editor/bootstrap-responsive.css" rel="stylesheet">
	<link href="/JobPostingsWeb/js/editor/font-awesome.css" rel="stylesheet">
	<script src="/JobPostingsWeb/js/editor/all.js" id="facebook-jssdk"></script>
	<script src="/JobPostingsWeb/js/editor/analytics.js" async=""></script>
	<script src="/JobPostingsWeb/js/editor/jquery_002.js"></script>
		<script src="/JobPostingsWeb/js/editor/jquery.js"></script>
    <script src="/JobPostingsWeb/js/editor/bootstrap.js"></script>
<!--     <script src="./js/editor/prettify.js"></script> -->
		<link href="/JobPostingsWeb/js/editor/index.css" rel="stylesheet">
    <script src="/JobPostingsWeb/js/editor/bootstrap-wysiwyg.js"></script>
    <script>
    
    function loginValidationCallBack(responseText){
    	if(responseText.trim()=='failed'){
    		alert("发布失败!");
    	}else if(responseText.trim()=='successed'){
    		alert("发布成功!");
    		$("#editor").html("");
    	}
     }
    
    	$(function(){
    		$("#cancelBtn").click(function(){
    			$("#editor").html("");
    		});
    		
    		$("#sumbitBtn").click(function(){
    			if($.trim($("#editor").html())==''){
    				alert("新闻不能为空!");	
    			}else if($.trim($("#title").val())==''){
    				alert($("#editor").html());
    			}else{
    				var varnews=$("#editor").html();
    				var vartitle=$("#title").val();
    				$.post("PostNews",{news:varnews,title:vartitle},function(responseText){
    					loginValidationCallBack(responseText);
    				});
    			}
    		});
    	});
    </script>
  </head>
  <body>

<div class="container">
  <div class="hero-unit" >
	<h2 style="margin-top:-40px;">发布就业新闻</h2>
	<br/>
  
   <label for="title" style="display:inline-block" >标题:</label>	<input id="title" name="title" type="text" >
  
	<div id="alerts"></div>
    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
      <div class="btn-group">
        <a data-original-title="Font" class="btn dropdown-toggle" data-toggle="dropdown" title=""><b class="caret"></b>字体</a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontName Serif" style="font-family:'Serif'">Serif</a></li><li><a data-edit="fontName Sans" style="font-family:'Sans'">Sans</a></li><li><a data-edit="fontName Arial" style="font-family:'Arial'">Arial</a></li><li><a data-edit="fontName Arial Black" style="font-family:'Arial Black'">Arial Black</a></li><li><a data-edit="fontName Courier" style="font-family:'Courier'">Courier</a></li><li><a data-edit="fontName Courier New" style="font-family:'Courier New'">Courier New</a></li><li><a data-edit="fontName Comic Sans MS" style="font-family:'Comic Sans MS'">Comic Sans MS</a></li><li><a data-edit="fontName Helvetica" style="font-family:'Helvetica'">Helvetica</a></li><li><a data-edit="fontName Impact" style="font-family:'Impact'">Impact</a></li><li><a data-edit="fontName Lucida Grande" style="font-family:'Lucida Grande'">Lucida Grande</a></li><li><a data-edit="fontName Lucida Sans" style="font-family:'Lucida Sans'">Lucida Sans</a></li><li><a data-edit="fontName Tahoma" style="font-family:'Tahoma'">Tahoma</a></li><li><a data-edit="fontName Times" style="font-family:'Times'">Times</a></li><li><a data-edit="fontName Times New Roman" style="font-family:'Times New Roman'">Times New Roman</a></li><li><a data-edit="fontName Verdana" style="font-family:'Verdana'">Verdana</a></li></ul>
        </div>
      <div class="btn-group">
        <a data-original-title="Font Size" class="btn dropdown-toggle" data-toggle="dropdown" title=""><b class="caret"></b>大小</a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontSize 5"><font size="5">大</font></a></li>
          <li><a data-edit="fontSize 3"><font size="3">正常</font></a></li>
          <li><a data-edit="fontSize 1"><font size="1">小</font></a></li>
          </ul>
      </div>
      <div class="btn-group">
        <a data-original-title="Bold (Ctrl/Cmd+B)" class="btn" data-edit="bold" title="">加粗</i></a>
        <a data-original-title="Italic (Ctrl/Cmd+I)" class="btn" data-edit="italic" title="">倾斜</a>
        <a data-original-title="Strikethrough" class="btn" data-edit="strikethrough" title="">删除线</i></a>
        <a data-original-title="Underline (Ctrl/Cmd+U)" class="btn" data-edit="underline" title="">下划线</a>
      </div>
      <div class="btn-group">
        <a data-original-title="Bullet list" class="btn" data-edit="insertunorderedlist" title="">索引编号</a>
        <a data-original-title="Number list" class="btn" data-edit="insertorderedlist" title="">数字编号</a>
        <a data-original-title="Reduce indent (Shift+Tab)" class="btn" data-edit="outdent" title="">左缩进</a>
        <a data-original-title="Indent (Tab)" class="btn" data-edit="indent" title="">右缩进</a>
      </div>
      <div class="btn-group">
        <a data-original-title="Align Left (Ctrl/Cmd+L)" class="btn btn-info" data-edit="justifyleft" title="">居左</a>
        <a data-original-title="Center (Ctrl/Cmd+E)" class="btn" data-edit="justifycenter" title="">居中</a>
        <a data-original-title="Align Right (Ctrl/Cmd+R)" class="btn" data-edit="justifyright" title="">居右</a>
      </div>
      <div class="btn-group">
		  <a data-original-title="Hyperlink" class="btn dropdown-toggle" data-toggle="dropdown" title="">插入链接</a>
		    <div class="dropdown-menu input-append">
			    <input class="span2" placeholder="URL" data-edit="createLink" type="text">
			    <button class="btn" type="button">Add</button>
        </div>
        <a data-original-title="Remove Hyperlink" class="btn" data-edit="unlink" title="">移除链接</a>

      </div>
      
      <div class="btn-group">
        <a data-original-title="Insert picture (or just drag &amp; drop)" class="btn" title="" id="pictureBtn">插图</a>
        <input style="opacity: 0; position: absolute; top: 0px; left: 0px; width: 41px; height: 30px;" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" type="file">
      </div>
      <div class="btn-group">
        <a data-original-title="Undo (Ctrl/Cmd+Z)" class="btn" data-edit="undo" title="">撤销</a>
        <a data-original-title="Redo (Ctrl/Cmd+Y)" class="btn" data-edit="redo" title="">重做</a>
      </div>
      <input style="display: none;" data-edit="inserttext" id="voiceBtn" x-webkit-speech="" type="text">
    </div>

  
    <div id="editor" name="editor" contenteditable="true">
     
	</div>
	<div style="margin-top:50px;"> 
		<input type="button" id="sumbitBtn" class="btn-large btn-primary" value="提交" style="width:150px; margin-left:200px;"/>
		<input type="button" id="cancelBtn" class="btn-large btn-primary" value="取消" style="width:150px; margin-left:150px;;"/>
	</div>
  </div>
</div>
<script>
  $(function(){
    function initToolbarBootstrapBindings() {
      var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier', 
            'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
            'Times New Roman', 'Verdana'],
            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
      $.each(fonts, function (idx, fontName) {
          fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
      });
      $('a[title]').tooltip({container:'body'});
    	$('.dropdown-menu input').click(function() {return false;})
		    .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
        .keydown('esc', function () {this.value='';$(this).change();});

      $('[data-role=magic-overlay]').each(function () { 
        var overlay = $(this), target = $(overlay.data('target')); 
        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
      });
      if ("onwebkitspeechchange"  in document.createElement("input")) {
        var editorOffset = $('#editor').offset();
        $('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
      } else {
        $('#voiceBtn').hide();
      }
	};
	function showErrorAlert (reason, detail) {
		var msg='';
		if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
		else {
			console.log("error uploading file", reason, detail);
		}
		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
		 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
	};
    initToolbarBootstrapBindings();  
	$('#editor').wysiwyg({ fileUploadError: showErrorAlert} );
    window.prettyPrint && prettyPrint();
  });
</script>
</body></html>