<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3>JPGͼλ�� </h3>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">		
				<td class=tt align=center>
					ɢ��
				</td>				
				<td class=tt align=center>
					�л�
				</td>			
				<td class=tt align=center>
					��
				</td>		
				<td class=tt align=center>
					����
				</td>
				<td class=tt align=center>
					����
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
