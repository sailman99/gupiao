<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>显示某一股票代码的每笔成交股数均线情况</title>
    
	

  </head>
  
  <body>
    输入股东代码 <br>
    <s:form action="GupiaoAction!getMbcjgsjs_riqi.action" method="post">
	    <s:textfield name="gupiaodaima" label="股票代码"/>
		<s:submit value="提交"/>
	</s:form>

    
  </body>
</html>
