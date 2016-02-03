package com.gupiao.model.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.gupiao.web.tools.*;

/**
 * ChichuangxinxiTemp entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
public class ChichuangxinxiTemp implements java.io.Serializable {

	// Fields

	private String gupiaodaima;
	private String gupiaomingcheng;
	private Double sanhu;
	private Double zhonghu;
	private Double dahu;
	private Double faren;
	private Double jigou;

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

	public Double getSanhu() {
		return this.sanhu;
	}

	public void setSanhu(Double sanhu) {
		this.sanhu = sanhu;
	}

	public Double getZhonghu() {
		return this.zhonghu;
	}

	public void setZhonghu(Double zhonghu) {
		this.zhonghu = zhonghu;
	}

	public Double getDahu() {
		return this.dahu;
	}

	public void setDahu(Double dahu) {
		this.dahu = dahu;
	}

	public Double getFaren() {
		return this.faren;
	}

	public void setFaren(Double faren) {
		this.faren = faren;
	}

	public Double getJigou() {
		return this.jigou;
	}

	public void setJigou(Double jigou) {
		this.jigou = jigou;
	}

}