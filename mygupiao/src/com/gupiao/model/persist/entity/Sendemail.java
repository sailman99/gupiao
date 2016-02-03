package com.gupiao.model.persist.entity;



import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Entity;//引入这个类就正确了


/**
 * Gupiao entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
public class Sendemail implements java.io.Serializable {

	// Fields

	private String gupiaodaima;
	private String biaoji;
	private Date  cyc13riqi;
	private Double cyc13price;
	private Date  cyc34riqi;
	private Double cyc34price;
	private Double cyc28price;
	private Date  cyc28riqi;
	@Id
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	public String getBiaoji() {
		return biaoji;
	}
	public void setBiaoji(String biaoji) {
		this.biaoji = biaoji;
	}
	public Date getCyc13riqi() {
		return cyc13riqi;
	}
	public void setCyc13riqi(Date cyc13riqi) {
		this.cyc13riqi = cyc13riqi;
	}
	public Double getCyc13price() {
		return cyc13price;
	}
	public void setCyc13price(Double cyc13price) {
		this.cyc13price = cyc13price;
	}
	public Date getCyc34riqi() {
		return cyc34riqi;
	}
	public void setCyc34riqi(Date cyc34riqi) {
		this.cyc34riqi = cyc34riqi;
	}
	public Double getCyc34price() {
		return cyc34price;
	}
	public void setCyc34price(Double cyc34price) {
		this.cyc34price = cyc34price;
	}
	public Double getCyc28price() {
		return cyc28price;
	}
	public void setCyc28price(Double cyc28price) {
		this.cyc28price = cyc28price;
	}
	public Date getCyc28riqi() {
		return cyc28riqi;
	}
	public void setCyc28riqi(Date cyc28riqi) {
		this.cyc28riqi = cyc28riqi;
	}
	


}