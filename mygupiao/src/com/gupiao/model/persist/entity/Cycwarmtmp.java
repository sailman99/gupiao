package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *Rzzgs entity. @author MyEclipse Persistence Tools
 */
@Entity
@IdClass(PKId.class)
public class Cycwarmtmp  implements java.io.Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 950693746534837949L;
	private String gupiaodaima;
	private String gupiaomingcheng;
	private Date riqi;
	private Integer cyc;
	private Double jiage;
	private String comeriqi;
	private String beizhu;
	private String beizhuriqi;
	@Id
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	@Id
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	public Integer getCyc() {
		return cyc;
	}
	public void setCyc(Integer cyc) {
		this.cyc = cyc;
	}
	public Double getJiage() {
		return jiage;
	}
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	
	public String getGupiaomingcheng() {
		return gupiaomingcheng;
	}
	public void setGupiaomingcheng(String gupiaomingcheng) {
		this.gupiaomingcheng = gupiaomingcheng;
	}
	public String getComeriqi() {
		return comeriqi;
	}
	public void setComeriqi(String comeriqi) {
		this.comeriqi = comeriqi;
	}
	public String getBeizhuriqi() {
		return beizhuriqi;
	}
	public void setBeizhuriqi(String beizhuriqi) {
		this.beizhuriqi = beizhuriqi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comeriqi == null) ? 0 : comeriqi.hashCode());
		result = prime * result + ((cyc == null) ? 0 : cyc.hashCode());
		result = prime * result
				+ ((gupiaodaima == null) ? 0 : gupiaodaima.hashCode());
		result = prime * result + ((jiage == null) ? 0 : jiage.hashCode());
		result = prime * result + ((riqi == null) ? 0 : riqi.hashCode());
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
		Cycwarmtmp other = (Cycwarmtmp) obj;
		if (comeriqi == null) {
			if (other.comeriqi != null)
				return false;
		} else if (!comeriqi.equals(other.comeriqi))
			return false;
		if (cyc == null) {
			if (other.cyc != null)
				return false;
		} else if (!cyc.equals(other.cyc))
			return false;
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
		return true;
	}
	
}