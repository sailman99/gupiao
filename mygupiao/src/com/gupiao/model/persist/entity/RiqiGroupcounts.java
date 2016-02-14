package com.gupiao.model.persist.entity;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



/**
 * Gupiao entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
public class RiqiGroupcounts implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2627808776009091340L;
	private Date riqi;
	private Integer rowcounts;
	@Id
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	public Integer getRowcounts() {
		return rowcounts;
	}
	public void setRowcounts(Integer rowcounts) {
		this.rowcounts = rowcounts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((riqi == null) ? 0 : riqi.hashCode());
		result = prime * result + ((rowcounts == null) ? 0 : rowcounts.hashCode());
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
		RiqiGroupcounts other = (RiqiGroupcounts) obj;
		if (riqi == null) {
			if (other.riqi != null)
				return false;
		} else if (!riqi.equals(other.riqi))
			return false;
		if (rowcounts == null) {
			if (other.rowcounts != null)
				return false;
		} else if (!rowcounts.equals(other.rowcounts))
			return false;
		return true;
	}
	
}