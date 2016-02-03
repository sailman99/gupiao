package com.gupiao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Rzzgs;

public class TestGupiaoDAOImpl {

	@Test
	public void testGetgupiaoshuju() throws Exception {
		ApplicationContext ctx =new FileSystemXmlApplicationContext("D:/workspaces/mygupiao/WebRoot/WEB-INF/applicationContext.xml");
		GupiaoDAO gupiaoDAO=(GupiaoDAO)ctx.getBean("gupiaoDAO");
		List<Rzzgs> list=(List<Rzzgs>)gupiaoDAO.getrzzgsByCondition(new Double(20),new Double(20));
		for(Rzzgs rzzgs:list){
			System.out.println(rzzgs.getRiqi());
		}
		
	}

}
