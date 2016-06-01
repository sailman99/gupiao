package com.gupiao.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.share.Gpsclientdata;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.MbcjgsjsTemporary;
import com.gupiao.model.persist.entity.Months;
import com.gupiao.model.persist.entity.Rzzgs;
import com.gupiao.model.persist.entity.RzzgsShow;
import com.gupiao.model.persist.entity.Rzzgszc;
import com.gupiao.model.persist.entity.Sendemail;
import com.gupiao.model.persist.entity.Trendlines;
public interface GupiaoDAO {
	public List<MbcjgsjsTemporary> getfindZUIDICYC13return();
	public List<MbcjgsjsTemporary> findlow();
	public List<MbcjgsjsTemporary> seilininput();
	public List<Inoutprice> getInoutprice();			
	public void deleteInoutprice(String str_gupiaodaima);
	//public String getInpriceBeiZu(String str_gupiaodaima);
	public double getzuixincyc13(String str_gupiaodaima);
	public void updateWhilework();
	public int getWhileworkspilttime();
	public int getrzzgsfenxi(final String str_gupiaodaima);
	public List<Rzzgszc> getrzzgszcsendmail();
	public List<Sendemail> getsendemail();
	public List<Trendlines> getTrendlines();
	public void SaveObject(Object k);
	public String getprocedurecondition(String str_procedurethread);
	public List<Gupiaoshuju> getgupiaoshuju(String gupiaodaima) throws Exception;
	public void updateGpsclientdata(List<Gpsclientdata> list);
	public List<RzzgsShow> getrzzgsbygupiaodaima(String gupiaodaima);
	public List<RzzgsShow> getrzzgsByCondition(Double jsqhb,Double jsqhb2,String riqi);
	public List<Rzzgs> getrzzgsbyjsqbhandjsqbh2(Double jsqbh,Double jsqbh2);
	public List getrzzgsGroupByCondition(Double jsqbh,Double jsqbh2);
	public List<Months> getMonths();
}
