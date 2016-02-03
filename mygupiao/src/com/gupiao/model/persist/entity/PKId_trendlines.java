package com.gupiao.model.persist.entity;

import java.util.Date;

public class PKId_trendlines implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6096124838058762532L;
	private String gupiaodaima;
	private Date riqi1;
	private Date riqi2;
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}	
	public Date getRiqi1() {
		return riqi1;
	}
	public void setRiqi1(Date riqi1) {
		this.riqi1 = riqi1;
	}
	public Date getRiqi2() {
		return riqi2;
	}
	public void setRiqi2(Date riqi2) {
		this.riqi2 = riqi2;
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
