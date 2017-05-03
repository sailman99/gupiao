package com.gupiao.struts.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Cycwarm;
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
	
	private String gupiaodaima;
	
	private String riqi;
	
	private Double jsqbh;
	
	private Double jsqbh2;
	
	private HttpServletRequest httpServletRequest=ServletActionContext.getRequest();
	
	@Autowired
	public JsonAction(GupiaoDAO gupiaoDAO){
		this.gupiaoDAO=gupiaoDAO;
	
	}
	
	public String getGupiaodaima() {
		return gupiaodaima;
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
}
