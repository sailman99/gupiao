<%@ page language="java"  pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3>���ɶ����仯</h3>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					���
				</tD>
				<td class=tt align=center>
					������
				</td>
				<td class=tt align=center>
					�������
				</td>				
				<td class=tt align=center>
					<s:property value="qigumingcheng"/>
				</td>
				<td class=tt align=center>
					5���
				</td>
				<td class=tt align=center>
					10���
				</td>
				<td class=tt align=center>
					20���
				</td>				
			</tr>
				

				

				<s:iterator value="#request.tianlangbankuaiwarning" id="temp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!getDuiyingwarning.action">
							<s:param name="bankuaidaima"><s:property value="bankuaidaima"/></s:param>								
						</s:url>
						<s:a href="%{url}"><s:property value="bankuaidaima"/></s:a>					 	 
					</td>						
					<td class=tt align=center>
						<s:property value="bankuaimincheng"/>
					</td>					
					<td class=tt align=center>
						<s:property value="sanhubili0"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhubili5"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhubili10"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhubili20"/>
					</td>									
				</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
