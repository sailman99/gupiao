<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
  <head>
   
    <title>显示及输入备注情况</title>
    
	

  </head>
  
  <body>
   <h3><s:property value="gupiaodaima"/> <s:property value="gupiaomingcheng"/> 股东数变化详细情况 </h3>
   
    日期（YYYY-MM-DD） <br>
    <s:form action="GupiaoAction!getChichuangxinxi_blank.action" method="post">
	    <s:textfield name="chichuangxinxidate" label="请输入日期"/>
		<s:submit value="提交"/>
	</s:form>

    
  </body>
</html>
