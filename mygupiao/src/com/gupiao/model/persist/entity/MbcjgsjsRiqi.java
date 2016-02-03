package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * MbcjgsjsRiqi entity. @author MyEclipse Persistence Tools
 */
@Entity
public class MbcjgsjsRiqi implements java.io.Serializable {

	// Fields

	private Date riqi;
	private Double mbcjgs;
	private Double mbcjgs5;
	private Double mbcjgs10;
	private Double mbcjgs30;
	private Double mbcjgs120;

	// Constructors
    @Id
	public Date getRiqi() {
		return this.riqi;
	}

	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}

	public Double getMbcjgs() {
		return this.mbcjgs;
	}

	public void setMbcjgs(Double mbcjgs) {
		this.mbcjgs = mbcjgs;
	}

	public Double getMbcjgs5() {
		return this.mbcjgs5;
	}

	public void setMbcjgs5(Double mbcjgs5) {
		this.mbcjgs5 = mbcjgs5;
	}

	public Double getMbcjgs10() {
		return this.mbcjgs10;
	}

	public void setMbcjgs10(Double mbcjgs10) {
		this.mbcjgs10 = mbcjgs10;
	}

	public Double getMbcjgs30() {
		return this.mbcjgs30;
	}

	public void setMbcjgs30(Double mbcjgs30) {
		this.mbcjgs30 = mbcjgs30;
	}

	public Double getMbcjgs120() {
		return this.mbcjgs120;
	}

	public void setMbcjgs120(Double mbcjgs120) {
		this.mbcjgs120 = mbcjgs120;
	}

}