package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Whilework {
	
	private String whilethread;
	private Date riqi;
	

	@Id
	public String getWhilethread() {
		return whilethread;
	}
	public void setWhilethread(String whilethread) {
		this.whilethread = whilethread;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	
	

}
