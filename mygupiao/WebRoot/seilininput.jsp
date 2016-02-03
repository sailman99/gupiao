<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  
  <head>
    <h3>股票买入设置</h3>
  </head>
  <br>
  <body>
   
	
	
	
	
	<s:property value="gupiaodaima"/>
	
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="web2">
		<tr>
			<td height="1" colspan="6" bgcolor="#cfcfcf"></td>
		</tr>
		<tr class="tt" height="25">
			<td class=tt align=left>
				<s:url id="url" value="GupiaoAction!seilinother.action">	
					<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>	
					<s:param name="price"><s:property value="mbcjgs"/></s:param>	
					<s:param name="condition" value="0"/>		   																				
				</s:url>
				<s:a href="%{url}">0.99倍买入</s:a>	<br>
			</td>	
		</tr>	
		<tr/>
		<tr class="tt" height="25">
			<td class=tt align=left>
				<s:url id="url" value="GupiaoAction!seilinother.action">	
					<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>	
					<s:param name="price"><s:property value="mbcjgs5"/></s:param>
					<s:param name="condition" value="1"/>			   																				
				</s:url>
				<s:a href="%{url}">0.985倍买入</s:a>	<br>
			</td>				
		</tr>	
		<tr class="tt" height="25">
			<td class=tt align=left>
				<s:url id="url" value="GupiaoAction!seilinother.action">	
					<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>	
					<s:param name="price"><s:property value="mbcjgs10"/></s:param>
					<s:param name="condition" value="2"/>	   																				
				</s:url>
				<s:a href="%{url}">0.98倍买入</s:a>	<br>
			</td>	
		</tr>	
		<tr class="tt" height="25">
			<td class=tt align=left>
				<s:url id="url" value="GupiaoAction!seilinother.action">
					<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>	
					<s:param name="price"><s:property value="mbcjgs30"/></s:param>	
					<s:param name="condition" value="3"/>	   																				
				</s:url>
				<s:a href="%{url}">0.97倍买入</s:a>	<br>
			</td>	
		</tr>	
		<tr class="tt" height="25">
			<td class=tt align=left>
				<s:url id="url" value="GupiaoAction!seilinother.action">	
					<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>	
					<s:param name="price"><s:property value="mbcjgs120"/></s:param>
					<s:param name="condition" value="4"/>	   																				
				</s:url>
				<s:a href="%{url}">cyc34倍买入</s:a>	<br>
			</td>	
		</tr>	
		<tr class="tt" height="25">
			<td class=tt align=left>
				<s:url id="url" value="GupiaoAction!seilinother.action">	
					<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>	
					<s:param name="price"><s:property value="cyc"/></s:param>
					<s:param name="condition" value="5"/>	   																				
				</s:url>
				<s:a href="%{url}">cyc55倍买入</s:a>	<br>
			</td>	
		</tr>				
	</table>
		
	
				
					
					<br>
  </body>
</html>
