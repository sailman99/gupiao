<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    This is my JSP page. <br>
    request.getParameter("name")
    <s:set name="name" value="<%="'"+request.getParameter("name")+"'" %>"/>
    <s:if test="#name=='Max'">
    	Max is here
    </s:if>
    <s:elseif test="#name='Scott'">
    	Scott is here
    </s:elseif>
    <s:else>
    	Other is here
    </s:else>
  </body>
</html>
