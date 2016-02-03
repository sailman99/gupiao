package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gupiao.web.tools.MyTools;



/**
 * MbcjgsjsTemporary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="mbcjgsjs_temporary")
public class MbcjgsjsTemporary implements java.io.Serializable {

	// Fields

	private String id;
	private String gupiaodaima;
	private String gupiaomingcheng;
	private Date riqi;
	private Double mbcjgs;
	private Double mbcjgs5;
	private Double mbcjgs10;
	private Double mbcjgs30;
	private Double mbcjgs120;
	private Double cyc;

	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGupiaodaima() {
		return this.gupiaodaima;
	}

	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}

	public String getGupiaomingcheng() {
		return MyTools.getGBKStr(this.gupiaomingcheng);
		//return this.gupiaomingcheng;
	}

	public void setGupiaomingcheng(String gupiaomingcheng) {
		this.gupiaomingcheng = gupiaomingcheng;
	}

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

	public Double getCyc() {
		return this.cyc;
	}

	public void setCyc(Double cyc) {
		this.cyc = cyc;
	}

}