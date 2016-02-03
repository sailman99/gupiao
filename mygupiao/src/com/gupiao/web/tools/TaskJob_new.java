package com.gupiao.web.tools;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.Set;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;







import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.Sendemail;
import com.gupiao.model.persist.entity.Trendlines;
import com.gupiao.socket.MyProtocolHandler;
public class TaskJob_new{

	
		private GupiaoDAO gupiaoDAO;
		
		private MyProtocolHandler myprotocolhandler;
		
		private SendEmailByQQ sendEmailByQQ=new SendEmailByQQ();

		private SimpleDateFormat sdf;//
		private org.apache.activemq.command.ActiveMQTopic aMQTopic;
		private org.springframework.jms.core.JmsTemplate jmsTemplate;
	//	private boolean sendemailcondition=false;	
		private String str_msg,str_seilout,str_seilin;
		
		public SimpleDateFormat getSdf() {
			//return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA); //����ʱ���ʽ
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sim.setTimeZone(TimeZone.getDefault());
			return sim;	
		}
		
		public void setGupiaoDAO(GupiaoDAO gupiaoDAO) {
			this.gupiaoDAO = gupiaoDAO;
		}
		
		public void setMyprotocolhandler(MyProtocolHandler myprotocolhandler) {
			this.myprotocolhandler = myprotocolhandler;
		}

		
		public void setJmsTemplate(org.springframework.jms.core.JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
		}
		public void setaMQTopic(org.apache.activemq.command.ActiveMQTopic aMQTopic) {
			this.aMQTopic = aMQTopic;
		}

		public void TestJMS(){
			
			
			
			UUID uuid=UUID.randomUUID();
	    		sdf=this.getSdf();
	    		final String str_temp=String.valueOf(uuid)+"@#@���ݲ���@#@"+sdf.format(System.currentTimeMillis())+"���ݲ���"+"@#@author@#@"+sdf.format(System.currentTimeMillis()); 
	   
	    		jmsTemplate.send(aMQTopic, new MessageCreator() {  
	  	            public Message createMessage(Session session) throws JMSException {   
	  	            	
	  	            	Message message= session.createTextMessage(str_temp);
	  	            	
	  	            	
	  	            //	message.setStringProperty("PTP_CLIENTID", "867058469098214");
	  	            	message.setStringProperty("PTP_CLIENTID", "863994018967547");	  	            	
	  	                return message;  
	  	            }  
	  	        });  
		
		}
	//	public static Logger log = Logger.getLogger(TaskJob.class);
	  /*  public void SayHello() {
	              // TODO Auto-generated method stub
	              try {
	                     log.info("��������ʼ>........");
	                     // ҵ���߼��������
	                     System.out.println("ʱ��[" + new java.util.Date().toLocaleString()
	                                   + "]----->��Һð���");
	                     log.info("�����������!");
	              } catch (Exception e) {
	                     log.error("������������쳣", e);
	              }
	    }
	       */
	       
	      
	   /*
	    * var hq_str_sz000001=
	    * 0  "ƽ������,
	    * 1  14.06,���̼�
	    * 2  14.07,
	    * 3  13.99,���̼�
	    * 4  14.16,��߼�
	    * 5  13.96,��ͼ�
	    * 6  13.98,���̼�
	    * 7  13.99,������
	    * 8  79357014,����
	    * 9  1115146052.80,�ɽ����
	    * 10 356712,
	    * 11 13.98,
	    * 12 265727,
	    * 13 13.97,
	    * 14 459700,
	    * 15 13.96,
	    * 16 517700,
	    * 17 13.95,
	    * 18 67400,
	    * 19 13.94,
	    * 244703,13.99,336878,14.00,108773,14.01,269800,14.02,87655,14.03,2015-02-27,15:05:53,00";
	    */


