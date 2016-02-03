package com.gupiao.model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;






import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;






import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.MbcjgsjsTemporary;
import com.gupiao.model.persist.entity.Procedurecondition;
import com.gupiao.model.persist.entity.Rzzgs;
import com.gupiao.model.persist.entity.Rzzgszc;
import com.gupiao.model.persist.entity.Sendemail;
import com.gupiao.model.persist.entity.Trendlines;
import com.gupiao.web.tools.MyTools;
import com.example.share.Gpsclientdata;


@Repository("gupiaoDAO")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class GupiaoDAOImpl  implements GupiaoDAO {
	
	
	private int Result=0;
	private SessionFactory sessionFactory;
	
	
	
	@Autowired
	public void GupiaoDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	private Session getOneSession(){
		return this.sessionFactory.openSession();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateGpsclientdata(List<Gpsclientdata> list){
		Iterator<Gpsclientdata> iter=list.iterator();
		while(iter.hasNext()){
			com.example.share.Gpsclientdata gpsclientdata=(Gpsclientdata)iter.next();
			SaveObject(gpsclientdata);
			
		}
		
	}
	
	
	public List<Gupiaoshuju> getgupiaoshuju(String str_gupiaodaima) throws Exception{
		String tempurl="";
		String sinajs[];
		Session session=getOneSession();
	//	session.beginTransaction();
		Query query = session.createQuery("from Gupiaoshuju where gupiaodaima="+str_gupiaodaima+" and riqi>sysdate-200 order by riqi");
		
		List<Gupiaoshuju> list=query.list();
	//	session.close();
		Gupiaoshuju gupiaoshujua=list.listIterator(list.size()-1).next();
		Gupiaoshuju gupiaoshuju=new Gupiaoshuju();
		gupiaoshuju.setGupiaodaima(str_gupiaodaima);
		
		tempurl=MyTools.makeurl(tempurl,str_gupiaodaima,0); 
		String sinashuju = MyTools.inputStream2String(MyTools.readHttmnew(tempurl));
		int i_position = sinashuju.indexOf("str");
		if(i_position>0){			
			sinajs=sinashuju.split(",");
			if(sinajs.length>10 && MyTools.StrToDouble(sinajs[5])>0){
				if(!(gupiaoshujua.getRiqi().compareTo(MyTools.strToDate(sinajs[30].replaceAll("-", "")))==0)){
					gupiaoshuju.setGupiaodaima(str_gupiaodaima);
					gupiaoshuju.setRiqi(MyTools.strToDate(sinajs[30].replaceAll("-", "")));
					gupiaoshuju.setKaipan(MyTools.StrToDouble(sinajs[1]));
					gupiaoshuju.setZuigao(MyTools.StrToDouble(sinajs[4]));
					gupiaoshuju.setZuidi(MyTools.StrToDouble(sinajs[5]));
					gupiaoshuju.setShoupan(MyTools.StrToDouble(sinajs[3]));
					gupiaoshuju.setChengjiaoshou(MyTools.StrToDouble(sinajs[8]));
					gupiaoshuju.setChengjiaojiner(MyTools.StrToDouble(sinajs[9]));
					list.add(gupiaoshuju);
				}
			}
		}
		session.close();
		return list;
		
	}
	public List<MbcjgsjsTemporary> getfindZUIDICYC13return(){
		
		
		Session session=getOneSession();
		Query query = session.getNamedQuery("getfindZUIDICYC13");		
		List< MbcjgsjsTemporary> list=query.list();
		session.close();
		return list;
		
	
	}
	public String getprocedurecondition(String str_procedurethread){	
		String str_return="";
		Session session=getOneSession();		
		Query query = session.createQuery("from Procedurecondition where procedurethread="+str_procedurethread);			
		List<Procedurecondition> list=query.list();
		Iterator<Procedurecondition> iterprocedurecondition = list.iterator();
		while(iterprocedurecondition.hasNext()){
			Procedurecondition procedurecondition=(Procedurecondition)iterprocedurecondition.next();
			str_return=procedurecondition.getCondition();
		}		
		session.close();
		return str_return;
	}
	public List<MbcjgsjsTemporary> findlow(){
		Session session=getOneSession();		
		Query query = session.getNamedQuery("findlow"); 		
		List< MbcjgsjsTemporary> list=query.list();	
		session.close();
		return list;
	}
	
	public List<Inoutprice> getInoutprice(){
		Session session=getOneSession();
		
		Query query = session.createQuery("from Inoutprice");			
		List<Inoutprice> list=query.list();
		session.close();
		return list;
		
	}
	
	public List<Sendemail> getsendemail(){
		Session session=getOneSession();
		
		Query query = session.createQuery("from Sendemail");			
		List<Sendemail> list=query.list();
		session.close();
		return list;
		
	}
	public List<Trendlines> getTrendlines(){
		Session session=getOneSession();
		Query query = session.createQuery("from Trendlines where riqi4 is null");			
		List<Trendlines> list=query.list();
		session.close();
		return list;
		
	}
	public void deleteInoutprice(String str_gupiaodaima){
		Session session=getOneSession();
		session.beginTransaction();
		Inoutprice inprice =(Inoutprice)session.get(Inoutprice.class,str_gupiaodaima);
		session.delete(inprice);		
		session.close();
	}
	public double getzuixincyc13(String str_gupiaodaima){
		Session session=getOneSession();
		Query query = session.createSQLQuery("select cyc13 from gupiaoshuju where gupiaodaima=:v_gupiaodaima and  riqi=(select max(riqi) from gupiaoshuju a where a.gupiaodaima=:v_gupiaodaima)");
		query.setParameter("v_gupiaodaima", str_gupiaodaima);
		Double cyc13 = Double.parseDouble(query.list().iterator().next().toString());
		session.close();
		return cyc13;
	}
	public void updateWhilework(){
		
		Session session=getOneSession();
			//定义一个匿名类，实现了Work接口		
			Work work=new Work(){		
				public void execute(Connection conn)throws SQLException{
				//通过JDBC API执行用于批量更新的SQL语句
					java.sql.CallableStatement       cstmt; 
					cstmt = conn.prepareCall("{  call testpackage.updatewhilework}");  				
					cstmt.execute();   						
					cstmt.close();		
				}
			};
			//执行work 
			
			session.doWork(work);
			session.close();
	}
	public int getWhileworkspilttime(){
		
		
		Session session=getOneSession();
		//定义一个匿名类，实现了Work接口
		
		Work work=new Work(){		
			public void execute(Connection conn)throws SQLException{
			//通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement       cstmt; 
				cstmt = conn.prepareCall("{ ? = call getWhileworkspilttime}");   
			    
				cstmt.registerOutParameter(1,java.sql.Types.INTEGER);   				  
				cstmt.execute();   
				Result = cstmt.getInt(1);				
				cstmt.close();		
			}
		};
		//执行work 
		
		session.doWork(work);		
		session.close();
		return Result;
	}
	
	public int getrzzgsfenxi(final String str_gupiaodaima){
		
		
		
		
		Session session=getOneSession();
		//定义一个匿名类，实现了Work接口
		
		Work work=new Work(){		
			public void execute(Connection conn)throws SQLException{
			//通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement       cstmt; 
				cstmt = conn.prepareCall("{ ? = call testpackage.getrzzgsfenxi(?)}");   			    
				cstmt.registerOutParameter(1,java.sql.Types.INTEGER);   
				cstmt.setString(2,str_gupiaodaima);
				cstmt.execute();   
				Result = cstmt.getInt(1);				
				cstmt.close();		
			}
		};
		//执行work 
		
		session.doWork(work);		
		session.close();
		return Result;
	}
	public List<MbcjgsjsTemporary> seilininput(){
		Session session=getOneSession();
		Query query = session.getNamedQuery("seilininput"); 		
		List< MbcjgsjsTemporary> list=query.list();
		session.close();
		return list;
		
	}
	public List<Rzzgszc> getrzzgszcsendmail(){
		
		Session session=getOneSession();
		Query query = session.getNamedQuery("getrzzgszcsendmail");
		List<Rzzgszc> list=query.list();
		session.close();
		return list;
		
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void SaveObject(Object k) {
		// TODO Auto-generated method stub
		Session session=getOneSession();	
		session.saveOrUpdate(k);
		session.close();
		//this.getHibernateTemplate().getSessionFactory().getCurrentSession().saveOrUpdate(k);
	}
	
	
	
	public List<Rzzgs> getrzzgsByCondition(Double jsqbh,Double jsqbh2) {
		
		System.out.println("gupiaoDAOImpl");
		
		Session session=getOneSession();
		Query query = session.createSQLQuery("select * from Rzzgs where jsqbh>=:v_jsqbh and jsqbh2>=:v_jsqbh2 ").addEntity(Rzzgs.class);
		query.setParameter("v_jsqbh", jsqbh);
		query.setParameter("v_jsqbh2", jsqbh2);
		List<Rzzgs> list=query.list();
		
		session.close();
        return list;
	}
	public List<Rzzgs> getrzzgsbygupiaodaima(String gupiaodaima){

		Session session=getOneSession();
		Query query = session.createSQLQuery("select * from Rzzgs where gupiaodaima=:v_gupiaodaima order by riqi desc").addEntity(Rzzgs.class);
		query.setParameter("v_gupiaodaima", gupiaodaima);
		List<Rzzgs> list=query.list();
		
		session.close();
        return list;
	}
	public List<Rzzgs> getrzzgsbyjsqbhandjsqbh2(Double jsqbh,Double jsqbh2){

		Session session=getOneSession();
		if (null==jsqbh){
			jsqbh=0.0;
		}
		if(null==jsqbh2){
			jsqbh2=0.0;
		}
		Query query = session.createSQLQuery("select * from Rzzgs where jsqbh>=:v_jsqbh and jsqbh2>=:v_jsqbh2").addEntity(Rzzgs.class);
		query.setParameter("v_jsqbh", jsqbh);
		query.setParameter("v_jsqbh2",jsqbh2);
		List<Rzzgs> list=query.list();
		
		session.close();
        return list;
	}
	
}