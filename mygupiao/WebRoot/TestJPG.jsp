<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>��ʾĳһ��Ʊ�����JPG���</title>
    
	

  </head>
  
  <body>
    ����ɶ����� <br>
    <s:form action="GupiaoAction!testJPG.action" method="post">
	    <s:textfield name="gupiaodaima" label="��Ʊ����"/>	    
        <s:textfield name="urldate" label="��������ҳ����" />
		<s:submit value="�ύ"/>
	</s:form>

    
  </body>
</html>
