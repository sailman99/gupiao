package com.gupiao.model.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.struts.action.GupiaoAction;
import com.gupiao.web.tools.TaskJob;





public class gupiaotest {
	

	
	
   public static void main(String[] args){
	   
		

			 ApplicationContext act = new ClassPathXmlApplicationContext("testapplicationContext.xml");
	//   ApplicationContext act = new FileSystemXmlApplicationContext("/testapplicationContext.xml");		
	   
			 TaskJob gupiaodao =(TaskJob)act.getBean("taskJob");
			 try{
				// gupiaodao.test();
				 System.out.println("");
			 }catch(Exception e){
				 e.printStackTrace();
			 }
				
   }
}