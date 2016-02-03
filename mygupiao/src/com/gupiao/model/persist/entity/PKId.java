package com.gupiao.model.persist.entity;

import java.util.Date;

public class PKId implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6096155628058762532L;
	private String gupiaodaima;
	private Date riqi;
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

}
