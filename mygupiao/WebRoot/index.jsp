<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  
  <head>
    <h3>��Ʊ</h3>
  </head>
  <br>
  <body>
   
	
	
	
	
	
	<s:url id="url" value="GupiaoAction!testjson.action">
	    <s:param name="gupiaodaima" value="000001"/>																						
	</s:url>
	<s:a href="%{url}">TEST</s:a><br>
	

	<br>
	
	
	<s:url id="url" value="/ShowGudongshu.jsp">																						
	</s:url>
	<s:a href="%{url}">����������ɶ������</s:a>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<s:url id="url" value="/ShowGudongshu.jsp">																						
	</s:url>
	<s:a href="%{url}">�ɶ������</s:a>	<br>	
	<s:url id="url" value="/ShowChichuangxinxi.jsp">																						
	</s:url>
	<s:a href="%{url}">�ɶ������(chichuangxinxi)</s:a>	<br>	
	<s:url id="url" value="/ShowSuperview.jsp">																						
	</s:url>
	
		<br>	
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="web2">
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/Showmbcjgsjs.jsp">																						
				</s:url>
				<s:a href="%{url}">ÿ�ʳɽ���������mbcjgsjs����ȫ������</s:a>
			</td>				
				
			
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getMbcjgsjs_temp.action">		   																				
				</s:url>
				<s:a href="%{url}">ÿ�ʳɽ�����Ԥ��������1.2���ҵ���۸�Ϊ�����¸ߣ�ÿ�죩</s:a>	<br>
			</td>			
		</tr>
		<tr>
			<td height="1" colspan="6" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/Showtestmbcjgsjsbl.jsp">		   																				
				</s:url>
				<s:a href="%{url}">����ÿ�ʳɽ���������</s:a>	<br>
			</td>	
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getThreeDayDump.action">		   																				
				</s:url>
				<s:a href="%{url}">���������µ�Ԥ����ÿ�죩</s:a>
			</td>	
		</tr>				
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/ShowfindThreeDayDump.jsp">		   																				
				</s:url>
				<s:a href="%{url}">�������������µ�</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getGSHY.action">		   																				
				</s:url>
				<s:a href="%{url}">���Ի�ԾԤ����ÿ�죩</s:a>
			</td>	
		</tr>
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/ShowfindGSHY.jsp">		   																				
				</s:url>
				<s:a href="%{url}">���Թ��Ի�Ծ</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindlow.action">		   																				
				</s:url>
				<s:a href="%{url}">�ҵף�ÿ�죩</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getylbs.action">		   																				
				</s:url>
				<s:a href="%{url}">ӯ������</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindTwoLow.action">		   																				
				</s:url>
				<s:a href="%{url}">����˫�ף�ÿ�죩</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindCYC.action">		
				 <s:param name="condition" value="0"/>	   																				
				</s:url>
				<s:a href="%{url}">CYC13</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindchaodie.action">		   																				
				</s:url>
				<s:a href="%{url}">��������,��������ߵ�0.82-0.65,�����������Ƿ�����10%�ڣ�ÿ�죩</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindCYC.action">	
				<s:param name="condition" value="1"/>		   																				
				</s:url>
				<s:a href="%{url}">CYC34</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindCYC.action">		
				<s:param name="condition" value="2"/>	   																				
				</s:url>
				<s:a href="%{url}">CYC55</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindCYC.action">		
				<s:param name="condition" value="3"/>		   																				
				</s:url>
				<s:a href="%{url}">CYC125</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindCYC.action">	
				<s:param name="condition" value="4"/>		   																				
				</s:url>
				<s:a href="%{url}">CYC250</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindZUIDICYC13.action">		
				<s:param name="condition" value="3"/>		   																				
				</s:url>
				<s:a href="%{url}">ZUIDICYC13</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindZUIDICYC13.action">	
				<s:param name="condition" value="5"/>		   																				
				</s:url>
				<s:a href="%{url}">ZUIDICYC13B</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/seilin.jsp">																						
				</s:url>
				<s:a href="%{url}">��Ʊ����</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="/seilout.jsp">						   																			
				</s:url>
				<s:a href="%{url}">��Ʊ����</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!openorstopsendemail.action">		
				<s:param name="condition" value="0"/>															
				</s:url>
				<s:a href="%{url}">�������Ͷ���</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!openorstopsendemail.action">	
				<s:param name="condition" value="1"/>		   																			
				</s:url>
				<s:a href="%{url}">�رշ��Ͷ���</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getseilininput.action">		
				<s:param name="condition" value="3"/>		   																				
				</s:url>
				<s:a href="%{url}">��Ʊ�����б�</s:a>
			</td>
		</tr>	
	</table>
		
	
				
					
					<br>
  </body>
</html>
