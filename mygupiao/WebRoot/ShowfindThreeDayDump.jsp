<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>显示某一股票测试连续三天下跌情况</title>
    
	

  </head>
  
  <body>
    输入股东代码 <br>
    <s:form action="GupiaoAction!getfindThreeDayDump.action" method="post">
	    <s:textfield name="gupiaodaima" label="股票代码"/>
		<s:submit value="提交"/>
	</s:form>

    
  </body>
</html>
