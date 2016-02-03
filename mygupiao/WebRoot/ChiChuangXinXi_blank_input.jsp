<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>显示某一持仓情况所有没有信息的情况</title>
    
	

  </head>
  
  <body>
    日期（YYYY-MM-DD） <br>
    <s:form action="GupiaoAction!getChichuangxinxi_blank.action" method="post">
	    <s:textfield name="chichuangxinxidate" label="请输入日期"/>
		<s:submit value="提交"/>
	</s:form>

    
  </body>
</html>
