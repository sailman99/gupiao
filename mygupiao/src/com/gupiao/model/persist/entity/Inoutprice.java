package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Inoutprice {
	
	private String gupiaodaima;
	private Date riqi;
	private double price;
	private String beizu;
	private String leixin;
	
	@Id
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	public String getBeizu() {
		return beizu;
	}
	public void setBeizu(String beizu) {
		this.beizu = beizu;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLeixin() {
		return leixin;
	}
	public void setLeixin(String leixin) {
		this.leixin = leixin;
	}
	

}