		public void manipulation_data(List<Inoutprice> inoutprice_list,List<Trendlines> trendlines_list,String tempurl) throws Exception{
	    	   
	    	   	String[] sinajs;
	    		
	    		String   hashmapkey;
	    			  
	    		int i_position=0;
	    	   
	    		String tempsinajs = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));
	    		
	    		String[] sinashuju=tempsinajs.split(";");	    		
				for(int i=0;i<sinashuju.length;i++){
					i_position = sinashuju[i].indexOf("str");
					if(i_position>0){
						hashmapkey=sinashuju[i].substring(i_position+6,i_position+12);
						sinajs=sinashuju[i].split(",");
						if(sinajs.length>6){
							
							/*
							 * ������Ʊ�ж�,��߼۴����趨��,��߼��ڵ�����sinajs[4],inoutprice.leixin='0'
							 */
							if(!inoutprice_list.isEmpty()){
								Iterator<Inoutprice> iter_inoutprice=inoutprice_list.iterator();
								while(iter_inoutprice.hasNext()){
									Inoutprice inoutprice=(Inoutprice)iter_inoutprice.next();
									if(inoutprice.getGupiaodaima().equals(hashmapkey)){
										if("0".equals(inoutprice.getLeixin())){
											if(MyTools.StrToDouble(sinajs[4])>=inoutprice.getPrice()){
												this.str_seilout=this.str_seilout+hashmapkey+"����,";	
												gupiaoDAO.deleteInoutprice(hashmapkey);
											}
										}	
									
										else{
											/*
											 * �����Ʊ�ж�,��ǰ��С���趨��,��ǰ���ڵ�����sinajs[5],inoutprice.leixin='1',���outprice.price=0,ȡ��Ӧ��Ʊ������cyc13ֵ���������0���Ƚϵ�ǰֵ��
											 */
											if(inoutprice.getPrice()>0){
												if(MyTools.StrToDouble(sinajs[5])<=inoutprice.getPrice()&&MyTools.StrToDouble(sinajs[5])>0){											
													this.str_seilin=this.str_seilin+hashmapkey+"����,�۸�"+inoutprice.getPrice();
													gupiaoDAO.deleteInoutprice(hashmapkey);
												}
											}
										}
									}
								}
							}
							if(!trendlines_list.isEmpty()){
								Iterator<Trendlines> trendlines_iter=trendlines_list.iterator();
								while(trendlines_iter.hasNext()){
									Trendlines trendlines = trendlines_iter.next();
									if(hashmapkey.equals(trendlines.getGupiaodaima())){	
										if("1".equals(trendlines.getUpordown())){
											/*
											 * ����ͻ��������,��ǰ�۴����趨��,��ǰ���ڵ�����sinajs[4]
											 */
											if(trendlines.getForecastprice()<=MyTools.StrToDouble(sinajs[4]) && MyTools.StrToDouble(sinajs[4])>0){
			   									
			   									this.str_msg=this.str_msg + hashmapkey+"��߼۸�Ϊ"+sinajs[4]+"�����趨ֵ"+trendlines.getForecastprice();	   									  			   								
			   									trendlines.setRiqi4(new Date());
			   									trendlines.setDot4(MyTools.StrToDouble(sinajs[4]));
			   									gupiaoDAO.SaveObject(trendlines);		   						
			   								}	
										}
										else{
											/*
											 * ����ͻ��������,��ǰ��С���趨��,��ǰ���ڵ�����sinajs[5]
											 */
			   								if(trendlines.getForecastprice()>=MyTools.StrToDouble(sinajs[5]) && MyTools.StrToDouble(sinajs[5])>0){
			   									
			   									this.str_msg=this.str_msg + hashmapkey+"��ͼ۸�Ϊ"+sinajs[5]+"С���趨ֵ"+trendlines.getForecastprice();	   									  
			   									trendlines.setRiqi4(new Date());
			   									trendlines.setDot4(MyTools.StrToDouble(sinajs[3]));
			   									gupiaoDAO.SaveObject(trendlines);		   						
			   								}	
										}
									}
								}
							}
						}
					}
				}
	       }
	       
	       public void SendMailofInoutPrice() throws Exception {
	    	   
	    	    String tempstr = "",tempurl="";
	    		
	    		
	    		this.str_msg="";
	    		
	    		this.str_seilout="";
	    		this.str_seilin="";
	    		
	    	    int i_count = 0;
	    	    HashMap<String,Inoutprice> inoutpricehashmap=new HashMap<String,Inoutprice>();	    	  
	    	    HashMap<String,Trendlines> trendlineshashmap = new HashMap<String,Trendlines>();
	    	    Set<String> gupiaodaimaSet = new HashSet<String>();  
	    	    
	    	
	    	   
	    	    if(gupiaoDAO.getWhileworkspilttime()==1)
	    	    {
	    	    	/*if ("0".equals(gupiaoDAO.getprocedurecondition("1")))//����1���������ı�ʾ,������������õ�2,3,4...,����"0"�ͷ����ʼ�,���������������ʼ�
	    	    		sendemailcondition=true;
	    	    	else
	    	    		sendemailcondition=false;
	    	    	
	    	    	
	    	    	  
	    	    	sendemailcondition=true;
	    	    	
	    	    	*/
	    	    	List<Trendlines> trendlines_list = gupiaoDAO.getTrendlines();
	    	    	if(!trendlines_list.isEmpty()){
		  	    	    Iterator<Trendlines> iter=trendlines_list.iterator();
		  	    	    while(iter.hasNext()){
		  	    	    	Trendlines trendlines=(Trendlines)iter.next();
		  	    		   if(null==trendlines.getRiqi4()){
		  		    		   tempstr=trendlines.getGupiaodaima();		  		    		   
		  		    		   trendlineshashmap.put(tempstr,trendlines);
		  		    		   if(!gupiaodaimaSet.contains(tempstr))
		  		    			   gupiaodaimaSet.add(tempstr);
		  	    		   }
		  	    	    }
	    	    	}

	    	    	List<Inoutprice> inoutprice_list = gupiaoDAO.getInoutprice();
	  	    	    if(!inoutprice_list.isEmpty()){		  						  		
						Iterator<Inoutprice> iter=inoutprice_list.iterator();
						while(iter.hasNext()){
							Inoutprice inoutprice   = (Inoutprice) iter.next();
							tempstr=inoutprice.getGupiaodaima();
							inoutpricehashmap.put(tempstr,inoutprice);
							 if(!gupiaodaimaSet.contains(tempstr))
		  		    			   gupiaodaimaSet.add(tempstr);
						}
	  	    	    }
	  	    	    i_count = 0;
	  	    	    Iterator iter=gupiaodaimaSet.iterator();
	  	    	    while(iter.hasNext()){
	  	    	    	tempstr=(String)iter.next();
	  	    	    	if(i_count<100){	    			  
	  					  tempurl=MyTools.makeurl(tempurl,tempstr,i_count); 
	  					  i_count++;
	  	    		    }
	  				    else{		
	  					  tempurl=MyTools.makeurl(tempurl,tempstr,i_count);
	  					  i_count=0;
	  					  manipulation_data(inoutprice_list,trendlines_list,tempurl);
	  					  tempurl="";
	  				    }
	  	    	    }
	  	    	    if(i_count>0)
	  	    	    	manipulation_data(inoutprice_list,trendlines_list,tempurl);
	  	    	    if(this.str_seilin.length()>0){
	  	    	    	sendEmailByQQ.doSendHtmlEmail("��",new StringBuffer(this.str_seilin),"13580016553@139.com");	
	  	    	    	myprotocolhandler.broadcast(this.str_seilin);
	  	    	    }
	  	    	    if(this.str_seilout.length()>0){
	  	    	    	sendEmailByQQ.doSendHtmlEmail("��",new StringBuffer(this.str_seilout),"13580016553@139.com");	
	  	    	    	myprotocolhandler.broadcast(this.str_seilout);
	  	    	    	
	  	    	    }
	  	    	  if(this.str_msg.length()>0){
	  	    		  	sendEmailByQQ.doSendHtmlEmail("ͻ��������",new StringBuffer(this.str_msg),"13580016553@139.com");	
	  	    	    	myprotocolhandler.broadcast(this.str_msg);
	  	    	    	
	  	    	    }
	  	    	    this.str_msg="";  	    	   
	  	    	    this.str_seilin="";
	  	    	    this.str_seilout="";
	  	    	   
	  	    	    
	    	    }
	       }
}
