<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>��ʾĳһ�ֲ��������û����Ϣ�����</title>
    
	

  </head>
  
  <body>
    ���ڣ�YYYY-MM-DD�� <br>
    <s:form action="GupiaoAction!getChichuangxinxi_blank.action" method="post">
	    <s:textfield name="chichuangxinxidate" label="����������"/>
		<s:submit value="�ύ"/>
	</s:form>

    
  </body>
</html>
