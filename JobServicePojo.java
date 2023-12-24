package com.ms.master.pojos.bikepojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="jobservice")
public class JobServicePojo {
	
	@Id
	@Column(name="JobId")
	private String jobid;
	
	@Column(name="RegId")
	private int regid;
	
	@Column(name="ServiceType")
	private String service;
	
	@Column(name="ServiceCharge")
	private int serchrg;
	
	@Column(name="DateCreated")
	private Timestamp date;
	
	@Column(name="Status")
	private String status;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
		this.regid = regid;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getSerchrg() {
		return serchrg;
	}

	public void setSerchrg(int serchrg) {
		this.serchrg = serchrg;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
}
