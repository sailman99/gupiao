package com.gupiao.struts.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Cycwarm;
import com.gupiao.model.persist.entity.Gaokao_xyst;
import com.gupiao.model.persist.entity.Gaokao_zyb;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.JsonGupiaoshuju;
import com.gupiao.model.persist.entity.Rzzgs;
import com.gupiao.model.persist.entity.Scalewarm;
import com.gupiao.model.persist.entity.Trendlines;
import com.gupiao.model.persist.entity.Userdefine;
import com.gupiao.web.tools.DateJsonValueProcessor;
import com.gupiao.web.tools.MyTools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.opensymphony.xwork2.ActionSupport;

@Service
@Scope("prototype")
public class JsonAction  extends ActionSupport {   
	private static final long serialVersionUID = -5279892367628798557L;
	
	private JSONArray resultTree;
	private JSONObject jsonObject;
	private String jsonString;
	private GupiaoDAO gupiaoDAO;
	private String https_url;
	private String gupiaodaima;
	private String subject;
	private String preblem;
	private String comefrom;
	private String xystid;
	private String riqi;
	
	private Double jsqbh;
	
	private Double jsqbh2;
	
	private HttpServletRequest httpServletRequest=ServletActionContext.getRequest();
	
	@Autowired
	public JsonAction(GupiaoDAO gupiaoDAO){
		this.gupiaoDAO=gupiaoDAO;
	
	}
	
