<%@ page language="java"  pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    每笔成交股数比例均线 <br>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					序号
				</tD>				
				<td class=tt align=center>
					日期
				</td>				
				<td class=tt align=center>
					当天
				</td>
				<td class=tt align=center>
					5天均线
				</td>
				<td class=tt align=center>
					10天均线
				</td>
				<td class=tt align=center>
					30天均线
				</td>
				<td class=tt align=center>
					120天均线
				</td>
				<td class=tt align=center>
					股东数
				</td>
				<td class=tt align=center>
					Ｋ线图
				</td>
				<td class=tt align=center>
					备注
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
						<s:a href="%{url}">股东数情况</s:a>					 	 
					</td>	
					<td class=tt align=center>
						<s:url id="url" value="%{'http://image.sinajs.cn/newchart/daily/n/sh'+#temp.gupiaodaima+'.gif'}">																
						</s:url>
						<s:a href="%{url}">Ｋ线图</s:a>					 	 
					</td>					
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}">备注</s:a>					 	 
					</td>						
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
