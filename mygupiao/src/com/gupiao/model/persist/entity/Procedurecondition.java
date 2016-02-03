package com.gupiao.model.persist.entity;



import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Entity;//引入这个类就正确了


/**
 * Gupiao entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
public class Procedurecondition implements java.io.Serializable {

	// Fields

	private String procedurethread;
	private String condition;
	
	@Id
	public String getProcedurethread() {
		return procedurethread;
	}
	public void setProcedurethread(String procedurethread) {
		this.procedurethread = procedurethread;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
	
	

}