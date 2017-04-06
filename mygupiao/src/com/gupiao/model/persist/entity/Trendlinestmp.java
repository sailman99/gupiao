package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Gupiaoshuju entity. @author MyEclipse Persistence Tools
 */
@Entity
@IdClass(PKId_trendlines.class)
public class Trendlinestmp implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3181139419685546457L;
	private String gupiaodaima;
	private Date riqi1;
	private Double dot1;
	private Date riqi2;
	private Double dot2;
	private Integer dot1todot2;
	private Double gradient;
	private Date riqi3;
	private Double dot3;
	private Double forecastprice;
	private String upordown;
	

	@Id
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}

	@Id
	public Date getRiqi1() {
		return riqi1;
	}
	public void setRiqi1(Date riqi1) {
		this.riqi1 = riqi1;
	}
	public Double getDot1() {
		return dot1;
	}
	public void setDot1(Double dot1) {
		this.dot1 = dot1;
	}
	@Id
	public Date getRiqi2() {
		return riqi2;
	}
	public void setRiqi2(Date riqi2) {
		this.riqi2 = riqi2;
	}
	public Double getDot2() {
		return dot2;
	}
	public void setDot2(Double dot2) {
		this.dot2 = dot2;
	}
	public Integer getDot1todot2() {
		return dot1todot2;
	}
	public void setDot1todot2(Integer dot1todot2) {
		this.dot1todot2 = dot1todot2;
	}
	public Double getGradient() {
		return gradient;
	}
	public void setGradient(Double gradient) {
		this.gradient = gradient;
	}
	public Date getRiqi3() {
		return riqi3;
	}
	public void setRiqi3(Date riqi3) {
		this.riqi3 = riqi3;
	}
	public Double getDot3() {
		return dot3;
	}
	public void setDot3(Double dot3) {
		this.dot3 = dot3;
	}
	public Double getForecastprice() {
		return forecastprice;
	}
	public void setForecastprice(Double forecastprice) {
		this.forecastprice = forecastprice;
	}
	
	public String getUpordown() {
		return upordown;
	}
	public void setUpordown(String upordown) {
		this.upordown = upordown;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dot1 == null) ? 0 : dot1.hashCode());
		result = prime * result
				+ ((dot1todot2 == null) ? 0 : dot1todot2.hashCode());
		result = prime * result + ((dot2 == null) ? 0 : dot2.hashCode());
		result = prime * result + ((dot3 == null) ? 0 : dot3.hashCode());
		result = prime * result
				+ ((forecastprice == null) ? 0 : forecastprice.hashCode());
		result = prime * result
				+ ((gradient == null) ? 0 : gradient.hashCode());
		result = prime * result
				+ ((gupiaodaima == null) ? 0 : gupiaodaima.hashCode());
		result = prime * result + ((riqi1 == null) ? 0 : riqi1.hashCode());
		result = prime * result + ((riqi2 == null) ? 0 : riqi2.hashCode());
		result = prime * result + ((riqi3 == null) ? 0 : riqi3.hashCode());
		result = prime * result
				+ ((upordown == null) ? 0 : upordown.hashCode());
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
		Trendlinestmp other = (Trendlinestmp) obj;
		if (dot1 == null) {
			if (other.dot1 != null)
				return false;
		} else if (!dot1.equals(other.dot1))
			return false;
		if (dot1todot2 == null) {
			if (other.dot1todot2 != null)
				return false;
		} else if (!dot1todot2.equals(other.dot1todot2))
			return false;
		if (dot2 == null) {
			if (other.dot2 != null)
				return false;
		} else if (!dot2.equals(other.dot2))
			return false;
		if (dot3 == null) {
			if (other.dot3 != null)
				return false;
		} else if (!dot3.equals(other.dot3))
			return false;
		if (forecastprice == null) {
			if (other.forecastprice != null)
				return false;
		} else if (!forecastprice.equals(other.forecastprice))
			return false;
		if (gradient == null) {
			if (other.gradient != null)
				return false;
		} else if (!gradient.equals(other.gradient))
			return false;
		if (gupiaodaima == null) {
			if (other.gupiaodaima != null)
				return false;
		} else if (!gupiaodaima.equals(other.gupiaodaima))
			return false;
		if (riqi1 == null) {
			if (other.riqi1 != null)
				return false;
		} else if (!riqi1.equals(other.riqi1))
			return false;
		if (riqi2 == null) {
			if (other.riqi2 != null)
				return false;
		} else if (!riqi2.equals(other.riqi2))
			return false;
		if (riqi3 == null) {
			if (other.riqi3 != null)
				return false;
		} else if (!riqi3.equals(other.riqi3))
			return false;
		if (upordown == null) {
			if (other.upordown != null)
				return false;
		} else if (!upordown.equals(other.upordown))
			return false;
		return true;
	}
		

	
	}