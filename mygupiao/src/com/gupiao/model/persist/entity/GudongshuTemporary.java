package com.gupiao.model.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.gupiao.web.tools.*;

/**
 * GudongshuTemporary entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
public class GudongshuTemporary implements java.io.Serializable {

	// Fields

	private String gupiaodaima;
	private String gupiaomingcheng;
	private Double sanhubili0;
	private Double sanhubili5;
	private Double sanhubili10;
	private Double sanhubili20;

	@Id
	public String getGupiaodaima() {
		return this.gupiaodaima;
	}

	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}

	public String getGupiaomingcheng() {
		return MyTools.getGBKStr(this.gupiaomingcheng);
		
	}

	public void setGupiaomingcheng(String gupiaomingcheng) {
		this.gupiaomingcheng = gupiaomingcheng;
	}

	public Double getSanhubili0() {
		return this.sanhubili0;
	}

	public void setSanhubili0(Double sanhubili0) {
		this.sanhubili0 = sanhubili0;
	}

	public Double getSanhubili5() {
		return this.sanhubili5;
	}

	public void setSanhubili5(Double sanhubili5) {
		this.sanhubili5 = sanhubili5;
	}

	public Double getSanhubili10() {
		return this.sanhubili10;
	}

	public void setSanhubili10(Double sanhubili10) {
		this.sanhubili10 = sanhubili10;
	}

	public Double getSanhubili20() {
		return this.sanhubili20;
	}

	public void setSanhubili20(Double sanhubili20) {
		this.sanhubili20 = sanhubili20;
	}

}