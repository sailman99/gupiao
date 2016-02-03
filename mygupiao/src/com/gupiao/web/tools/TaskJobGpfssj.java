package com.gupiao.web.tools;

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
public class TaskJobGpfssj{

	
		private GupiaoDAO gupiaoDAO;
		
		public void setGupiaoDAO(GupiaoDAO gupiaoDAO) {
			this.gupiaoDAO = gupiaoDAO;
		}
		
	/*	public static Logger log = Logger
	                     .getLogger(TaskJobGpfssj.class);
	       public void SayHello() {
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
	       public void  jiexiZUIDICYC13return(String tempurl,HashMap<String,Rzzgszc> hashmap,int k)throws Exception {//k=3���ڼۣ�k=5��ͼ�
	   		String[] sinashuju,sinajs;
	   		String tempsinajs;
	   		int    i_position;
	   		String hashmapkey;
	   		
	   		
	   		tempsinajs = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));//��ȡ��Ʊ����	   		
	   		sinashuju=tempsinajs.split(";");                                      //��ÿ����Ʊ���ݷֿ�
	   		for(int i=0;i<sinashuju.length;i++){                                  //һ��һ����Ʊ����������
	   			i_position = sinashuju[i].indexOf("str");                         //��λͷ��
	   			if(i_position>0){
	   				hashmapkey=sinashuju[i].substring(i_position+6,i_position+12);//ȡ����Ʊ����
	   				sinajs=sinashuju[i].split(",");                               //һ��һ������ȡ��
	   				if(sinajs.length>0){
	   					if(hashmap.containsKey(hashmapkey)){                      //������HashMap��
	   						Rzzgszc rzzgszc = (Rzzgszc) hashmap.get(hashmapkey);//ȡ�� 
	   						if (sinajs.length>k&&rzzgszc.getSendemail()==0)  //��֤��������쳣  
	   							if (gupiaoDAO.getzuixincyc13(hashmapkey)>=MyTools.StrToDouble(sinajs[k]) && MyTools.StrToDouble(sinajs[k])>0){//���ڼۺ���ͼ۲��������Ƚϣ���߼�����������
	   								
	   								MyTools.SendMail("�ɶ��ռ�25%����!",hashmapkey+",�ռ�"+String.valueOf(rzzgszc.getRzzgzc())+"%"+",�����ռ�"+String.valueOf(rzzgszc.getLongtime())+"����");    
	   								rzzgszc.setEmailriqi(new Date());
	   								gupiaoDAO.SaveObject(rzzgszc);
	   							}
	   					}
	   												
	   				}
	   			}
	   		}
	   		
	   	}
	   	
	  
	       public void test() throws Exception{
	    	   int i_count=0;
	    	   String tempurl="",tempstr;
	    	   HashMap<String,Rzzgszc> hashmap = new HashMap<String,Rzzgszc>();
	    	   
	    	   List<Rzzgszc> list = gupiaoDAO.getrzzgszcsendmail();
	    	   Iterator<Rzzgszc> iter=list.iterator();//�õ��ļ�¼�����п��ܴ���200
	    	   while(iter.hasNext()){
	    		   Rzzgszc rzzgszc=(Rzzgszc)iter.next();
	    		   tempstr=rzzgszc.getGupiaodaima();
	    		   hashmap.put(tempstr,rzzgszc);
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
	    	   if(i_count>0){
						jiexiZUIDICYC13return(tempurl,hashmap,3);
								
	    	   }
	       }
	    	   


	   
	       public void SendMailofInoutPrice() throws Exception {
	    	   
	    	    String tempstr = "",tempurl="",tempsinajs="",str_msg="";
	    	    String[] sinajs;
	    		String[] sinashuju;
	    		String   haspmapkey;
	    		String   email_msg="";
	    		
	    	    int i_count = 0,i_position=0;
	    	    HashMap<String,Inoutprice> haspmap=new HashMap<String,Inoutprice>();
	    	    test();
	    	   
	    	   
	    	    if(gupiaoDAO.getWhileworkspilttime()==1)
	    	    {
	    	    	
	    	    	
	    	   
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
										 * ������Ʊ�ж�,��߼۴����趨��,��߼��ڵ�����sinajs[4],inoutprice.leixin='0'
										 */
										if("0".equals(((Inoutprice)haspmap.get(haspmapkey)).getLeixin())){
											if(MyTools.StrToDouble(sinajs[4])>=((Inoutprice)haspmap.get(haspmapkey)).getPrice()){
												str_msg=str_msg+haspmapkey+"����,";	
												email_msg=email_msg+str_msg;
												gupiaoDAO.deleteInoutprice(haspmapkey);
											}
										}
										else{
										/*
										 * �����Ʊ�ж�,��ǰ��С���趨��,��ǰ���ڵ�����sinajs[3],inoutprice.leixin='1',���outprice.price=0,ȡ��Ӧ��Ʊ������cyc13ֵ���������0���Ƚϵ�ǰֵ��
										 */
											if(((Inoutprice)haspmap.get(haspmapkey)).getPrice()>0){
												if(MyTools.StrToDouble(sinajs[3])<=((Inoutprice)haspmap.get(haspmapkey)).getPrice()&&MyTools.StrToDouble(sinajs[3])>0){
													str_msg=str_msg+haspmapkey+"����,�۸�"+((Inoutprice)haspmap.get(haspmapkey)).getPrice()+","+((Inoutprice)haspmap.get(haspmapkey)).getBeizu();
													email_msg=email_msg+str_msg;
													//MyTools.SendMail("��Ʊ�������!taskjob",str_msg);													
													str_msg="";
													gupiaoDAO.deleteInoutprice(haspmapkey);
												}
											}else{
												double dou_zuixincyc13=	gupiaoDAO.getzuixincyc13(haspmapkey);								
												if(MyTools.StrToDouble(sinajs[3])<=dou_zuixincyc13&&MyTools.StrToDouble(sinajs[3])>0){
													str_msg=str_msg+haspmapkey+"����,�۸�"+dou_zuixincyc13+","+((Inoutprice)haspmap.get(haspmapkey)).getBeizu();														
													email_msg=email_msg+str_msg;
													//MyTools.SendMail("��Ʊ�������!taskjob",str_msg);													
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
								MyTools.SendMail("��Ʊ�������!taskjob",email_msg);
							}
							
						}
			   		}
		   		
	    	    }
	  

	       }

}
