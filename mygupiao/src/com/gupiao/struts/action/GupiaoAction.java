package com.gupiao.struts.action;

import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONArray;





import net.sf.json.JSONArray;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gupiao.model.dao.GupiaoDAO;


import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.MbcjgsjsTemporary;
import com.gupiao.model.persist.entity.Procedurecondition;




import com.gupiao.web.tools.MyTools;
import com.gupiao.web.tools.MyTools.PositionXY;
import com.opensymphony.xwork2.ModelDriven;
@Service
@Scope("prototype")
public class GupiaoAction  implements ModelDriven,ServletRequestAware,ServletResponseAware,  StrutsStatics {  
	//ServletResponseAware.setServletResponse(HttpServletResponse)
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String gupiaodaima;
	private String gupiaomingcheng;
	private String bankuaidaima;
	private int condition;//存偖过程用到的条件
	private float price;//金额
	private String chichuangxinxidate;
	private String urldate;
	private String qigumingcheng;
	private float mbcjgs;
	private float mbcjgs5;
	private float mbcjgs10;
	private float mbcjgs30;
	private float mbcjgs120;
	private float cyc;
	
	
	
	
	
	private String column_namea;
	private String column_nameb;
	private String column_namec;
	private String column_named;
	private String column_namee;
	private String column_namef;
	private String column_nameg;
	private String column_nameh;
	private String column_namei;
	private String column_namej;
	private String column_namek;
	private String column_namel;
	private String column_namem;
	private String column_namen;
	private String column_nameo;
	private String column_namep;
	private String column_nameq;
	
	
	private String list_gupiaoshuju;
	
	public String getList_gupiaoshuju() {
		return list_gupiaoshuju;
	}






	private GupiaoDAO gupiaoDAO;
	
	/*
	public void setGupiaoDAO(GupiaoDAO gupiaoDAO) {
		this.gupiaoDAO = gupiaoDAO;
	}

	*/
	@Autowired
	public GupiaoAction(GupiaoDAO gupiaoDAO){
		this.gupiaoDAO=gupiaoDAO;
	}
	
	public void setServletResponse(HttpServletResponse response) {  
		        this.response = response;  
	}  
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String execute() throws Exception {

		return "gudongshuwarning";
	}
	
	
	public float getMbcjgs() {
		return mbcjgs;
	}


	public void setMbcjgs(float mbcjgs) {
		this.mbcjgs = mbcjgs;
	}


	public float getMbcjgs5() {
		return mbcjgs5;
	}


	public void setMbcjgs5(float mbcjgs5) {
		this.mbcjgs5 = mbcjgs5;
	}


	public float getMbcjgs10() {
		return mbcjgs10;
	}


	public void setMbcjgs10(float mbcjgs10) {
		this.mbcjgs10 = mbcjgs10;
	}


	public float getMbcjgs30() {
		return mbcjgs30;
	}


	public void setMbcjgs30(float mbcjgs30) {
		this.mbcjgs30 = mbcjgs30;
	}


	public float getMbcjgs120() {
		return mbcjgs120;
	}


	public void setMbcjgs120(float mbcjgs120) {
		this.mbcjgs120 = mbcjgs120;
	}


	public float getCyc() {
		return cyc;
	}


