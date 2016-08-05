package com.gupiao.web.tools;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailByQQ {
	 
    private static String KEY_SMTP         = "mail.smtp.host";
    private static String VALUE_SMTP     = "smtp.qq.com";
   
    private static String KEY_PROPS     = "mail.smtp.auth";
    private static boolean VALUE_PROPS     = true;
  
    //授权码：nibjwwbghgagcaif
    private String SEND_USER             = "371969053@qq.com";
    private String SEND_UNAME             = "371969053";        
    private String SEND_PWD             = "a920708";     
  //  private String SEND_PWD             = "nibjwwbghgagcaif";
   
   
    private MimeMessage message;
    private Session s;
     
    
    public SendEmailByQQ (){
        Properties props = System.getProperties();
        props.setProperty(KEY_SMTP, VALUE_SMTP);
        props.put(KEY_PROPS, VALUE_PROPS);
        s = Session.getInstance(props);
       
        message = new MimeMessage(s);  
    }
     
    
    public void doSendHtmlEmail(String headName,StringBuffer sendHtml,String receiveUser){
        try {
           
            InternetAddress from = new InternetAddress(SEND_USER);
            message.setFrom(from);  
           
            InternetAddress to = new InternetAddress(receiveUser);  
            message.setRecipient(Message.RecipientType.TO, to);  
            
            message.setSubject(headName);  
            String content = sendHtml.toString();  
            
            message.setContent(content, "text/html;charset=GBK");  
            message.saveChanges();  
            Transport transport = s.getTransport("smtp");  
            
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);  
           
            transport.sendMessage(message, message.getAllRecipients());  
            transport.close();  
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }  
    }
}