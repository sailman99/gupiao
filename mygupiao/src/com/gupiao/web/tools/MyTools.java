//

package com.gupiao.web.tools;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

import com.gupiao.model.persist.entity.Dazhongjiaoyi;
import com.gupiao.model.persist.entity.Gaokao_xyst;
import com.gupiao.model.persist.entity.Gubanjiegou;
import com.gupiao.model.persist.entity.Rzzgs;









public class MyTools {
	
	  
    public static class SearchAndReturn{
		private String str_search;  //传进要被搜索的字符串
		private String str_position1;//初始定位
		private String str_position2;//准确定位开始
		private String str_position3;//准确定位结束
		private String str_return;//结果
		private int int_position;
		
		public int getInt_position() {
			return int_position;
		}
		public String search(){
			if(!isNullOrEmpty(str_position1)){
				int_position = str_search.indexOf(str_position1);//初始定位
				if(int_position>-1)
					str_search=str_search.substring(int_position+str_position1.length());//截取后一段
				else
					return null;				
			}
			int_position = str_search.indexOf(str_position2);//准确定位开始
			if(int_position>-1){
				str_search=str_search.substring(int_position+str_position2.length());//截取后一段
				int_position = str_search.indexOf(str_position3);
				if(int_position>-1){
					str_return=str_search.substring(0,int_position);
					str_search=str_search.substring(int_position+str_position3.length());//截取后一段
					return str_return;
				}
			}
			return null;
			
		}
		public void str_split(){//利用初始定位截取后一段
			if(!isNullOrEmpty(str_position1)){
				int_position = str_search.indexOf(str_position1);
				str_search=str_search.substring(int_position+str_position1.length());//截取后一段
			}
		}
		public String getStr_search() {
			return str_search;
		}
		public void setStr_search(String str_search) {
			this.str_search = str_search;
		}
		public String getStr_position1() {
			return str_position1;
		}
		public void setStr_position1(String str_position1) {
			this.str_position1 = str_position1;
		}
		public String getStr_position2() {
			return str_position2;
		}
		public void setStr_position2(String str_position2) {
			this.str_position2 = str_position2;
		}
		public String getStr_position3() {
			return str_position3;
		}
		public void setStr_position3(String str_position3) {
			this.str_position3 = str_position3;
		}
		
		
	}
	
	
	
	 public static String getJiaoYiShuoYahoo(String gupiaodaima){//���ؽ�������
			if(MyTools.StrToDouble(gupiaodaima).intValue()<600000)
			{
				return "SZ";
			}else{
				return "SS";
			}
		}
	public static String inputStream2String(InputStream is){ 
		   if(!is.equals(null)){
			   BufferedReader in = new BufferedReader(new InputStreamReader(is)); 
			   StringBuffer buffer = new StringBuffer(); 
			   String line = ""; 
			   try{
				   while ((line = in.readLine()) != null){ 
				     buffer.append(line); 
				   }
			   }
			   catch(Exception e){
				   
			   }
			   return buffer.toString();
		   }
		   else return "";
	} 
	public static BufferedReader readHttps(String destUrl) throws IOException{
		
		URL url;
		 try {
			 
			 url = new URL(destUrl);
		     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
	 
		     BufferedReader br = 
		    			new BufferedReader(
		    				new InputStreamReader(con.getInputStream()));
		     return br;
	 
	      } catch (MalformedURLException e) {
		     e.printStackTrace();
	      } catch (IOException e) {
		     e.printStackTrace();
	      }
		 return null;
	}
	public static InputStream readHttmnew(String destUrl) throws IOException{
		ByteArrayInputStream bais = null;
		BufferedInputStream bis = null;
	    HttpURLConnection httpUrl = null;
	    URL url = null;
	    
	    //��������
	    try{
		    url = new URL(destUrl);
		   // System.out.println(destUrl);
		    httpUrl = (HttpURLConnection) url.openConnection();
		    httpUrl.setRequestProperty("Cookie", "userid=179275&password=FoEi85zsbqGBClcI1YZQWtoa665CZ8ftFj4d517D6w1mdldYF016SQ%3d%3d&tpp=0&ppp=0&pmsound=0&invisible=0&referer=index.aspx&sigstatus=0&expires=5256000");
		    // httpUrl.setFollowRedirects(true);
		    httpUrl.setRequestMethod("GET"); 
		    httpUrl.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
		   
		    //����ָ������Դ
		    httpUrl.connect();
		    //��ȡ����������
		    bis = new BufferedInputStream(httpUrl.getInputStream());
		    
		    //is = new InputStream(bis);
		    
		   
		    ByteArrayOutputStream swapStream = new ByteArrayOutputStream();

		    byte[] buff = new byte[100]; //buff���ڴ��ѭ����ȡ����ʱ���

		    int rc = 0;

		    while ((rc = bis.read(buff, 0, 100)) > 0) {

		    	swapStream.write(buff, 0, rc);

		    }
		    bais  = new ByteArrayInputStream(swapStream.toByteArray());   
		    if(!bis.equals(null)) bis.close();
	    }
	    catch(Exception e){
	    	
	    }
	    
	    
	    httpUrl.disconnect();
	    return bais;
		
	}
	
