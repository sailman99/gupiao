package com.gupiao.web.tools;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailByQQ {
	 //���÷�����
    private static String KEY_SMTP         = "mail.smtp.host";
    private static String VALUE_SMTP     = "smtp.qq.com";
    //��������֤
    private static String KEY_PROPS     = "mail.smtp.auth";
    private static boolean VALUE_PROPS     = true;
    //�������û���������
    private String SEND_USER             = "371969053@qq.com";//���QQ����
    private String SEND_UNAME             = "371969053";         //���������
    private String SEND_PWD             = "a920708";     //�����������
    //�����Ự
    private MimeMessage message;
    private Session s;
     
    /*
     * ��ʼ������
     * */
    public SendEmailByQQ (){
        Properties props = System.getProperties();
        props.setProperty(KEY_SMTP, VALUE_SMTP);
        props.put(KEY_PROPS, VALUE_PROPS);
        s = Session.getInstance(props);
        /*s.setDebug(true);�������е�����Ϣ*/
        message = new MimeMessage(s);  
    }
     
    /**
     * �����ʼ�
     * @param headName         �ʼ�ͷ�ļ���
     * @param sendHtml         �ʼ�����
     * @param receiveUser     �ռ���184172133@qq.com
     */
    public void doSendHtmlEmail(String headName,StringBuffer sendHtml,String receiveUser){
        try {
            // ������  
            InternetAddress from = new InternetAddress(SEND_USER);
            message.setFrom(from);  
            // �ռ���  
            InternetAddress to = new InternetAddress(receiveUser);  
            message.setRecipient(Message.RecipientType.TO, to);  
            // �ʼ�����  
            message.setSubject(headName);  
            String content = sendHtml.toString();  
            // �ʼ�����,Ҳ����ʹ���ı�"text/plain"  
            message.setContent(content, "text/html;charset=GBK");  
            message.saveChanges();  
            Transport transport = s.getTransport("smtp");  
            // smtp��֤���������������ʼ��������û�������  
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);  
            // ����  
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