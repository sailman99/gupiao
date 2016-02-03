package com.gupiao.jms.spring;



import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueConsumerMessageListener implements MessageListener{
	public void onMessage(Message msg) {
		if(msg instanceof TextMessage){
			TextMessage textMessage = (TextMessage) msg;
			try {
				System.out.println("--���� MessageListener�յ���Ϣ��"+textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
