<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3><s:property value="gupiaodaima"/> <s:property value="gupiaomingcheng"/> 股东数变化详细情况 </h3>
    
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					序号
				</td>				
				<td class=tt align=center>
					日期
				</td>
				<td class=tt align=center>
					散户人数
				</td>
				<td class=tt align=center>
					散户持股比例
				</td>
				<td class=tt align=center>
					中户人数
				</td>
				<td class=tt align=center>
					中户持股比例
				</td>
				<td class=tt align=center>
					大户人数
				</td>
				<td class=tt align=center>
					大户持股比例
				</td>
				<td class=tt align=center>
					超大户人数
				</td>
				<td class=tt align=center>
					法人持股比例
				</td>
				<td class=tt align=center>
					机构持股比例
				</td>
				
			</tr>
				

				<% int i; %>

				<s:iterator value="#request.gudongshutemp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:date  name="riqi"  format="yyyy-MM-dd"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhubili"/>
					</td>
					<td class=tt align=center>
						<s:property value="zhonghushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="zhonghubili"/>
					</td>
					<td class=tt align=center>
						<s:property value="dahushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="dahubili"/>
					</td>					
					<td class=tt align=center>
						<s:property value="qiaodahushu"/>
					</td>
					<td class=tt align=center>
						<s:property value="farenbili"/>
					</td>	
					<td class=tt align=center>
						<s:property value="jigoubili"/>
					</td>
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
