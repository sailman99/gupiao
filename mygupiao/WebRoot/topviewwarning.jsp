<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
   topview���� <br>
     
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					���
				</tD>
				<td class=tt align=center>
					��Ʊ����
				</td>
				<td class=tt align=center>
					��Ʊ����
				</td>
				<td class=tt align=center>
					����
				</td>				
				<td class=tt align=center>
					ɢ����
				</td>
				<td class=tt align=center>
					5�����
				</td>
				<td class=tt align=center>
					ɢ������
				</td>
				<td class=tt align=center>
					�л���
				</td>
				<td class=tt align=center>
					�л�����
				</td>
				<td class=tt align=center>
					����
				</td>
				<td class=tt align=center>
					�󻧱���
				</td>
				<td class=tt align=center>
					������
				</td>
				<td class=tt align=center>
					���󻧱���
				</td>
				<td class=tt align=center>
					����ͼ
				</td>
				<td class=tt align=center>
					��ע
				</td>
				
			</tr>
				

				<% int i; %>

				<s:iterator value="#request.topview_temp" id="temp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!getMbcjgsjs_riqi.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
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
						<s:property value="SANHUSHU"/>
					</td>
					<td class=tt align=center>
						<s:property value="SANHUBILI"/>
					</td>
					<td class=tt align=center>
						<s:property value="ZHONGHUSHU"/>
					</td>
					<td class=tt align=center>
						<s:property value="ZHONGHUBILI"/>
					</td>
					<td class=tt align=center>
						<s:property value="DAHUSHU"/>
					</td>					
					<td class=tt align=center>
						<s:property value="DAHUBILI"/>
					</td>
					<td class=tt align=center>
						<s:property value="QIAODAHUSHU"/>
					</td>					
					<td class=tt align=center>
						<s:property value="QIAODAHUSHUBILI"/>
					</td>
					
					<s:if test="#temp.gupiaodaima<'600000'">
    					<td class=tt align=center>
							<s:url id="url" value="%{'http://image.sinajs.cn/newchart/daily/n/sz'+#temp.gupiaodaima+'.gif'}">																
							</s:url>
							<s:a href="%{url}">����ͼ</s:a>					 	 
						</td>		
    				</s:if>					
    				<s:else>
    					<td class=tt align=center>
							<s:url id="url" value="%{'http://image.sinajs.cn/newchart/daily/n/sh'+#temp.gupiaodaima+'.gif'}">																
							</s:url>
							<s:a href="%{url}">����ͼ</s:a>					 	 
						</td>
    				</s:else>	
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
