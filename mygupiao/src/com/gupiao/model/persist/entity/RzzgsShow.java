package com.gupiao.model.persist.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PKId.class)
public class RzzgsShow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 821809490693795839L;
	private String gupiaodaima;
	private String gupiaomingcheng;
	private Date riqi;
	private Double gdzs;
	private Double rzzg;
	private Double jsqbh;
	private Double zgb;
	private Double ltg;
	private Double jsqbh2;
	private String genericriqi;
	private String beizhuriqi;
	private String beizhu;
	private Long dazhongjiaoyicounts;
	@Id
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	public String getGupiaomingcheng() {
		return gupiaomingcheng;
	}
	public void setGupiaomingcheng(String gupiaomingcheng) {
		this.gupiaomingcheng = gupiaomingcheng;
	}
	@Id
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	public Double getGdzs() {
		return gdzs;
	}
	public void setGdzs(Double gdzs) {
		this.gdzs = gdzs;
	}
	public Double getRzzg() {
		return rzzg;
	}
	public void setRzzg(Double rzzg) {
		this.rzzg = rzzg;
	}
	public Double getJsqbh() {
		return jsqbh;
	}
	public void setJsqbh(Double jsqbh) {
		this.jsqbh = jsqbh;
	}
	public Double getZgb() {
		return zgb;
	}
	public void setZgb(Double zgb) {
		this.zgb = zgb;
	}
	public Double getLtg() {
		return ltg;
	}
	public void setLtg(Double ltg) {
		this.ltg = ltg;
	}
	public Double getJsqbh2() {
		return jsqbh2;
	}
	public void setJsqbh2(Double jsqbh2) {
		this.jsqbh2 = jsqbh2;
	}
	
	
	public String getGenericriqi() {
		return genericriqi;
	}
	public void setGenericriqi(String genericriqi) {
		this.genericriqi = genericriqi;
	}
	
	public String getBeizhuriqi() {
		return beizhuriqi;
	}
	public void setBeizhuriqi(String beizhuriqi) {
		this.beizhuriqi = beizhuriqi;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public Long getDazhongjiaoyicounts() {
		return dazhongjiaoyicounts;
	}
	public void setDazhongjiaoyicounts(Long dazhongjiaoyicounts) {
		
		this.dazhongjiaoyicounts = dazhongjiaoyicounts;
		
		System.out.println(this.dazhongjiaoyicounts);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beizhu == null) ? 0 : beizhu.hashCode());
		result = prime * result
				+ ((beizhuriqi == null) ? 0 : beizhuriqi.hashCode());
		result = prime
				* result
				+ ((dazhongjiaoyicounts == null) ? 0 : dazhongjiaoyicounts
						.hashCode());
		result = prime * result + ((gdzs == null) ? 0 : gdzs.hashCode());
		result = prime * result
				+ ((genericriqi == null) ? 0 : genericriqi.hashCode());
		result = prime * result
				+ ((gupiaodaima == null) ? 0 : gupiaodaima.hashCode());
		result = prime * result
				+ ((gupiaomingcheng == null) ? 0 : gupiaomingcheng.hashCode());
		result = prime * result + ((jsqbh == null) ? 0 : jsqbh.hashCode());
		result = prime * result + ((jsqbh2 == null) ? 0 : jsqbh2.hashCode());
		result = prime * result + ((ltg == null) ? 0 : ltg.hashCode());
		result = prime * result + ((riqi == null) ? 0 : riqi.hashCode());
		result = prime * result + ((rzzg == null) ? 0 : rzzg.hashCode());
		result = prime * result + ((zgb == null) ? 0 : zgb.hashCode());
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
		RzzgsShow other = (RzzgsShow) obj;
		if (beizhu == null) {
			if (other.beizhu != null)
				return false;
		} else if (!beizhu.equals(other.beizhu))
			return false;
		if (beizhuriqi == null) {
			if (other.beizhuriqi != null)
				return false;
		} else if (!beizhuriqi.equals(other.beizhuriqi))
			return false;
		if (dazhongjiaoyicounts == null) {
			if (other.dazhongjiaoyicounts != null)
				return false;
		} else if (!dazhongjiaoyicounts.equals(other.dazhongjiaoyicounts))
			return false;
		if (gdzs == null) {
			if (other.gdzs != null)
				return false;
		} else if (!gdzs.equals(other.gdzs))
			return false;
		if (genericriqi == null) {
			if (other.genericriqi != null)
				return false;
		} else if (!genericriqi.equals(other.genericriqi))
			return false;
		if (gupiaodaima == null) {
			if (other.gupiaodaima != null)
				return false;
		} else if (!gupiaodaima.equals(other.gupiaodaima))
			return false;
		if (gupiaomingcheng == null) {
			if (other.gupiaomingcheng != null)
				return false;
		} else if (!gupiaomingcheng.equals(other.gupiaomingcheng))
			return false;
		if (jsqbh == null) {
			if (other.jsqbh != null)
				return false;
		} else if (!jsqbh.equals(other.jsqbh))
			return false;
		if (jsqbh2 == null) {
			if (other.jsqbh2 != null)
				return false;
		} else if (!jsqbh2.equals(other.jsqbh2))
			return false;
		if (ltg == null) {
			if (other.ltg != null)
				return false;
		} else if (!ltg.equals(other.ltg))
			return false;
		if (riqi == null) {
			if (other.riqi != null)
				return false;
		} else if (!riqi.equals(other.riqi))
			return false;
		if (rzzg == null) {
			if (other.rzzg != null)
				return false;
		} else if (!rzzg.equals(other.rzzg))
			return false;
		if (zgb == null) {
			if (other.zgb != null)
				return false;
		} else if (!zgb.equals(other.zgb))
			return false;
		return true;
	}
	
	
}
