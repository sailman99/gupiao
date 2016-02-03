package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PKId.class)
public class Zuidicyc {
	
	private String gupiaodaima;
	private Date riqi;
	private double zuidicyc13;
	private double huanshoubi120;
	private Date inriqi;
	private double injia;
    private double innday;
    private double findzuidi;
    private double findzuidinday;
    private Date outriqi;
    private double outjia;
    private double inoutnday;
    private double li;
    
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
	public double getZuidicyc13() {
		return zuidicyc13;
	}
	public void setZuidicyc13(double zuidicyc13) {
		this.zuidicyc13 = zuidicyc13;
	}
	public double getHuanshoubi120() {
		return huanshoubi120;
	}
	public void setHuanshoubi120(double huanshoubi120) {
		this.huanshoubi120 = huanshoubi120;
	}
	public Date getInriqi() {
		return inriqi;
	}
	public void setInriqi(Date inriqi) {
		this.inriqi = inriqi;
	}
	public double getInjia() {
		return injia;
	}
	public void setInjia(double injia) {
		this.injia = injia;
	}
	public double getInnday() {
		return innday;
	}
	public void setInnday(double innday) {
		this.innday = innday;
	}
	public double getFindzuidi() {
		return findzuidi;
	}
	public void setFindzuidi(double findzuidi) {
		this.findzuidi = findzuidi;
	}
	public double getFindzuidinday() {
		return findzuidinday;
	}
	public void setFindzuidinday(double findzuidinday) {
		this.findzuidinday = findzuidinday;
	}
	public Date getOutriqi() {
		return outriqi;
	}
	public void setOutriqi(Date outriqi) {
		this.outriqi = outriqi;
	}
	public double getOutjia() {
		return outjia;
	}
	public void setOutjia(double outjia) {
		this.outjia = outjia;
	}
	public double getInoutnday() {
		return inoutnday;
	}
	public void setInoutnday(double inoutnday) {
		this.inoutnday = inoutnday;
	}
	public double getLi() {
		return li;
	}
	public void setLi(double li) {
		this.li = li;
	}
    
    
}
