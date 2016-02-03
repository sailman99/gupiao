<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3>持仓信息空白统计情况 </h3>
    
     
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					序号
				</td>				
				<td class=tt align=center>
					日期
				</td>
				<td class=tt align=center>
					统计数
				</td>	
				<td class=tt align=center>
					查看对应当日ＧＩＦ
				</td>	
				<td class=tt align=center>
					整理当日数据
				</td>	
			</tr>
				

				<s:iterator value="#request.ccxx_blank_counts" id="temp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!getChichuangxinxi_blank.action">
							<s:param name="chichuangxinxidate"><s:date  name="riqi" /></s:param>								
						</s:url>
						<s:a href="%{url}"><s:date  name="riqi"  format="yyyy-MM-dd"/></s:a>					 	 
					</td>	
					<td class=tt align=center>
						<s:property value="rowCounts"/>
					</td>						
					<td class=tt align=center>
						<s:url id="url" value="%{'http://gubit.cn/TopView/'+#temp.riqi+'/600000.jpg'}">														
						</s:url>
						<s:a href="%{url}">查看对应当日ＧＩＦ</s:a>					 	 
					</td>
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!updateChichuangxinxi_blank.action">
							<s:param name="chichuangxinxidate"><s:date  name="riqi" /></s:param>								
						</s:url>
						<s:a href="%{url}">整理当日数据</s:a>					 	 
					</td>
					
					
					
									
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
