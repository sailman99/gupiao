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
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.JsonGupiaoshuju;
import com.gupiao.model.persist.entity.Rzzgs;
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
			 rzzgs.setBeizhuriqi(new java.util.Date());
			 rzzgs.setBeizhu(jsonObject.get("beizhu").toString());
			 gupiaoDAO.SaveObject(rzzgs);
	        }  
		/*
		 * 
			private Double jsqbh;
			private Double zgb;
			private Double ltg;
			private Double jsqbh2;
			private Double jsqbh3;
			private Double jsqbh4;
			private Double jsqbh5;
			private Double jsqbh6;
			private Date genericriqi;
			private Date beizhuriqi;
			private String beizhu;
		 */
		return "success";
	}
	
}
