<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>显示某一股票测试股性活跃情况</title>
    
	

  </head>
  
  <body>
    输入股东代码 <br>
    <s:form action="GupiaoAction!getfindGSHY.action" method="post">
	    <s:textfield name="gupiaodaima" label="股票代码"/>
		<s:submit value="提交"/>
	</s:form>

    
  </body>
</html>
