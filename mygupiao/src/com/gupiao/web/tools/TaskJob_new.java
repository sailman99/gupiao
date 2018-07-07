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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.MessageCreator;













import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Cycwarm;
import com.gupiao.model.persist.entity.Dazhongjiaoyi;
import com.gupiao.model.persist.entity.Gubanjiegou;
import com.gupiao.model.persist.entity.Gupiao;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.Rzzgs;
import com.gupiao.model.persist.entity.Scalewarm;
import com.gupiao.model.persist.entity.Sendemail;
import com.gupiao.model.persist.entity.Trendlines;
import com.gupiao.socket.MyProtocolHandler;


public class TaskJob_new{

	
		private GupiaoDAO gupiaoDAO;
	
	//	private MyProtocolHandler myprotocolhandler;
		
	//	private SendEmailByQQ sendEmailByQQ=new SendEmailByQQ();

		private SimpleDateFormat sdf;//
	//	private org.apache.activemq.command.ActiveMQTopic aMQTopic;
	//	private org.springframework.jms.core.JmsTemplate jmsTemplate;
	//	private boolean sendemailcondition=false;	
		private String str_msg,str_seilout,str_seilin,str_cycwarm,str_scalewarm;
		
		public SimpleDateFormat getSdf() {
			//return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA); //
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sim.setTimeZone(TimeZone.getDefault());
			return sim;	
		}
		
