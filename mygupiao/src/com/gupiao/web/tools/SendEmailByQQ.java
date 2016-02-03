package com.gupiao.web.tools;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailByQQ {
	 //设置服务器
    private static String KEY_SMTP         = "mail.smtp.host";
    private static String VALUE_SMTP     = "smtp.qq.com";
    //服务器验证
    private static String KEY_PROPS     = "mail.smtp.auth";
    private static boolean VALUE_PROPS     = true;
    //发件人用户名、密码
    private String SEND_USER             = "371969053@qq.com";//你的QQ邮箱
    private String SEND_UNAME             = "371969053";         //你的邮箱名
    private String SEND_PWD             = "a920708";     //你的邮箱密码
    //建立会话
    private MimeMessage message;
    private Session s;
     
    /*
     * 初始化方法
     * */
    public SendEmailByQQ (){
        Properties props = System.getProperties();
        props.setProperty(KEY_SMTP, VALUE_SMTP);
        props.put(KEY_PROPS, VALUE_PROPS);
        s = Session.getInstance(props);
        /*s.setDebug(true);开启后有调试信息*/
        message = new MimeMessage(s);  
    }
     
    /**
     * 发送邮件
     * @param headName         邮件头文件名
     * @param sendHtml         邮件内容
     * @param receiveUser     收件人184172133@qq.com
     */
    public void doSendHtmlEmail(String headName,StringBuffer sendHtml,String receiveUser){
        try {
            // 发件人  
            InternetAddress from = new InternetAddress(SEND_USER);
            message.setFrom(from);  
            // 收件人  
            InternetAddress to = new InternetAddress(receiveUser);  
            message.setRecipient(Message.RecipientType.TO, to);  
            // 邮件标题  
            message.setSubject(headName);  
            String content = sendHtml.toString();  
            // 邮件内容,也可以使纯文本"text/plain"  
            message.setContent(content, "text/html;charset=GBK");  
            message.saveChanges();  
            Transport transport = s.getTransport("smtp");  
            // smtp验证，就是你用来发邮件的邮箱用户名密码  
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);  
            // 发送  
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