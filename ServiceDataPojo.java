package com.ms.master.pojos.bikepojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="servicedata")
public class ServiceDataPojo {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;


	@Column(name="RegId")
	private int regid;


	@Column(name="ServiceId")
	private int serviceid;
	
	
	@ManyToOne()
	@JoinColumn(name="RegId",updatable=false,insertable=false)
	private CustomerDataPojo customerpojo;
	
	@ManyToOne()
	@JoinColumn(name="ServiceId",updatable=false,insertable=false)
	private PaidServicePojo paidservice;


	public PaidServicePojo getPaidservice() {
		return paidservice;
	}


	public void setPaidservice(PaidServicePojo paidservice) {
		this.paidservice = paidservice;
	}


	public CustomerDataPojo getCustomerpojo() {
		return customerpojo;
	}


	public void setCustomerpojo(CustomerDataPojo customerpojo) {
		this.customerpojo = customerpojo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRegid() {
		return regid;
	}


	public void setRegid(int regid) {
		this.regid = regid;
	}


	public int getServiceid() {
		return serviceid;
	}


	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	
	
	
	
	
}
