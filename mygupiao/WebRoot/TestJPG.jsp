<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>显示某一股票代码的JPG情况</title>
    
	

  </head>
  
  <body>
    输入股东代码 <br>
    <s:form action="GupiaoAction!testJPG.action" method="post">
	    <s:textfield name="gupiaodaima" label="股票代码"/>	    
        <s:textfield name="urldate" label="请输入网页日期" />
		<s:submit value="提交"/>
	</s:form>

    
  </body>
</html>