	public static String readHttm(String url){
		
		
		
		
		   
		//ȡ����ҳ����
		String str = null;
//		 ����HttpClient��ʵ��
		HttpClient httpClient = new HttpClient();
	//	httpClient.getParams().setParameter(
	//		      HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
		// ����GET������ʵ��
		
		GetMethod getMethod = new GetMethod(url);
		// ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			// ִ��getMethod
			int statusCode = httpClient.executeMethod(getMethod);
//			if (statusCode != HttpStatus.SC_OK) {
//				System.err.println("Method failed: "
//						+ getMethod.getStatusLine());
//			}


			if (statusCode == HttpStatus.SC_OK) {

				// ��ȡ����

				byte[] responseBody = getMethod.getResponseBody();
				//BufferedReader in = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream(),get.getResponseCharSet()));
				// ��������
				str=new String(responseBody);
			}
		} catch (HttpException e) {
			// ����������쳣��������Э�鲻�Ի��߷��ص�����������
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			// ���������쳣
			e.printStackTrace();
		} finally {
			// �ͷ�����
			getMethod.releaseConnection();
		}
			return str;
	}
	 public static String jieXiip_loveroot(String str){
	    	int position;
	    	position = str.indexOf("�ٷ���ݲ�ѯ���");
	    	if( position>0) {
	    		str=str.substring(position+10);
	    		position = str.indexOf("&nbsp;");
	    		if(position>0){
	    			str=str.substring(0,position);
	    			return str;
	    		}
	    	}
	    	return null;
	}
	 
	 public static String convertStringToUTF8(String s) {
			if (s == null || s.equals("")) {
				return null;
			}
			StringBuffer sb = new StringBuffer();
			try {
				char c;
				for (int i = 0; i < s.length(); i++) {
					c = s.charAt(i);
					if (c >= 0 && c <= 255) {
						sb.append(c);
					} else {
						byte[] b;
						b = Character.toString(c).getBytes("utf-8");
						for (int j = 0; j < b.length; j++) {
							int k = b[j];
							//转换为unsigned integer  无符号integer
							/*if (k < 0)
								k += 256;*/
							k = k < 0? k+256:k;
							//返回整数参数的字符串表示形式 作为十六进制（base16）中的无符号整数
							//该值以十六进制（base16）转换为ASCII数字的字符串
							sb.append(Integer.toHexString(k).toUpperCase());
		 
							// url转置形式
							// sb.append("%" +Integer.toHexString(k).toUpperCase());
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sb.toString();
	 }
	public static Gaokao_xyst jiexiXYST(String https_url) {
		System.out.println(https_url);
		URL url;
	      try {
		     url = new URL(https_url);
		     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		     try {
		    	 BufferedReader br = 
		    			new BufferedReader(
		    				new InputStreamReader(con.getInputStream()));
		    		   String input;
		    		   StringBuffer sb = new StringBuffer();
		    		   while ((input = br.readLine()) != null){
		    		       sb.append(input);
		    		   }
		    		   
		    		   String pattern = "</a></div><div class=\"content\"><div class=\"section-content\">";
		    		      // 创建 Pattern 对象
		    		   Pattern r = Pattern.compile(pattern);
		    		 
		    		      // 现在创建 matcher 对象
		    		   Matcher m = r.matcher(sb);
		    		  
		    		   String problems=null,answers=null,analyzes=null;
		    		   String surplus="";//存剩余部分
		    		   
		    		   if(m.find()) {//搜问题
		    			   surplus=sb.substring(m.end());//取剩余部分
		    			   System.out.println("surplus_1:"+surplus);
		    			   pattern = "<div class=\"section-seperator\"></div><div class=\"section-header\">";
			    		   r = Pattern.compile(pattern);
			    		   m = r.matcher(surplus);
			    		   if(m.find()) {
			    			   //取出问题
			    			   problems=surplus.substring(0, m.start());
			    			   surplus=surplus.substring(m.end());//取剩余部分
			    			   System.out.println("surplus_2:"+surplus);
			    		   }
			    		    pattern = "</div><div class=\"section-content\">";//去除多余部分
				    	    r = Pattern.compile(pattern);
				    	    m = r.matcher(surplus);
				    	    if(m.find()) {//去除多余部分
				    		  surplus=surplus.substring(m.end());//取剩余部分
				    		  System.out.println("surplus_3:"+surplus);
				    	    }
				    	    pattern = "解析</div><div class=\"section-content\">";
					        r = Pattern.compile(pattern);
					    	m = r.matcher(surplus);
					    	if(m.find()) {
					    		answers=surplus.substring(0,m.start());
					    		surplus=surplus.substring(m.end());//取剩余部分
					    		System.out.println("surplus_4:"+surplus);
					    	}else {
					    		pattern = "解析:</div><div class=\"section-content\">";
						    	r = Pattern.compile(pattern);
						    	m = r.matcher(surplus);
						    	if(m.find()) {
						    		answers=surplus.substring(0,m.start());
						    		surplus=surplus.substring(m.end());//取剩余部分
						    		System.out.println("surplus_5:"+surplus);
						    	}
						    		   
					    	}
					    	answers=answers.replaceAll("</p></div><div class=\"section-seperator\">", "</p>").replaceAll("</p></div><div class=\"section-content\">", "</p>").replaceAll("</p></div><div class=\"section-header\">", "</p>");
					    	answers=answers.replaceAll("</div><div class=\"section-seperator\"></div><div class=\"section-header\">", "");
					    	answers=answers.replaceAll("</div><div class=\"section-content\">", "");
					    	
					    	pattern = "</div><div class=\"vip-content-wrapper\">";
					    	r = Pattern.compile(pattern);
					    	m = r.matcher(surplus);
					    	if(m.find()) {
					    		analyzes=surplus.substring(0,m.start());
					    	}else {
					    		pattern = "</div><div class=\"vip-toast\">";
						    	r = Pattern.compile(pattern);
						    	m = r.matcher(surplus);
						    	if(m.find()) {
						    		analyzes=surplus.substring(0,m.start());
						    	}
					    	}
					    		   
				    	}
		    			//gupiaoDAO.insertGaokao_xyst(https_url, problems, answers, analyzes);	   
		    		   br.close();
		    		   Gaokao_xyst gaokao_xyst=new Gaokao_xyst();
		    		   gaokao_xyst.setUrl(https_url);
		    		   gaokao_xyst.setProblems(problems);
		    		   gaokao_xyst.setAnswers(answers);
		    		   gaokao_xyst.setAnalyzes(analyzes);
		    		   return gaokao_xyst;
		    		} catch (IOException e) {
		    		   e.printStackTrace();
		    		}
	      } catch (MalformedURLException e) {
		     e.printStackTrace();
	      } catch (IOException e) {
		     e.printStackTrace();
	      }
	      return null;
	}
	public static class Chichuangxinxi_tmp{
		private Double sanhu;
		private Double zhonghu;
		private Double dahu;
		private Double faren;
		private Double jigou;
		public Double getSanhu() {
			return sanhu;
		}
		public void setSanhu(Double sanhu) {
			this.sanhu = sanhu;
		}
		public Double getZhonghu() {
			return zhonghu;
		}
		public void setZhonghu(Double zhonghu) {
			this.zhonghu = zhonghu;
		}
		public Double getDahu() {
			return dahu;
		}
		public void setDahu(Double dahu) {
			this.dahu = dahu;
		}
		public Double getFaren() {
			return faren;
		}
		public void setFaren(Double faren) {
			this.faren = faren;
		}
		public Double getJigou() {
			return jigou;
		}
		public void setJigou(Double jigou) {
			this.jigou = jigou;
		}
		
	}
	public static class PositionXY{
		
//		���ʺŷ���
		private int[] lzhfl={-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		private int   lzhfl_width=60;//���ʺŷ���gifͼ��width
		private int   lzhfl_height=14;//���ʺŷ���gifͼ��height
//		����ֲ�
		private int[] flcq={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		private int   flcq_width=48;//����ֲ�gifͼ��width
		private int   flcq_height=14;//����ֲ�gifͼ��height
//		ʶ�����ֹؼ��
		private int[] gjd={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216};
		private int   gjd_width=10;//�ؼ��gifͼ��width
		private int   gjd_height=6;//�ؼ��gifͼ��height
		
		//�ʻ���
		private int[] zfs={-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216};
		private int   zfs_width=36;//�ʻ���gifͼ��width
		private int   zfs_height=14;//�ʻ���gifͼ��height
		
		
		private int X1;//ɢ����X���
		private int X2;//�л���X���
		private int X3;//����X���
		private int X4;//������X���
		private int Y1;//�ɶ����Y���
		private int X11;//ɢ������X���
		private int X12;//�л�����X���
		private int X13;//�󻧱���X���
		private int X14;//���˱���X���
		private int X15;//�����X���
		private int Y11;//����Y���
		private int X;//��ʱ�õ�
		private int Y;//��ʱ�õ�
		
		private int gif_width;//gifͼƬwidth
		private int gif_height;//gifͼƬheigth
		
		
		
		
		public int getGif_height() {
			return gif_height;
		}
		public void setGif_height(int gif_height) {
			this.gif_height = gif_height;
		}
		public int getGif_width() {
			return gif_width;
		}
		public void setGif_width(int gif_width) {
			this.gif_width = gif_width;
		}
		public int[] getZfs() {
			return zfs;
		}
		public void setZfs(int[] zfs) {
			this.zfs = zfs;
		}
		public int getZfs_height() {
			return zfs_height;
		}
		public void setZfs_height(int zfs_height) {
			this.zfs_height = zfs_height;
		}
		public int getZfs_width() {
			return zfs_width;
		}
		public void setZfs_width(int zfs_width) {
			this.zfs_width = zfs_width;
		}
		public int[] getGjd() {
			return gjd;
		}
		public void setGjd(int[] gjd) {
			this.gjd = gjd;
		}
		public int getGjd_height() {
			return gjd_height;
		}
		public void setGjd_height(int gjd_height) {
			this.gjd_height = gjd_height;
		}
		public int getGjd_width() {
			return gjd_width;
		}
		public void setGjd_width(int gjd_width) {
			this.gjd_width = gjd_width;
		}
		public int[] getFlcq() {
			return flcq;
		}
		public void setFlcq(int[] flcq) {
			this.flcq = flcq;
		}
		public int getFlcq_height() {
			return flcq_height;
		}
		public void setFlcq_height(int flcq_height) {
			this.flcq_height = flcq_height;
		}
		public int getFlcq_width() {
			return flcq_width;
		}
		public void setFlcq_width(int flcq_width) {
			this.flcq_width = flcq_width;
		}
		public int[] getLzhfl() {
			return lzhfl;
		}
		public void setLzhfl(int[] lzhfl) {
			this.lzhfl = lzhfl;
		}
		public int getLzhfl_height() {
			return lzhfl_height;
		}
		public void setLzhfl_height(int lzhfl_height) {
			this.lzhfl_height = lzhfl_height;
		}
		public int getLzhfl_width() {
			return lzhfl_width;
		}
		public void setLzhfl_width(int lzhfl_width) {
			this.lzhfl_width = lzhfl_width;
		}
		public int hashCode(){
			return   1;   
		} 
		public boolean equals(PositionXY positionxy){
			if(this.X1==positionxy.X1 && this.X2==positionxy.X2 && this.X3==positionxy.X3 && this.X4==positionxy.X4)
			return true;
			return false;
		}
		public int getX() {
			return X;
		}
		public void setX(int x) {
			X = x;
		}
		public int getX1() {
			return X1;
		}
		public void setX1(int x1) {
			X1 = x1;
		}
		public int getX11() {
			return X11;
		}
		public void setX11(int x11) {
			X11 = x11;
		}
		public int getX12() {
			return X12;
		}
		public void setX12(int x12) {
			X12 = x12;
		}
		public int getX13() {
			return X13;
		}
		public void setX13(int x13) {
			X13 = x13;
		}
		public int getX14() {
			return X14;
		}
		public void setX14(int x14) {
			X14 = x14;
		}
		public int getX15() {
			return X15;
		}
		public void setX15(int x15) {
			X15 = x15;
		}
		public int getX2() {
			return X2;
		}
		public void setX2(int x2) {
			X2 = x2;
		}
		public int getX3() {
			return X3;
		}
		public void setX3(int x3) {
			X3 = x3;
		}
		public int getX4() {
			return X4;
		}
		public void setX4(int x4) {
			X4 = x4;
		}
		public int getY() {
			return Y;
		}
		public void setY(int y) {
			Y = y;
		}
		public int getY1() {
			return Y1;
		}
		public void setY1(int y1) {
			Y1 = y1;
		}
		public int getY11() {
			return Y11;
		}
		public void setY11(int y11) {
			Y11 = y11;
		}
		
		
		
		
	}
	public static PositionXY position(BufferedImage bi,int[] png,int i_begin,int i_leng,int k_begin,int k_leng,int width,int height){
		
		/*
		 * ƥ��ͼƬ������ƥ����ʼλ��
		 * bi ͼƬ
		 * pngƥ��ͼƬ����
		 * i_begin��bi ͼƬ��һ�����꿪ʼƥ��
		 * k_begin��bi ͼƬ��һ�����꿪ʼƥ��
		 * widthƥ��ͼƬ�Ŀ�
		 * heightƥ��ͼƬ�ĸ�
		*/
		
		boolean find = false;//�Ƿ��Ѿ�ƥ��
		int int_tmp=0;
		PositionXY positionxy=new PositionXY();
		int tar_width = bi.getWidth();//����ͼƬ�Ŀ�
		int tar_height = bi.getHeight();//����ͼƬ�ĸ�
		
		int i_minleng=i_leng>tar_width?tar_width:i_leng;
		int k_minleng=k_leng>tar_height?tar_height:k_leng;
		
		
		
		
		for(int i=i_begin;i<i_minleng-width;i++){//��ָ����X��꿪ʼƥ��,��..Ϊֹ
    		for(int k=k_begin;k<k_minleng-height;k++){//��ָ����Y��꿪ʼƥ��,��..Ϊֹ
    			int count=0;//ƥ��������
    			for(int m=0;m<width;m++){//һ��width��
    				boolean breakout=false;//���ƥ�䣬�������һ��
    				for(int n=0;n<height;n++){//һ��height��
    					int_tmp=bi.getRGB(i+m, k+n);
    					//System.out.println(count);
    					//if(int_tmp!=png[count])//���ƥ��,���һ��FOR���
    					if(!(((int_tmp<-10000000)&&(png[count]<-10000000))||((int_tmp>-10000000)&&(png[count]>-10000000))))//ͬʱС�ڻ���ڲų���
    					{
    						//count=0;
    						breakout=true;
    						break;
    					}
    					count++;
    				}
    				if(breakout){
    					break;//���
    				}
    			}
    			if (count==width*height){//��ȫƥ��
    				//System.out.println(count);    				
    				positionxy.setX(i);
    				positionxy.setY(k);
    				find = true;//ƥ��
    				break;//���
    			}
    		}
    		if(find){
    			break;//�����
    		}	
    		
    	}
		return positionxy;

		
	}
	public static int position_X(BufferedImage bi,int i_begin,int k_begin) {
		/*
		 * ����ɶ������ʼλ��
		 */
		int int_position_x=0;
		
		int int_tmp[]=new int[60];
		for(int i=i_begin;i<bi.getWidth()-6;i++){
			int count=0;//����
			for(int m=0;m<6;m++){//һ��width��
				for(int n=0;n<10;n++){//һ��height��
					int_tmp[count]=bi.getRGB(i+m,k_begin+n);
					count++;
			    	}
			}
			if(MyTools.comparisonGIF(int_tmp)!=null){
				int_position_x = i;
				break;
			}
		}
		return int_position_x;
			
	}

	public static PositionXY initPositionXY(BufferedImage bi,PositionXY po) throws Exception{//��λ������ݵĳ�ʼλ��
		
		PositionXY positionxy,tmp_positionxy ;
		int maxpix=10000;
		positionxy = po;
		tmp_positionxy = po;
		/*
		positionxy=position(bi,positionxy.getLzhfl(),0,maxpix,0,maxpix,positionxy.getLzhfl_width(),positionxy.getLzhfl_height());//��λ���ʺŷ��࣬�أ������������PositionXY.X,PositionXY.Y
		if(positionxy.getX()==0){
			return positionxy;
		}
		//��λ�ʻ���
		positionxy=position(bi,positionxy.getZfs(),positionxy.getX()-140,maxpix,positionxy.getY(),maxpix,positionxy.getZfs_width(),positionxy.getZfs_height());//��λ�ʻ���أ������������PositionXY.X,PositionXY.Y,�ùؼ�㶨λ
		if(positionxy.getX()==0){
			return positionxy;
		}
		
		
		 
		
		positionxy=position(bi,positionxy.getGjd(),positionxy.getX(),maxpix,positionxy.getY()-15,positionxy.getY()-15+40,positionxy.getGjd_width(),positionxy.getGjd_height());//��λ�ؼ��,��λ����أ������������PositionXY.X,PositionXY.Y,�ùؼ�㶨λ
		if(positionxy.getX()==0){
			return positionxy;
		}
		
		//��λ�ɶ���λ��,������X1��X2,X3,X4,Y1
		positionxy.setX1(position_X(bi,positionxy.getX(),positionxy.getY()+5));//����õ�����ݣ���������λ�ƣ�����λ
		positionxy.setX2(position_X(bi,positionxy.getX1()+42,positionxy.getY()+5));//�Ϊ������
		positionxy.setX3(position_X(bi,positionxy.getX2()+42,positionxy.getY()+5));//�Ϊ������
		positionxy.setX4(position_X(bi,positionxy.getX3()+42,positionxy.getY()+5));//�Ϊ������
		positionxy.setY1(positionxy.getY()+5);
		
		*/
		tmp_positionxy=position(bi,tmp_positionxy.getFlcq(),0,maxpix,0,maxpix,tmp_positionxy.getFlcq_width(),tmp_positionxy.getFlcq_height());//��λ����ֲ֣��أ������������PositionXY.X,PositionXY.Y
		//System.out.println(tmp_positionxy.getX());
		if(tmp_positionxy.getX()==0){
			return tmp_positionxy;
		}
		
		tmp_positionxy=position(bi,tmp_positionxy.getZfs(),tmp_positionxy.getX()-200,maxpix,tmp_positionxy.getY(),maxpix,tmp_positionxy.getZfs_width(),tmp_positionxy.getZfs_height());//��λ�ʻ���أ������������PositionXY.X,PositionXY.Y,�ùؼ�㶨λ
		//System.out.println(tmp_positionxy.getX());
		if(tmp_positionxy.getX()==0){
			return tmp_positionxy;
		}
		
		
		tmp_positionxy=position(bi,tmp_positionxy.getGjd(),tmp_positionxy.getX(),maxpix,tmp_positionxy.getY()-15,tmp_positionxy.getY()-15+40,tmp_positionxy.getGjd_width(),tmp_positionxy.getGjd_height());//��λ�ؼ��,��λ����أ������������PositionXY.X,PositionXY.Y,�ùؼ�㶨λ
		//System.out.println(tmp_positionxy.getX());
		if(tmp_positionxy.getX()==0){
			return tmp_positionxy;
		}
		//��λ����λ��,������X11,X12,X13,X14,X15,Y11
		positionxy.setX11(position_X(bi,tmp_positionxy.getX(),tmp_positionxy.getY()-10));//����õ�����ݣ���������λ��10����λ
		positionxy.setX12(position_X(bi,positionxy.getX11()+30,tmp_positionxy.getY()-10));//�Ϊ5����
		positionxy.setX13(position_X(bi,positionxy.getX12()+30,tmp_positionxy.getY()-10));//�Ϊ5����
		positionxy.setX14(position_X(bi,positionxy.getX13()+30,tmp_positionxy.getY()-10));//�Ϊ5����
		positionxy.setX15(position_X(bi,positionxy.getX14()+30,tmp_positionxy.getY()-10));//�Ϊ5����
		positionxy.setY11(tmp_positionxy.getY()-10);
		return positionxy;
	}

	public static Double getGuDongShu(BufferedImage bi,int X,int Y,int maxcharcount){//�ӣУΣ�ͼƬ�ļ��ж�ȡ��������Ϣ
		/*
		 * �����ж�ȡ�������
		 * is�ļ�������
		 * X,Y��ȡ����ʼ���
		 * maxcharcount���ɶ�ȡ�ַ���
		 * 
		 */

		
		
        String str_tmp="";
        int int_tmp[]=new int[60];
        
        try{
        	
        	
        	for(int i=0;i<maxcharcount;i++){//����ȡmaxcharcount��
        		for(int m=0;m<6;m++){//ͼƬ��С��6*10
        			for(int n=0;n<10;n++){
        				int_tmp[10*m+n]=bi.getRGB(X+m+6*i, Y+n);   //     				
        			}
        		}
        		String tmp=comparisonGIF(int_tmp);
        		if(tmp==null){
        			break;
        		}
        		str_tmp=str_tmp+tmp;
        	}
            
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }

		return StrToDouble(str_tmp);
	}
	
	public static String comparisonGIF(int[] int_tmp) {  //�Ƚ�GIFͼƬ
		
		String tmp=null;
	
		
		for(int i=0;i<int_tmp.length;i++){
			if (int_tmp[i]<-10000000)
			{
				int_tmp[i]=-16777216;
			}
			else
			{
				int_tmp[i]=-7894906;
			}
		}
		/*
		int[] png0={-16777216,-16777216,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png1={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png2={-16777216,-16777216,-4144960,-4144960,-16777216,-16777216,-16777216,-4144960,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png3={-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-4144960,-16777216,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,};
		int[] png4={-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-4144960,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png5={-16777216,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png6={-16777216,-16777216,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-4144960,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png7={-16777216,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png8={-16777216,-16777216,-4144960,-4144960,-16777216,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-4144960,-16777216,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] png9={-16777216,-16777216,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-4144960,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-4144960,-4144960,-4144960,-4144960,-4144960,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
	//	int[] pngx={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		int[] pngdot={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-4144960,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		*/
		
		
		
		
//		����1    6*10
		int[] png1={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};

		//����2    6*10
		int[] png2={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216};

		//����3    6*10
		int[] png3={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216};

		//		����4   6*10
		int[] png4={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-16777216};
		
		
		//����5    6*10

		int[] png5={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216};


		//����6    6*10
		int[] png6={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216};

		
		//����7    6*10
		int[] png7={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};

		
		//����8    6*10
		int[] png8={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216};


		//����9    6*10
		int[] png9={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-7894906,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216};


//		����0   6*10
		int[] png0={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-7894906,-7894906,-7894906,-7894906,-7894906,-7894906,-16777216,-16777216};


		//����dot   6*10
		int[] pngdot={-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-7894906,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216};
		
		
		
		if(Arrays.equals(int_tmp, png0)){
			tmp="0";
		}
		if(Arrays.equals(int_tmp, png1)){
			tmp="1";
		}
		if(Arrays.equals(int_tmp, png2)){
			tmp="2";
		}
		if(Arrays.equals(int_tmp, png3)){
			tmp="3";
		}
		if(Arrays.equals(int_tmp, png4)){
			tmp="4";
		}
		if(Arrays.equals(int_tmp, png5)){
			tmp="5";
		}
		if(Arrays.equals(int_tmp, png6)){
			tmp="6";
		}
		if(Arrays.equals(int_tmp, png7)){
			tmp="7";
		}
		if(Arrays.equals(int_tmp, png8)){
			tmp="8";
		}
		if(Arrays.equals(int_tmp, png9)){
			tmp="9";
		}
		//if(Arrays.equals(int_tmp,pngx)){
		//	tmp="X";
		//}
		if(Arrays.equals(int_tmp, pngdot)){
			tmp=".";
		}
		return tmp;
	}
	
	
	
	
	
	
	
	
	
	public static String comparisonPNG(BufferedImage bi) throws Exception{  //�ȽϣУΣ�ͼƬ
		
		String tmp=null;
		int m = 0;
		int int_tmp[]=new int[72];
		int[] png0={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-16777216,-1,-1,-1,-1};
		int[] png1={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1};
		int[] png2={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-1,-1,-1,-16777216,-1,-1};
		int[] png3={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-16777216,-16777216,-16777216,-1,-1,-1};
		int[] png4={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1};
		int[] png5={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-16777216,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-16777216,-16777216,-16777216,-1,-1,-1};
		int[] png6={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-16777216,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-16777216,-16777216,-16777216,-1,-1,-1};
		int[] png7={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-16777216,-1,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-1};
		int[] png8={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-16777216,-16777216,-16777216,-1,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-16777216,-16777216,-16777216,-1,-1,-1};
		int[] png9={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-1,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-1,-16777216,-1,-1,-1,-1,-16777216,-1,-1,-1,-16777216,-1,-16777216,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-16777216,-16777216,-16777216,-1,-1,-1,-1};
		int[] pngdot={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-16777216,-16777216,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		for(int i=0;i<6;i++){
    		for(int k=0;k<12;k++){
    			int_tmp[m]=bi.getRGB(i, k);
    			m++;
    		}
    	}
		
		if(Arrays.equals(int_tmp, png0)){
			tmp="0";
		}
		if(Arrays.equals(int_tmp, png1)){
			tmp="1";
		}
		if(Arrays.equals(int_tmp, png2)){
			tmp="2";
		}
		if(Arrays.equals(int_tmp, png3)){
			tmp="3";
		}
		if(Arrays.equals(int_tmp, png4)){
			tmp="4";
		}
		if(Arrays.equals(int_tmp, png5)){
			tmp="5";
		}
		if(Arrays.equals(int_tmp, png6)){
			tmp="6";
		}
		if(Arrays.equals(int_tmp, png7)){
			tmp="7";
		}
		if(Arrays.equals(int_tmp, png8)){
			tmp="8";
		}
		if(Arrays.equals(int_tmp, png9)){
			tmp="9";
		}
		if(Arrays.equals(int_tmp, pngdot)){
			tmp=".";
		}
		return tmp;
	}
	
	public static Chichuangxinxi_tmp jieXiChichuangxinxi(InputStream is,PositionXY positionxy) throws Exception{

		/*
		 * 
		 * positionxy Ҫ��ȡ�ĸ�����ݵ�λ��
		 * positionxy.X1ɢ����
		 * positionxy.X2�л���
		 * positionxy.X3����
		 * positionxy.X4������
		 * positionxy.Y1
		 * positionxy.X11
		 * positionxy.X12
		 * positionxy.X13
		 * positionxy.X14
		 * positionxy.X15
		 * positionxy.Y11
		 */
		
		
        
		Chichuangxinxi_tmp chichuangxinxi_tmp=new Chichuangxinxi_tmp() ;
        try{
        	
        	
//        	 ȡ��ͼƬ������
        	
        	BufferedImage bi = ImageIO.read(is);
        	
        	
           
        	
        
            //ɢ������           
             
        	chichuangxinxi_tmp.setSanhu(getGuDongShu(bi,positionxy.getX11(),positionxy.getY11(),5));//��ͼƬ�ж�ȡ��ݣ�����ʼλ�ã���������
            //�л�����
            
        	chichuangxinxi_tmp.setZhonghu(getGuDongShu(bi,positionxy.getX12(),positionxy.getY11(),5));//��ͼƬ�ж�ȡ��ݣ�����ʼλ�ã���������
            //�󻧱���
           
        	chichuangxinxi_tmp.setDahu(getGuDongShu(bi,positionxy.getX13(),positionxy.getY11(),5));//��ͼƬ�ж�ȡ��ݣ�����ʼλ�ã���������
            //���˱���
            
        	chichuangxinxi_tmp.setFaren(getGuDongShu(bi,positionxy.getX14(),positionxy.getY11(),5));//��ͼƬ�ж�ȡ��ݣ�����ʼλ�ã���������
            //�����
          
        	chichuangxinxi_tmp.setJigou(getGuDongShu(bi,positionxy.getX15(),positionxy.getY11(),5));//��ͼƬ�ж�ȡ��ݣ�����ʼλ�ã���������
            
            
            
           
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
		return chichuangxinxi_tmp;
	}
	
	
	
	//�ַ�"2016-01-16"ת�������� "2016-01-16"
	public static java.sql.Date strToDate(String aStrValue){
		 String str_year,str_month,str_day;
		 aStrValue=aStrValue.replaceAll("/","").replaceAll("-","").replaceAll(" ","");
		 if(aStrValue.length()==8){
				str_year =aStrValue.substring(0,4);
				str_month=aStrValue.substring(4,6);
				str_day=aStrValue.substring(6);
				
				GregorianCalendar da = new GregorianCalendar(StrToDouble(str_year).intValue(),StrToDouble(str_month).intValue()-1,StrToDouble(str_day).intValue(),21,0,0);   
				
				java.util.Date time = da.getTime();   
				java.sql.Date sqlDate = new java.sql.Date(time.getTime()); 				
				return sqlDate;
		 }
		 return null;
     }  
	//�ַ�"2016-01-16"ת�������� "2016-01-16 21:00:00"
	public static java.util.Date strToDateTime(String aStrValue){
		 String str_year,str_month,str_day;
		 aStrValue=aStrValue.replaceAll("/","").replaceAll("-","").replaceAll(" ","");
		 if(aStrValue.length()==8){
				str_year =aStrValue.substring(0,4);
				str_month=aStrValue.substring(4,6);
				str_day=aStrValue.substring(6);
				
				GregorianCalendar da = new GregorianCalendar(StrToDouble(str_year).intValue(),StrToDouble(str_month).intValue()-1,StrToDouble(str_day).intValue(),21,0,0);   
				
				java.util.Date time = da.getTime();   
							
				return time;
		 }
		 return null;
    }  
	public static InputStream URLdownloadFile(String destUrl) throws IOException{//�����ļ����һ����
		ByteArrayInputStream bais = null;
		BufferedInputStream bis = null;
	    HttpURLConnection httpUrl = null;
	    URL url = null;
	    
	    //��������
	    try{
		    url = new URL(destUrl);
		   // System.out.println(destUrl);
		    httpUrl = (HttpURLConnection) url.openConnection();
		    //����ָ������Դ
		    httpUrl.connect();
		    //��ȡ����������
		    bis = new BufferedInputStream(httpUrl.getInputStream());
		    
		    //is = new InputStream(bis);
		    
		   
		    ByteArrayOutputStream swapStream = new ByteArrayOutputStream();

		    byte[] buff = new byte[100]; //buff���ڴ��ѭ����ȡ����ʱ���

		    int rc = 0;

		    while ((rc = bis.read(buff, 0, 100)) > 0) {

		    	swapStream.write(buff, 0, rc);

		    }
		    bais  = new ByteArrayInputStream(swapStream.toByteArray());   
	    }
	    catch(Exception e){
	    	
	    }
	    
	    bis.close();
	    httpUrl.disconnect();
	    return bais;
		
	}
	public static Double StrToDouble(String str){  
		
		
		Double f =new Double(0);
		if (str.isEmpty() || str.equals(null)){
			return f;
		}
		else{
		
			str = str.replaceAll(",","").replaceAll("%","");
			
			try {   
				f = new Double(Double.parseDouble(str));   
			}catch(NumberFormatException   e)
			{
			}
			return f;
		}

	}
	public static boolean isNullOrEmpty(String str)
	{
		if (str == null || str.trim().length() < 1)
		{
			return true;
		} else 
		{
			return false;
		}
	}
	public static String getNullStr(String str, String str1) {
		if (isNullOrEmpty(str)) {
			return str1;
		} else {
			return str;
		}
	}
	public static String getISOStr(String str) {
		try {
			String temp_p;
			temp_p = str;
			temp_p = getNullStr(temp_p, "");
			byte[] temp_t = temp_p.getBytes("GBK");
			String temp = new String(temp_t, "ISO8859_1");
			return temp;
		} catch (Exception e) {
		}
		return "";
	}
	public static String getGBKStr(String str) {
		/*try {
			String temp_p;
			temp_p = str;
			temp_p = getNullStr(temp_p, "");
		//	byte[] temp_t = temp_p.getBytes("ISO8859_1");
			byte[] temp_t = temp_p.getBytes("UTF8");
			String temp = new String(temp_t, "GBK");
			return temp;
			
		} catch (Exception e) {
		}
		return "";
		*/
		return str;
	}
	public static void SendMail(String subject,String msg) {
   		
		String host = "smtp.live.com";   //发邮件服务器的SMtP
	    String from = "sailman0607@hotmail.com";    //发邮件的账号
	    String to = "13580016553@139.com";   //接收邮件的账号
	    final String SMTP = "smtp"; 
	    
	    Properties props = new Properties();
	    Properties prop_send_hotmail = new Properties();
	    
	    // Setup mail server
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", "25");  // default smtp
        props.put("mail.Transport.protocol", SMTP);
	    // Get session
	    props.put("mail.smtp.auth", "true"); 
	    prop_send_hotmail.putAll(props); // add default smtp
        prop_send_hotmail.put("mail.smtp.starttls.enable", "true");
	   
	    
	    javax.mail.Authenticator myauth=new javax.mail.Authenticator(){
	    	private String strUser="sailman0607@hotmail.com";//发邮件用到的账号
	    	private String strPwd="920708";//发邮件的密码
	    	 protected PasswordAuthentication getPasswordAuthentication() {
	    	      return new PasswordAuthentication(strUser, strPwd);}
	    	
	    };
	    
	    javax.mail.Session session = Session.getDefaultInstance(prop_send_hotmail,myauth);

	    javax.mail.internet.MimeMessage message = new MimeMessage(session);
	    
	    try{
	    	//Set the from address
		    message.setFrom(new InternetAddress(from));

		    // Set the to address
		    message.addRecipient(Message.RecipientType.TO,
		      new InternetAddress(to));

		    // Set the subject
		    message.setSubject(subject);
		    // Set the content
		    message.setText(msg.trim());

		    message.saveChanges();

		    
		    Transport.send(message); 
		      
        } catch (Exception e) {
              System.out.println(e);
        }
	
	}
	
public static void SendMailBy189(String subject,String msg) {
   		
		String host = "smtp.189.cn";   //发邮件服务器的SMtP
	    String from = "13580016553@189.cn";    //发邮件的账号
	    String to = "13580016553@139.com";   //接收邮件的账号
	    final String SMTP = "smtp"; 
	    
	    Properties props = new Properties();
	    Properties prop_send_hotmail = new Properties();
	    
	    // Setup mail server
	    props.put("mail.smtp.host", host);
	  //  props.put("mail.smtp.port", "25");  // default smtp
        props.put("mail.Transport.protocol", SMTP);
	    // Get session
	    props.put("mail.smtp.auth", "true"); 
	    prop_send_hotmail.putAll(props); // add default smtp
        prop_send_hotmail.put("mail.smtp.starttls.enable", "true");
	   
	    
	    javax.mail.Authenticator myauth=new javax.mail.Authenticator(){
	    	private String strUser="13580016553@189.cn";//发邮件用到的账号
	    	private String strPwd="a19920708";//发邮件的密码
	    	 protected PasswordAuthentication getPasswordAuthentication() {
	    	      return new PasswordAuthentication(strUser, strPwd);}
	    	
	    };
	    
	    javax.mail.Session session = Session.getDefaultInstance(prop_send_hotmail,myauth);

	    javax.mail.internet.MimeMessage message = new MimeMessage(session);
	    
	    try{
	    	//Set the from address
		    message.setFrom(new InternetAddress(from));

		    // Set the to address
		    message.addRecipient(Message.RecipientType.TO,
		      new InternetAddress(to));

		    // Set the subject
		    message.setSubject(subject);
		    // Set the content
		    message.setText(msg.trim());

		    message.saveChanges();

		    
		    Transport.send(message); 
		      
        } catch (Exception e) {
              System.out.println(e);
        }
	
	}
public static void SendMailBy163(String subject,String msg) {
		
	String host = "smtp.163.com";   //发邮件服务器的SMtP
    String from = "13580016553@163.com";    //发邮件的账号
    String to = "13580016553@139.com";   //接收邮件的账号
    final String SMTP = "smtp"; 
    
    Properties props = new Properties();
    Properties prop_send_hotmail = new Properties();
    
    // Setup mail server
    props.put("mail.smtp.host", host);
  //  props.put("mail.smtp.port", "25");  // default smtp
    props.put("mail.Transport.protocol", SMTP);
    // Get session
    props.put("mail.smtp.auth", "true"); 
    prop_send_hotmail.putAll(props); // add default smtp
    prop_send_hotmail.put("mail.smtp.starttls.enable", "true");
   
    
    javax.mail.Authenticator myauth=new javax.mail.Authenticator(){
    	private String strUser="13580016553@163.com";//发邮件用到的账号
    	private String strPwd="a19920708";//发邮件的密码
    	 protected PasswordAuthentication getPasswordAuthentication() {
    	      return new PasswordAuthentication(strUser, strPwd);}
    	
    };
    
    javax.mail.Session session = Session.getDefaultInstance(prop_send_hotmail,myauth);

    javax.mail.internet.MimeMessage message = new MimeMessage(session);
    
    try{
    	//Set the from address
	    message.setFrom(new InternetAddress(from));

	    // Set the to address
	    message.addRecipient(Message.RecipientType.TO,
	      new InternetAddress(to));

	    // Set the subject
	    message.setSubject(subject);
	    // Set the content
	    message.setText(msg.trim());

	    message.saveChanges();

	    
	    Transport.send(message); 
	      
    } catch (Exception e) {
          System.out.println(e);
    }

}


	/*
	 * �����ж�ϵͳʱ��,�����ڹ�Ʊ����ʱ��Ź���,����һ���������9:30-11:30,13:00-15:00
	 */
	
	public static boolean isworktime(){
		boolean bool_isworktime=false;
		SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd" );   
		Calendar c = Calendar.getInstance();   
		c.setTime(new Date());   
		int  dayForWeek = 0 ;   
		if (c.get(Calendar.DAY_OF_WEEK) == 1 ){   
			dayForWeek = 7 ;   
		}else {   
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1 ;   
		}   
		if(dayForWeek>0&&dayForWeek<6){
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min  = c.get(Calendar.MINUTE);
			if (hour==9&&min>29)
				bool_isworktime=true;			
			if(hour==10||hour==13||hour==14)
				bool_isworktime=true;			
			if(hour==11&&min<31)
				bool_isworktime=true;			
		}
		return bool_isworktime;
		
	}
	/*
	 * ��ɶ�ȡ��Ʊʵʱ��ݵ�url�ַ�tempurl�Ǵ������õã�i_count�ж��ǲ��ǵ�һ����Ʊ
	 */
	public static String makeurl(String tempurl,String gupiaodaima,int i_count){
		
		if (i_count==0){
			if(MyTools.getJiaoYiShuoYahoo(gupiaodaima).equalsIgnoreCase("SZ"))
				tempurl="http://hq.sinajs.cn/list="+"sz"+gupiaodaima;
			else
				tempurl="http://hq.sinajs.cn/list="+"sh"+gupiaodaima;
		}
		else
		{
			if(MyTools.getJiaoYiShuoYahoo(gupiaodaima).equalsIgnoreCase("SZ"))
				tempurl=tempurl+",sz"+gupiaodaima;
			else
				tempurl=tempurl+",sh"+gupiaodaima;
		}
		return tempurl;
	}
	public  static boolean fileIsExists(String strFile)	    {
	        try
	        {
	            File f=new File("F://VDownload/"+strFile+".mp4");
	            if(!f.exists())
	            {
	                return false;
	            }

	        }
	        catch (Exception e)
	        {
	            return false;
	        }

	        return true;
	    }
	
	public static List<Dazhongjiaoyi>  getDazhongjiaoyi(String tempurl,String gupiaodaima){
		String str;	
		String tmp_str="";
		int int_position,int_rows,int_records;
		
		String str_date="";//日期变量
		SearchAndReturn searchAndReturn = new SearchAndReturn();//搜索定位类
		
		List<Dazhongjiaoyi> list = new ArrayList();
		
		
		
		try{
				tmp_str = MyTools.readHttm(tempurl);
				searchAndReturn.setStr_search(tmp_str);//设置被搜索的字符串
				searchAndReturn.setStr_position1("卖方营业部</th>");
				searchAndReturn.setStr_position2("<tr class=\"list_eve\">");//从str_position2开始
				searchAndReturn.setStr_position3("</table>");
				tmp_str=searchAndReturn.search();
				searchAndReturn.setStr_search(tmp_str);//设置被搜索的字符串
				searchAndReturn.setStr_position1("<td rowspan");
				searchAndReturn.setStr_position2("=\"");
				searchAndReturn.setStr_position3("</tr>");
				while((str=searchAndReturn.search())!=null){//在这已经读一行了
					//先要判断有几行
					int_position=str.indexOf("\"");//定位有几行
					if(int_position>0){
						int_rows=Integer.valueOf(str.substring(0,int_position)).intValue();
					}
					else{
						int_rows=0;
					}
					//在这要分析出第一行的内容
					int_position=str.indexOf(">");
					if(int_position>0){
						str_date=str.substring(int_position+1,int_position+1+10);
						
						str=str.substring(int_position+1+10);
						int_records=0;
						Dazhongjiaoyi dazhongjiaoyi=new Dazhongjiaoyi();
						dazhongjiaoyi.setGupiaodaima(gupiaodaima);
						dazhongjiaoyi.setRiqi(MyTools.strToDate(str_date));
						while((int_position=str.indexOf("<td class=\"r_6\">"))>-1){
							str=str.substring(int_position+"<td class=\"r_6\">".length());			
							int_records++;
							if((int_position=str.indexOf("</td>"))>0){
								if(int_records==1){
									dazhongjiaoyi.setChengjiaojiage(MyTools.StrToDouble(str.substring(0,int_position)));
								}
								if(int_records==2){
									dazhongjiaoyi.setChengjiaoshulian(MyTools.StrToDouble(str.substring(0,int_position)));
								}
								if(int_records==3){
									dazhongjiaoyi.setChengjiaojiner(MyTools.StrToDouble(str.substring(0,int_position)));
								}
								
							}
							
							//System.out.println(str);
						}
						int_records=0;
						while((int_position=str.indexOf("<td>"))>-1){
							str=str.substring(int_position+"<td>".length());
							
							int_records++;
							if((int_position=str.indexOf("</td>"))>-1){
								if(int_records==1){
									dazhongjiaoyi.setBuyer(str.substring(0,int_position));
								}
								if(int_records==2){
									dazhongjiaoyi.setSeller(str.substring(0,int_position));
								}
								
								
							}
						}
						list.add(dazhongjiaoyi);
					}
					while(--int_rows>0){//在这要补充读多几行
						searchAndReturn.setStr_position1("<tr class=\"list_eve\"");
						searchAndReturn.setStr_position2(">");
						searchAndReturn.setStr_position3("</tr>");
						str=searchAndReturn.search();
						
						Dazhongjiaoyi dazhongjiaoyi=new Dazhongjiaoyi();
						dazhongjiaoyi.setGupiaodaima(gupiaodaima);
						dazhongjiaoyi.setRiqi(MyTools.strToDate(str_date,int_rows));
						int_records=0;
						while((int_position=str.indexOf("<td class=\"r_6\">"))>-1){
							str=str.substring(int_position+"<td class=\"r_6\">".length());
							
							int_records++;
							if((int_position=str.indexOf("</td>"))>-1){
								if(int_records==1){
									dazhongjiaoyi.setChengjiaojiage(MyTools.StrToDouble(str.substring(0,int_position)));
								}
								if(int_records==2){
									dazhongjiaoyi.setChengjiaoshulian(MyTools.StrToDouble(str.substring(0,int_position)));
								}
								if(int_records==3){
									dazhongjiaoyi.setChengjiaojiner(MyTools.StrToDouble(str.substring(0,int_position)));
								}
							}
							
							//System.out.println(str);
						}
						int_records=0;
						while((int_position=str.indexOf("<td>"))>-1){
							str=str.substring(int_position+"<td>".length());
							int_records++;
							if((int_position=str.indexOf("</td>"))>-1){
								if(int_records==1){
									dazhongjiaoyi.setBuyer(str.substring(0,int_position));
								}
								if(int_records==2){
									dazhongjiaoyi.setSeller(str.substring(0,int_position));
								}
								
								
							}
						}
						list.add(dazhongjiaoyi);
					}
					//恢复原来设计
					searchAndReturn.setStr_position1("<td rowspan");
					searchAndReturn.setStr_position2("=\"");
					searchAndReturn.setStr_position3("</tr>");
				}
				
				
			
			
	
		}catch(Exception e){
			System.out.println("Exception");
			return null;
		}
		return list;
			//tmp_str = MyTools.filetoStr(tempurl);//先读文件，完成后删除这句,用上一条
			
			
	}
	public static List<Dazhongjiaoyi>  getDazhongjiaoyiByOneHtml(){
		String str,tmp_str="",str_gupiaodaima="";	
		
		int int_position,int_rows=0,int_records;
		
		String str_date="";//日期变量
		SearchAndReturn searchAndReturn = new SearchAndReturn();//搜索定位类
	
		List<Dazhongjiaoyi> list = new ArrayList();
		
		
		
		try{
				tmp_str = MyTools.readHttm("http://data.eastmoney.com/dzjy/default.html");
				searchAndReturn.setStr_search(tmp_str);//设置被搜索的字符串
				searchAndReturn.setStr_position1("<th>卖方营业部");
				searchAndReturn.setStr_position2("</th>");//从str_position2开始
				searchAndReturn.setStr_position3("</table>");
				tmp_str=searchAndReturn.search();
				searchAndReturn.setStr_search(tmp_str);//设置被搜索的字符串
				searchAndReturn.setStr_position1("");
				searchAndReturn.setStr_position2("<tr class=\"list_eve\">");
				searchAndReturn.setStr_position3("</tr>");
				
				while((str=searchAndReturn.search())!=null){//在这已经读一行了
					
					//定位是否有日期
					int_position=str.indexOf("<strong>");
					if(int_position>-1){//提取日期
						str_date=str.substring(int_position+"<strong>".length(),int_position+"<strong>".length()+10);
					}
					
					
					//提取股票代码
					int_position=str.indexOf(".html\">");
					
					if(int_position>-1){
						str_gupiaodaima=str.substring(int_position+".html\">".length(),int_position+".html\">".length()+6);
						int_rows=0;
					}else{//如果提取不到股票代码，表明这是同一股票的另一行
						int_rows++;
						
					}
					//读取剩余的行
					
					
					int_records=0;
					Dazhongjiaoyi dazhongjiaoyi=new Dazhongjiaoyi();
					dazhongjiaoyi.setGupiaodaima(str_gupiaodaima);
					dazhongjiaoyi.setRiqi(MyTools.strToDate(str_date,int_rows));
					while((int_position=str.indexOf("<td class=\"r_6\">"))>-1){
						str=str.substring(int_position+"<td class=\"r_6\">".length());			
						int_records++;
						if((int_position=str.indexOf("</td>"))>-1){
							if(int_records==1){
								dazhongjiaoyi.setChengjiaojiage(MyTools.StrToDouble(str.substring(0,int_position)));
							}
							if(int_records==2){
								dazhongjiaoyi.setChengjiaoshulian(MyTools.StrToDouble(str.substring(0,int_position)));
							}
							if(int_records==3){
								dazhongjiaoyi.setChengjiaojiner(MyTools.StrToDouble(str.substring(0,int_position)));
							}
						}
					}
					int_records=0;
					while((int_position=str.indexOf("<td>"))>-1){
						str=str.substring(int_position+"<td>".length());
						
						int_records++;
						if((int_position=str.indexOf("</td>"))>-1){
							if(int_records==1){
								dazhongjiaoyi.setBuyer(str.substring(0,int_position));
							}
							if(int_records==2){
								dazhongjiaoyi.setSeller(str.substring(0,int_position));
							}
						}
					}
					list.add(dazhongjiaoyi);
				}
		}catch(Exception e){
			System.out.println("Exception");
			return null;
		}
		return list;
			//tmp_str = MyTools.filetoStr(tempurl);//先读文件，完成后删除这句,用上一条
			
			
	}

	
	 public static java.util.Date strToDate(String aStrValue,int int_minute){
		 String str_year,str_month,str_day;
		 aStrValue=aStrValue.replaceAll("-","").replaceAll("/","");
		 if(aStrValue.length()==8){
				str_year =aStrValue.substring(0,4);
				str_month=aStrValue.substring(4,6);
				str_day=aStrValue.substring(6);
				
				GregorianCalendar da = new GregorianCalendar(StrToDouble(str_year).intValue(),StrToDouble(str_month).intValue()-1,StrToDouble(str_day).intValue(),21,0,int_minute);   
				
				java.util.Date time = da.getTime();   
				java.sql.Date sqlDate = new java.sql.Date(time.getTime()); 
				return sqlDate;
		 }
		 return null;
    }  
	 public static java.util.Date strToDate(String aStrValue,String strTime){
		 String str_year,str_month,str_day;
		 String[] str_time;
		 str_time=strTime.split(":");
		 aStrValue=aStrValue.replaceAll("-","").replaceAll("/","");
		 if(aStrValue.length()==8){
				str_year =aStrValue.substring(0,4);
				str_month=aStrValue.substring(4,6);
				str_day=aStrValue.substring(6);
				
				GregorianCalendar da = new GregorianCalendar(StrToDouble(str_year).intValue(),StrToDouble(str_month).intValue()-1,StrToDouble(str_day).intValue(),StrToDouble(str_time[0]).intValue(),StrToDouble(str_time[1]).intValue(),0);   
				
				java.util.Date time = da.getTime();   
				java.sql.Date sqlDate = new java.sql.Date(time.getTime()); 
				return sqlDate;
		 }
		 return null;
    }  
	 public static List getGubenjiegou(String tempurl,String gupiaodaima){
			String tmp_str,str;

			String str_date;//日期变量
			SearchAndReturn searchAndReturn = new SearchAndReturn();//搜索定位类
			Date date;
			
			List<Gubanjiegou> list=new ArrayList();
			
			try{
				tmp_str = MyTools.readHttm(tempurl);
				//tmp_str = MyTools.filetoStr(tempurl);//先读文件，完成后删除这句,用上一条
				
				searchAndReturn.setStr_search(tmp_str);
				searchAndReturn.setStr_position1("股本结构");
				searchAndReturn.str_split();//利用初始定位截取后一段
				searchAndReturn.str_split();//利用初始定位截取后一段
				searchAndReturn.str_split();//利用初始定位截取后一段
				searchAndReturn.str_split();//利用初始定位截取后一段
				Gubanjiegou gubanjiegou1= new Gubanjiegou();
				//GubanjiegouId gubanjiegouId1 = new GubanjiegouId();
				Gubanjiegou gubanjiegou2= new Gubanjiegou();
				//GubanjiegouId gubanjiegouId2 = new GubanjiegouId();
				Gubanjiegou gubanjiegou3= new Gubanjiegou();
				//GubanjiegouId gubanjiegouId3 = new GubanjiegouId();
				searchAndReturn.setStr_position1("align=\"center\"");
				searchAndReturn.setStr_position2(">");
				searchAndReturn.setStr_position3("</");
				int k=3;
				for(int i=0;i<k;i++){
					
					str=searchAndReturn.search();
					if(!isNullOrEmpty(str)){


						str=str.replaceAll("-","");
						if(str.length()==8){
							if(i==0){
								
								gubanjiegou1.setGupiaodaima(gupiaodaima);
								gubanjiegou1.setRiqi(MyTools.strToDate(str));							
							}
							if(i==1){
								
								gubanjiegou2.setGupiaodaima(gupiaodaima);
								gubanjiegou2.setRiqi(MyTools.strToDate(str));
							}
							if(i==2){
								
								gubanjiegou3.setGupiaodaima(gupiaodaima);
								gubanjiegou3.setRiqi(MyTools.strToDate(str));
							}						
						}else{
							k=1;
							
						}
						
						
					}
					
					
				}
				
				searchAndReturn.setStr_position1("人民币A股");
				searchAndReturn.str_split();//利用初始定位截取后一段
				searchAndReturn.setStr_position1("align=\"center\"");
				for(int i=0;i<2*k;i++){
					str=searchAndReturn.search();
					if(!isNullOrEmpty(str)){
						str=str.replaceAll("&nbsp;","").replaceAll(",","");
						if(i==0)
							gubanjiegou1.setAgulutonggushu(MyTools.StrToDouble(str));
						if(i==2)
							gubanjiegou2.setAgulutonggushu(MyTools.StrToDouble(str));
						if(i==4)
							gubanjiegou3.setAgulutonggushu(MyTools.StrToDouble(str));
					}
					
				}
				if(k==3){
					list.add(gubanjiegou1);
					list.add(gubanjiegou2);
					list.add(gubanjiegou3);
				}
				if(k==2){
					list.add(gubanjiegou1);
					list.add(gubanjiegou2);				
				}
				if(k==1){
					list.add(gubanjiegou1);		
				}
				return list;
			}
			catch(Exception e)
			{
				return null;
			}
		}
	 public static Double getLtgZhongShu(String gupiaodaima){
			String tmp_str;
			Double d_liutonggushu=0.0;
			String tempurla="http://f10.eastmoney.com/f10_v2/CapitalStockStructure.aspx?code="+getJiaoYiShuoYahoo(gupiaodaima)+gupiaodaima;
			SearchAndReturn searchAndReturn = new SearchAndReturn();//搜索定位类
			try{
				tmp_str = IOUtils.toString(MyTools.readHttmnew(tempurla),"UTF-8");
				
				
				searchAndReturn.setStr_search(tmp_str);
				searchAndReturn.setStr_position1("流通股份合计</td>");
				searchAndReturn.setStr_position2("<td class=\"tips-dataR\">");
				searchAndReturn.setStr_position3("</td>");
				searchAndReturn.str_split();//利用初始定位截取后一段
				searchAndReturn.setStr_position1("");
				
				
				
				String str_liutonggushu=searchAndReturn.search();
				
				if(null!=str_liutonggushu){
					str_liutonggushu=str_liutonggushu.replaceAll("	","").replaceAll(" ","").replaceAll("-","").replaceAll("\n", "").replaceAll("\r", "");
					d_liutonggushu=StrToDouble(str_liutonggushu);
					
				}
			}
			catch(Exception e)
			{
				
			}	
			return d_liutonggushu;
			
			
		}
		
	 public static List<Rzzgs>  getRzzgsnew(String tempurl,String gupiaodaima,Date maxriqi ){
			String tmp_str,str;
			String str_date;//日期变量
			Double d_ltg=0.0;//第一行股东总数,第一行人均持股数.
			SearchAndReturn searchAndReturn = new SearchAndReturn();//搜索定位类
			Date date;
			
			
			List<Rzzgs> list=new ArrayList();
			try{
				tmp_str = MyTools.readHttm(tempurl);
				//tmp_str = MyTools.filetoStr(tempurl);//先读文件，完成后删除这句,用上一条
				
				searchAndReturn.setStr_search(tmp_str);
				searchAndReturn.setStr_position1("<strong>流通股（万股）</strong></td>");
				searchAndReturn.setStr_position2("<span class=\"font10\">");
				searchAndReturn.setStr_position3("</span>");
				searchAndReturn.str_split();//利用初始定位截取后一段
				searchAndReturn.setStr_position1("");
		
				//d_ltg=getLtgZhongShu(gupiaodaima);
				while(searchAndReturn.getInt_position()>-1){
					
						Rzzgs rzzgs= new Rzzgs();
						rzzgs.setGupiaodaima(gupiaodaima);
						//rzzgs.setLtg(d_ltg);
						rzzgs.setGenericriqi(new Date());
						for(int i=0;i<6;i++){
								str=searchAndReturn.search();
								if(!isNullOrEmpty(str)){
									
									if(i==0){
										str_date=str;
										str_date=str_date.replaceAll("第1季", "0331").replaceAll("第2季", "0630").replaceAll("中期", "0630").replaceAll("前3季", "0930").replaceAll("年度", "1231").trim();								
										String str_tmp=str_date.substring(0,2);
										if(Integer.parseInt(str_tmp)>80){
											str_date="19"+str_date.replaceAll("年", "");
										}
										else{
											str_date="20"+str_date.replaceAll("年", "");
										}
										//System.out.println(str_date);
										date = MyTools.strToDate(str_date.replaceAll("-",""));
										rzzgs.setRiqi(date);								
									}
									if(i==1){
										rzzgs.setGdzs(MyTools.StrToDouble(str));
									}
									if(i==2){
										rzzgs.setRzzg(MyTools.StrToDouble(str));
									}
									if(i==3){
										rzzgs.setJsqbh(MyTools.StrToDouble(str));
									}
									if(i==4){
										rzzgs.setZgb(MyTools.StrToDouble(str));
									}
									if(i==5){
										rzzgs.setLtg(MyTools.StrToDouble(str));
									}
								}
						}
						if(rzzgs.getRiqi().after(maxriqi)){
							
							list.add(rzzgs);
						}
				}
				
				//return list;
			}
			catch(Exception e)
			{
				
			}
			return list;
			
		}
		
}
