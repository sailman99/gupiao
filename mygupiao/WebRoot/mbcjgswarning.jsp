<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <s:property value="gupiaomingcheng"/> <br>
     
    <table class="tt" width="100%" border="1">
   		 	<tr class="tt" height="25">
				<td class=tt align=center style="background-color:red">
					序号
				</tD>
				<td class=tt align=center style="background-color:red">
					每笔全部
				</td>
				<td class=tt align=center style="background-color:red">
					测试每笔
				</td>
				<td class=tt align=center style="background-color:red">
					连跌三天
				</td>
				<td class=tt align=center style="background-color:red">
					股性活跃
				</td>				
				<td class=tt align=center style="background-color:red">
					ＢＢ
				</td>
				<td class=tt align=center style="background-color:red">
					震荡
				</td>
				<td class=tt align=center style="background-color:red">
					EXPMA线图
				</td>
				<td class=tt align=center style="background-color:red">
					股东人数
				</td>
				<td class=tt align=center style="background-color:red">
					Ｋ线图
				</td>
				
				
			</tr>
			<tr class="tt" height="25"  bgcolor="#cfcfcf">
				<td class=tt align=center>
					<s:property value="column_namea"/>
				</tD>
				<td class=tt align=center>
					<s:property value="column_nameb"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namec"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_named"/>
				</td>				
				<td class=tt align=center>
					<s:property value="column_namee"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namef"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_nameg"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_nameh"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namei"/>
				</td>
				<td class=tt align=center>
					<s:property value="column_namej"/>
				</td>
				
				
			</tr>
				

				

				<s:iterator value="#request.mbcjgsjs_temp" id="temp" status="stuts">	
				<s:if test="stuts.Even">
					<tr class="tt" height="25" bgcolor="#cfcfcf">				
				</s:if>	
				<s:else>
					<tr class="tt" height="25">	
				</s:else>
    				<s:if test="#temp.cyc==1">
    					<td class=tt align=center style="background-color:red">
							<li>${stuts.index}</li>
						</td>
    				</s:if>
    				<s:else>
    					<td class=tt align=center >
							<li>${stuts.index}</li>
						</td>
    				</s:else>					
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!getMbcjgsjs_riqi.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}"><s:property value="gupiaodaima"/></s:a>					 	 
					</td>
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!testMbcjgsjsbl.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}"><s:property value="gupiaomingcheng"/></s:a>						
					</td>					
					<td class=tt align=center>
					<s:url id="url" value="GupiaoAction!getfindThreeDayDump.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}"><s:date  name="riqi"  format="yyyy-MM-dd"/></s:a>						
					</td>
					<td class=tt align=center>
					<s:url id="url" value="GupiaoAction!getfindGSHY.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}"><s:property value="mbcjgs"/></s:a>						
					</td>					
					<td class=tt align=center>
						<s:property value="mbcjgs5"/>
					</td>
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!getfindmbcjgsjsbscyc30.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}"><s:property value="mbcjgs10"/></s:a>		
					</td>
					<td class=tt align=center>
						<s:url id="url" value="GupiaoAction!getEXPMA.action">
							<s:param name="gupiaodaima"><s:property value="gupiaodaima"/></s:param>								
						</s:url>
						<s:a href="%{url}"><s:property value="mbcjgs30"/></s:a>		
					</td>				
					<td class=tt align=center>
						<s:url id="url" value="%{'http://stockdata.stock.hexun.com/2009_cgjzd_'+#temp.gupiaodaima+'.shtml'}">																
							</s:url>
							<s:a href="%{url}"><s:property value="mbcjgs120"/></s:a>					 	 											
					</td>	
					<s:if test="#temp.gupiaodaima<'600000'">
    					<td class=tt align=center>
							<s:url id="url" value="%{'http://image.sinajs.cn/newchart/daily/n/sz'+#temp.gupiaodaima+'.gif'}">																
							</s:url>
							<s:a href="%{url}"><s:property value="cyc"/></s:a>					 	 
						</td>		
    				</s:if>					
    				<s:else>
    					<td class=tt align=center>
							<s:url id="url" value="%{'http://image.sinajs.cn/newchart/daily/n/sh'+#temp.gupiaodaima+'.gif'}">																
							</s:url>
							<s:a href="%{url}"><s:property value="cyc"/></s:a>					 	 
						</td>
    				</s:else>					
					
				</tr>	
				</s:iterator>	
			
		</table>
      </body>
</html>
