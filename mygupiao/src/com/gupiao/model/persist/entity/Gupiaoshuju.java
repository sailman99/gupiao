package com.gupiao.model.persist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Gupiaoshuju entity. @author MyEclipse Persistence Tools
 */
@Entity
@IdClass(PKId.class)
public class Gupiaoshuju implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3186085701344546457L;
	private String gupiaodaima;
	private Date riqi;
	private Double kaipan;
	private Double zuigao;
	private Double zuidi;
	private Double shoupan;
	private Double chengjiaoshou;
	private Double chengjiaojiner;
	private Double huanshou;
	private Double huanshou5;
	private Double huanshou10;
	private Double huanshou30;
	private Double huanshou60;
	private Double huanshou120;
	private Double cyc5;
	private Double cyc13;
	private Double cyc28;
	private Double cyc34;
	private Double cyc55;
	private Double cyc125;
	private Double cyc250;
	private Short cyc5count;
	private Short cyc13count;
	private Short cyc34count;
	private Short cyc55count;
	private Short cyc125count;
	private Short cyc250count;

	

	
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

	public Double getKaipan() {
		return this.kaipan;
	}

	public void setKaipan(Double kaipan) {
		this.kaipan = kaipan;
	}

	public Double getZuigao() {
		return this.zuigao;
	}

	public void setZuigao(Double zuigao) {
		this.zuigao = zuigao;
	}

	public Double getZuidi() {
		return this.zuidi;
	}

	public void setZuidi(Double zuidi) {
		this.zuidi = zuidi;
	}

	public Double getShoupan() {
		return this.shoupan;
	}

	public void setShoupan(Double shoupan) {
		this.shoupan = shoupan;
	}

	public Double getChengjiaoshou() {
		return this.chengjiaoshou;
	}

	public void setChengjiaoshou(Double chengjiaoshou) {
		this.chengjiaoshou = chengjiaoshou;
	}

	public Double getChengjiaojiner() {
		return this.chengjiaojiner;
	}

	public void setChengjiaojiner(Double chengjiaojiner) {
		this.chengjiaojiner = chengjiaojiner;
	}

	public Double getHuanshou() {
		return this.huanshou;
	}

	public void setHuanshou(Double huanshou) {
		this.huanshou = huanshou;
	}

	public Double getHuanshou5() {
		return this.huanshou5;
	}

	public void setHuanshou5(Double huanshou5) {
		this.huanshou5 = huanshou5;
	}

	public Double getHuanshou10() {
		return this.huanshou10;
	}

	public void setHuanshou10(Double huanshou10) {
		this.huanshou10 = huanshou10;
	}

	public Double getHuanshou30() {
		return this.huanshou30;
	}

	public void setHuanshou30(Double huanshou30) {
		this.huanshou30 = huanshou30;
	}

	public Double getHuanshou60() {
		return this.huanshou60;
	}

	public void setHuanshou60(Double huanshou60) {
		this.huanshou60 = huanshou60;
	}

	public Double getHuanshou120() {
		return this.huanshou120;
	}

	public void setHuanshou120(Double huanshou120) {
		this.huanshou120 = huanshou120;
	}

	public Double getCyc5() {
		return this.cyc5;
	}

	public void setCyc5(Double cyc5) {
		this.cyc5 = cyc5;
	}

	public Double getCyc13() {
		return this.cyc13;
	}

	public void setCyc13(Double cyc13) {
		this.cyc13 = cyc13;
	}

	public Double getCyc34() {
		return this.cyc34;
	}

	public void setCyc34(Double cyc34) {
		this.cyc34 = cyc34;
	}

	public Double getCyc55() {
		return this.cyc55;
	}

	public void setCyc55(Double cyc55) {
		this.cyc55 = cyc55;
	}

	public Double getCyc125() {
		return this.cyc125;
	}

	public void setCyc125(Double cyc125) {
		this.cyc125 = cyc125;
	}

	public Double getCyc250() {
		return this.cyc250;
	}

	public void setCyc250(Double cyc250) {
		this.cyc250 = cyc250;
	}

	public Short getCyc5count() {
		return this.cyc5count;
	}

	public void setCyc5count(Short cyc5count) {
		this.cyc5count = cyc5count;
	}

	public Short getCyc13count() {
		return this.cyc13count;
	}

	public void setCyc13count(Short cyc13count) {
		this.cyc13count = cyc13count;
	}

	public Short getCyc34count() {
		return this.cyc34count;
	}

	public void setCyc34count(Short cyc34count) {
		this.cyc34count = cyc34count;
	}

	public Short getCyc55count() {
		return this.cyc55count;
	}

	public void setCyc55count(Short cyc55count) {
		this.cyc55count = cyc55count;
	}

	public Short getCyc125count() {
		return this.cyc125count;
	}

	public void setCyc125count(Short cyc125count) {
		this.cyc125count = cyc125count;
	}

	public Short getCyc250count() {
		return this.cyc250count;
	}

	public void setCyc250count(Short cyc250count) {
		this.cyc250count = cyc250count;
	}

	public Double getCyc28() {
		return cyc28;
	}

	public void setCyc28(Double cyc28) {
		this.cyc28 = cyc28;
	}

}