	public String getComefrom() {
		return comefrom;
	}

	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}

	public String getGupiaodaima() {
		return gupiaodaima;
	}
	
	
	
	

	public String getXystid() {
		return xystid;
	}

	public void setXystid(String xystid) {
		this.xystid = xystid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPreblem() {
		return preblem;
	}

	public void setPreblem(String preblem) {
		this.preblem = preblem;
	}

	public String getHttps_url() {
		return https_url;
	}

	public void setHttps_url(String https_url) {
		this.https_url = https_url;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	
	
	public Double getJsqbh() {
		return jsqbh;
	}


	public void setJsqbh(Double jsqbh) {
		this.jsqbh = jsqbh;
	}


	public Double getJsqbh2() {
		return jsqbh2;
	}


	public void setJsqbh2(Double jsqbh2) {
		this.jsqbh2 = jsqbh2;
	}


	public String getRiqi() {
		return riqi;
	}



	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}


/*
	@Resource(name="gupiaoDAO")
	public void setGupiaoDAO(GupiaoDAO gupiaoDAO) {
		this.gupiaoDAO = gupiaoDAO;
	}


*/
	

	
	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public void setResultTree(JSONArray resultTree) {
		this.resultTree = resultTree;
	}

	public JSONArray getResultTree() {
		return resultTree;
	}

	public String getrzzgsGroupByCondition() {
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
	
		
		resultTree=JSONArray.fromObject(gupiaoDAO.getrzzgsGroupByCondition(this.jsqbh,this.jsqbh2),config);
		return "success";
		
		
	}
	public String getrzzgsByCondition(){//ͨ��������ѯ
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getrzzgsByCondition(this.jsqbh,this.jsqbh2,this.riqi),config));
		
		return "success";
		
	}
	public String jsonRzzgs() throws Exception{
		List listRzzgs = new ArrayList();
//		JSONObject jsonObj = JSONObject.fromObject(this.httpServletRequest.getParameterMap());
		
		
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
//		List listRzzgs = gupiaoDAO.getrzzgs();
		return "success";  

	}
	public String getrzzgsbygupiaodaima() throws Exception{
		
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getrzzgsbygupiaodaima(this.gupiaodaima),config));
		
		return "success";
	}
	public String testjson() throws Exception{
		List list_gupiaoshuju=new ArrayList();
	
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			String str_zuoshou="";
		
			//List list_gupiaoshuju=new ArrayList();
			  
			//List list=gupiaoDAO.getgupiaoshuju(this.gupiaodaima);
			List list=gupiaoDAO.getgupiaoshuju(this.gupiaodaima);
			Iterator iter=list.iterator();
			while(iter.hasNext()){
				Gupiaoshuju gupiaoshuju=(Gupiaoshuju)iter.next();
				//str_temp[0]= Double.valueOf(format.format(gupiaoshuju.getRiqi())).doubleValue();
				JsonGupiaoshuju innergupiaoshuju=new JsonGupiaoshuju();
				innergupiaoshuju.setAa(format.format(gupiaoshuju.getRiqi()));
				if(str_zuoshou.length()>0){
					innergupiaoshuju.setBb(str_zuoshou);
					str_zuoshou=gupiaoshuju.getShoupan().toString();
				}
				else{
					innergupiaoshuju.setBb(gupiaoshuju.getShoupan().toString());
					str_zuoshou=gupiaoshuju.getShoupan().toString();
				}
					
				innergupiaoshuju.setCc(gupiaoshuju.getKaipan().toString());
				innergupiaoshuju.setDd(gupiaoshuju.getZuigao().toString());
				innergupiaoshuju.setEe(gupiaoshuju.getZuidi().toString());
				innergupiaoshuju.setFf(gupiaoshuju.getShoupan().toString());
				innergupiaoshuju.setGg((new BigDecimal((gupiaoshuju.getChengjiaoshou().toString()))).toPlainString());
				innergupiaoshuju.setHh((new BigDecimal((gupiaoshuju.getChengjiaojiner().toString()))).toPlainString());
				list_gupiaoshuju.add(innergupiaoshuju);
			}

			resultTree=JSONArray.fromObject(list_gupiaoshuju);  //����JSONArray jsarry=JSONArray.fromObject(list)  

		  

		return "success";  

	}
	public String getMonths() throws Exception{
		resultTree=JSONArray.fromObject(gupiaoDAO.getMonths());
		return "success";
	}
	public String updateTrendlines() throws Exception{
		
		JSONArray array = JSONArray.fromObject(jsonString);
		for(int i=0;i<array.size();i++){
			JSONObject jsonObject = array.getJSONObject(i);
			Trendlines trendlines= new Trendlines();
			trendlines.setGupiaodaima(jsonObject.get("gupiaodaima").toString());
			trendlines.setRiqi1(MyTools.strToDateTime(jsonObject.get("riqi1").toString().substring(0,10)));
			trendlines.setRiqi2(MyTools.strToDateTime(jsonObject.get("riqi2").toString().substring(0,10)));
			trendlines.setRiqi3(MyTools.strToDateTime(jsonObject.get("riqi3").toString().substring(0,10)));
			trendlines.setDot1(Double.parseDouble(jsonObject.get("dot1").toString()));
			trendlines.setDot2(Double.parseDouble(jsonObject.get("dot2").toString()));
			trendlines.setDot3(Double.parseDouble(jsonObject.get("dot3").toString()));
			trendlines.setUpordown(jsonObject.get("upordown").toString());
			trendlines.setDot1todot2(gupiaoDAO.getTrendlinesriqicount(trendlines.getGupiaodaima(),trendlines.getRiqi1(),trendlines.getRiqi2()));
			trendlines.setGradient((trendlines.getDot2()-trendlines.getDot1())/trendlines.getDot1todot2());
			Double riqicount=gupiaoDAO.getTrendlinesriqicount(trendlines.getGupiaodaima(),trendlines.getRiqi3(),new Date())+0.00;
			trendlines.setForecastprice(trendlines.getDot3()+riqicount*trendlines.getGradient());
			gupiaoDAO.SaveObject(trendlines);
		}
		
		JSONObject jsObject = new JSONObject();
		jsObject.put("success", true);
		jsObject.put("msg","数据更新成功！");
		setJsonObject(jsObject);
		
		return "success";

	}
	public String updateScalewarmBeizhu() throws Exception{
		JSONArray array = JSONArray.fromObject(jsonString); 
		 for (int i = 0; i < array.size(); i++)  
	        {  
			 jsonObject = array.getJSONObject(i); 
			 Scalewarm scalewarm = new Scalewarm();
			 scalewarm.setGupiaodaima(jsonObject.get("gupiaodaima").toString());
			 scalewarm.setZuidiriqi(MyTools.strToDateTime(jsonObject.get("zuidiriqi").toString().substring(0,10)));
			 scalewarm.setScale( Double.parseDouble(jsonObject.get("scale").toString()));
			 scalewarm.setZuidijia( Double.parseDouble(jsonObject.get("zuidijia").toString()));
			 scalewarm.setZuigaoriqi(MyTools.strToDateTime(jsonObject.get("zuigaoriqi").toString().substring(0,10)));
			 scalewarm.setZuigaojia( Double.parseDouble(jsonObject.get("zuigaojia").toString()));
			 scalewarm.setJiage( Double.parseDouble(jsonObject.get("jiage").toString()));
			 if(jsonObject.get("riqi").toString().length()>9){
				 scalewarm.setRiqi(MyTools.strToDateTime(jsonObject.get("riqi").toString().substring(0,10)));
			 }
			 scalewarm.setBeizhu(jsonObject.get("beizhu").toString());
			 scalewarm.setBeizhuriqi(new java.util.Date());
			 gupiaoDAO.SaveObject(scalewarm);
	        }  
		
		return "success";
	}
	
	public String updateCycwarmBeizhu() throws Exception{
		JSONArray array = JSONArray.fromObject(jsonString); 
		 for (int i = 0; i < array.size(); i++)  
	        {  
			 jsonObject = array.getJSONObject(i); 
			 Cycwarm cycwarm = new Cycwarm();
			 cycwarm.setGupiaodaima(jsonObject.get("gupiaodaima").toString());
			 cycwarm.setRiqi(MyTools.strToDateTime(jsonObject.get("riqi").toString().substring(0,10)));
			 cycwarm.setCyc( Integer.parseInt(jsonObject.get("cyc").toString()));
			 cycwarm.setJiage( Double.parseDouble(jsonObject.get("jiage").toString()));
			 if(jsonObject.get("comeriqi").toString().length()>9){
				 cycwarm.setComeriqi(MyTools.strToDateTime(jsonObject.get("comeriqi").toString().substring(0,10)));
			 }
			 cycwarm.setBeizhu(jsonObject.get("beizhu").toString());
			 cycwarm.setBeizhuriqi(new java.util.Date());
			 
			 
			 gupiaoDAO.SaveObject(cycwarm);
	        }  
		
		return "success";
	}
	
	
	public String updateUserdefine() throws Exception{
		 gupiaoDAO.clearUserdefine();
		 JSONArray array = JSONArray.fromObject(jsonString); 
		 for (int i = 0; i < array.size(); i++)  
	        {  
			 jsonObject = array.getJSONObject(i); 
			 Userdefine userdefine=new Userdefine();
			 userdefine.setGupiaodaima(jsonObject.get("gupiaodaima").toString());
			 gupiaoDAO.SaveObject(userdefine);
	        }
		 
		 return "success";
	}
	
	public String updateRzzgsBeizhu() throws Exception{
		
		JSONArray array = JSONArray.fromObject(jsonString); 
		 for (int i = 0; i < array.size(); i++)  
	        {  
			 jsonObject = array.getJSONObject(i); 
			 Rzzgs rzzgs=new Rzzgs();
			 rzzgs.setGupiaodaima(jsonObject.get("gupiaodaima").toString());
			 rzzgs.setRiqi(MyTools.strToDateTime(jsonObject.get("riqi").toString().substring(0,10)));
			 rzzgs.setGdzs( Double.parseDouble(jsonObject.get("gdzs").toString()));
			 rzzgs.setRzzg( Double.parseDouble(jsonObject.get("rzzg").toString()));
			 rzzgs.setJsqbh( Double.parseDouble(jsonObject.get("jsqbh").toString()));
			 rzzgs.setZgb( Double.parseDouble(jsonObject.get("zgb").toString()));
			 rzzgs.setLtg( Double.parseDouble(jsonObject.get("ltg").toString()));
			 rzzgs.setJsqbh2( Double.parseDouble(jsonObject.get("jsqbh2").toString()));
			 rzzgs.setJsqbh3( Double.parseDouble(jsonObject.get("jsqbh3").toString()));
			 rzzgs.setJsqbh4( Double.parseDouble(jsonObject.get("jsqbh4").toString()));
			 rzzgs.setJsqbh5( Double.parseDouble(jsonObject.get("jsqbh5").toString()));
			 rzzgs.setJsqbh6( Double.parseDouble(jsonObject.get("jsqbh6").toString()));
			 rzzgs.setGenericriqi(MyTools.strToDateTime(jsonObject.get("genericriqi").toString().substring(0,10)));
			 rzzgs.setBeizhuriqi(MyTools.strToDateTime((new SimpleDateFormat("yyyy-MM-dd")).format(new java.util.Date())));
			 rzzgs.setBeizhu(jsonObject.get("beizhu").toString());
			 if("true".equals(jsonObject.get("cyc55").toString())){
				Cycwarm cycwarm=new Cycwarm();
				cycwarm.setGupiaodaima(rzzgs.getGupiaodaima());
				cycwarm.setRiqi(MyTools.strToDateTime((new SimpleDateFormat("yyyy-MM-dd")).format(new java.util.Date())));
				cycwarm.setCyc(55);
				gupiaoDAO.SaveObject(cycwarm);
				gupiaoDAO.generic_updatecycwarm();
			 }
			 if("true".equals(jsonObject.get("cyc125").toString())){
					Cycwarm cycwarm=new Cycwarm();
					cycwarm.setGupiaodaima(rzzgs.getGupiaodaima());
					cycwarm.setRiqi(MyTools.strToDateTime((new SimpleDateFormat("yyyy-MM-dd")).format(new java.util.Date())));
					cycwarm.setCyc(125);
					gupiaoDAO.SaveObject(cycwarm);
					gupiaoDAO.generic_updatecycwarm();
			 }
			 if("true".equals(jsonObject.get("cyc250").toString())){
					Cycwarm cycwarm=new Cycwarm();
					cycwarm.setGupiaodaima(rzzgs.getGupiaodaima());
					cycwarm.setRiqi(MyTools.strToDateTime((new SimpleDateFormat("yyyy-MM-dd")).format(new java.util.Date())));
					cycwarm.setCyc(250);
					gupiaoDAO.SaveObject(cycwarm);
					gupiaoDAO.generic_updatecycwarm();
			} 
			 if("true".equals(jsonObject.get("down50").toString())){
				    gupiaoDAO.updateScalewarm(rzzgs.getGupiaodaima(),new Double(0.5),MyTools.strToDateTime(jsonObject.get("minriqi").toString().substring(0,10)));
			 }
			 if("true".equals(jsonObject.get("down618").toString())){
				    gupiaoDAO.updateScalewarm(rzzgs.getGupiaodaima(),new Double(0.618),MyTools.strToDateTime(jsonObject.get("minriqi").toString().substring(0,10)));
			 }
			 if("true".equals(jsonObject.get("down732").toString())){
				    gupiaoDAO.updateScalewarm(rzzgs.getGupiaodaima(),new Double(0.732),MyTools.strToDateTime(jsonObject.get("minriqi").toString().substring(0,10)));
			 }
			 gupiaoDAO.SaveObject(rzzgs);
	        }  
		
		return "success";
	}
	public String getTrendlines(){
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getTrendlines(),config));
		
		return "success";
	}
	public String getTrendlinestmp(){
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getTrendlinestmp(),config));
		
		return "success";
	}
	
	public String getCycwarmtmp(){
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getCycwarmtmp(),config));
		
		return "success";
	}
	public String getScalewarmtmp(){
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getScalewarmtmp(),config));
		
		return "success";
	}
	public String deleteScalewarm(){
		this.gupiaoDAO.deleteScalewarm(JSONArray.fromObject(jsonString));
		return "success";
	}
	public String updateGaokao_videoartitle(){		
		this.gupiaoDAO.updateGaokao_videoartitle(JSONArray.fromObject(jsonString));
		return "success";
	}
	public String getGaokao_labelclassification(){
		setResultTree(JSONArray.fromObject(this.gupiaoDAO.getGaokao_labelclassification(jsonString)));
		return "success";
	}
	public String getGaokao_subjectchapter(){		
		setResultTree(JSONArray.fromObject(this.gupiaoDAO.getGaokao_subjectchapter(jsonString)));
		return "success";
	}
	public String updateGaokao_labelclassification(){
		this.gupiaoDAO.updateGaokao_labelclassification(JSONArray.fromObject(jsonString));
		return "success";
	}
	public String updateGaokao_subjectchapter(){
		//System.out.println(jsonString);
		this.gupiaoDAO.updateGaokao_subjectchapter(JSONArray.fromObject(jsonString));
		return "success";
	}
	public void in_Gaokao_zyb(String https_url,StringBuffer sb) {
		String[] str_mfind=sb.toString().split("<dl class=\"trace refer-answer\">");
		String surplus;
		Gaokao_zyb gaokao_zyb = new Gaokao_zyb();
		gaokao_zyb.setUrl(https_url);		
		gaokao_zyb.setInputdate(new Date());
		gaokao_zyb.setUpdatedate(new Date());
		gaokao_zyb.setSubjectid(subject);
		gaokao_zyb.setTypeid(preblem);
		  
		   for(int i=0;i<str_mfind.length;i++) {
			   //System.out.println(str_mfind[i]);
			   if(str_mfind[i].indexOf("题目")>-1) {
				   //System.out.println("题目");
				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>题目：</dt>")+"<dt>题目：</dt>".length());
				   gaokao_zyb.setProblems(surplus.replaceAll("</span>                                              </dd>            </dl>          </dd>                      <dd>","</span></dd>"));
					
			   }
			   if(str_mfind[i].indexOf("考点")>-1) {
				   //System.out.println("考点");
				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>考点：</dt>")+"<dt>考点：</dt>".length());
				   gaokao_zyb.setExamination(surplus.replaceAll("</dd>              </dl>            </dd>                                <dd>", "</dd>"));
			   }
			   if(str_mfind[i].indexOf("分析")>-1) {
				   //System.out.println("分析");
				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>分析：</dt>")+"<dt>分析：</dt>".length());
					gaokao_zyb.setAnalyzes(surplus.replaceAll("</dd>              </dl>            </dd>                    <dd>", "</dd>"));
			   }
			   if(str_mfind[i].indexOf("解答")>-1) {
				   //System.out.println("解答");
				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>解答：</dt>")+"<dt>解答：</dt>".length());
				   
				   if(surplus.indexOf("</body>")>-1) {
				   surplus=surplus.substring(0,surplus.indexOf("</body>"));
				   }
				   gaokao_zyb.setAnswers(surplus.replaceAll("</dd>            </dl>          </dd>        </dl>             </div>      </div></div>", "</dd>"));
			   }
		   }
		   this.gupiaoDAO.insertGaokao_zyb(gaokao_zyb);
		   
	}
	
	public void in_Gaokao_xyst(String https_url,StringBuffer sb) {
		
		String pattern = "</a></div><div class=\"content\"><div class=\"section-content\">";
			   
			  // 创建 Pattern 对象
	   Pattern r = Pattern.compile(pattern);
	 
			  // 现在创建 matcher 对象
	   Matcher m = r.matcher(sb);
	  
	   String problems=null,answers=null,analyzes=null;
	   String surplus="";//存剩余部分
	   
	   if(m.find()) {//搜问题
			   surplus=sb.substring(m.end());//取剩余部分
			   pattern = "<div class=\"section-seperator\"></div><div class=\"section-header\">答案";
			  
			   r = Pattern.compile(pattern);
			   m = r.matcher(surplus);
			   if(m.find()) {
				   //取出问题
				  
				   problems=surplus.substring(0, m.start());
				   surplus=surplus.substring(m.end());//取剩余部分
			   }
			    pattern = "</div><div class=\"section-content\">";//去除多余部分
			r = Pattern.compile(pattern);
			m = r.matcher(surplus);
			if(m.find()) {//去除多余部分
			  surplus=surplus.substring(m.end());//取剩余部分
			}
			pattern = "解析</div><div class=\"section-content\">";
			//pattern = "</div><div class=\"section-content\">";
			    r = Pattern.compile(pattern);
				m = r.matcher(surplus);
				if(m.find()) {
					answers=surplus.substring(0,m.start());
					surplus=surplus.substring(m.end());//取剩余部分
				}else {
					pattern = "解析:</div><div class=\"section-content\">";
					//pattern = "</div><div class=\"section-content\">";
			    	r = Pattern.compile(pattern);
			    	m = r.matcher(surplus);
			    	if(m.find()) {
			    		answers=surplus.substring(0,m.start());
			    		surplus=surplus.substring(m.end());//取剩余部分
			    	}else {//如果都没有找到，表明这道题是没有解析的
			    		pattern = "</div><div class=\"vip-content-wrapper\">";
				    	r = Pattern.compile(pattern);
				    	m = r.matcher(surplus);
				    	if(m.find()) {
				    		answers=surplus.substring(0,m.start());
				    		surplus=surplus.substring(m.end());//取剩余部分
				    	}else {
				    		pattern = "</div><div class=\"vip-toast\">";
					    	r = Pattern.compile(pattern);
					    	m = r.matcher(surplus);
					    	if(m.find()) {
					    		answers=surplus.substring(0,m.start());
					    		surplus=surplus.substring(m.end());//取剩余部分
					    	}
				    	}
			    	}
				}
				problems=problems.replaceAll("</p></div>", "</p>").replaceAll("</ul></div>", "</ul>");
				answers=answers.replaceAll("</p></div><div class=\"section-seperator\">", "</p>").replaceAll("</p></div><div class=\"section-content\">", "</p>").replaceAll("</p></div><div class=\"section-header\">", "</p>");
				answers=answers.replaceAll("</div><div class=\"section-seperator\"></div><div class=\"section-header\">", "");
				answers=answers.replaceAll("</div><div class=\"section-content\">", "");
				
				pattern = "</div><div class=\"vip-content-wrapper\">";
				r = Pattern.compile(pattern);
				m = r.matcher(surplus);
				if(m.find()) {
					analyzes=surplus.substring(0,m.start());//.replaceAll("</div>", "").replaceAll("</xhtml>", "</xhtml></div>");
				}else {
					pattern = "</div><div class=\"vip-toast\">";
			    	r = Pattern.compile(pattern);
			    	m = r.matcher(surplus);
			    	if(m.find()) {
			    		analyzes=surplus.substring(0,m.start());//.replaceAll("</div>", "").replaceAll("</xhtml>", "</xhtml></div>");
			    	}
				}
					   
	 	}
				   
			
	   //this.gupiaoDAO.insertGaokao_xyst
	   Gaokao_xyst gaokao_xyst=new Gaokao_xyst();
	   gaokao_xyst.setUrl(https_url);
	   gaokao_xyst.setProblems(problems);
	   gaokao_xyst.setAnswers(answers);
	   gaokao_xyst.setAnalyzes(analyzes);
	   gaokao_xyst.setInputdate(new Date());
	   gaokao_xyst.setUpdatedate(new Date());
	   gaokao_xyst.setSubjectid(subject);
	   gaokao_xyst.setTypeid(preblem);
	   this.gupiaoDAO.insertGaokao_xyst(gaokao_xyst);
	
	     

	}
	public void insertGaokao_zyborxyst() throws Exception{
		System.out.println("jsonString:"+jsonString);
		JSONArray array = JSONArray.fromObject(jsonString); 
		 for (int i = 0; i < array.size(); i++)  
	        {  
			 jsonObject = array.getJSONObject(i); 
			 
			 this.https_url= URLDecoder.decode(jsonObject.get("https_url").toString(),"UTF-8");
			 this.subject=jsonObject.get("subject").toString();
			 this.preblem=jsonObject.get("preblem").toString();
			 this.comefrom=jsonObject.get("comefrom").toString();
			 }
		/* System.out.println("jsonString:"+jsonString);
		 System.out.println("https_url:"+https_url);
		 System.out.println("subject:"+subject);
		 System.out.println("comefrom:"+comefrom);*/
		 insertGaokao_xyst();
	}
	public String insertGaokao_xyst() {
		
		URL url;
		
		Integer urlcounts= this.gupiaoDAO.whetherExistencexystUrl(https_url,comefrom);
		
		if(urlcounts==0) {
			
	      try {  
		     url = new URL(https_url);
		     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		  
		     try {
		    	 BufferedReader br = 
		    			new BufferedReader(
		    				new InputStreamReader(con.getInputStream(),"utf-8"));
		    	 
		    		   String input;
		    		   StringBuffer sb = new StringBuffer();
		    	
		    		   while ((input = br.readLine()) != null){
		    			   
		    		       sb.append(input);
		    		   }
		    	
		    		   if("001".equals(comefrom)) {
		    	
		    			   in_Gaokao_zyb(https_url, sb);
		    			
		    		   }
		    		   if("002".equals(comefrom)) {
		    			   in_Gaokao_xyst(https_url, sb);
		    		   }
		    	
		    		   br.close();
		    		   //
		    	 
		    		} catch (IOException e) {
		    		   e.printStackTrace();
		    		}
	
		    	 
	 
	      } catch (MalformedURLException e) {
		     e.printStackTrace();
	      } catch (IOException e) {
		     e.printStackTrace();
	      }
		
	
		}
		
	
		
		JSONObject jsObject = new JSONObject();
		jsObject.put("success", true);	
		if(urlcounts==0) {
			jsObject.put("message", "保存成功！");
		}else {
			jsObject.put("message", "该题已存在！");
		}
		setJsonObject(jsObject);
		return "success";
	}
	public String whetherExistenceUrl(){
		
		
		Integer urlcounts= this.gupiaoDAO.whetherExistenceUrl(jsonString);
		
		
		
		JSONObject jsObject = new JSONObject();
		jsObject.put("success", true);
		jsObject.put("urlcounts",urlcounts);
		setJsonObject(jsObject);
		 
		return "success";
	}
	
	public String getGaokao_xyst() {
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  

		setResultTree(JSONArray.fromObject(gupiaoDAO.getGaokao_xyst(jsonString),config));
		return "success";
	}
	public String getGaokao_zyb() {
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  

		setResultTree(JSONArray.fromObject(gupiaoDAO.getGaokao_zyb(jsonString),config));
		return "success";
	}
	public String getXystlist() {
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		//System.out.println(jsonString);
		setResultTree(JSONArray.fromObject(gupiaoDAO.getXystlist(jsonString),config));
		return "success";
	}
	public String getZyblist() {
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		//System.out.println(jsonString);
		setResultTree(JSONArray.fromObject(gupiaoDAO.getZyblist(jsonString),config));
		return "success";
	}
	public String getGaokao_vedioartitle(){
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getGaokao_vedioartitle(jsonString),config));
		return "success";
	}
	public String getGaokao_vedioartitlefornoDownload(){
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.getGaokao_vedioartitlefornoDownload(jsonString),config));
		return "success";
	}
	public String downloadGaokao_vedioartitle(){
		JsonConfig config = new JsonConfig();  
		config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateJsonValueProcessor("yyyy-MM-dd"));  
		
		setResultTree(JSONArray.fromObject(gupiaoDAO.downloadGaokao_vedioartitle(jsonString),config));
		return "success";
	}
}
