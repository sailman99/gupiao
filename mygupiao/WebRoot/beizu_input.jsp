<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>��ʾ�����뱸ע���</title>
    
	

  </head>
  
  <body>
   <h3><s:property value="gupiaodaima"/> <s:property value="gupiaomingcheng"/> �ɶ����仯��ϸ��� </h3>
   
    ���ڣ�YYYY-MM-DD�� <br>
    <s:form action="GupiaoAction!getChichuangxinxi_blank.action" method="post">
	    <s:textfield name="chichuangxinxidate" label="����������"/>
		<s:submit value="�ύ"/>
	</s:form>

    
  </body>
</html>
