<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="application/javascript">
$(function(){
	total2=${pageBeanTwo.allRow};
});
	
</script>

			 <s:iterator value="pageBeanTwo.list" status="sts">
					<li class="content well-small">
         				<div class="media">
                			<a href="#" class="pull-left">
    							<img class="media-object img-polaroid" src="${logo}" style="" >
               				</a>
    						<div class="media-body">
   								<a href=" javascript:void(0)" >
   									<h4 class="media-heading">${postingName}</h4>
   								</a>
                   				<a href="#"><h6 class="media-heading">${enterpriseName} </h6></a>
    			  				<strong>创建时间</strong>：<fmt:formatDate value="${foundDate}" pattern="yyyy-MM-dd"/> 
            					<strong>企业性质</strong>：${enterpriseProperty}
    							<strong>注册资金</strong>：${registeredFund}
            					<strong>公司地址</strong>：${address}
            					<strong>联系人</strong>：${linkman}
            					<strong>联系人电话</strong>：${phone}
            					<strong>传真</strong>：${fax}
            					<strong>公司网址</strong>：${webSite}
    							<strong>企业法人</strong>：${enterpriseLegalPerson}
    							<strong>企业规模</strong>：${enterpriseScale}
            					<strong>简介</strong>：${brief}
     						</div>
   			 			</div>
        			</li>
				 </s:iterator>