<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  <head>
    <h3>��Ʊ</h3>
  </head>
  <br>
  <body>
    <s:url id="url" value="GupiaoAction!getHuolipanwaring.action">	
    ������<s:param name="condition" value="0"/>																					
	</s:url>
	<s:a href="%{url}">�����̾���(ɢ��)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getHuolipanwaring.action">	
	     <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">�����̾���(��)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getHuolipanwaring.action">		
	     <s:param name="condition" value="2"/>																				
	</s:url>
	<s:a href="%{url}">�����̾���(����)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getHuolipanwaring.action">	
	    <s:param name="condition" value="3"/>																					
	</s:url>
	<s:a href="%{url}">�����̾���(����)</s:a>	<br>
	<br>
	 <s:url id="url" value="GupiaoAction!getMbcjgsjs_temp.action">	    ������																		
	</s:url>
	<s:a href="%{url}">�����̾���(ɢ��)</s:a>	<br>
	
	<br>
	
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">		
	    <s:param name="condition" value="0"/>																				
	</s:url>
	<s:a href="%{url}">�ɶ�������(ɢ��)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">	
	    <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">�ɶ�������(��)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">	
	    <s:param name="condition" value="2"/>																					
	</s:url>
	<s:a href="%{url}">�ɶ�������(����)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getGudongshuwarning.action">
	    <s:param name="condition" value="3"/>																						
	</s:url>
	<s:a href="%{url}">�ɶ�������(����)</s:a><br>
	<br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">		
	    <s:param name="condition" value="0"/>																				
	</s:url>
	<s:a href="%{url}">�ɶ�������Superview(ɢ��)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">	
	    <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">�ɶ�������Superview(�л�)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">	
	    <s:param name="condition" value="2"/>																					
	</s:url>
	<s:a href="%{url}">�ɶ�������Superview(��)</s:a><br>
	
	<s:url id="url" value="GupiaoAction!getSuperviewwarning.action">
	    <s:param name="condition" value="3"/>																						
	</s:url>
	<s:a href="%{url}">�ɶ�������Superview(����)</s:a><br>
	
	
	
	
	
	
	
	<br>
	<s:url id="url" value="GupiaoAction!getCycwaring.action">
	    <s:param name="condition" value="0"/>																							
	</s:url>
	<s:a href="%{url}">�ɱ����߾���(ɢ��)</s:a>	<br>
	
	<s:url id="url" value="GupiaoAction!getCycwaring.action">
	    <s:param name="condition" value="1"/>																							
	</s:url>
	<s:a href="%{url}">�ɱ����߾���(��)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getCycwaring.action">
	    <s:param name="condition" value="2"/>																							
	</s:url>
	<s:a href="%{url}">�ɱ����߾���(����)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getCycwaring.action">	
	    <s:param name="condition" value="3"/>																						
	</s:url>
	<s:a href="%{url}">�ɱ����߾���(����)</s:a>	<br>
	
	<br>
	
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="0"/>																					
	</s:url>
	<s:a href="%{url}">����50������(ɢ��)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="1"/>																					
	</s:url>
	<s:a href="%{url}">����50������(��)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="2"/>																					
	</s:url>
	<s:a href="%{url}">����50������(����)</s:a>	<br>
	<s:url id="url" value="GupiaoAction!getTianlangbankuaiwarning.action">	
	    <s:param name="condition" value="3"/>																					
	</s:url>
	<s:a href="%{url}">����50������(����)</s:a>	<br>
	<br>
	<s:url id="url" value="/ShowGudongshu.jsp">																						
	</s:url>
	<s:a href="%{url}">�ɶ������</s:a>	<br>	
	<s:url id="url" value="/ShowChichuangxinxi.jsp">																						
	</s:url>
	<s:a href="%{url}">�ɶ������(chichuangxinxi)</s:a>	<br>	
	<s:url id="url" value="/ShowSuperview.jsp">																						
	</s:url>
	<s:a href="%{url}">�ɶ������SUPERVIEW</s:a>	<br>	
	<s:url id="url" value="/ShowDDE.jsp">																						
	</s:url>
	<s:a href="%{url}">ÿ�ʳɽ���������mbcjgsjs</s:a>	<br>	
	<s:url id="url" value="/Showmbcjgsjs.jsp">																						
	</s:url>
	<s:a href="%{url}">DDE���</s:a>	<br>	
	<br>
	
	<s:url id="url" value="GupiaoAction!getccxx_blank_counts.action">																						
	</s:url>
	<s:a href="%{url}">�ֲ��������</s:a>	<br>	
	<br>
	
	
	<s:url id="url" value="/TestJPG.jsp">																						
	</s:url>
	<s:a href="%{url}">���ԣʣУ��ļ�</s:a>	<br>	
	<br>
	
	
  </body>
</html>
