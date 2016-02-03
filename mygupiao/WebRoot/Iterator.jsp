<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    This is my JSP page. <br>
    <ol>
    	<s:iterator value="#request.names" status="stuts">
    		<s:if test="#stuts.odd==true">
    			<li>While <s:property/></li>
    		</s:if>
    		<s:else>
    			<li style="background-color:green"><s:property/></li>
    		</s:else>
    	</s:iterator>
    </ol>
  </body>
</html>
