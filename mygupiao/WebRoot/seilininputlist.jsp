<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <s:property value="gupiaomingcheng"/> <br>
     
    <table class="tt" width="100%" border="1">
   		 	<tr class="tt" height="25">
				<td class=tt align=center style="background-color:red">
					���
				</tD>
				<td class=tt align=center style="background-color:red">
					ÿ��ȫ��
				</td>
				<td class=tt align=center style="background-color:red">
					����ÿ��
				</td>
				<td class=tt align=center style="background-color:red">
					��������
				</td>
				<td class=tt align=center style="background-color:red">
					���Ի�Ծ
				</td>				
				<td class=tt align=center style="background-color:red">
					�£�
				</td>
				<td class=tt align=center style="background-color:red">
					��
				</td>
				<td class=tt align=center style="background-color:red">
					EXPMA��ͼ
				</td>
				<td class=tt align=center style="background-color:red">
					�ɶ�����
				</td>
				<td class=tt align=center style="background-color:red">
					����ͼ
				</td>
				
				
			</tr>
			<tr class="tt" height="25"  bgcolor="#cfcfcf">
				<td class=tt align=center>
					<s:property value="column_namea"/>
				</tD>
				<td class=tt align=center>
					<s:property value="column_nameb"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namec"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_named"/>
				</td>				
				<td class=tt align=center>
					<s:property value="column_namee"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namef"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_nameg"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_nameh"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namei"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namej"/>
				</td>
				
				
			</tr>
				

				

				<s:iterator value="#request.mbcjgsjs_temp" id="temp" status="stuts">	
				<s:if test="stuts.Even">
					<tr class="tt" height="25" bgcolor="#cfcfcf">				
				</s:if>	
				<s:else>
					<tr class="tt" height="25">	
				</s:else>
    				<s:if test="#temp.cyc==1">
    					<td class=tt align=center style="background-color:red">
							<li>${stuts.index}</li>
						</td>
    				</s:if>
    				<s:else>
    					<td class=tt align=center >
							<li>${stuts.index}</li>
						</td>
    				</s:else>					
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!setseilininput.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>		
							<s:param name="mbcjgs"><s:property value="mbcjgs"/></s:param>	
							<s:param name="mbcjgs5"><s:property value="mbcjgs5"/></s:param>
							<s:param name="mbcjgs10"><s:property value="mbcjgs10"/></s:param>
							<s:param name="mbcjgs30"><s:property value="mbcjgs30"/></s:param>
							<s:param name="mbcjgs120"><s:property value="mbcjgs120"/></s:param>
							<s:param name="cyc"><s:property value="cyc"/></s:param>						
						</s:url>
						<s:a href="%{url}"><s:property value="gupiaodaima"/></s:a>					 	 
					</td>
					<td class=tt align=center>
						<s:property value="gupiaomingcheng"/>
					</td>
					<td class=tt align=center>
						<s:date  name="riqi"  format="yyyy-MM-dd"/>
					</td>
					<td class=tt align=center>
						<s:property value="mbcjgs"/>
					</td>
					<td class=tt align=center>
						<s:property value="mbcjgs5"/>
					</td>
					<td class=tt align=center>
						<s:property value="mbcjgs10"/>
					</td>
					<td class=tt align=center>
						<s:property value="mbcjgs30"/>
					</td>
					<td class=tt align=center>
						<s:property value="mbcjgs120"/>
					</td>
					<td class=tt align=center>
						<s:property value="cyc"/>
					</td>		
				</tr>	
				</s:iterator>	
			
		</table>
      </body>
</html>
