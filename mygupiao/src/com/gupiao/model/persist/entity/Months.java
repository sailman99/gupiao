package com.gupiao.model.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Months implements java.io.Serializable{
	private static final long serialVersionUID = -26276562009091340L;
	private String month;
	@Id
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
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
		Months other = (Months) obj;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		return true;
	}
	

}
