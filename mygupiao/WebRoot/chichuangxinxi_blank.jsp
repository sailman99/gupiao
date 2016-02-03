<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  
  
  <body>
    <h3><s:property value="chichuangxinxidate"/>持仓信息空白详细情况 </h3>
    
     <s:form action="GupiaoAction!updateChichuangxinxi_blank.action" method="post">
        <s:textfield name="chichuangxinxidate" label="请输入数据库日期"/>
        <s:textfield name="urldate" label="请输入网页日期" />
        <s:textfield name="gupiaodaima" label="股票代码" />
		<s:submit value="提交"/>
	</s:form>
    <table class="tt" width="100%" border="1">
   	 
			<tr class="tt" height="25">
				<td class=tt align=center>
					序号
				</td>				
				<td class=tt align=center>
					股票代码
				</td>
				<td class=tt align=center>
					股票名称
				</td>
				<td class=tt align=center>
					散户持股比例
				</td>
				<td class=tt align=center>
					中户持股比例
				</td>
				<td class=tt align=center>
					大户持股比例
				</td>
				<td class=tt align=center>
					法人持股比例
				</td>
				<td class=tt align=center>
					机构持股比例
				</td>
			</tr>
				

				<s:iterator value="#request.chichuangxinxitemp" status="stuts">		
				<tr>		
					<td class=tt align="center">
						<li>${stuts.index}</li>
					</td>
					<td class=tt align=center>
						<s:property value="gupiaodaima"/>
					</td>
					<td class=tt align=center>
						<s:property value="gupiaomingcheng"/>
					</td>
					<td class=tt align=center>
						<s:property value="sanhu"/>
					</td>
					<td class=tt align=center>
						<s:property value="zhonghu"/>
					</td>
					<td class=tt align=center>
						<s:property value="dahu"/>
					</td>
					<td class=tt align=center>
						<s:property value="faren"/>
					</td>	
					<td class=tt align=center>
						<s:property value="jigou"/>
					</td>
					</tr>		
				</s:iterator>	
			
		</table>
      </body>
</html>
