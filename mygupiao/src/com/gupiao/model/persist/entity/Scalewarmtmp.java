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
public class Scalewarmtmp  implements java.io.Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 250693746534832949L;
	private String gupiaodaima;
	private String gupiaomingcheng;
	private Date zuidiriqi;
	private Double scale;
	private Double zuidijia;
	private Date zuigaoriqi;
	private Double zuigaojia;
	private Double jiage;
	private String riqi;
	private String beizhu;
	private String beizhuriqi;
	
	
	
	private Double  huitiaobili;
	private Double  fantanbili;
	private Double  zaihuitiaobili;
	private String  jierudianjiageariqi;
	private String  jierudianjiagebriqi;

	
	
	
	
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
	
	public String getRiqi() {
		return riqi;
	}
	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	
	public String getGupiaomingcheng() {
		return gupiaomingcheng;
	}
	public void setGupiaomingcheng(String gupiaomingcheng) {
		this.gupiaomingcheng = gupiaomingcheng;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getBeizhuriqi() {
		return beizhuriqi;
	}
	public void setBeizhuriqi(String beizhuriqi) {
		this.beizhuriqi = beizhuriqi;
	}
	public Double getHuitiaobili() {
		return huitiaobili;
	}
	public void setHuitiaobili(Double huitiaobili) {
		this.huitiaobili = huitiaobili;
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
	public String getJierudianjiageariqi() {
		return jierudianjiageariqi;
	}
	public void setJierudianjiageariqi(String jierudianjiageariqi) {
		this.jierudianjiageariqi = jierudianjiageariqi;
	}
	public String getJierudianjiagebriqi() {
		return jierudianjiagebriqi;
	}
	public void setJierudianjiagebriqi(String jierudianjiagebriqi) {
		this.jierudianjiagebriqi = jierudianjiagebriqi;
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
		Scalewarmtmp other = (Scalewarmtmp) obj;
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