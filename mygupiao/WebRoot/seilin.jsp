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
    <s:form action="GupiaoAction!seilin.action" method="post">
	    <s:textfield name="gupiaodaima" label="��Ʊ����"/>
	    <s:textfield name="price" label="���"/>	   
	    <s:if test="condition==1">
    		<s:param name="condition" value="1"/>
    	</s:if> 
		<s:submit value="�ύ"/>
	</s:form>

    
  </body>
</html>
