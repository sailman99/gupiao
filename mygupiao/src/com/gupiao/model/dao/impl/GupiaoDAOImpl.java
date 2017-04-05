package com.gupiao.model.dao.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.jdbc.Work;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Cycwarm;
import com.gupiao.model.persist.entity.Cycwarmtmp;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.MbcjgsjsTemporary;
import com.gupiao.model.persist.entity.Months;
import com.gupiao.model.persist.entity.Procedurecondition;
import com.gupiao.model.persist.entity.RiqiGroupcounts;
import com.gupiao.model.persist.entity.Rzzgs;
import com.gupiao.model.persist.entity.RzzgsShow;
import com.gupiao.model.persist.entity.Rzzgszc;
import com.gupiao.model.persist.entity.Scalewarm;
import com.gupiao.model.persist.entity.Scalewarmtmp;
import com.gupiao.model.persist.entity.Sendemail;
import com.gupiao.model.persist.entity.Trendlines;
import com.gupiao.model.persist.entity.Trendlinestmp;
import com.gupiao.web.tools.MyTools;
import com.example.share.Gpsclientdata;


@Repository("gupiaoDAO")
@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
public class GupiaoDAOImpl  implements GupiaoDAO {
	
	
	private int Result=0;
	private SessionFactory sessionFactory;
	

