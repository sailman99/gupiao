package com.gupiao.model.persist.entity;

import java.util.Date;

public class PKId_scalewarm implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6036155628058762532L;
	private String gupiaodaima;
	private Date zuidiriqi;
	private Double scale;
	public String getGupiaodaima() {
		return gupiaodaima;
	}
	public void setGupiaodaima(String gupiaodaima) {
		this.gupiaodaima = gupiaodaima;
	}
	public Date getZuidiriqi() {
		return zuidiriqi;
	}
	public void setZuidiriqi(Date zuidiriqi) {
		this.zuidiriqi = zuidiriqi;
	}
	public Double getScale() {
		return scale;
	}
	public void setScale(Double scale) {
		this.scale = scale;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gupiaodaima == null) ? 0 : gupiaodaima.hashCode());
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
		result = prime * result
				+ ((zuidiriqi == null) ? 0 : zuidiriqi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PKId_scalewarm other = (PKId_scalewarm) obj;
		if (gupiaodaima == null) {
			if (other.gupiaodaima != null)
				return false;
		} else if (!gupiaodaima.equals(other.gupiaodaima))
			return false;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		if (zuidiriqi == null) {
			if (other.zuidiriqi != null)
				return false;
		} else if (!zuidiriqi.equals(other.zuidiriqi))
			return false;
		return true;
	}
	
	

}
