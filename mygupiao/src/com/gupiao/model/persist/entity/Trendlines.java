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
public class Trendlines implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3186039411344546457L;
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
	private Date riqi4;
	private Double dot4;
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
	public Date getRiqi4() {
		return riqi4;
	}
	public void setRiqi4(Date riqi4) {
		this.riqi4 = riqi4;
	}
	public Double getDot4() {
		return dot4;
	}
	public void setDot4(Double dot4) {
		this.dot4 = dot4;
	}
	public String getUpordown() {
		return upordown;
	}
	public void setUpordown(String upordown) {
		this.upordown = upordown;
	}
		

	
	}