<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3><s:property value="gupiaodaima"/> <s:property value="gupiaomingcheng"/> �ɶ����仯��ϸ��� </h3>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					���
				</td>				
				<td class=tt align=center>
					����
				</td>				
				<td class=tt align=center>
					ɢ���ֹɱ���
				</td>				
				<td class=tt align=center>
					�л��ֹɱ���
				</td>			
				<td class=tt align=center>
					�󻧳ֹɱ���
				</td>		
				<td class=tt align=center>
					���˳ֹɱ���
				</td>
				<td class=tt align=center>
					�����ֹɱ���
				</td>	
			</tr>
				

				

				<s:iterator value="#request.CcxxTemp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:date  name="riqi"  format="yyyy-MM-dd"/>
					</td>					
					<td class=tt align=center>
						<s:property value="sanhu"/>
					</td>
					<td class=tt align=center>
						<s:property value="zhonghu"/>
					</td>
					<td class=tt align=center>
						<s:property value="dahu"/>
					</td>					
					<td class=tt align=center>
						<s:property value="faren"/>
					</td>	
					<td class=tt align=center>
						<s:property value="jigou"/>
					</td>
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
