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
					ɢ������
				</td>
				<td class=tt align=center>
					ɢ���ֹɱ���
				</td>
				<td class=tt align=center>
					�л�����
				</td>
				<td class=tt align=center>
					�л��ֹɱ���
				</td>
				<td class=tt align=center>
					������
				</td>
				<td class=tt align=center>
					�󻧳ֹɱ���
				</td>
				<td class=tt align=center>
					��������
				</td>
				<td class=tt align=center>
					���˳ֹɱ���
				</td>
				<td class=tt align=center>
					�����ֹɱ���
				</td>
				
			</tr>
				

				<% int i; %>

				<s:iterator value="#request.gudongshutemp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:date  name="riqi"  format="yyyy-MM-dd"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhubili"/>
					</td>
					<td class=tt align=center>
						<s:property value="zhonghushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="zhonghubili"/>
					</td>
					<td class=tt align=center>
						<s:property value="dahushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="dahubili"/>
					</td>					
					<td class=tt align=center>
						<s:property value="qiaodahushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="farenbili"/>
					</td>	
					<td class=tt align=center>
						<s:property value="jigoubili"/>
					</td>
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
