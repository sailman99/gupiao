<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>输入股票代码及卖出金额(股票买入)</title>
  
	<h1>股票买入</h1>
	<br>
  </head>
  
  <body>
    输入股东代码 <br>
    <s:form action="GupiaoAction!seilin.action" method="post">
	    <s:textfield name="gupiaodaima" label="股票代码"/>
	    <s:textfield name="price" label="金额"/>	   
	    <s:if test="condition==1">
    		<s:param name="condition" value="1"/>
    	</s:if> 
		<s:submit value="提交"/>
	</s:form>

    
  </body>
</html>
