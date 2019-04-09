package com.gupiao.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Gaokao_xyst;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Rzzgs;
import com.gupiao.web.tools.MyTools;

public class TestGupiaoDAOImpl {

	@Test
	public void testGetgupiaoshuju() throws Exception {
	//	ApplicationContext ctx =new FileSystemXmlApplicationContext("C:/Users/Administrator/git/gupiao/mygupiao/WebRoot/WEB-INF/applicationContext.xml");
	//	GupiaoDAO gupiaoDAO=(GupiaoDAO)ctx.getBean("gupiaoDAO");
		
		
		
		
		
		//String https_url = "https://xyst.yuanfudao.com/questions/vip-share?token=5173b8fb16fbb7b0cd8e3db89906e9b2644955b7dfb72daa4e9e214cec4b0c81&from=wechat";
	    //String https_url="https://xyst.yuanfudao.com/questions/share?token=b1bde11c42d99972d4a68b5042de9ee4be0ee5f58bdfb0d28109349d6dfef3d7&from=singlemessage" ; 
		//String https_url="https://xyst.yuanfudao.com/questions/vip-share?token=4f6b2374db7a6501b4e7170572823fbcf453ecc8d15aed9dd180b8c9f5b0c45e&from=singlemessage";
		//String https_url="https://xyst.yuanfudao.com/questions/share?token=0eec6754060ce6dd23435781fa35ad483c4d6a6533d77a854c1c1b83863cbfd7&from=singlemessage";
		//String https_url="https://xyst.yuanfudao.com/questions/share?token=0c0fe04a187b9e2c83c9ab31f824237ad52ad9ff019560285500269113e76da5&from=singlemessage";
		//String https_url="https://xyst.yuanfudao.com/questions/share?token=b1bde11c42d99972d4a68b5042de9ee4383e84c1b8f632ddceaa44ef34de1592&from=singlemessage";
		String https_url="https://www.zybang.com/question/rcswebview/03034da50cb51af4b6da501ca26ead1f.html?nqid=032ee9de9bd0667f7494f26fdc0f2f5c9bcdd21816048d5a&from=singlemessage";
		//String https_url="https://www.zybang.com/question/rcswebview/00bc0be1ca6367e3abcf533909997903.html?nqid=c62cffe0985cc89d54bfee183da44c5a702b52edfea00a24&from=singlemessage";
		URL url;
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
		    		
		    		   String[] str_mfind=sb.toString().split("<dl class=\"trace refer-answer\">");
		    		   String surplus;
		    		   for(int i=0;i<str_mfind.length;i++) {
		    			   if(str_mfind[i].indexOf("题目")>-1) {
		    				   
		    				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>题目：</dt>")+"<dt>题目：</dt>".length());
		    				   System.out.println("题目:"+surplus);
		    			   }
		    			   if(str_mfind[i].indexOf("考点")>-1) {
		    				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>考点：</dt>")+"<dt>考点：</dt>".length());
		    				   System.out.println("考点:"+surplus);
		    			   }
		    			   if(str_mfind[i].indexOf("分析")>-1) {
		    				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>分析：</dt>")+"<dt>分析：</dt>".length());
		    				   System.out.println("分析:"+surplus);
		    			   }
		    			   if(str_mfind[i].indexOf("解答")>-1) {
		    				   surplus=str_mfind[i].substring(str_mfind[i].indexOf("<dt>解答：</dt>")+"<dt>解答：</dt>".length());
		    				   surplus=surplus.substring(0,surplus.indexOf("</body><script type=\"text/javascript\""));
		    				   System.out.println("解答:"+surplus);
		    			   }
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
		//System.out.println("list.size"+list.size());
		//List<Rzzgs> list=(List<Rzzgs>)gupiaoDAO.getrzzgsByCondition(new Double(20),new Double(20),"2015-09-30");
		/*
		for(Rzzgs rzzgs:list){
			System.out.println(rzzgs.getRiqi());
		}*/
		
	}

}
