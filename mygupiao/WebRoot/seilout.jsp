<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>�����Ʊ���뼰�������(��Ʊ����)</title>
    
	<h1>��Ʊ����</h1>
	<br>
  </head>
  
  <body>
    ����ɶ����� <br>
    <s:form action="GupiaoAction!seilout.action" method="post">
	    <s:textfield name="gupiaodaima" label="��Ʊ����"/>
	    <s:textfield name="price" label="���"/>	   
		<s:submit value="�ύ"/>
	</s:form>

    
  </body>
</html>
