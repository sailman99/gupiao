<%@ page language="java"  pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    ÿ�ʳɽ������������� <br>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					���
				</tD>				
				<td class=tt align=center>
					����
				</td>				
				<td class=tt align=center>
					����
				</td>
				<td class=tt align=center>
					5�����
				</td>
				<td class=tt align=center>
					10�����
				</td>
				<td class=tt align=center>
					30�����
				</td>
				<td class=tt align=center>
					120�����
				</td>
				<td class=tt align=center>
					�ɶ���
				</td>
				<td class=tt align=center>
					����ͼ
				</td>
				<td class=tt align=center>
					��ע
				</td>
			</tr>
				
				

				<s:iterator value="#request.mbcjgsjs_riqi" id="temp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
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
						<s:url id="url" value="GupiaoAction!getGudongshu.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}">�ɶ������</s:a>					 	 
					</td>	
					<td class=tt align=center>
						<s:url id="url" value="%{'http://image.sinajs.cn/newchart/daily/n/sh'+#temp.gupiaodaima+'.gif'}">																
						</s:url>
						<s:a href="%{url}">����ͼ</s:a>					 	 
					</td>					
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}">��ע</s:a>					 	 
					</td>						
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