		public void setGupiaoDAO(GupiaoDAO gupiaoDAO) {
			this.gupiaoDAO = gupiaoDAO;
		}
		/*
		public void setMyprotocolhandler(MyProtocolHandler myprotocolhandler) {
			this.myprotocolhandler = myprotocolhandler;
		}
		*/
		/*
		public void setJmsTemplate(org.springframework.jms.core.JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
		}
		public void setaMQTopic(org.apache.activemq.command.ActiveMQTopic aMQTopic) {
			this.aMQTopic = aMQTopic;
		}
		 */
		/*
		public void TestJMS(){
			
			
			
			UUID uuid=UUID.randomUUID();
	    		sdf=this.getSdf();
	    		final String str_temp=String.valueOf(uuid)+"@#@��ݲ���@#@"+sdf.format(System.currentTimeMillis())+"��ݲ���"+"@#@author@#@"+sdf.format(System.currentTimeMillis()); 
	   
	    		jmsTemplate.send(aMQTopic, new MessageCreator() {  
	  	            public Message createMessage(Session session) throws JMSException {   
	  	            	
	  	            	Message message= session.createTextMessage(str_temp);
	  	            	
	  	            	
	  	            //	message.setStringProperty("PTP_CLIENTID", "867058469098214");
	  	            	message.setStringProperty("PTP_CLIENTID", "863994018967547");	  	            	
	  	                return message;  
	  	            }  
	  	        });  
		
		}*/
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

		
		public  void manipulation_data(String tempurl) throws Exception{
			String[] sinajs;
			
			String   str_gupiaodaima;
			  
			int i_position=0;
		   
			Gupiaoshuju gupiaoshuju=new Gupiaoshuju();
			
			String tempsinajs = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));
		   
			String[] sinashuju=tempsinajs.split(";");
			for(int i=0;i<sinashuju.length;i++){
				i_position = sinashuju[i].indexOf("str");
				if(i_position>0){
					str_gupiaodaima=sinashuju[i].substring(i_position+6,i_position+12);
					sinajs=sinashuju[i].split(",");
					
					if(sinajs.length>10 && MyTools.StrToDouble(sinajs[5])>0){
						gupiaoshuju.setGupiaodaima(str_gupiaodaima);
						gupiaoshuju.setRiqi(MyTools.strToDate(sinajs[30].replaceAll("-", "")));
						gupiaoshuju.setKaipan(MyTools.StrToDouble(sinajs[1]));
						gupiaoshuju.setZuigao(MyTools.StrToDouble(sinajs[4]));
						gupiaoshuju.setZuidi(MyTools.StrToDouble(sinajs[5]));
						gupiaoshuju.setShoupan(MyTools.StrToDouble(sinajs[3]));
						gupiaoshuju.setChengjiaoshou(MyTools.StrToDouble(sinajs[8]));
						gupiaoshuju.setChengjiaojiner(MyTools.StrToDouble(sinajs[9]));
						gupiaoDAO.SaveObject(gupiaoshuju);
					}
				}
			}
		}
		
		
		
		
		
		
		
		

		public void manipulation_data(List<Inoutprice> inoutprice_list,List<Trendlines> trendlines_list,List<Cycwarm> cycwarm_list,List<Scalewarm> scalewarm_list,String tempurl) throws Exception{
	    	   
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
							//判断股价是否达到卖出买入价
							for(Inoutprice inoutprice:inoutprice_list){
								if(inoutprice.getGupiaodaima().equals(hashmapkey)){
									if("0".equals(inoutprice.getLeixin())){
										if(MyTools.StrToDouble(sinajs[4])>=inoutprice.getPrice()){
											this.str_seilout=this.str_seilout+hashmapkey+",";	
											gupiaoDAO.deleteInoutprice(hashmapkey);
										}
									}	
								
									else{
										if(inoutprice.getPrice()>0){
											if(MyTools.StrToDouble(sinajs[5])<=inoutprice.getPrice()&&MyTools.StrToDouble(sinajs[5])>0){											
												this.str_seilin=this.str_seilin+hashmapkey+","+inoutprice.getPrice();
												gupiaoDAO.deleteInoutprice(hashmapkey);
											}
										}
									}
								}	
							}
							//判断股价穿越趋势线
							for(Trendlines trendlines:trendlines_list){
								if(hashmapkey.equals(trendlines.getGupiaodaima())){	
									if("1".equals(trendlines.getUpordown())){//股价由下向上突破趋势线
										/*
										 * sinajs[4]的当天最高价格
										 */
										if(trendlines.getForecastprice()<=MyTools.StrToDouble(sinajs[4]) && MyTools.StrToDouble(sinajs[4])>0){
		   									
		   									this.str_msg=this.str_msg + hashmapkey+"今天最高股价是："+sinajs[4]+"向上突破趋势线，原定的价格是："+trendlines.getForecastprice();	   									  			   								
		   									trendlines.setRiqi4(new Date());
		   									trendlines.setDot4(MyTools.StrToDouble(sinajs[4]));
		   									gupiaoDAO.SaveObject(trendlines);		   						
		   								}	
									}
									else{
										/*
										 * sinajs[5]当天最低价格，股价跌破预定价格
										 */
		   								if(trendlines.getForecastprice()>=MyTools.StrToDouble(sinajs[5]) && MyTools.StrToDouble(sinajs[5])>0){
		   									
		   									this.str_msg=this.str_msg + hashmapkey+"今天最低价格是："+sinajs[5]+"向下跌破趋势线,原定的价格是："+trendlines.getForecastprice();	   									  
		   									trendlines.setRiqi4(new Date());
		   									trendlines.setDot4(MyTools.StrToDouble(sinajs[3]));
		   									gupiaoDAO.SaveObject(trendlines);		   						
		   								}	
									}
								}
							}
							
							//判断股价是否跌到EXPMA线
							for(Cycwarm cycwarm:cycwarm_list){
								if(cycwarm.getGupiaodaima().equals(hashmapkey)){
									if(cycwarm.getJiage()>0){
										if(MyTools.StrToDouble(sinajs[5])<=cycwarm.getJiage()&&MyTools.StrToDouble(sinajs[5])>0){											
											this.str_cycwarm=this.str_cycwarm+hashmapkey+","+cycwarm.getJiage();
											cycwarm.setComeriqi(new Date());
											gupiaoDAO.SaveObject(cycwarm);
										}
									}
								}	
							}
							
							
							//判断股价是否达到黄金比例价
							for(Scalewarm scalewarm:scalewarm_list){
								if(scalewarm.getGupiaodaima().equals(hashmapkey)){
									if((scalewarm.getJiage()>0)&&(null==scalewarm.getRiqi())){
										if(MyTools.StrToDouble(sinajs[5])<=scalewarm.getJiage()&&MyTools.StrToDouble(sinajs[5])>0){											
											this.str_scalewarm=this.str_scalewarm+hashmapkey+",股价由高点回调,达到设定的价格"+scalewarm.getJiage();
											scalewarm.setRiqi(new Date());
											gupiaoDAO.SaveObject(scalewarm);
										}
									}
								}	
							}
							
							//判断股价是否达到再回调0.5
							for(Scalewarm scalewarm:scalewarm_list){
								if(scalewarm.getGupiaodaima().equals(hashmapkey)){
									if(scalewarm.getJierudianjiagea()>0&&null==scalewarm.getJierudianjiageariqi()){
										if(MyTools.StrToDouble(sinajs[5])<=scalewarm.getJierudianjiagea()&&MyTools.StrToDouble(sinajs[5])>0){											
											this.str_scalewarm=this.str_scalewarm+hashmapkey+",股价达到再回调0.5,设定的价格是"+scalewarm.getJierudianjiagea();
											scalewarm.setJierudianjiageariqi(new Date());
											gupiaoDAO.SaveObject(scalewarm);
										}
									}
								}	
							}
							//判断股价是否达到再回调0.618
							for(Scalewarm scalewarm:scalewarm_list){
								if(scalewarm.getGupiaodaima().equals(hashmapkey)){
									if(scalewarm.getJierudianjiageb()>0&&null==scalewarm.getJierudianjiagebriqi()){
										if(MyTools.StrToDouble(sinajs[5])<=scalewarm.getJierudianjiageb()&&MyTools.StrToDouble(sinajs[5])>0){											
											this.str_scalewarm=this.str_scalewarm+hashmapkey+",股价达到再回调0.618,设定的价格是"+scalewarm.getJierudianjiageb();
											scalewarm.setJierudianjiagebriqi(new Date());
											gupiaoDAO.SaveObject(scalewarm);
										}
									}
								}	
							}
							
							
							
						}
					}
				}
	       }
	       
		   public void genericGupiaoshuju() throws Exception{
			   String str_gupiaodaima,tempurl="";
				
				
				int i_count=0;
				
				
				
				List<Gupiao> list =gupiaoDAO.getAllGupiao();
				
				
				for(Gupiao gupiao:list){
		    	    	str_gupiaodaima=gupiao.getGupiaodaima();
		    	    	if(i_count<100){	    			  
						  tempurl=MyTools.makeurl(tempurl,str_gupiaodaima,i_count); 
						  i_count++;
		    		    }
					    else{		
						  tempurl=MyTools.makeurl(tempurl,str_gupiaodaima,i_count);
						  i_count=0;
						  manipulation_data(tempurl);
						  tempurl="";
					    }
				}
	    	    if(i_count>0)
	    	    	manipulation_data(tempurl);
			
			
	    	    List<Dazhongjiaoyi> list_dazhongjiaoyi=MyTools.getDazhongjiaoyiByOneHtml();
	    		if(null!=list_dazhongjiaoyi){
	    			for(Dazhongjiaoyi dazhongjiaoyi:list_dazhongjiaoyi){
	    				gupiaoDAO.SaveObject(dazhongjiaoyi);
	    				
	    			}
	    			
	    		}
	    		
				
	    		gupiaoDAO.generate_gupiaoshujus();//生成换手率
				
	    		gupiaoDAO.generate_gupiaoshujuhuanshou();//生成换手率5,10,...
				
	    		gupiaoDAO.generic_gupiaoshujucyc();//生成CYC
				
	    		gupiaoDAO.generic_zuidicyc();//
				
	    		gupiaoDAO.generic_zuoshouzhangfu();
				
	    		gupiaoDAO.generic_genericcyc55zhouqi();
				
	    		gupiaoDAO.generic_updatetrendlines();
				
	    		gupiaoDAO.generic_updatescalewarm();
				
	    		gupiaoDAO.generic_updatecycwarm();
				
	    		gupiaoDAO.generichuanshou30cyc34count();
				
		   }
		
		   public void genericGubenjiegou() throws Exception {
			    String tmpurl;
				
			    List<Gupiao> listgupiao=gupiaoDAO.getAllGupiao();
				for(Gupiao gupiao:listgupiao){
					String str_gupiaodaima = gupiao.getGupiaodaima();
					tmpurl="http://stockdata.stock.hexun.com/2009_gbjg_"+str_gupiaodaima+".shtml";
				
					List<Gubanjiegou> list=MyTools.getGubenjiegou(tmpurl, str_gupiaodaima);
					if(null!=list){						
						for(Gubanjiegou gubanjiegou:list){							
							 if(null != gubanjiegou && null !=gubanjiegou.getGupiaodaima() && null != gubanjiegou.getRiqi()){
								 gupiaoDAO.SaveObject(gubanjiegou);
							 }
						}
					}
				}
		   }
		   public void genericRzzgs() throws Exception {
			    String tmpurl ;
				
				
				
				List<Gupiao> listgupiao=gupiaoDAO.getAllGupiao();
				
				for(Gupiao gupiao:listgupiao)
				{
					       
					String str_gupiaodaima = gupiao.getGupiaodaima();
					
					tmpurl="http://stockdata.stock.hexun.com/2009_cgjzd_"+str_gupiaodaima+".shtml";
				
					Date maxriqi=gupiaoDAO.getRzzgsMaxDate(str_gupiaodaima);
					List<Rzzgs> list=MyTools.getRzzgsnew(tmpurl, str_gupiaodaima,maxriqi);
					if(null!=list){
						Iterator<Rzzgs> iter=list.iterator();
						while(iter.hasNext()){
							Rzzgs rzzgs   = (Rzzgs) iter.next(); 	
							 if(null != rzzgs  && null !=rzzgs .getGupiaodaima() && null != rzzgs.getRiqi()){
								 
								 gupiaoDAO.SaveObject(rzzgs);
							 }
						}
					}
				}
				gupiaoDAO.generic_updaterzzgsjsqbh2();
			}
				
		  
	       public void SendMailofInoutPrice() throws Exception {
	    	   
	    	    String tempstr = "",tempurl="";
	    		
	    		
	    		this.str_msg="";
	    		
	    		this.str_seilout="";
	    		this.str_seilin="";
	    		this.str_scalewarm="";
	    		this.str_cycwarm="";
	    		
	    	    int i_count = 0;
	    	    HashMap<String,Inoutprice> inoutpricehashmap=new HashMap<String,Inoutprice>();	    	  
	    	    HashMap<String,Trendlines> trendlineshashmap = new HashMap<String,Trendlines>();
	    	    HashMap<String,Cycwarm>    cycwarmhashmap= new HashMap<String,Cycwarm>();
	    	    HashMap<String,Scalewarm>  scalewarmhashmap= new HashMap<String,Scalewarm>();
	    	    Set<String> gupiaodaimaSet = new HashSet<String>();  
	    	    
	    	
	    	   
	    	   // if(gupiaoDAO.getWhileworkspilttime()==1)
	    	    {   //跌破或升破某一趋势线时预警
	    	    	List<Trendlines> trendlines_list=gupiaoDAO.getTrendlines();
	    	    	
		    	    for(Trendlines trendlines:trendlines_list){
		    	    	if(null==trendlines.getRiqi4()){
			  		   		   tempstr=trendlines.getGupiaodaima();		  		    		   
			  		   		   trendlineshashmap.put(tempstr,trendlines);
			  		   		   if(!gupiaodaimaSet.contains(tempstr))
			  		   			   gupiaodaimaSet.add(tempstr);
			  	    	   }
		    	    }
		    	   
	    	    	//跌破或升破某一价格点时预警
	    	    	List<Inoutprice> inoutprice_list=gupiaoDAO.getInoutprice();
	    	    	
	    	    	for(Inoutprice inoutprice:inoutprice_list){
	    	    		tempstr=inoutprice.getGupiaodaima();
						inoutpricehashmap.put(tempstr,inoutprice);
						 if(!gupiaodaimaSet.contains(tempstr))
	  		    			   gupiaodaimaSet.add(tempstr);
	    	    	}
	    	    
	    	    	//跌破EXMPA线时预警
	    	    	List<Cycwarm> cycwarm_list = gupiaoDAO.getCycwarm();
	    	    	for(Cycwarm cycwarm:cycwarm_list){
	    	    		tempstr=cycwarm.getGupiaodaima();
	    	    		cycwarmhashmap.put(tempstr,cycwarm);
	    	    		if(!gupiaodaimaSet.contains(tempstr))
	    	    			gupiaodaimaSet.add(tempstr);
	    	    	}
	    	    	
	    	    	//跌破黄金线警告
	    	    	List<Scalewarm> scalewarm_list = gupiaoDAO.getScalewarm();
	    	    	for(Scalewarm scalewarm:scalewarm_list){
	    	    		tempstr=scalewarm.getGupiaodaima();
	    	    		scalewarmhashmap.put(tempstr,scalewarm);
	    	    		if(!gupiaodaimaSet.contains(tempstr))
	    	    			gupiaodaimaSet.add(tempstr);
	    	    	}
	    	    
	    	    	
	    	    	i_count = 0;
	  	    	    Iterator iter=gupiaodaimaSet.iterator();
	  	    	    while(iter.hasNext()){
	  	    	    	tempstr=(String)iter.next();
	  	    	    	if(i_count<100){//如果太多股票代码会出现问题的，就限定100个股票	    			  
	  					  tempurl=MyTools.makeurl(tempurl,tempstr,i_count); 
	  					  i_count++;
	  				
	  	    		    }
	  				    else{		
	  					  tempurl=MyTools.makeurl(tempurl,tempstr,i_count);
	  					  i_count=0;
	  					  manipulation_data(inoutprice_list,trendlines_list,cycwarm_list,scalewarm_list,tempurl);
	  					  tempurl="";
	  				    }
	  	    	    }
	  	    	    if(i_count>0)
	  	    	    	manipulation_data(inoutprice_list,trendlines_list,cycwarm_list,scalewarm_list,tempurl);
	  	    	    if(this.str_seilin.length()>0){
	  	    	    	//sendEmailByQQ.doSendHtmlEmail("买入",new StringBuffer(this.str_seilin),"13580016553@139.com");	
	  	    	    	MyTools.SendMailBy163("买入",this.str_seilin);
	  	    	    	//myprotocolhandler.broadcast(this.str_seilin);
	  	    	    }
	  	    	    if(this.str_seilout.length()>0){
	  	    	    	//sendEmailByQQ.doSendHtmlEmail("卖出",new StringBuffer(this.str_seilout),"13580016553@139.com");	
	  	    	    	MyTools.SendMailBy163("卖出",this.str_seilout);
	  	    	    	//myprotocolhandler.broadcast(this.str_seilout);
	  	    	    	
	  	    	    }
	  	    	    if(this.str_msg.length()>0){
	  	    		  //sendEmailByQQ.doSendHtmlEmail("消息",new StringBuffer(this.str_msg),"13580016553@139.com");	
	  	    	    	MyTools.SendMailBy163("消息",this.str_msg);
	  	    		  //myprotocolhandler.broadcast(this.str_msg);
	  	    	    	
	  	    	    }
	  	    	  if(this.str_cycwarm.length()>0){
	  	    		  //sendEmailByQQ.doSendHtmlEmail("消息",new StringBuffer(this.str_msg),"13580016553@139.com");	
	  	    	    	MyTools.SendMailBy163("expma",this.str_cycwarm);
	  	    		  //myprotocolhandler.broadcast(this.str_msg);
	  	    	    	
	  	    	    }
	  	    	 if(this.str_scalewarm.length()>0){
	  	    		  //sendEmailByQQ.doSendHtmlEmail("消息",new StringBuffer(this.str_msg),"13580016553@139.com");	
	  	    	    	MyTools.SendMailBy163("黄金线",this.str_scalewarm);
	  	    		  //myprotocolhandler.broadcast(this.str_msg);
	  	    	    	
	  	    	    }
	  	    	    
	  	    	    
	  	    	    
	  	    	    this.str_msg="";  	    	   
	  	    	    this.str_seilin="";
	  	    	    this.str_seilout="";
	  	    	   
	  	    	    
	    	    }
	       }
}
