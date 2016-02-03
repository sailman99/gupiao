<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  <head>
    <h3>股票</h3>
  </head>
  <br>
  <body>
    <s:url id="url" value="GupiaoAction!getHuolipanwaring.action">	
    　　　<s:param name="condition" value="0"/>																					
	</s:url>
	<s:a href="%{url}">获利盘警告(散户)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getHuolipanwaring.action">	
	     <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">获利盘警告(大户)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getHuolipanwaring.action">		
	     <s:param name="condition" value="2"/>																				
	</s:url>
	<s:a href="%{url}">获利盘警告(法人)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getHuolipanwaring.action">	
	    <s:param name="condition" value="3"/>																					
	</s:url>
	<s:a href="%{url}">获利盘警告(机构)</s:a>	<br>
	<br>
	 <s:url id="url" value="GupiaoAction!getMbcjgsjs_temp.action">	    　　　																		
	</s:url>
	<s:a href="%{url}">获利盘警告(散户)</s:a>	<br>
	
	<br>
	
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">		
	    <s:param name="condition" value="0"/>																				
	</s:url>
	<s:a href="%{url}">股东数警告(散户)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">	
	    <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">股东数警告(大户)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">	
	    <s:param name="condition" value="2"/>																					
	</s:url>
	<s:a href="%{url}">股东数警告(法人)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">
	    <s:param name="condition" value="3"/>																						
	</s:url>
	<s:a href="%{url}">股东数警告(机构)</s:a><br>
	<br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">		
	    <s:param name="condition" value="0"/>																				
	</s:url>
	<s:a href="%{url}">股东数警告Superview(散户)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">	
	    <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">股东数警告Superview(中户)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">	
	    <s:param name="condition" value="2"/>																					
	</s:url>
	<s:a href="%{url}">股东数警告Superview(大户)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">
	    <s:param name="condition" value="3"/>																						
	</s:url>
	<s:a href="%{url}">股东数警告Superview(超大户)</s:a><br>
	
	
	
	
	
	
	
	<br>
	<s:url id="url" value="GupiaoAction!getCycwaring.action">
	    <s:param name="condition" value="0"/>																							
	</s:url>
	<s:a href="%{url}">成本均线警告(散户)</s:a>	<br>
	
	<s:url id="url" value="GupiaoAction!getCycwaring.action">
	    <s:param name="condition" value="1"/>																							
	</s:url>
	<s:a href="%{url}">成本均线警告(大户)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getCycwaring.action">
	    <s:param name="condition" value="2"/>																							
	</s:url>
	<s:a href="%{url}">成本均线警告(法人)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getCycwaring.action">	
	    <s:param name="condition" value="3"/>																						
	</s:url>
	<s:a href="%{url}">成本均线警告(机构)</s:a>	<br>
	
	<br>
	
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="0"/>																					
	</s:url>
	<s:a href="%{url}">天狼50板块情况(散户)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">天狼50板块情况(大户)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="2"/>																					
	</s:url>
	<s:a href="%{url}">天狼50板块情况(法人)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="3"/>																					
	</s:url>
	<s:a href="%{url}">天狼50板块情况(机构)</s:a>	<br>
	<br>
	<s:url id="url" value="/ShowGudongshu.jsp">																						
	</s:url>
	<s:a href="%{url}">股东数情况</s:a>	<br>	
	<s:url id="url" value="/ShowChichuangxinxi.jsp">																						
	</s:url>
	<s:a href="%{url}">股东数情况(chichuangxinxi)</s:a>	<br>	
	<s:url id="url" value="/ShowSuperview.jsp">																						
	</s:url>
	<s:a href="%{url}">股东数情况SUPERVIEW</s:a>	<br>	
	<s:url id="url" value="/ShowDDE.jsp">																						
	</s:url>
	<s:a href="%{url}">每笔成交股数均线mbcjgsjs</s:a>	<br>	
	<s:url id="url" value="/Showmbcjgsjs.jsp">																						
	</s:url>
	<s:a href="%{url}">DDE情况</s:a>	<br>	
	<br>
	
	<s:url id="url" value="GupiaoAction!getccxx_blank_counts.action">																						
	</s:url>
	<s:a href="%{url}">持仓情况整理</s:a>	<br>	
	<br>
	
	
	<s:url id="url" value="/TestJPG.jsp">																						
	</s:url>
	<s:a href="%{url}">测试ＪＰＧ文件</s:a>	<br>	
	<br>
	
	
  </body>
</html>
