package com.example.share;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity
@IdClass(GpsclientdataPKId.class)
public class Gpsclientdata  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4276555750180755285L;
	
	 private Integer userid;  
	 private Date gpsdatetime;
	 private Double longitude ;
	 private Double  latitude;
	 private Float  speed;
	 private Double blongitude;
	 private Double blatitude;
	 private Double glongitude;
	 private Double glatitude;
	@Id 
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer integer) {
		this.userid = integer;
	}
	@Id
	public Date getGpsdatetime() {
		return gpsdatetime;
	}
	public void setGpsdatetime(Date gpsdatetime) {
		this.gpsdatetime = gpsdatetime;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Float getSpeed() {
		return speed;
	}
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
	public Double getBlongitude() {
		return blongitude;
	}
	public void setBlongitude(Double blongitude) {
		this.blongitude = blongitude;
	}
	public Double getBlatitude() {
		return blatitude;
	}
	public void setBlatitude(Double blatitude) {
		this.blatitude = blatitude;
	}
	public Double getGlongitude() {
		return glongitude;
	}
	public void setGlongitude(Double glongitude) {
		this.glongitude = glongitude;
	}
	public Double getGlatitude() {
		return glatitude;
	}
	public void setGlatitude(Double glatitude) {
		this.glatitude = glatitude;
	}
	
	 

}
