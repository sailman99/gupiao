<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3>JPG图位置 </h3>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">		
				<td class=tt align=center>
					散户
				</td>				
				<td class=tt align=center>
					中户
				</td>			
				<td class=tt align=center>
					大户
				</td>		
				<td class=tt align=center>
					法人
				</td>
				<td class=tt align=center>
					机构
				</td>	
			</tr>
				

				

				<s:iterator value="#request.positionxy" status="stuts">		
				<tr>		
					<td class=tt align=center>
						<s:property value="X11"/>
					</td>
					<td class=tt align=center>
						<s:property value="X12"/>
					</td>
					<td class=tt align=center>
						<s:property value="X13"/>
					</td>					
					<td class=tt align=center>
						<s:property value="X14"/>
					</td>	
					<td class=tt align=center>
						<s:property value="X15"/>
					</td>
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
