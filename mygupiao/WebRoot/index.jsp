<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  
  <head>
    <h3>股票</h3>
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
	<s:a href="%{url}">有条件浏览股东数情况</s:a>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<s:url id="url" value="/ShowGudongshu.jsp">																						
	</s:url>
	<s:a href="%{url}">股东数情况</s:a>	<br>	
	<s:url id="url" value="/ShowChichuangxinxi.jsp">																						
	</s:url>
	<s:a href="%{url}">股东数情况(chichuangxinxi)</s:a>	<br>	
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
				<s:a href="%{url}">每笔成交股数均线mbcjgsjs个股全部资料</s:a>
			</td>				
				
			
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getMbcjgsjs_temp.action">		   																				
				</s:url>
				<s:a href="%{url}">每笔成交股数预警，大于1.2并且当天价格为近期新高（每天）</s:a>	<br>
			</td>			
		</tr>
		<tr>
			<td height="1" colspan="6" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/Showtestmbcjgsjsbl.jsp">		   																				
				</s:url>
				<s:a href="%{url}">测试每笔成交股数均线</s:a>	<br>
			</td>	
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getThreeDayDump.action">		   																				
				</s:url>
				<s:a href="%{url}">连续三天下跌预警（每天）</s:a>
			</td>	
		</tr>				
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/ShowfindThreeDayDump.jsp">		   																				
				</s:url>
				<s:a href="%{url}">测试连续三天下跌</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getGSHY.action">		   																				
				</s:url>
				<s:a href="%{url}">股性活跃预警（每天）</s:a>
			</td>	
		</tr>
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="/ShowfindGSHY.jsp">		   																				
				</s:url>
				<s:a href="%{url}">测试股性活跃</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindlow.action">		   																				
				</s:url>
				<s:a href="%{url}">找底（每天）</s:a>
			</td>
		</tr>	
		<tr>
			<td height="1" colspan="7" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getylbs.action">		   																				
				</s:url>
				<s:a href="%{url}">盈利倍数</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!getfindTwoLow.action">		   																				
				</s:url>
				<s:a href="%{url}">个股双底（每天）</s:a>
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
				<s:a href="%{url}">超跌个股,跌幅在最高点0.82-0.65,并且现在上涨幅度在10%内（每天）</s:a>
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
				<s:a href="%{url}">股票买入</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="/seilout.jsp">						   																			
				</s:url>
				<s:a href="%{url}">股票卖出</s:a>
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
				<s:a href="%{url}">启动发送短信</s:a>
			</td>
			<td class=tt align=center>
				<s:url id="url" value="GupiaoAction!openorstopsendemail.action">	
				<s:param name="condition" value="1"/>		   																			
				</s:url>
				<s:a href="%{url}">关闭发送短信</s:a>
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
				<s:a href="%{url}">股票买入列表</s:a>
			</td>
		</tr>	
	</table>
		
	
				
					
					<br>
  </body>
</html>
