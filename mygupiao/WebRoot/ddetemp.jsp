<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3><s:property value="gupiaodaima"/> <s:property value="gupiaomingcheng"/> DDE变化详细情况 </h3>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					序号
				</td>				
				<td class=tt align=center>
					日期
				</td>
				<td class=tt align=center>
					最新
				</td>
				<td class=tt align=center>
					涨幅
				</td>
				<td class=tt align=center>
					DDX
				</td>
				<td class=tt align=center>
					DDY
				</td>
				<td class=tt align=center>
					DDZ
				</td>
				<td class=tt align=center>
					DDX60
				</td>
				<td class=tt align=center>
					DDY60
				</td>
				<td class=tt align=center>
					10日内
				</td>
				<td class=tt align=center>
					连续
				</td>
				<td class=tt align=center>
					特大买入
				</td>
				<td class=tt align=center>
					特大卖出
				</td>
				<td class=tt align=center>
					大单买入
				</td>
				<td class=tt align=center>
					大单卖出
				</td>
			</tr>
				<s:iterator value="#request.ddetemp" id="temp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:date  name="riqi"  format="yyyy-MM-dd"/>
					</td>	
    				<td class=tt align=center>
						<s:property value="zuixin"/>
					</td>
					
					<s:if test="#temp.ddx>0 and #temp.zanfu<0">
    					<td class=tt align=center style="background-color:red">
							<s:property value="zanfu"/>
						</td>
    				</s:if>
					<s:elseif test="#temp.ddx<0 and #temp.zanfu>0">
    					<td class=tt align=center style="background-color:green">
							<s:property value="zanfu"/>
						</td>
    				</s:elseif>
    				<s:else>
    					<td class=tt align=center >
							<s:property value="zanfu"/>
						</td>
    				</s:else>					
					<s:if test="#temp.ddx>0">
    					<td class=tt align=center style="background-color:red">
							<s:property value="ddx"/>
						</td>
    				</s:if>
					<s:else>
    					<td class=tt align=center >
							<s:property value="ddx"/>
						</td>
    				</s:else>
					<s:if test="#temp.ddy>0">
    					<td class=tt align=center style="background-color:red">
							<s:property value="ddy"/>
						</td>
    				</s:if>
					<s:else>
    					<td class=tt align=center >
							<s:property value="ddy"/>
						</td>
    				</s:else>
					<td class=tt align=center>
						<s:property value="ddz"/>
					</td>
					<td class=tt align=center>
						<s:property value="ddx60"/>
					</td>
					<td class=tt align=center>
						<s:property value="ddy60"/>
					</td>
					<td class=tt align=center>
						<s:property value="tenday"/>
					</td>
					<td class=tt align=center>
						<s:property value="lianxu"/>
					</td>
					<td class=tt align=center>
						<s:property value="tdmr"/>
					</td>					
					<td class=tt align=center>
						<s:property value="tdmc"/>
					</td>
					<td class=tt align=center>
						<s:property value="ddmr"/>
					</td>	
					<td class=tt align=center>
						<s:property value="ddmc"/>
					</td>
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
