package com.gupiao.model.dao;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.share.Gpsclientdata;
import com.gupiao.model.persist.entity.Cycwarm;
import com.gupiao.model.persist.entity.Cycwarmtmp;
import com.gupiao.model.persist.entity.Gaokao_subjectchapter;
import com.gupiao.model.persist.entity.Gaokao_vedioartitle;
import com.gupiao.model.persist.entity.Gaokao_vedioartitleSendPhone;
import com.gupiao.model.persist.entity.Gaokao_xyst;
import com.gupiao.model.persist.entity.Gaokao_zyb;
import com.gupiao.model.persist.entity.Gupiao;
import com.gupiao.model.persist.entity.Gupiaoshuju;
import com.gupiao.model.persist.entity.Inoutprice;
import com.gupiao.model.persist.entity.MbcjgsjsTemporary;
import com.gupiao.model.persist.entity.Months;
import com.gupiao.model.persist.entity.Rzzgs;
import com.gupiao.model.persist.entity.RzzgsShow;
import com.gupiao.model.persist.entity.Rzzgszc;
import com.gupiao.model.persist.entity.Scalewarm;
import com.gupiao.model.persist.entity.Scalewarmtmp;
import com.gupiao.model.persist.entity.Sendemail;
import com.gupiao.model.persist.entity.Trendlines;
import com.gupiao.model.persist.entity.Trendlinestmp;
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
	public List<Trendlinestmp> getTrendlinestmp();
	public void SaveObject(Object k);
	public void DeleteObject(Object k);
	public String getprocedurecondition(String str_procedurethread);
	public List<Gupiaoshuju> getgupiaoshuju(String gupiaodaima) throws Exception;
	public void updateGpsclientdata(List<Gpsclientdata> list);
	public List<RzzgsShow> getrzzgsbygupiaodaima(String gupiaodaima);
	public List<RzzgsShow> getrzzgsByCondition(Double jsqhb,Double jsqhb2,String riqi);
	public List<Rzzgs> getrzzgsbyjsqbhandjsqbh2(Double jsqbh,Double jsqbh2);
	public List<Rzzgs> getrzzgsbygupiaodaimaandriqi(String gupiaodaima,String riqi);	
	public List getrzzgsGroupByCondition(Double jsqbh,Double jsqbh2);
	public List<Months> getMonths();
	public Integer getTrendlinesriqicount(String gupiaodaima,Date riqi1,Date riqi2);
	public void updateCycwarm(String gupiaodaima,Integer cyc);
	public void updateScalewarm(String gupiaodaima,Double scale,Date minriqi);
	public List<Scalewarm> getScalewarm();
	public List<Cycwarm> getCycwarm();
	public void generic_updatecycwarm();
	public void generic_updatescalewarm();
	public List<Scalewarmtmp> getScalewarmtmp();
	public List<Cycwarmtmp> getCycwarmtmp();
	public void deleteScalewarm(JSONArray jsonArray);
	public void clearUserdefine();
	public void updateGaokao_videoartitle(JSONArray jsonArray);
	public void updateGaokao_labelclassification(JSONArray jsonArray);
	public void updateGaokao_subjectchapter(JSONArray jsonArray);
	public Integer whetherExistenceUrl(String jsonString);
	public Integer whetherExistencexystUrl(String https_url,String comefrom);
	public List<Gaokao_xyst> getXystlist(String jsonString);
	public List<Gaokao_zyb> getZyblist(String jsonString);
	public List<Gaokao_xyst> getGaokao_xyst(String jsonString);	
	public List<Gaokao_zyb> getGaokao_zyb(String jsonString);	
	public List<Gaokao_subjectchapter> getGaokao_subjectchapter(String jsonString);
	public List<Gaokao_subjectchapter> getGaokao_labelclassification(String jsonString);
	public List<Gaokao_vedioartitle>   downloadGaokao_vedioartitle(String jsonString);
	public List<Gaokao_vedioartitleSendPhone>   getGaokao_vedioartitle(String jsonString);
	public List<Gaokao_vedioartitleSendPhone> getGaokao_vedioartitlefornoDownload(String jsonString);
	public List<Gupiao> getAllGupiao();
	public void generate_gupiaoshujus();
	public void generate_gupiaoshujuhuanshou();
	public void generic_gupiaoshujucyc();
	public void generic_zuidicyc();
	public void generic_zuoshouzhangfu();
	public void generic_genericcyc55zhouqi();
	public void generic_updatetrendlines();
	public void generichuanshou30cyc34count();
	public Date getRzzgsMaxDate(String gupiaodaima);
	public void generic_updaterzzgsjsqbh2();
	public void insertGaokao_xyst(Gaokao_xyst gaokao_xyst);
	public void insertGaokao_zyb(Gaokao_zyb gaokao_zyb);
}
