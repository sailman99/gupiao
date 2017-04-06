package com.gupiao.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Rzzgs;

public class TestDate {

	@Test
	public void testGetgupiaoshuju() throws Exception {
		
		System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		//List<Rzzgs> list=(List<Rzzgs>)gupiaoDAO.getrzzgsByCondition(new Double(20),new Double(20),"2015-09-30");
		/*
		for(Rzzgs rzzgs:list){
			System.out.println(rzzgs.getRiqi());
		}*/
		
	}

}
