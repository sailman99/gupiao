package com.gupiao.model.persist.entity;



import javax.persistence.Id;
import javax.persistence.Entity;//引入这个类就正确了


/**
 * Gupiao entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
public class Gupiao implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -262780312009091340L;
	private String gupiaodaima;
	private String gupiaomingcheng;
	private String hangyedaima;
	private String xingji;
	private String qianzhong;
	private String gainian;
	private String qita;
	
	@Id
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	public String getGupiaomingcheng() {
		return gupiaomingcheng;
	}
	public void setGupiaomingcheng(String gupiaomingcheng) {
		this.gupiaomingcheng = gupiaomingcheng;
	}
	public String getHangyedaima() {
		return hangyedaima;
	}
	public void setHangyedaima(String hangyedaima) {
		this.hangyedaima = hangyedaima;
	}
	public String getXingji() {
		return xingji;
	}
	public void setXingji(String xingji) {
		this.xingji = xingji;
	}
	public String getQianzhong() {
		return qianzhong;
	}
	public void setQianzhong(String qianzhong) {
		this.qianzhong = qianzhong;
	}
	public String getGainian() {
		return gainian;
	}
	public void setGainian(String gainian) {
		this.gainian = gainian;
	}
	public String getQita() {
		return qita;
	}
	public void setQita(String qita) {
		this.qita = qita;
	}



}