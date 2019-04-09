package com.gupiao.model.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
 
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
 
public class HttpsClient{
 
   public static void main(String[] args)
   {
        new HttpsClient().testIt();
   }
 
   private void testIt(){
 
      String https_url = "https://xyst.yuanfudao.com/questions/vip-share?token=5173b8fb16fbb7b0cd8e3db89906e9b2644955b7dfb72daa4e9e214cec4b0c81&from=wechat";
      URL url;
      try {
 
	     url = new URL(https_url);
	     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
 
	     //dumpl all cert info
	     //print_https_cert(con);
 
	     //dump all the content
	     print_content(con);
 
      } catch (MalformedURLException e) {
	     e.printStackTrace();
      } catch (IOException e) {
	     e.printStackTrace();
      }
 
   }
 
   private void print_https_cert(HttpsURLConnection con){
 
    if(con!=null){
 
      try {
 
	System.out.println("Response Code : " + con.getResponseCode());
	System.out.println("Cipher Suite : " + con.getCipherSuite());
	System.out.println("\n");
 
	Certificate[] certs = con.getServerCertificates();
	for(Certificate cert : certs){
	   System.out.println("Cert Type : " + cert.getType());
	   System.out.println("Cert Hash Code : " + cert.hashCode());
	   System.out.println("Cert Public Key Algorithm : " + cert.getPublicKey().getAlgorithm());
	   System.out.println("Cert Public Key Format : " + cert.getPublicKey().getFormat());
	   System.out.println("\n");
	}
 
	} catch (SSLPeerUnverifiedException e) {
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
 
     }
 
   }
 
   private void print_content(HttpsURLConnection con){
	if(con!=null){
 
	try {
 
	   System.out.println("****** Content of the URL ********");			
	   BufferedReader br = 
		new BufferedReader(
			new InputStreamReader(con.getInputStream()));
 
	   String input;
	   StringBuffer sb = new StringBuffer();
 
	   while ((input = br.readLine()) != null){
		   
	       sb.append(input);
	   }
	   
	   
	   String pattern = "\\<div class=\"section-content\">";
	   
	      // 创建 Pattern 对象
	   Pattern r = Pattern.compile(pattern);
	 
	      // 现在创建 matcher 对象
	   Matcher m = r.matcher(sb);
	   int position_start=0;
	 
	   while (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );	
	         System.out.println("out: "+sb.substring(position_start, m.start()) );
	         System.out.println("m.start():"+m.start());
	         System.out.println("m.end():"+m.end());
	         position_start=m.end();
	   } 
	   String str_end= sb.substring(position_start);
	   
	   pattern = "\\<div class=\"vip-content-wrapper\">";
	   
	      // 创建 Pattern 对象
	   r = Pattern.compile(pattern);
	 
	      // 现在创建 matcher 对象
	   m = r.matcher(str_end);
	   if(m.find( )) {
		   System.out.println("out: "+str_end.substring(0, m.start()) );
	   }
	   
			   
			   
	  // System.out.println("out: "+sb.substring(position_start));
	   
	   br.close();
 
	} catch (IOException e) {
	   e.printStackTrace();
	}
 
       }
 
   }
 
}
