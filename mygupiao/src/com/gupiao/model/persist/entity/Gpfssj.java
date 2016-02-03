package com.gupiao.model.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import java.util.Date;
@Entity
@IdClass(PKId.class)
public class Gpfssj implements java.io.Serializable {

	// Fields

	private String gupiaodaima;
	private Date riqi;
	private Double zuoshou;
	private Double jinkai;
	private Double chengjiaojia;
	private Double zuigaojia;
	private Double zuidijia;
	private Double inone;
	private Double outone;
	private Double zongliang;
	private Double chengjiaojine;
	private Double in1shou;
	private Double in1jia;
	private Double in2shou;
	private Double in2jia;
	private Double in3shou;
	private Double in3jia;
	private Double in4shou;
	private Double in4jia;
	private Double in5shou;
	private Double in5jia;
	private Double out1shu;
	private Double out1jia;
	private Double out2shu;
	private Double out2jia;
	private Double out3shu;
	private Double out3jia;
	private Double out4shu;
	private Double out4jia;
	private Double out5shu;
	private Double out5jia;
	

	
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

	public Double getZuoshou() {
		return zuoshou;
	}

	public void setZuoshou(Double zuoshou) {
		this.zuoshou = zuoshou;
	}

	public Double getJinkai() {
		return jinkai;
	}

	public void setJinkai(Double jinkai) {
		this.jinkai = jinkai;
	}

	public Double getChengjiaojia() {
		return chengjiaojia;
	}

	public void setChengjiaojia(Double chengjiaojia) {
		this.chengjiaojia = chengjiaojia;
	}

	public Double getZuigaojia() {
		return zuigaojia;
	}

	public void setZuigaojia(Double zuigaojia) {
		this.zuigaojia = zuigaojia;
	}

	public Double getZuidijia() {
		return zuidijia;
	}

	public void setZuidijia(Double zuidijia) {
		this.zuidijia = zuidijia;
	}

	public Double getInone() {
		return inone;
	}

	public void setInone(Double inone) {
		this.inone = inone;
	}

	public Double getOutone() {
		return outone;
	}

	public void setOutone(Double outone) {
		this.outone = outone;
	}

	public Double getZongliang() {
		return zongliang;
	}

	public void setZongliang(Double zongliang) {
		this.zongliang = zongliang;
	}

	public Double getChengjiaojine() {
		return chengjiaojine;
	}

	public void setChengjiaojine(Double chengjiaojine) {
		this.chengjiaojine = chengjiaojine;
	}

	public Double getIn1shou() {
		return in1shou;
	}

	public void setIn1shou(Double in1shou) {
		this.in1shou = in1shou;
	}

	public Double getIn1jia() {
		return in1jia;
	}

	public void setIn1jia(Double in1jia) {
		this.in1jia = in1jia;
	}

	public Double getIn2shou() {
		return in2shou;
	}

	public void setIn2shou(Double in2shou) {
		this.in2shou = in2shou;
	}

	public Double getIn2jia() {
		return in2jia;
	}

	public void setIn2jia(Double in2jia) {
		this.in2jia = in2jia;
	}

	public Double getIn3shou() {
		return in3shou;
	}

	public void setIn3shou(Double in3shou) {
		this.in3shou = in3shou;
	}

	public Double getIn3jia() {
		return in3jia;
	}

	public void setIn3jia(Double in3jia) {
		this.in3jia = in3jia;
	}

	public Double getIn4shou() {
		return in4shou;
	}

	public void setIn4shou(Double in4shou) {
		this.in4shou = in4shou;
	}

	public Double getIn4jia() {
		return in4jia;
	}

	public void setIn4jia(Double in4jia) {
		this.in4jia = in4jia;
	}

	public Double getIn5shou() {
		return in5shou;
	}

	public void setIn5shou(Double in5shou) {
		this.in5shou = in5shou;
	}

	public Double getIn5jia() {
		return in5jia;
	}

	public void setIn5jia(Double in5jia) {
		this.in5jia = in5jia;
	}

	public Double getOut1shu() {
		return out1shu;
	}

	public void setOut1shu(Double out1shu) {
		this.out1shu = out1shu;
	}

	public Double getOut1jia() {
		return out1jia;
	}

	public void setOut1jia(Double out1jia) {
		this.out1jia = out1jia;
	}

	public Double getOut2shu() {
		return out2shu;
	}

	public void setOut2shu(Double out2shu) {
		this.out2shu = out2shu;
	}

	public Double getOut2jia() {
		return out2jia;
	}

	public void setOut2jia(Double out2jia) {
		this.out2jia = out2jia;
	}

	public Double getOut3shu() {
		return out3shu;
	}

	public void setOut3shu(Double out3shu) {
		this.out3shu = out3shu;
	}

	public Double getOut3jia() {
		return out3jia;
	}

	public void setOut3jia(Double out3jia) {
		this.out3jia = out3jia;
	}

	public Double getOut4shu() {
		return out4shu;
	}

	public void setOut4shu(Double out4shu) {
		this.out4shu = out4shu;
	}

	public Double getOut4jia() {
		return out4jia;
	}

	public void setOut4jia(Double out4jia) {
		this.out4jia = out4jia;
	}

	public Double getOut5shu() {
		return out5shu;
	}

	public void setOut5shu(Double out5shu) {
		this.out5shu = out5shu;
	}

	public Double getOut5jia() {
		return out5jia;
	}

	public void setOut5jia(Double out5jia) {
		this.out5jia = out5jia;
	}
	
	
}