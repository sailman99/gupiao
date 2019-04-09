package com.gupiao.model.dao.impl;


import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.gupiao.model.dao.GupiaoDAO;
import com.gupiao.model.persist.entity.Cycwarm;
import com.gupiao.model.persist.entity.Cycwarmtmp;
import com.gupiao.model.persist.entity.Gaokao_lookrec;
import com.gupiao.model.persist.entity.Gaokao_vedioartitle;
import com.gupiao.model.persist.entity.Gaokao_labelclassification;
import com.gupiao.model.persist.entity.Gaokao_subjectchapter;
import com.gupiao.model.persist.entity.Gaokao_vedioartitleSendPhone;
import com.gupiao.model.persist.entity.Gaokao_xyst;
import com.gupiao.model.persist.entity.Gaokao_zyb;
import com.gupiao.model.persist.entity.Gupiao;
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
		Query query = session.createSQLQuery("select a.gupiaodaima,b.gupiaomingcheng,a.riqi1,a.dot1,a.riqi2,a.dot2,a.dot1todot2,a.gradient,a.riqi3,a.dot3,a.forecastprice,to_char(a.riqi4,'yyyy-mm-dd') as riqi4, a.upordown from Trendlines a,Gupiao b where a.gupiaodaima=b.gupiaodaima ").addEntity(Trendlinestmp.class);			
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
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void DeleteObject(Object k) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(k);
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
	public List<Rzzgs> getrzzgsbygupiaodaimaandriqi(String gupiaodaima,String riqi){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select * from Rzzgs where gupiaodaima=:v_gupiaodaima and to_char(riqi,'yyyymmdd')=:v_riqi").addEntity(Rzzgs.class);
		query.setParameter("v_gupiaodaima", gupiaodaima);
		query.setParameter("v_riqi",riqi);
		return query.list();
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
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
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
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
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
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public Date getRzzgsMaxDate(String gupiaodaima){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select max(riqi) from rzzgs where gupiaodaima=:v_gupiaodaima and rzzg>0 and ltg>0");
		query.setParameter("v_gupiaodaima", gupiaodaima);
		Date riqi = (Date)query.list().iterator().next();
		
		return riqi;
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Scalewarmtmp> getScalewarmtmp(){

		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select a.gupiaodaima,b.gupiaomingcheng,a.zuidiriqi,a.scale,a.zuidijia,a.zuigaoriqi,a.zuigaojia,a.jiage,to_char(a.riqi,'yyyy-mm-dd') as riqi,a.beizhu,to_char(a.beizhuriqi,'yyyy-mm-dd') as beizhuriqi,a.huitiaobili,a.fantanbili,a.zaihuitiaobili,to_char(a.jierudianjiageariqi,'yyyy-mm-dd') as jierudianjiageariqi,to_char(a.jierudianjiagebriqi,'yyyy-mm-dd') as jierudianjiagebriqi from scalewarm a,gupiao b where a.gupiaodaima=b.gupiaodaima").addEntity(Scalewarmtmp.class);
        return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Cycwarmtmp> getCycwarmtmp(){

		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select a.gupiaodaima,b.gupiaomingcheng,a.riqi,a.cyc,a.jiage,to_char(a.comeriqi,'yyyy-mm-dd') as comeriqi,a.beizhu,to_char(a.beizhuriqi,'yyyy-mm-dd') as beizhuriqi from cycwarm a,gupiao b where a.gupiaodaima=b.gupiaodaima").addEntity(Cycwarmtmp.class);
        return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteScalewarm(JSONArray jsonArray){

		JSONObject jsonObject;
		
		Session session=this.sessionFactory.getCurrentSession();
		for(int i=0;i<jsonArray.size();i++){
			jsonObject=jsonArray.getJSONObject(i);
		
			Query query = session.createSQLQuery("delete from scalewarm where gupiaodaima =:v_gupiaodaima and zuidiriqi=:v_zuidiriqi and scale=:v_scale");
			query.setParameter("v_gupiaodaima",jsonObject.getString("gupiaodaima"));
			query.setParameter("v_zuidiriqi",MyTools.strToDateTime((jsonObject.getString("zuidiriqi")).substring(0,10)));
			query.setParameter("v_scale",jsonObject.getDouble("scale"));
			query.executeUpdate();
			
		}		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void clearUserdefine(){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("delete from userdefine where  1=1");
		query.executeUpdate();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_subjectchapter> getGaokao_subjectchapter(String jsonString){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select subjectchapterid,subjectid,chaptername from gaokao_subjectchapter where subjectid = :v_subjectid ").addEntity(Gaokao_subjectchapter.class);
        query.setParameter("v_subjectid",jsonString);
       
		return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_subjectchapter> getGaokao_labelclassification(String jsonString){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select labelclassificationid,subjectid,labelname from gaokao_labelclassification where subjectid = :v_subjectid ").addEntity(Gaokao_labelclassification.class);
        query.setParameter("v_subjectid",jsonString);
		return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void updateGaokao_labelclassification(JSONArray jsonArray){
		JSONObject jsonObject;
		
		Session session=this.sessionFactory.getCurrentSession();
		for(int i=0;i<jsonArray.size();i++){
			jsonObject=jsonArray.getJSONObject(i);
		
			
			
			Query query = session.createSQLQuery("select vedioartitle_sequence.nextval from dual");
			
			java.math.BigDecimal currentID = (java.math.BigDecimal)query.list().iterator().next();
			
			Integer ID = new Integer(currentID.toString());
			
			
			
			Gaokao_labelclassification gaokao_labelclassification= new Gaokao_labelclassification();
			gaokao_labelclassification.setLabelclassificationid(ID);
			
			try{
				gaokao_labelclassification.setSubjectid(jsonObject.getString("subject"));
			}catch(Exception e){}
			try{
				gaokao_labelclassification.setLabelname(jsonObject.getString("label").trim());
			}catch(Exception e){}
					this.SaveObject(gaokao_labelclassification);
		}		
	
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void updateGaokao_subjectchapter(JSONArray jsonArray){
		JSONObject jsonObject;
		
		Session session=this.sessionFactory.getCurrentSession();
		for(int i=0;i<jsonArray.size();i++){
			jsonObject=jsonArray.getJSONObject(i);
		
			
			
			Query query = session.createSQLQuery("select vedioartitle_sequence.nextval from dual");
			
			java.math.BigDecimal currentID = (java.math.BigDecimal)query.list().iterator().next();
			
			Integer ID = new Integer(currentID.toString());
			
			
			
			Gaokao_subjectchapter gaokao_subjectchapter= new Gaokao_subjectchapter();
			gaokao_subjectchapter.setSubjectchapterid(ID);
			
			try{
				gaokao_subjectchapter.setSubjectid(jsonObject.getString("subject"));
			}catch(Exception e){}
			try{
				gaokao_subjectchapter.setChaptername(jsonObject.getString("chapter").trim());
			}catch(Exception e){}
					this.SaveObject(gaokao_subjectchapter);
		}		
	
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void insertGaokao_xyst(Gaokao_xyst gaokao_xyst)
	{
		Integer ID=0;
		Session session=this.sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery("select vedioartitle_sequence.nextval from dual");
		java.math.BigDecimal currentID = (java.math.BigDecimal)query.list().iterator().next();
		ID = new Integer(currentID.toString());
				
			
		
		gaokao_xyst.setXystid(ID);
		
		this.SaveObject(gaokao_xyst);
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void insertGaokao_zyb(Gaokao_zyb gaokao_zyb)
	{
		Integer ID=0;
		Session session=this.sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery("select vedioartitle_sequence.nextval from dual");
		java.math.BigDecimal currentID = (java.math.BigDecimal)query.list().iterator().next();
		ID = new Integer(currentID.toString());
				
			
		
		gaokao_zyb.setZybid(ID);
		
		this.SaveObject(gaokao_zyb);
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=false)
	public void updateGaokao_videoartitle(JSONArray jsonArray){
		/*
		 * subject,title,videoartitle,url,publication,label,chapter,keyword,
		 * relationimage,comments
		 */
		JSONObject jsonObject;		
		Integer ID=0;
		Session session=this.sessionFactory.getCurrentSession();
		for(int i=0;i<jsonArray.size();i++){
			jsonObject=jsonArray.getJSONObject(i);
			//System.out.println(i);
			try{
				if(jsonObject.getInt("vedioartitleid")<1){
					Query query = session.createSQLQuery("select vedioartitle_sequence.nextval from dual");
					java.math.BigDecimal currentID = (java.math.BigDecimal)query.list().iterator().next();
					ID = new Integer(currentID.toString());
				}else{
					ID=jsonObject.getInt("vedioartitleid");
				}
			}catch(Exception e){}
			
			
			Gaokao_vedioartitle vedioartitle=new Gaokao_vedioartitle();
			vedioartitle.setVedioartitleid(ID);
			/*
			 * subject,title,videoartitle,url,publication,label,chapter,keyword,
			 * relationimage,comments
			 */
			try{
				vedioartitle.setSubjectid(jsonObject.getString("subject").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setTitle(jsonObject.getString("title").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setTypeid(jsonObject.getString("videoartitle").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setUrl(jsonObject.getString("url").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setKeyword(jsonObject.getString("keyword").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setImageurl(jsonObject.getString("relationimage").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setComments(jsonObject.getString("comments").trim());
			}catch(Exception e){}
			vedioartitle.setInputdate(new Date());
			try{
				vedioartitle.setPublication(MyTools.strToDate(jsonObject.getString("publication")));
			}catch(Exception e){vedioartitle.setPublication(new Date());}
			
			try{
				vedioartitle.setLabelclassificationid(new Integer(jsonObject.getString("label")));				
			}catch(Exception e){}
			try{
				vedioartitle.setSubjectchapterid(new Integer(jsonObject.getString("chapter")));				
			}catch(Exception e){}
			try{
				vedioartitle.setVedio(jsonObject.getString("vedio").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setContent(jsonObject.getString("content").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setLearn(jsonObject.getString("learn").trim());
			}catch(Exception e){}
			try{
				vedioartitle.setStay(jsonObject.getString("stay").trim());
			}catch(Exception e){}
			try{
				if("0".equals(jsonObject.getString("look"))){//记录观看日期
					Gaokao_lookrec gaokao_lookrec=new Gaokao_lookrec();
					gaokao_lookrec.setVedioartitleid(ID);
					gaokao_lookrec.setLookdate(new Date());
					this.SaveObject(gaokao_lookrec);
				}
			}catch(Exception e){}
			
			/*
			 * publication,label,chapter
			 *
			try{
				JSONArray jsonArrayLabel=JSONArray.fromObject(jsonObject.getString("label"));
				for(int j=0;j<jsonArrayLabel.size();j++){
					str_Label=jsonArrayLabel.getString(j);
					vedioartitle.setLabelclassificationid(new Integer(str_Label.toString()));
				}				
			}catch(Exception e){}
			try{
				JSONArray jsonArrayChapter=JSONArray.fromObject(jsonObject.getString("chapter"));
				for(int j=0;j<jsonArrayChapter.size();j++){
					str_Chapter=jsonArrayChapter.getString(j);
					vedioartitle.setSubjectchapterid(new Integer(str_Chapter.toString()));
				}
			}catch(Exception e){}	
			*/
			this.SaveObject(vedioartitle);
		}		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public Integer whetherExistencexystUrl(String https_url,String comefrom) {
		Session session=this.sessionFactory.getCurrentSession();
		String sql="select count(*) from ";
		if("001".equals(comefrom)) {
			sql=sql + " gaokao_zyb  where url = :v_url";
		}
		if("002".equals(comefrom)) {
			sql=sql+" gaokao_xyst  where url = :v_url";
		}
		
		Query query = session.createSQLQuery(sql);
		query.setParameter("v_url",https_url);
		java.math.BigDecimal urlcount = (java.math.BigDecimal)query.list().iterator().next();
		
		return new Integer(urlcount.toString());
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public Integer whetherExistenceUrl(String jsonString){
		String[] splitUrl=jsonString.trim().split("/");
		if(splitUrl.length>0){
			Session session=this.sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select count(*) from gaokao_vedioartitle  where url   like :v_url");
			query.setParameter("v_url","%"+splitUrl[splitUrl.length-1]+"%");
			java.math.BigDecimal urlcount = (java.math.BigDecimal)query.list().iterator().next();
			
			return new Integer(urlcount.toString());
		}
		return new Integer(0);
		
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_xyst> getXystlist(String jsonString){
		String sql="select * from gaokao_xyst "+jsonString  +"  order by xystid";
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql).addEntity(Gaokao_xyst.class);
		
		return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_zyb> getZyblist(String jsonString){
		String sql="select * from gaokao_zyb "+jsonString  +"  order by zybid";
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql).addEntity(Gaokao_zyb.class);
		
		return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_xyst> getGaokao_xyst(String jsonString){
		String sql="select * from gaokao_xyst where xystid=:v_xystid ";
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql).addEntity(Gaokao_xyst.class);
		query.setParameter("v_xystid", Integer.parseInt(jsonString));
		return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_zyb> getGaokao_zyb(String jsonString){
		String sql="select * from gaokao_zyb where zybid=:v_zybid ";
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql).addEntity(Gaokao_zyb.class);
		query.setParameter("v_zybid", Integer.parseInt(jsonString));
		return query.list();
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_vedioartitleSendPhone> getGaokao_vedioartitlefornoDownload(String jsonString){
		String sql=" where 1=2 ";
		
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Gaokao_vedioartitle");
		List<Gaokao_vedioartitle> list = query.list();
		for(Gaokao_vedioartitle gaokao_vedioartitle:list){
			String[] st=gaokao_vedioartitle.getTitle().split("\\(");
			if(st.length>2){
				String str="";
				for(int i=0;i<st.length-1;i++){
					if(i==0){
						str=str+st[i];
					}else{
						str=str+"("+st[i];
					}
				}
				if(!MyTools.fileIsExists(str)){
				
					sql=sql+" or vedioartitleid="+gaokao_vedioartitle.getVedioartitleid();
				}
			
			}else{
				if(st.length>1)
					if(!MyTools.fileIsExists(st[st.length-2])){						
						sql=sql+" or vedioartitleid="+gaokao_vedioartitle.getVedioartitleid();
					}
			}
		
		}
		
		
		return getGaokao_vedioartitle(sql);
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_vedioartitleSendPhone>   getGaokao_vedioartitle(String jsonString){
		//System.out.println(jsonString);
		
		String sql="select o.vedioartitleid,o.title,o.url,o.subjectid,o.typeid,o.keyword,o.imageurl,"+
		"o.comments,o.publication,o.inputdate,o.labelclassificationid,o.subjectchapterid,q.labelname as labelclassificationname,s.chaptername as subjectchaptername"+	
		",o.vedio,o.content,o.learn,o.stay,t.readcount,z.maxlookdate "+
		" from (select * from gaokao_vedioartitle  "+jsonString+" ) o,"+
		" (select a.vedioartitleid,b.labelname from gaokao_vedioartitle a,gaokao_labelclassification b where a.labelclassificationid=b.labelclassificationid)  q , "+
		" (select a.vedioartitleid,b.chaptername from gaokao_vedioartitle a,gaokao_subjectchapter b where a.subjectchapterid=b.subjectchapterid) s ,"+
		" (select a.vedioartitleid,count(*) as readcount from gaokao_lookrec a group by a.vedioartitleid) t ,"+
		" (select a.vedioartitleid,to_char(max(a.lookdate),'yyyy-mm-dd') as maxlookdate from gaokao_lookrec a group by a.vedioartitleid) z "+
		" where  o.vedioartitleid=q.vedioartitleid(+) and o.vedioartitleid=s.vedioartitleid(+) and o.vedioartitleid=t.vedioartitleid(+) and o.vedioartitleid=z.vedioartitleid(+) order by o.publication desc,o.vedioartitleid desc";
		//System.out.println(sql);
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql).addEntity(Gaokao_vedioartitleSendPhone.class);
		return query.list();
		
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gaokao_vedioartitle>   downloadGaokao_vedioartitle(String jsonString){
		
		
		String sql="select * from gaokao_vedioartitle";
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql).addEntity(Gaokao_vedioartitle.class);
		return query.list();
		
		
	}
	
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public List<Gupiao> getAllGupiao()

	{

		String sql="select * from gupiao";
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql).addEntity(Gupiao.class);
		return query.list();
		

	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generic_updaterzzgsjsqbh2(){
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call testpackage.genericrzzgsjsqbh2}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
	}
	
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generate_gupiaoshujus() { // gupiaoshujupackage.genericgupiaoshuju

		
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.genericgupiaoshuju}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generate_gupiaoshujuhuanshou() { 
		
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.genericgupiaoshujuhuanshou}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generic_gupiaoshujucyc() { // gupiaoshujupackage.genericgupiaoshujucyc
		

		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.genericgupiaoshujucyc}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generic_zuidicyc() { // gupiaoshujupackage.genericgupiaoshuju
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call testpackage.genericzuidicyc13}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generic_zuoshouzhangfu() { // gupiaoshujupackage.genericzuoshouzhangfu
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.genericzuoshouzhangfu}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generic_genericcyc55zhouqi(){
		
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.genericcyc55zhouqi}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generic_updatetrendlines(){
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.updatetrendlines}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
		
	}
	@Transactional(value="txManager",propagation=Propagation.REQUIRED,readOnly=true)
	public void generichuanshou30cyc34count(){
		Session session=this.sessionFactory.getCurrentSession();
		// 定义一个匿名类，实现了Work接口
		Work work = new Work() {
			public void execute(Connection conn) throws SQLException {
				// 通过JDBC API执行用于批量更新的SQL语句
				java.sql.CallableStatement cstmt;
				cstmt = conn
						.prepareCall("{  call gupiaoshujupackage.generichuanshou30cyc34count}");
				cstmt.execute();
				cstmt.close();
			}
		};
		// 执行work

		session.doWork(work);
		
	}
}