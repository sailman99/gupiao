package com.example.share;

import java.util.Date;

public class GpsclientdataPKId implements java.io.Serializable{
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3201777467357821017L;
	private Integer userid;
	private Date gpsdatetime;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Date getGpsdatetime() {
		return gpsdatetime;
	}
	public void setGpsdatetime(Date gpsdatetime) {
		this.gpsdatetime = gpsdatetime;
	}
	

}