	@Autowired
	public GupiaoDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;				
	}
	
	public StatelessSession getStatelessSession(){
		return this.sessionFactory.openStatelessSession();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
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
		StatelessSession session=getStatelessSession();
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
		StatelessSession session=getStatelessSession();
		Query query = session.getNamedQuery("getfindZUIDICYC13");		
		List< MbcjgsjsTemporary> list=query.list();
		session.close();
		return list;
		
	
	}
	public String getprocedurecondition(String str_procedurethread){	
		String str_return="";
		StatelessSession session=getStatelessSession();		
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
		StatelessSession session=getStatelessSession();
		Query query = session.getNamedQuery("findlow"); 		
		List< MbcjgsjsTemporary> list=query.list();	
		session.close();
		return list;
	}
	
	public List<Inoutprice> getInoutprice(){
		StatelessSession session=getStatelessSession();
		Query query = session.createQuery("from Inoutprice");			
		List<Inoutprice> list=query.list();
		session.close();
		return list;
		
	}
	
	public List<Sendemail> getsendemail(){
		StatelessSession session=getStatelessSession();
		Query query = session.createQuery("from Sendemail");			
		List<Sendemail> list=query.list();
		session.close();
		return list;
		
	}
	public List<Trendlines> getTrendlines(){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select * from Trendlines where riqi4 is null").addEntity(Trendlines.class);			
		List<Trendlines> list=query.list();
		return list;
		
	}
	public List<Trendlinestmp> getTrendlinestmp(){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select gupiaodaima,riqi1,dot1,riqi2,dot2,dot1todot2,gradient,riqi3,dot3,forecastprice,upordown from Trendlines where riqi4 is null").addEntity(Trendlinestmp.class);			
		List<Trendlinestmp> list=query.list();
		return list;
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteInoutprice(String str_gupiaodaima){
		Session session = this.sessionFactory.getCurrentSession();
		Inoutprice inprice =(Inoutprice)session.get(Inoutprice.class,str_gupiaodaima);
		session.delete(inprice);		
//		session.close();
	}
	public double getzuixincyc13(String str_gupiaodaima){
		StatelessSession session=getStatelessSession();
		Query query = session.createSQLQuery("select cyc13 from gupiaoshuju where gupiaodaima=:v_gupiaodaima and  riqi=(select max(riqi) from gupiaoshuju a where a.gupiaodaima=:v_gupiaodaima)");
		query.setParameter("v_gupiaodaima", str_gupiaodaima);
		Double cyc13 = Double.parseDouble(query.list().iterator().next().toString());
		session.close();
		return cyc13;
	}
	public void updateWhilework(){
		
		Session session = this.sessionFactory.getCurrentSession();
			//����һ�������࣬ʵ����Work�ӿ�		
			Work work=new Work(){		
				public void execute(Connection conn)throws SQLException{
				//ͨ��JDBC APIִ�������������µ�SQL���
					java.sql.CallableStatement       cstmt; 
					cstmt = conn.prepareCall("{  call testpackage.updatewhilework}");  				
					cstmt.execute();   						
					cstmt.close();		
				}
			};
			//ִ��work 
			
			session.doWork(work);
	//		session.close();
	}
	public int getWhileworkspilttime(){
		
		//���������ڶ�ʱ����ã���Ҫ
		Session session = this.sessionFactory.getCurrentSession();
	
		//����һ�������࣬ʵ����Work�ӿ�
		
		Work work=new Work(){		
			public void execute(Connection conn)throws SQLException{
			//ͨ��JDBC APIִ�������������µ�SQL���
				java.sql.CallableStatement       cstmt; 
				cstmt = conn.prepareCall("{ ? = call getWhileworkspilttime}");   
			    
				cstmt.registerOutParameter(1,java.sql.Types.INTEGER);   				  
				cstmt.execute();   
				Result = cstmt.getInt(1);				
				cstmt.close();		
			}
		};
		//ִ��work 
		
		session.doWork(work);		
	//	session.flush();
	//	session.close();
		return Result;
	}
	
	public int getrzzgsfenxi(final String str_gupiaodaima){
		
		
		
		
		Session session = this.sessionFactory.getCurrentSession();
		//����һ�������࣬ʵ����Work�ӿ�
		
		Work work=new Work(){		
			public void execute(Connection conn)throws SQLException{
			//ͨ��JDBC APIִ�������������µ�SQL���
				java.sql.CallableStatement       cstmt; 
				cstmt = conn.prepareCall("{ ? = call testpackage.getrzzgsfenxi(?)}");   			    
				cstmt.registerOutParameter(1,java.sql.Types.INTEGER);   
				cstmt.setString(2,str_gupiaodaima);
				cstmt.execute();   
				Result = cstmt.getInt(1);				
				cstmt.close();		
			}
		};
		//ִ��work 
		
		session.doWork(work);		
	//	session.close();
		return Result;
	}
	public List<MbcjgsjsTemporary> seilininput(){
		StatelessSession session=getStatelessSession();
		Query query = session.getNamedQuery("seilininput"); 		
		List< MbcjgsjsTemporary> list=query.list();
		session.close();
		return list;
		
	}
	public List<Rzzgszc> getrzzgszcsendmail(){
		
		StatelessSession session=getStatelessSession();
		Query query = session.getNamedQuery("getrzzgszcsendmail");
		List<Rzzgszc> list=query.list();
		session.close();
		return list;
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void SaveObject(Object k) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(k);
	//	session.close();
		//this.getHibernateTemplate().getSessionFactory().getCurrentSession().saveOrUpdate(k);
	}
	
	public List getrzzgsGroupByCondition(Double jsqbh,Double jsqbh2) {
		//Session session=this.sessionFactory.getCurrentSession();
		StatelessSession session=getStatelessSession();
		Query query = session.createSQLQuery("select riqi,count(*) as rowcounts from Rzzgs where jsqbh>=:v_jsqbh and jsqbh2>=:v_jsqbh2  group by riqi order by riqi desc")
				.addEntity(RiqiGroupcounts.class);
		query.setParameter("v_jsqbh", jsqbh);
		query.setParameter("v_jsqbh2", jsqbh2);
		List list=query.list();		
		session.close();
        return list;
	}
	public List<Scalewarm> getScalewarm(){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(" select * from scalewarm where riqi is null ").addEntity(Scalewarm.class);
		return query.list();
		
	}
	public List<Cycwarm> getCycwarm(){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(" select * from cycwarm where comeriqi is null ").addEntity(Cycwarm.class);
		return query.list();
	}
	
	
	
/*	public List<RzzgsShow> getrzzgsByCondition(Double jsqbh,Double jsqbh2,String riqi) {
		Session session=this.sessionFactory.getCurrentSession();
		//	StatelessSession session=getStatelessSession();
		
		Query query = session.createSQLQuery(" select a.gupiaodaima,b.gupiaomingcheng,a.riqi,"+
		"a.gdzs,a.rzzg,a.jsqbh,a.zgb,a.ltg,a.jsqbh2,to_char(a.genericriqi,'yyyy-MM-dd') genericriqi,to_char(a.beizhuriqi,'yyyy-MM-dd') beizhuriqi,a.beizhu "+
		"		from rzzgs a,gupiao b where a.gupiaodaima=b.gupiaodaima "+		
        "  and a.jsqbh>=:v_jsqbh and a.jsqbh2>=:v_jsqbh2 and a.riqi=:v_riqi").addEntity(RzzgsShow.class);
		query.setParameter("v_jsqbh", jsqbh);
		query.setParameter("v_jsqbh2", jsqbh2);
		query.setParameter("v_riqi",MyTools.strToDateTime(riqi));
		List<RzzgsShow> list=query.list();
		
        return list;
	}*/
	public List<RzzgsShow> getrzzgsByCondition(Double jsqbh,Double jsqbh2,String riqi) {
		Session session=this.sessionFactory.getCurrentSession();
		//	StatelessSession session=getStatelessSession();
		
		Query query = session.createSQLQuery(" select a.gupiaodaima,b.gupiaomingcheng,a.riqi,"+
		" a.gdzs,a.rzzg,a.jsqbh,a.zgb,a.ltg,a.jsqbh2,to_char(a.genericriqi,'yyyy-MM-dd') genericriqi,"+
		" to_char(a.beizhuriqi,'yyyy-MM-dd') beizhuriqi,a.beizhu , c.dazhongjiaoyicounts "+
		"		from rzzgs a,gupiao b,"+
		" (select gupiaodaima,count(*) dazhongjiaoyicounts from dazhongjiaoyi "+
		" where  to_char(riqi,'yyyy-MM-dd')>:v_riqi and  to_char(riqi-270,'yyyy-MM-dd')<:v_riqi group by gupiaodaima) c "+
		" where a.gupiaodaima=b.gupiaodaima (+) and a.gupiaodaima=c.gupiaodaima(+) "+		
        "  and a.jsqbh>=:v_jsqbh and a.jsqbh2>=:v_jsqbh2 and to_char(a.riqi,'yyyy-MM-dd')=:v_riqi")
        
        
        .addEntity(RzzgsShow.class);
		query.setParameter("v_jsqbh", jsqbh);
		query.setParameter("v_jsqbh2", jsqbh2);
		query.setParameter("v_riqi",riqi);
		List<RzzgsShow> list=query.list();
		
        return list;
	}
	public List<RzzgsShow> getrzzgsbygupiaodaima(String gupiaodaima){
		
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(" select a.gupiaodaima,b.gupiaomingcheng,a.riqi,"+
				"a.gdzs,a.rzzg,a.jsqbh,a.zgb,a.ltg,a.jsqbh2,to_char(a.genericriqi,'yyyy-MM-dd') genericriqi,to_char(a.beizhuriqi,'yyyy-MM-dd') beizhuriqi,a.beizhu,0 dazhongjiaoyicounts "+
				"		from rzzgs a,gupiao b where a.gupiaodaima=b.gupiaodaima "+		
		        "  and a.gupiaodaima=:v_gupiaodaima order by a.riqi desc").addEntity(RzzgsShow.class);
				query.setParameter("v_gupiaodaima", gupiaodaima);
		List<RzzgsShow> list=query.list();
		
        return list;
	}
	public List<Rzzgs> getrzzgsbyjsqbhandjsqbh2(Double jsqbh,Double jsqbh2){

		StatelessSession session=getStatelessSession();
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
	
	public List<Months> getMonths(){
		
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select to_char(riqi,'yyyy-mm-dd')  month from rzzgs where riqi>sysdate-750 group by riqi  order by riqi desc").addEntity(Months.class);
		return query.list();		
	}
	public Integer getTrendlinesriqicount(String gupiaodaima,Date riqi1,Date riqi2){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select count(*) from gupiaoshuju where gupiaodaima=:v_gupiaodaima and riqi>:v_riqi1 and riqi<=:v_riqi2");
		query.setParameter("v_gupiaodaima",gupiaodaima);
		query.setParameter("v_riqi1",riqi1);
		query.setParameter("v_riqi2",riqi2);
		java.math.BigDecimal riqicount = (java.math.BigDecimal)query.list().iterator().next();
		
		return new Integer(riqicount.toString());
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void updateCycwarm(String gupiaodaima,Integer cyc){
		Cycwarm cycwarm=new Cycwarm();
		cycwarm.setGupiaodaima(gupiaodaima);
		cycwarm.setRiqi(new Date());
		cycwarm.setCyc(cyc);
		this.SaveObject(cycwarm);
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void updateScalewarm(String gupiaodaima,Double scale,Date minriqi){
		Scalewarm scalewarm=new Scalewarm();
		scalewarm.setGupiaodaima(gupiaodaima);
		scalewarm.setScale(scale);
		scalewarm.setZuidiriqi(minriqi);
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("select * from gupiaoshuju where gupiaodaima=:v_gupiaodaima and riqi=:v_riqi").addEntity(Gupiaoshuju.class);
		query.setParameter("v_gupiaodaima",gupiaodaima);
		query.setParameter("v_riqi",minriqi);
		List<Gupiaoshuju> list=query.list();
		for(Gupiaoshuju gupiaoshuju:list){
			scalewarm.setZuidijia(gupiaoshuju.getZuidi());
		}
		this.SaveObject(scalewarm);
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void generic_updatescalewarm() { // gupiaoshujupackage.updatescalewarm;

		Session session=this.sessionFactory.getCurrentSession();
	//	session.beginTransaction();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.updatescalewarm}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
	//	session.close();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void generic_updatecycwarm() { // gupiaoshujupackage.updatecycwarm;

		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call  gupiaoshujupackage.updatecycwarm}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
	//	session.close();
	}	
	
	public List<Scalewarmtmp> getScalewarmtmp(){

		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select a.gupiaodaima,b.gupiaomingcheng,a.zuidiriqi,a.scale,a.zuidijia,a.zuigaoriqi,a.zuigaojia,a.jiage,to_char(a.riqi,'yyyy-mm-dd') as riqi,a.beizhu,to_char(a.beizhuriqi,'yyyy-mm-dd') as beizhuriqi,a.huitiaobili,a.fantanbili,a.zaihuitiaobili,to_char(a.jierudianjiageariqi,'yyyy-mm-dd') as jierudianjiageariqi,to_char(a.jierudianjiagebriqi,'yyyy-mm-dd') as jierudianjiagebriqi from scalewarm a,gupiao b where a.gupiaodaima=b.gupiaodaima").addEntity(Scalewarmtmp.class);
        return query.list();
	}
	public List<Cycwarmtmp> getCycwarmtmp(){

		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select a.gupiaodaima,b.gupiaomingcheng,a.riqi,a.cyc,a.jiage,to_char(a.comeriqi,'yyyy-mm-dd') as comeriqi,a.beizhu,to_char(a.beizhuriqi,'yyyy-mm-dd') as beizhuriqi from cycwarm a,gupiao b where a.gupiaodaima=b.gupiaodaima").addEntity(Cycwarmtmp.class);
        return query.list();
	}
}