	public void setCyc(float cyc) {
		this.cyc = cyc;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getColumn_namea() {
		return column_namea;
	}

	public void setColumn_namea(String column_namea) {
		this.column_namea = column_namea;
	}

	public String getColumn_nameb() {
		return column_nameb;
	}

	public void setColumn_nameb(String column_nameb) {
		this.column_nameb = column_nameb;
	}

	public String getColumn_namec() {
		return column_namec;
	}

	public void setColumn_namec(String column_namec) {
		this.column_namec = column_namec;
	}

	public String getColumn_named() {
		return column_named;
	}

	public void setColumn_named(String column_named) {
		this.column_named = column_named;
	}

	public String getColumn_namee() {
		return column_namee;
	}

	public void setColumn_namee(String column_namee) {
		this.column_namee = column_namee;
	}

	public String getColumn_namef() {
		return column_namef;
	}

	public void setColumn_namef(String column_namef) {
		this.column_namef = column_namef;
	}

	public String getColumn_nameg() {
		return column_nameg;
	}

	public void setColumn_nameg(String column_nameg) {
		this.column_nameg = column_nameg;
	}

	public String getColumn_nameh() {
		return column_nameh;
	}

	public void setColumn_nameh(String column_nameh) {
		this.column_nameh = column_nameh;
	}

	public String getColumn_namei() {
		return column_namei;
	}

	public void setColumn_namei(String column_namei) {
		this.column_namei = column_namei;
	}

	public String getColumn_namej() {
		return column_namej;
	}

	public void setColumn_namej(String column_namej) {
		this.column_namej = column_namej;
	}

	public String getColumn_namek() {
		return column_namek;
	}

	public void setColumn_namek(String column_namek) {
		this.column_namek = column_namek;
	}

	public String getColumn_namel() {
		return column_namel;
	}

	public void setColumn_namel(String column_namel) {
		this.column_namel = column_namel;
	}

	public String getColumn_namem() {
		return column_namem;
	}

	public void setColumn_namem(String column_namem) {
		this.column_namem = column_namem;
	}

	public String getColumn_namen() {
		return column_namen;
	}

	public void setColumn_namen(String column_namen) {
		this.column_namen = column_namen;
	}

	public String getColumn_nameo() {
		return column_nameo;
	}

	public void setColumn_nameo(String column_nameo) {
		this.column_nameo = column_nameo;
	}

	public String getColumn_namep() {
		return column_namep;
	}

	public void setColumn_namep(String column_namep) {
		this.column_namep = column_namep;
	}

	public String getColumn_nameq() {
		return column_nameq;
	}

	public void setColumn_nameq(String column_nameq) {
		this.column_nameq = column_nameq;
	}
	
	
	
	public String getUrldate() {
		return urldate;
	}

	public void setUrldate(String urldate) {
		this.urldate = urldate;
	}

	public String getChichuangxinxidate() {
		return chichuangxinxidate;
	}

	public void setChichuangxinxidate(String chichuangxinxidate) {
		String[] riqi=chichuangxinxidate.split(" ");		
		this.chichuangxinxidate = riqi[0];
	}

	public String getQigumingcheng() {
		return qigumingcheng;
	}

	public void setQigumingcheng(String qigumingcheng) {
		this.qigumingcheng = qigumingcheng;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
		if(condition ==0){
			this.qigumingcheng="散户持股";
		}
		if(condition==(int)1){
			this.qigumingcheng="大户持股";
		}
		if(condition==(int)2){
			this.qigumingcheng="法人持股";
		}
		if(condition==(int)3){
			this.qigumingcheng="机构持股";
		}
	}

	public String getBankuaidaima() {
		return bankuaidaima;
	}

	public void setBankuaidaima(String bankuaidaima) {
		this.bankuaidaima = bankuaidaima;
	}

	public String getGupiaomingcheng() {
		return gupiaomingcheng;
	}

	public void setGupiaomingcheng(String gupiaomingcheng) {
		this.gupiaomingcheng = gupiaomingcheng;
	}
	public String getGupiaodaima() {
		return gupiaodaima;
	}

	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletRequest(HttpServletRequest request) {
		 this.request=request;
	}
	
	//testJPG
	public String testJPG() throws Exception{
		String tempurl = null;
		String url=null;
		String url_follow;
		String[] riqi;
		String[] urlriqi;
		
		PositionXY positionxy = new PositionXY();
		
		urlriqi=this.urldate.split("-");
		if(urlriqi.length==3){//网页日期有字符串
		    if(urlriqi[1].length()==1){//月份为一个数字
		    	urlriqi[1]="0"+urlriqi[1];//添加一个零
		    }
		    if(urlriqi[2].length()==1){//日为一个数字
		    	urlriqi[2]="0"+urlriqi[2];//添加一个零
		    }
	    	tempurl="http://gubit.cn/TopView/"+urlriqi[0].substring(2)+urlriqi[1]+urlriqi[2]+"/";
			url_follow=".jpg";
			
			
			BufferedImage bi;
				
			
			
			if(gupiaodaima==null || "".equals(gupiaodaima)){
				gupiaodaima="600000";
					
			}
			System.out.println(tempurl+gupiaodaima+url_follow);
			bi=ImageIO.read(MyTools.URLdownloadFile(tempurl+gupiaodaima+url_follow));
			
			positionxy=MyTools.initPositionXY(bi,positionxy);
		}
		List<PositionXY> list=new ArrayList();
		list.add(positionxy);
		request.setAttribute("positionxy",list);		
		return "showpositionxy";
	}
	/*
	
	public String getChichuangxinxi_blank() throws Exception{		
		List<ChichuangxinxiTemp> list=gupiaodao.getChichuangxinxi_blank(this.chichuangxinxidate);
		request.setAttribute("chichuangxinxitemp", list);
		return "chichuangxinxi_blank";
	}
	
	public String getMbcjgsjs_temp() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.getMbcjgsjs_temp();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="每笔成交股数预警，大于1.2并且当天价格为近期新高";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "每笔成交股数 ";
		this.column_namef = "当天换手率";
		this.column_nameg = "120天换手率 ";
		this.column_nameh = "当天/120天换手率 ";
		this.column_namei = "流通市值";
		this.column_namej = "预警";
		
		return "mbcjgsjs_temp";
	}
	public String getThreeDayDump() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findThreeDayDumpreturn();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="三天连续下跌预警";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "最高最低比 ";
		this.column_namef = "今天收盘最低比";
		this.column_nameg = "最低离现在天数";
		this.column_nameh = "当天换手/120";
		this.column_namei = "30天换手率 ";		
		this.column_namej = "120天换手率";
		
		return "mbcjgsjs_temp";
	}
	public String getGSHY() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findGSHYreturn();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="股性活跃预警";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "股性活跃 ";
		this.column_namef = "当天换手率";
		this.column_nameg = "120天换手率 ";
		this.column_nameh = "当天/120天换手率 ";
		this.column_namei = "30天/120天换手率";
		this.column_namej = "流通市值";	
		return "mbcjgsjs_temp";
	}
	public String getylbs() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.ylbs();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="盈利倍数";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "盈利倍数 ";
		this.column_namef = "无意义";
		this.column_nameg = "无意义 ";
		this.column_nameh = "无意义 ";
		this.column_namei = "无意义";
		this.column_namej = "无意义";	
		return "mbcjgsjs_temp";
	}*/
	public String openorstopsendemail() throws Exception{
		Procedurecondition procedurecondition=new Procedurecondition();
		procedurecondition.setProcedurethread("1");
		procedurecondition.setCondition(((Integer)this.condition).toString());
		gupiaoDAO.SaveObject(procedurecondition);
		return "index";
		
	}
	public String gettest() throws Exception{
		List<Inoutprice> list = gupiaoDAO.getInoutprice();
		request.setAttribute("inoutprice",list);
		return "test";
	}
	public String getfindlow() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaoDAO.findlow();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="找底";
		this.column_namea = "序号";
		this.column_nameb = "无意义";
		this.column_namec = "无意义";
		this.column_named = "日期 ";
		this.column_namee = "合条件数 ";
		this.column_namef = "无意义";
		this.column_nameg = "无意义 ";
		this.column_nameh = "无意义 ";
		this.column_namei = "无意义";
		this.column_namej = "无意义";	
		return "mbcjgsjs_temp";
	}
	public String getseilininput() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaoDAO.seilininput();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="找底";
		this.column_namea = "序号";
		this.column_nameb = "股票代码";
		this.column_namec = "类型";
		this.column_named = "日期 ";
		this.column_namee = "099 ";
		this.column_namef = "098";
		this.column_nameg = "0985 ";
		this.column_nameh = "097 ";
		this.column_namei = "CYC34";
		this.column_namej = "CYC55";	
		return "seilininput";
	}/*
	public String getMbcjgsjs_riqi() throws Exception{
		List<MbcjgsjsRiqi> list = gupiaodao.getMbcjgsjs_riqi(this.gupiaodaima);
		request.setAttribute("mbcjgsjs_riqi",list);
		return "mbcjgsjs_riqi";
	}
	public String testMbcjgsjsbl() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.testMbcjgsjsbl(this.gupiaodaima);
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="每笔成交股数突破顶预警";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "每笔成交股数 ";
		this.column_namef = "当天换手率";
		this.column_nameg = "120天换手率 ";
		this.column_nameh = "5天盈利";
		this.column_namei = "20天盈利";
		this.column_namej = "预警";
		
	
		return "mbcjgsjs_temp";
	}
	public String getfindGSHY() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findGSHY(this.gupiaodaima);
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="股性活跃预警";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "股性活跃 ";
		this.column_namef = "当天换手率";
		this.column_nameg = "120天换手率 ";
		this.column_nameh = "当天/120天换手率 ";
		this.column_namei = "30天/120天换手率";
		this.column_namej = "流通市值";	
		
		return "mbcjgsjs_temp";
	}
	public String getfindThreeDayDump() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findThreeDayDump(this.gupiaodaima);
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="连续三天下跌";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "最高最低比 ";
		this.column_namef = "最低离现在天数";
		this.column_nameg = "120天换手率 ";
		this.column_nameh = "当天换手/120 ";
		this.column_namei = "5天盈利";
		this.column_namej = "40天盈利";
		
	
		
		return "mbcjgsjs_temp";
	}
	public String getfindmbcjgsjsbscyc30() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findmbcjgsjsbscyc30(this.gupiaodaima);
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="mbcjgsjsbscyc30";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "震荡天数";
		this.column_namef = "无意义";
		this.column_nameg = "无意义 ";
		this.column_nameh = "无意义 ";
		this.column_namei = "无意义";
		this.column_namej = "无意义";
		
	
		
		return "mbcjgsjs_temp";
	}
	public String getfindchaodie() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findchaodie();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="mbcjgsjsbscyc30";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "最新收盘价";
		this.column_namef = "120天内最高收盘价";
		this.column_nameg = "0.77倍最高收盘价 ";
		this.column_nameh = "0.67倍最高收盘价 ";
		this.column_namei = "无意义";
		this.column_namej = "无意义";
		
	
		
		return "mbcjgsjs_temp";
	}
	public String getfindTwoLow() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findTwoLow();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="个股双底";
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "最高最低比 ";
		this.column_namef = "最低离现在天数";
		this.column_nameg = "120天换手率 ";
		this.column_nameh = "当天换手/120 ";
		this.column_namei = "5天盈利";
		this.column_namej = "40天盈利";
		
	
		
		return "mbcjgsjs_temp";
	}
	
	
	@Test
	public void mytest() throws Exception{
		
		String tempstr,tempsinajs="";
		String[] sinajs;
		String[] sinashuju;
		String   hashmapkey;
		//String tstr="";
		String tempurl="";
		int i_count,i_position;
		HashMap hashmap=new HashMap();
		List newlist = new ArrayList();
		//List<MbcjgsjsTemporary> list = gupiaodao.getfindZUIDICYC13return();
		
		System.out.println("OK");
	}
	*/
	public String setseilininput(){
		request.setAttribute("guiaodaima",this.gupiaodaima);
		request.setAttribute("mbcjgs",this.mbcjgs);
		request.setAttribute("mbcjgs5",this.mbcjgs5);
		request.setAttribute("mbcjgs10",this.mbcjgs10);
		request.setAttribute("mbcjgs30",this.mbcjgs30);
		request.setAttribute("mbcjgs120",this.mbcjgs120);
		request.setAttribute("cyc",this.cyc);
		return "setseilininput";
		
		
	}
	public String seilinother(){
		Inoutprice inoutprice=new Inoutprice();
		inoutprice.setGupiaodaima(this.gupiaodaima);
		inoutprice.setRiqi(new   Date(System.currentTimeMillis()));
		
	    inoutprice.setLeixin("1");
	    if (this.condition==0)
	    	inoutprice.setBeizu("下跌0.9倍,跌到这价位可买进");
	    if (this.condition==1)
	    	inoutprice.setBeizu("下跌0.985倍,跌到这价位可买进");
	    if (this.condition==2)
	    	inoutprice.setBeizu("下跌0.98倍,跌到这价位可买进");
	    if (this.condition==3)
	    	inoutprice.setBeizu("下跌0.97倍,跌到这价位可买进");
	    if (this.condition==4)
	    	inoutprice.setBeizu("下跌到CYC34,跌到这价位可买进");
	    if (this.condition==5)
	    	inoutprice.setBeizu("下跌到CYC55,跌到这价位可买进");
		inoutprice.setPrice(this.price);
		gupiaoDAO.SaveObject(inoutprice);
		List<MbcjgsjsTemporary> list = gupiaoDAO.seilininput();
		request.setAttribute("mbcjgsjs_temp",list);
		this.gupiaomingcheng ="找底";
		this.column_namea = "序号";
		this.column_nameb = "股票代码";
		this.column_namec = "类型";
		this.column_named = "日期 ";
		this.column_namee = "099 ";
		this.column_namef = "098";
		this.column_nameg = "0985 ";
		this.column_nameh = "097 ";
		this.column_namei = "CYC34";
		this.column_namej = "CYC55";	
		return "seilininput";
	}
	
	public String seilin(){
		Inoutprice inoutprice=new Inoutprice();
		inoutprice.setGupiaodaima(this.gupiaodaima);
		inoutprice.setRiqi(new   Date(System.currentTimeMillis()));
		
	    inoutprice.setLeixin("1");
	    inoutprice.setBeizu("跌到这价位可买进");
	  
		inoutprice.setPrice(this.price);
		gupiaoDAO.SaveObject(inoutprice);
		return "seilin";
		/*if (this.condition==0)			
			return "seiloutinoutprice";
		else
			return "seilininoutprice";*/
	}
	
	public String seilout(){//股票卖出
		Inoutprice inoutprice=new Inoutprice();
		inoutprice.setGupiaodaima(this.gupiaodaima);
		inoutprice.setRiqi(new   Date(System.currentTimeMillis()));
		
		inoutprice.setLeixin("0");
	  
		inoutprice.setPrice(this.price);
		gupiaoDAO.SaveObject(inoutprice);
		return "seilout";
		
	}
	
	public void testjson() throws Exception{
		
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
	//	JSONArray arrayObj=new JSONArray();
	//	String[] str_temp =new String[8];
	//	List list_gupiaoshuju=new ArrayList();
		  
		List list=gupiaoDAO.getgupiaoshuju(this.gupiaodaima);
		/*Iterator iter=list.iterator();
		while(iter.hasNext()){
			Gupiaoshuju gupiaoshuju=(Gupiaoshuju)iter.next();
			//str_temp[0]= Double.valueOf(format.format(gupiaoshuju.getRiqi())).doubleValue();
			//str_temp[0]=format.format(gupiaoshuju.getRiqi());
			//str_temp[1] = gupiaoshuju.getKaipan().toString();
			//arrayObj.add(str_temp);
			list_gupiaoshuju.add(gupiaoshuju);
		}
		//request.setAttribute("testjson", arrayObj);
		*/
		list_gupiaoshuju =JSONArray.fromObject(list).toString();
		
		PrintWriter out = response.getWriter();
		
		out.println(list_gupiaoshuju);
		out.flush();
		out.close();
		/*for(int i=0;i<arrayObj.size();i++){
			  out.println(arrayObj.getString(i));
		}*/
		//return "testjson"; 
		
		
	}
	
	
	public String panduaninoutprice(String[] sinajs,HashMap<String,Inoutprice> hashmap_inoutprice,String hashmapkey,String str_msg){
		if (sinajs.length>4) {
			Inoutprice inoutprice=(Inoutprice)hashmap_inoutprice.get(hashmapkey);
			if("0".equals(inoutprice.getLeixin())){//判断是否有卖出													
				if(MyTools.StrToDouble(sinajs[4])>=inoutprice.getPrice()){		
					str_msg=str_msg+"买出"+hashmapkey+",";
					gupiaoDAO.deleteInoutprice(hashmapkey);																							
				}		
			}
			else{//判断是否有买入
				if(MyTools.StrToDouble(sinajs[3])>0){
					if(inoutprice.getPrice()>0){
						if(MyTools.StrToDouble(sinajs[3])<=inoutprice.getPrice()){
							str_msg=str_msg+"买入"+ hashmapkey+"设定价"+inoutprice.getPrice()+",现在价："+sinajs[3]+",设定内容："+inoutprice.getBeizu()+",";
							gupiaoDAO.deleteInoutprice(hashmapkey);
						}
					}
					else{
						double dou_cyc13=gupiaoDAO.getzuixincyc13(hashmapkey);
						if (dou_cyc13>=MyTools.StrToDouble(sinajs[3])){																												
							str_msg=str_msg+"买入"+ hashmapkey+"cyc13价"+dou_cyc13+",现在价："+sinajs[3]+",设定内容："+inoutprice.getBeizu()+",";
							gupiaoDAO.deleteInoutprice(hashmapkey);																							
						}
					}
				}
			}
		}
		return str_msg;
	}
	
	
	/*
	 * tempurl 网页链接,k=3股票现在价，k=4股票最高价，k=5股票最低价	 
	*/
	
	public List<MbcjgsjsTemporary> jiexiZUIDICYC13return(String tempurl,HashMap<String,MbcjgsjsTemporary> hashmap,int k)throws Exception {
		String[] sinashuju,sinajs;
		String tempsinajs;
		int    i_position;
		String hashmapkey;
		List<MbcjgsjsTemporary> newlist = new ArrayList<MbcjgsjsTemporary>();
		
		tempsinajs = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));//读取股票数据
		sinashuju=tempsinajs.split(";");                                      //把每个股票数据分开
		for(int i=0;i<sinashuju.length;i++){                                  //一个一个股票数据来分析
			i_position = sinashuju[i].indexOf("str");                         //定位头部
			if(i_position>0){
				hashmapkey=sinashuju[i].substring(i_position+6,i_position+12);//取出股票代码
				sinajs=sinashuju[i].split(",");                               //一个一个数据取出
				if(sinajs.length>0){
					if(hashmap.containsKey(hashmapkey)){                      //包含在HashMap中
						MbcjgsjsTemporary mbcjgsjs = (MbcjgsjsTemporary) hashmap.get(hashmapkey);//取出 
						if (sinajs.length>k&&mbcjgsjs.getMbcjgs120()!=null)  //保证不会出现异常  
							if (mbcjgsjs.getMbcjgs120()*1.01>=MyTools.StrToDouble(sinajs[k]) && MyTools.StrToDouble(sinajs[k])>0){//现在价和最低价才能这样比较，最高价这样不合适
								mbcjgsjs.setMbcjgs10(new Double(gupiaoDAO.getrzzgsfenxi(hashmapkey)));  //加入rzzgs表的结果
								mbcjgsjs.setCyc(MyTools.StrToDouble(sinajs[k]));                        //加入现在价或最低价
								newlist.add(mbcjgsjs);	                                                //加入返回值
							}
					}
												
				}
			}
		}
		return newlist;
	}
	
	 public void SendMailofInoutPrice(){
  	   
 	    String tempstr = "",tempurl="",tempsinajs="",str_msg="";
 	    String[] sinajs;
 		String[] sinashuju;
 		String   haspmapkey;
 		String email_msg="";
 	    int i_count = 0,i_position=0;
 	    HashMap<String,Inoutprice> haspmap=new HashMap<String,Inoutprice>();
 	
 	    
 	   
 	   
 	 
 	    	
 	    	
 	   
	    	    List<Inoutprice> list = gupiaoDAO.getInoutprice();	
	    	    
		  		if(!list.isEmpty()){
			  		
					Iterator<Inoutprice> iter=list.iterator();
					while(iter.hasNext()){
						Inoutprice inoutprice   = (Inoutprice) iter.next();
						haspmap.put(inoutprice.getGupiaodaima(),inoutprice);
						tempstr=inoutprice.getGupiaodaima();
						tempurl=MyTools.makeurl(tempurl,tempstr,i_count); 						
						i_count++;
					}
					
					
					try{
					
						tempsinajs = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));
						sinashuju=tempsinajs.split(";");
						for(int i=0;i<sinashuju.length;i++){
							i_position = sinashuju[i].indexOf("str");
							if(i_position>0){
								haspmapkey=sinashuju[i].substring(i_position+6,i_position+12);
								sinajs=sinashuju[i].split(",");
								if(sinajs.length>4){
									
									/*
									 * 卖出股票判断,最高价大于设定价,最高价在第五项sinajs[4],inoutprice.leixin='0'
									 */
									if("0".equals(((Inoutprice)haspmap.get(haspmapkey)).getLeixin())){
										if(MyTools.StrToDouble(sinajs[4])>=((Inoutprice)haspmap.get(haspmapkey)).getPrice()){
											str_msg=str_msg+haspmapkey+"卖出,";	
											email_msg=email_msg+str_msg;
											gupiaoDAO.deleteInoutprice(haspmapkey);
										}
									}
									else{
									/*
									 * 买入股票判断,当前价小于设定价,当前价在第四项sinajs[3],inoutprice.leixin='1',如果outprice.price=0,取对应股票的最新cyc13值，如果大于0，比较当前值。
									 */
										if(((Inoutprice)haspmap.get(haspmapkey)).getPrice()>0){
											if(MyTools.StrToDouble(sinajs[3])<=((Inoutprice)haspmap.get(haspmapkey)).getPrice()&&MyTools.StrToDouble(sinajs[3])>0){
												str_msg=str_msg+haspmapkey+"卖入,价格："+((Inoutprice)haspmap.get(haspmapkey)).getPrice()+","+((Inoutprice)haspmap.get(haspmapkey)).getBeizu();												
												email_msg=email_msg+str_msg;
												//MyTools.SendMail("股票买进卖出!zuidicyc13",str_msg);												
												str_msg="";
												gupiaoDAO.deleteInoutprice(haspmapkey);
											}
										}else{
											double dou_zuixincyc13=	gupiaoDAO.getzuixincyc13(haspmapkey);								
											if(MyTools.StrToDouble(sinajs[3])<=dou_zuixincyc13&&MyTools.StrToDouble(sinajs[3])>0){
												str_msg=str_msg+haspmapkey+"卖入,价格："+dou_zuixincyc13+","+((Inoutprice)haspmap.get(haspmapkey)).getBeizu();													
												email_msg=email_msg+str_msg;
												//MyTools.SendMail("股票买进卖出!zuidicyc13",str_msg);												
												str_msg="";
												gupiaoDAO.deleteInoutprice(haspmapkey);
											}
											
										}
									}
								}
							}
							
						}
					}catch(Exception e){
						
					}
					finally{
						if(email_msg.length()>1){
							MyTools.SendMail("股票买进卖出!zuidicyc13",email_msg);
						}
						
					}
		  		}
 	   
	 }
	
	
	
	
	
	public String getfindZUIDICYC13() throws Exception{
		String tempstr,tempsinajs="";		
		
		String   hashmapkey;
		//String tstr="";
		String tempurl="";
		int i_count;
		
		
		
		
		/*
		 * 加入更新whilework线程时间
		 */
		
		if(this.condition==3){
			gupiaoDAO.updateWhilework();
			SendMailofInoutPrice();
		}
		HashMap<String,MbcjgsjsTemporary> hashmap=new HashMap<String,MbcjgsjsTemporary>();
		List<MbcjgsjsTemporary> newlist = new ArrayList<MbcjgsjsTemporary>();
	//	HashMap<String,Inoutprice> hashmap_inoutprice=new HashMap<String,Inoutprice>();
		
		
		
		
		if(MyTools.isworktime()||this.condition==5)
		{  //加入判断系统时间,这有在股票开市时候才工作
			 
		//	 List<Inoutprice> list_inoutprice = gupiaoDAO.getInoutprice();
		//	 Iterator<Inoutprice> iter_inoutprice;
			 i_count = 0;
			 
			 /*
			  * 加入买出股票的监控
			  */
			 /*
			 iter_inoutprice=list_inoutprice.iterator();
			 while(iter_inoutprice.hasNext()){
				 Inoutprice inoutprice=(Inoutprice)iter_inoutprice.next();
				 tempstr=inoutprice.getGupiaodaima();
				 hashmap_inoutprice.put(tempstr, inoutprice);												
				 tempurl=MyTools.makeurl(tempurl,tempstr,i_count); 
				 i_count++;
			 }
			 */
			 List<MbcjgsjsTemporary> list = gupiaoDAO.getfindZUIDICYC13return();
			 Iterator<MbcjgsjsTemporary> iter;		
			 iter = list.iterator();
				
				while (iter.hasNext()) {
					
					MbcjgsjsTemporary mbcjgsjstemporary = (MbcjgsjsTemporary) iter.next();            
					tempstr = mbcjgsjstemporary.getGupiaodaima();
					hashmap.put(tempstr,mbcjgsjstemporary);
					if(i_count<100){
					//	if(!hashmap_inoutprice.containsKey(tempstr)){
							tempurl=MyTools.makeurl(tempurl,tempstr,i_count); 
							i_count++;
					//	}
					}
					else{		
					//	if(!hashmap_inoutprice.containsKey(tempstr)){
							tempurl=MyTools.makeurl(tempurl,tempstr,i_count);
					//	}
						i_count=0;
						List<MbcjgsjsTemporary> templistA = jiexiZUIDICYC13return(tempurl,hashmap,this.condition);
						Iterator<MbcjgsjsTemporary> tempiterA = templistA.iterator();
						while(tempiterA.hasNext()){
							MbcjgsjsTemporary mbcjgsjsTemporaryA  = (MbcjgsjsTemporary) tempiterA.next();   
							hashmapkey = mbcjgsjsTemporaryA.getGupiaodaima();
							newlist.add(mbcjgsjsTemporaryA);
							
						}
						
					}
				}	
				if(i_count>0){
					List<MbcjgsjsTemporary> templistB = jiexiZUIDICYC13return(tempurl,hashmap,this.condition);
					Iterator<MbcjgsjsTemporary> tempiterB = templistB.iterator();
					while(tempiterB.hasNext()){
						MbcjgsjsTemporary mbcjgsjsTemporaryB  = (MbcjgsjsTemporary) tempiterB.next();   
						hashmapkey = mbcjgsjsTemporaryB.getGupiaodaima();
						newlist.add(mbcjgsjsTemporaryB);
						
					}
							
				}
		}
		
		
		request.setAttribute("mbcjgsjs_temp",newlist);
		this.gupiaomingcheng ="实时监测";
		//this.gupiaomingcheng =tstr;	
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "买入日期 ";
		this.column_namef = "买入日期天数";
		this.column_nameg = "rzzgs结果 ";
		this.column_nameh = "买入当天涨跌幅";
		this.column_namei = "买入价";
		this.column_namej = "现在价";
		
	
		if(this.condition==3){
			return "mbcjgsjs_tempzuidicyc";
		}else
		{
			return "mbcjgsjs_tempzuidicycB";
		}
	}
	
	/*
	public String getfindCYC() throws Exception{
		List<MbcjgsjsTemporary> list = gupiaodao.findCYC(this.condition);
		request.setAttribute("mbcjgsjs_temp",list);
		if(this.condition == 0) {
			this.gupiaomingcheng ="CYC13";
		}
		if(this.condition == 1) {
			this.gupiaomingcheng ="CYC34";
		}
		if(this.condition == 2) {
			this.gupiaomingcheng ="CYC55";
		}
		if(this.condition == 3) {
			this.gupiaomingcheng ="CYC125";
		}
		if(this.condition == 4) {
			this.gupiaomingcheng ="CYC250";
		}
		this.column_namea = "序号";
		this.column_nameb = "代码";
		this.column_namec = "股票名称";
		this.column_named = "日期 ";
		this.column_namee = "收盘价 ";
		this.column_namef = "最低价";
		this.column_nameg = this.gupiaomingcheng;
		this.column_nameh = "无意义";
		this.column_namei = "无意义";
		this.column_namej = "无意义";
		
	
		
		return "mbcjgsjs_temp";
	}
	
	
	
	public String getEXPMA() throws Exception{
		gupiaodao.genericexpma(this.gupiaodaima);			
		return "expma";
	}
	
	
	public String getDuiyingwarning() throws Exception{		
		List<GudongshuTemporary> list=gupiaodao.getDuiyingwarning(this.bankuaidaima,this.condition);
		request.setAttribute("gudongshutemporary", list);
		return "gudongshuwarning";
	}
	public String getGudongshuwarning() throws Exception{
		List<GudongshuTemporary> list=gupiaodao.getGudongshuwarning(this.condition);
		request.setAttribute("gudongshutemporary", list);
		return "gudongshuwarning";
	}
	public String getSuperviewwarning() throws Exception{
		List<GudongshuTemporary> list=gupiaodao.getSuperviewwarning(this.condition);
		request.setAttribute("gudongshutemporary", list);
		return "gudongshuwarning";
	}
	*/
	

	
	

}
