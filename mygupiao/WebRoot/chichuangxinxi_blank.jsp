<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3><s:property value="chichuangxinxidate"/>�ֲ���Ϣ�հ���ϸ��� </h3>
    
     <s:form action="GupiaoAction!updateChichuangxinxi_blank.action" method="post">
        <s:textfield name="chichuangxinxidate" label="���������ݿ�����"/>
        <s:textfield name="urldate" label="��������ҳ����" />
        <s:textfield name="gupiaodaima" label="��Ʊ����" />
		<s:submit value="�ύ"/>
	</s:form>
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					���
				</td>				
				<td class=tt align=center>
					��Ʊ����
				</td>
				<td class=tt align=center>
					��Ʊ����
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
				

				<s:iterator value="#request.chichuangxinxitemp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:property value="gupiaodaima"/>
					</td>
					<td class=tt align=center>
						<s:property value="gupiaomingcheng"/>
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
