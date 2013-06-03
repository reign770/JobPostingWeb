<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script>
	$('#pagination').pagination({
		total:${pageBean.allRow},
	});
	$(".imgInfo").hover(
			 function(){$(this).popover('show');},
			 function(){$(this).popover('hide');});
</script>
 		<div id="contents" class="easyui-panel" style="height:auto; overflow:hidden;background:transparent; border:none;" data-options="href:''"> 
            <ul class="thumbnails">
              	  <s:iterator value="pageBean.list" var="ent" status="sts">
                  <li id="${enterpriseId }" class="span4 item" style="margin-left:45	px;">
                    <div class="thumbnail">
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