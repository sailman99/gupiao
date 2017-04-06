package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *Rzzgs entity. @author MyEclipse Persistence Tools
 */
@Entity
@IdClass(PKId_scalewarm.class)
public class Scalewarm  implements java.io.Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 850693746534832949L;
	private String gupiaodaima;
	private Date zuidiriqi;
	private Double scale;
	private Double zuidijia;
	private Date zuigaoriqi;
	private Double zuigaojia;
	private Double jiage;
	private Date riqi;
	private String beizhu;
	private Date beizhuriqi;
	
	private	Date	huitiaozuidiriqi;//回调最低日期
	private Double  huitiaozuidijia;//回调最低日期对应价格
	private Double  huitiaobili;
	private	Date  fantanzuigaoriqi;
	private Double  fantanzuigaojia;
	private Double  fantanbili;
	private Double  zaihuitiaobili;
	private Double  jierudianjiagea;
	private Date  jierudianjiageariqi;
	private Double  jierudianjiageb;
	private Date  jierudianjiagebriqi;
	private String  youxiaobiaozhi;
	
	
	
	@Id
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	@Id
	public Date getZuidiriqi() {
		return zuidiriqi;
	}
	public void setZuidiriqi(Date zuidiriqi) {
		this.zuidiriqi = zuidiriqi;
	}
	@Id
	public Double getScale() {
		return scale;
	}
	public void setScale(Double scale) {
		this.scale = scale;
	}
	public Double getZuidijia() {
		return zuidijia;
	}
	public void setZuidijia(Double zuidijia) {
		this.zuidijia = zuidijia;
	}
	public Date getZuigaoriqi() {
		return zuigaoriqi;
	}
	public void setZuigaoriqi(Date zuigaoriqi) {
		this.zuigaoriqi = zuigaoriqi;
	}
	public Double getZuigaojia() {
		return zuigaojia;
	}
	public void setZuigaojia(Double zuigaojia) {
		this.zuigaojia = zuigaojia;
	}
	public Double getJiage() {
		return jiage;
	}
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}	
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public Date getBeizhuriqi() {
		return beizhuriqi;
	}
	public void setBeizhuriqi(Date beizhuriqi) {
		this.beizhuriqi = beizhuriqi;
	}
	public Date getHuitiaozuidiriqi() {
		return huitiaozuidiriqi;
	}
	public void setHuitiaozuidiriqi(Date huitiaozuidiriqi) {
		this.huitiaozuidiriqi = huitiaozuidiriqi;
	}
	public Double getHuitiaozuidijia() {
		return huitiaozuidijia;
	}
	public void setHuitiaozuidijia(Double huitiaozuidijia) {
		this.huitiaozuidijia = huitiaozuidijia;
	}
	public Double getHuitiaobili() {
		return huitiaobili;
	}
	public void setHuitiaobili(Double huitiaobili) {
		this.huitiaobili = huitiaobili;
	}
	public Date getFantanzuigaoriqi() {
		return fantanzuigaoriqi;
	}
	public void setFantanzuigaoriqi(Date fantanzuigaoriqi) {
		this.fantanzuigaoriqi = fantanzuigaoriqi;
	}
	public Double getFantanzuigaojia() {
		return fantanzuigaojia;
	}
	public void setFantanzuigaojia(Double fantanzuigaojia) {
		this.fantanzuigaojia = fantanzuigaojia;
	}
	public Double getFantanbili() {
		return fantanbili;
	}
	public void setFantanbili(Double fantanbili) {
		this.fantanbili = fantanbili;
	}
	public Double getZaihuitiaobili() {
		return zaihuitiaobili;
	}
	public void setZaihuitiaobili(Double zaihuitiaobili) {
		this.zaihuitiaobili = zaihuitiaobili;
	}
	public Double getJierudianjiagea() {
		return jierudianjiagea;
	}
	public void setJierudianjiagea(Double jierudianjiagea) {
		this.jierudianjiagea = jierudianjiagea;
	}
	public Date getJierudianjiageariqi() {
		return jierudianjiageariqi;
	}
	public void setJierudianjiageariqi(Date jierudianjiageariqi) {
		this.jierudianjiageariqi = jierudianjiageariqi;
	}
	public Double getJierudianjiageb() {
		return jierudianjiageb;
	}
	public void setJierudianjiageb(Double jierudianjiageb) {
		this.jierudianjiageb = jierudianjiageb;
	}
	public Date getJierudianjiagebriqi() {
		return jierudianjiagebriqi;
	}
	public void setJierudianjiagebriqi(Date jierudianjiagebriqi) {
		this.jierudianjiagebriqi = jierudianjiagebriqi;
	}
	public String getYouxiaobiaozhi() {
		return youxiaobiaozhi;
	}
	public void setYouxiaobiaozhi(String youxiaobiaozhi) {
		this.youxiaobiaozhi = youxiaobiaozhi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gupiaodaima == null) ? 0 : gupiaodaima.hashCode());
		result = prime * result + ((jiage == null) ? 0 : jiage.hashCode());
		result = prime * result + ((riqi == null) ? 0 : riqi.hashCode());
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
		result = prime * result
				+ ((zuidijia == null) ? 0 : zuidijia.hashCode());
		result = prime * result
				+ ((zuidiriqi == null) ? 0 : zuidiriqi.hashCode());
		result = prime * result
				+ ((zuigaojia == null) ? 0 : zuigaojia.hashCode());
		result = prime * result
				+ ((zuigaoriqi == null) ? 0 : zuigaoriqi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scalewarm other = (Scalewarm) obj;
		if (gupiaodaima == null) {
			if (other.gupiaodaima != null)
				return false;
		} else if (!gupiaodaima.equals(other.gupiaodaima))
			return false;
		if (jiage == null) {
			if (other.jiage != null)
				return false;
		} else if (!jiage.equals(other.jiage))
			return false;
		if (riqi == null) {
			if (other.riqi != null)
				return false;
		} else if (!riqi.equals(other.riqi))
			return false;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		if (zuidijia == null) {
			if (other.zuidijia != null)
				return false;
		} else if (!zuidijia.equals(other.zuidijia))
			return false;
		if (zuidiriqi == null) {
			if (other.zuidiriqi != null)
				return false;
		} else if (!zuidiriqi.equals(other.zuidiriqi))
			return false;
		if (zuigaojia == null) {
			if (other.zuigaojia != null)
				return false;
		} else if (!zuigaojia.equals(other.zuigaojia))
			return false;
		if (zuigaoriqi == null) {
			if (other.zuigaoriqi != null)
				return false;
		} else if (!zuigaoriqi.equals(other.zuigaoriqi))
			return false;
		return true;
	}
	
}