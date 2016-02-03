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
public class Rzzgs  implements java.io.Serializable {

	

	private String gupiaodaima;
	private Date riqi;
	private Double gdzs;
	private Double rzzg;
	private Double jsqbh;
	private Double zgb;
	private Double ltg;
	private Double jsqbh2;
	private Double jsqbh3;
	private Double jsqbh4;
	private Double jsqbh5;
	private Double jsqbh6;
	
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
	public Double getJsqbh3() {
		return jsqbh3;
	}
	public void setJsqbh3(Double jsqbh3) {
		this.jsqbh3 = jsqbh3;
	}
	public Double getJsqbh4() {
		return jsqbh4;
	}
	public void setJsqbh4(Double jsqbh4) {
		this.jsqbh4 = jsqbh4;
	}
	public Double getJsqbh5() {
		return jsqbh5;
	}
	public void setJsqbh5(Double jsqbh5) {
		this.jsqbh5 = jsqbh5;
	}
	public Double getJsqbh6() {
		return jsqbh6;
	}
	public void setJsqbh6(Double jsqbh6) {
		this.jsqbh6 = jsqbh6;
	}
		
}