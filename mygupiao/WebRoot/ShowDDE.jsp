<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>��ʾĳһ��Ʊ�����DDE���</title>
    
	

  </head>
  
  <body>
    ����ɶ����� <br>
    <s:form action="GupiaoAction!getDdetemp.action" method="post">
	    <s:textfield name="gupiaodaima" label="��Ʊ����"/>
		<s:submit value="�ύ"/>
	</s:form>

    
  </body>
</html>
