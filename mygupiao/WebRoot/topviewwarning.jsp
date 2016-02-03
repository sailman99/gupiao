<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
   topview数据 <br>
     
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					序号
				</tD>
				<td class=tt align=center>
					股票代码
				</td>
				<td class=tt align=center>
					股票名称
				</td>
				<td class=tt align=center>
					日期
				</td>				
				<td class=tt align=center>
					散户数
				</td>
				<td class=tt align=center>
					5天均数
				</td>
				<td class=tt align=center>
					散户比例
				</td>
				<td class=tt align=center>
					中户数
				</td>
				<td class=tt align=center>
					中户比例
				</td>
				<td class=tt align=center>
					大户数
				</td>
				<td class=tt align=center>
					大户比例
				</td>
				<td class=tt align=center>
					超大户数
				</td>
				<td class=tt align=center>
					超大户比例
				</td>
				<td class=tt align=center>
					Ｋ线图
				</td>
				<td class=tt align=center>
					备注
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
							<s:a href="%{url}">Ｋ线图</s:a>					 	 
						</td>		
    				</s:if>					
    				<s:else>
    					<td class=tt align=center>
							<s:url id="url" value="%{'http://image.sinajs.cn/newchart/daily/n/sh'+#temp.gupiaodaima+'.gif'}">																
							</s:url>
							<s:a href="%{url}">Ｋ线图</s:a>					 	 
						</td>
    				</s:else>	
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
