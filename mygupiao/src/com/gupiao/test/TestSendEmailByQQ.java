package com.gupiao.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import com.gupiao.web.tools.MyTools;
import com.gupiao.web.tools.SendEmailByQQ;
public class TestSendEmailByQQ {
	@Test
	public  void sendEmail() throws Exception {
		MyTools.SendMail("卖出","价格是");
	}
}