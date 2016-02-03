package com.gupiao.web.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import org.apache.log4j.*;
import org.hibernate.Query;
import org.hibernate.StatelessSession;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.MbcjgsjsTemporary;
import com.gupiao.model.persist.entity.Rzzgszc;
import com.gupiao.model.persist.entity.Sendemail;
import com.gupiao.socket.MyProtocolHandler;
public class TaskJobbak{

	
		private GupiaoDAO gupiaoDAO;
		private MyProtocolHandler myprotocolhandler;
		private boolean sendemailcondition=false;		
		public void setGupiaoDAO(GupiaoDAO gupiaoDAO) {
			this.gupiaoDAO = gupiaoDAO;
		}
		
		public void setMyprotocolhandler(MyProtocolHandler myprotocolhandler) {
			this.myprotocolhandler = myprotocolhandler;
		}

		/*public static Logger log = Logger
	                     .getLogger(TaskJobbak.class);
	       public void SayHello() {
	              // TODO Auto-generated method stub
	              try {
	                     log.info("处理任务开始>........");
	                     // 业务逻辑代码调用
	                     System.out.println("时间[" + new java.util.Date().toLocaleString()
	                                   + "]----->大家好啊！");
	                     log.info("处理任务结束!");
	              } catch (Exception e) {
	                     log.error("处理任务出现异常", e);
	              }
	       }
	       
	       */
	       public void  jiexiZUIDICYC13return(String tempurl,HashMap<String,Sendemail> hashmap,int k)throws Exception {//k=3现在价，k=5最低价
	   		String[] sinashuju,sinajs;
	   		String tempsinajs;
	   		int    i_position;
	   		String hashmapkey;
	   		String str_message="";
	   		String str_sendmessage="";
	   		
	   		tempsinajs = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));//读取股票数据	   		
	   		sinashuju=tempsinajs.split(";");                                      //把每个股票数据分开
	   		for(int i=0;i<sinashuju.length;i++){                                  //一个一个股票数据来分析
	   			i_position = sinashuju[i].indexOf("str");                         //定位头部
	   			if(i_position>0){
	   				hashmapkey=sinashuju[i].substring(i_position+6,i_position+12);//取出股票代码
	   				sinajs=sinashuju[i].split(",");                               //一个一个数据取出
	   				if(sinajs.length>0){
	   					if(hashmap.containsKey(hashmapkey)){                      //包含在HashMap中
	   						Sendemail sendemail = (Sendemail) hashmap.get(hashmapkey);//取出 
	   						if (sinajs.length>k){  //保证不会出现异常  
	   							/*if (gupiaoDAO.getzuixincyc13(hashmapkey)>=MyTools.StrToDouble(sinajs[k]) && MyTools.StrToDouble(sinajs[k])>0){//现在价和最低价才能这样比较，最高价这样不合适
	   								
	   								MyTools.SendMail("股东收集25%以上!",hashmapkey+",收集"+String.valueOf(rzzgszc.getRzzgzc())+"%"+",连续收集"+String.valueOf(rzzgszc.getLongtime())+"季度");    
	   								rzzgszc.setEmailriqi(new Date());
	   								gupiaoDAO.SaveObject(rzzgszc);
	   							}*/
	   							if (sendemail.getCyc13riqi()==null){
	   								if(sendemail.getCyc13price()>=MyTools.StrToDouble(sinajs[k]) && MyTools.StrToDouble(sinajs[k])>0){
	   									//str_sendmessage = hashmapkey+"现在价格为"+sinajs[k]+",低于CYC13:"+sendemail.getCyc13price()+",实际CYC13是:"+(new  BigDecimal(sendemail.getCyc13price()/1.005)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	   									str_sendmessage = hashmapkey+"现在价格为"+sinajs[k]+",低于CYC13:"+sendemail.getCyc13price();
	   									if (sendemailcondition)
	   										MyTools.SendMail(sendemail.getBiaoji(),str_sendmessage);
	   									str_message = str_message+sendemail.getBiaoji()+"  "+str_sendmessage;
	   									str_sendmessage="";
	   									
	   									//myprotocolhandler.broadcast(str_message);
	   									sendemail.setCyc13riqi(new Date());
	   									gupiaoDAO.SaveObject(sendemail);		   								
	   								}	   					
	   							}
	   							if (sendemail.getCyc34riqi()==null){
	   								if(sendemail.getCyc34price()>=MyTools.StrToDouble(sinajs[k]) && MyTools.StrToDouble(sinajs[k])>0){
	   									//str_sendmessage = hashmapkey+"现在价格为"+sinajs[k]+",低于CYC34:"+sendemail.getCyc34price()+",实际CYC34是:"+(new  BigDecimal(sendemail.getCyc34price()/1.005)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();	   									
	   									str_sendmessage = hashmapkey+"现在价格为"+sinajs[k]+",低于CYC34:"+sendemail.getCyc34price();
	   									if (sendemailcondition)
	   										MyTools.SendMail(sendemail.getBiaoji(),str_sendmessage);
	   									str_message = str_message+sendemail.getBiaoji()+"  "+str_sendmessage;
	   									str_sendmessage="";
	   									//myprotocolhandler.broadcast(str_message);
	   									sendemail.setCyc34riqi(new Date());
	   									gupiaoDAO.SaveObject(sendemail);		   								
	   								}
	   								
	   							}
	   						}
	   					}
	   												
	   				}
	   			}
	   		}
	   		if(str_message.length()>1){
				//MyTools.SendMail("股票买进",str_message);
				myprotocolhandler.broadcast(str_message);
			}
	   		
	   	}
	   	
	  
	       public void test() throws Exception{
	    	   int i_count=0;
	    	   String tempurl="",tempstr;
	    	   HashMap<String,Sendemail> hashmap = new HashMap<String,Sendemail>();
	    	   
	    	   List<Sendemail> list = gupiaoDAO.getsendemail();
	    	   Iterator<Sendemail> iter=list.iterator();//得到的记录条数有可能大于200
	    	   while(iter.hasNext()){
	    		   Sendemail sendemail=(Sendemail)iter.next();
	    		   if(null==sendemail.getCyc34riqi()){
		    		   tempstr=sendemail.getGupiaodaima();
		    		   hashmap.put(tempstr,sendemail);
		    		   if(i_count<100){	    			  
						  tempurl=MyTools.makeurl(tempurl,tempstr,i_count); 
						  i_count++;
		    		   }
					   else{		
						  tempurl=MyTools.makeurl(tempurl,tempstr,i_count);
						  i_count=0;
						  jiexiZUIDICYC13return(tempurl,hashmap,3);
						  tempurl="";
					   }
	    		   }
	    	   }
	    	   if(i_count>0){
						jiexiZUIDICYC13return(tempurl,hashmap,3);
								
	    	   }
	    	   
	       }
	    	   


	   
	       public void SendMailofInoutPrice() throws Exception {
	    	   
	    	    String tempstr = "",tempurl="",tempsinajs="",str_msg="";
	    	    String[] sinajs;
	    		String[] sinashuju;
	    		String   haspmapkey;
	    		String   email_msg="",str_title="";	    		
	    	    int i_count = 0,i_position=0;
	    	    HashMap<String,Inoutprice> haspmap=new HashMap<String,Inoutprice>();
	    	    
	    	    
	    	    
	    	   
	    	   
	    	    if(gupiaoDAO.getWhileworkspilttime()==1)
	    	    {
	    	    	if ("0".equals(gupiaoDAO.getprocedurecondition("1")))//参数1是这个程序的标示,其他程序可能用到2,3,4...,返回"0"就发送邮件,返回其他不发送邮件
	    	    		sendemailcondition=true;
	    	    	else
	    	    		sendemailcondition=false;
	    	    	test();
	    	    	
	    	   
		    	    List<Inoutprice> list = gupiaoDAO.getInoutprice();	
		    	    
			  		if(!list.isEmpty()){
				  		
						Iterator<Inoutprice> iter=list.iterator();
						while(iter.hasNext()){
							Inoutprice inoutprice   = (Inoutprice) iter.next();
							haspmap.put(inoutprice.getGupiaodaima(),inoutprice);
							tempstr=inoutprice.getGupiaodaima();
							
							if (i_count==0){
								if(MyTools.getJiaoYiShuoYahoo(tempstr).equalsIgnoreCase("SZ"))
									tempurl="http://hq.sinajs.cn/list="+"sz"+tempstr;
								else
									tempurl="http://hq.sinajs.cn/list="+"sh"+tempstr;
							}
							else
							{
								if(MyTools.getJiaoYiShuoYahoo(tempstr).equalsIgnoreCase("SZ"))
									tempurl=tempurl+",sz"+tempstr;
								else
									tempurl=tempurl+",sh"+tempstr;
							}
							i_count++;
						}
						
						
						try{
						
							tempsinajs = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));
							sinashuju=tempsinajs.split(";");
							for(int i=0;i<sinashuju.length;i++){
								i_position = sinashuju[i].indexOf("str");
								if(i_position>0){
									haspmapkey=sinashuju[i].substring(i_position+6,i_position+12);
									sinajs=sinashuju[i].split(",");
									if(sinajs.length>4){
										
										/*
										 * 卖出股票判断,最高价大于设定价,最高价在第五项sinajs[4],inoutprice.leixin='0'
										 */
										if("0".equals(((Inoutprice)haspmap.get(haspmapkey)).getLeixin())){
											if(MyTools.StrToDouble(sinajs[4])>=((Inoutprice)haspmap.get(haspmapkey)).getPrice()){
												str_title="出";
												str_msg=str_msg+haspmapkey+"卖出,";	
												email_msg=email_msg+str_msg;
												gupiaoDAO.deleteInoutprice(haspmapkey);
											}
										}
										else{
										/*
										 * 买入股票判断,当前价小于设定价,当前价在第四项sinajs[3],inoutprice.leixin='1',如果outprice.price=0,取对应股票的最新cyc13值，如果大于0，比较当前值。
										 */
											if(((Inoutprice)haspmap.get(haspmapkey)).getPrice()>0){
												if(MyTools.StrToDouble(sinajs[3])<=((Inoutprice)haspmap.get(haspmapkey)).getPrice()&&MyTools.StrToDouble(sinajs[3])>0){
													str_title="入";
													str_msg=str_msg+haspmapkey+"卖入,价格："+((Inoutprice)haspmap.get(haspmapkey)).getPrice()+","+((Inoutprice)haspmap.get(haspmapkey)).getBeizu()+((Inoutprice)haspmap.get(haspmapkey)).getRiqi().toString();
													email_msg=email_msg+str_msg;
													//MyTools.SendMail("股票买进卖出!taskjob",str_msg);													
													str_msg="";
													gupiaoDAO.deleteInoutprice(haspmapkey);
												}
											}else{
												double dou_zuixincyc13=	gupiaoDAO.getzuixincyc13(haspmapkey);								
												if(MyTools.StrToDouble(sinajs[3])<=dou_zuixincyc13&&MyTools.StrToDouble(sinajs[3])>0){
													str_title="入";
													str_msg=str_msg+haspmapkey+"卖入,价格："+dou_zuixincyc13+","+((Inoutprice)haspmap.get(haspmapkey)).getBeizu()+((Inoutprice)haspmap.get(haspmapkey)).getRiqi().toString();													
													email_msg=email_msg+str_msg;
													//MyTools.SendMail("股票买进卖出!taskjob",str_msg);													
													str_msg="";
													gupiaoDAO.deleteInoutprice(haspmapkey);
												}
												
											}
										}
									}
								}
								
							}
						}catch(Exception e){
							
						}
						finally{
							if(email_msg.length()>1){
								MyTools.SendMail(str_title,email_msg);
								myprotocolhandler.broadcast(email_msg);
							}
							
						}
			   		}
		   		
	    	    }
	  

	       }

}
