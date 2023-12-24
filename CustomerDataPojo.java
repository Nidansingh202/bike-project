package com.ms.master.pojos.bikepojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="customerdata")
public class CustomerDataPojo {

	@Id
	@GeneratedValue
	@Column(name="RegId")
	private int id;

	@Column(name="VehicleNo")
	private String vno;
	
	
	@Column(name="Name")
	private String name;


	@Column(name="Mobile")
	private String mobile;
	

	
	@OneToMany(fetch=FetchType.EAGER,targetEntity=ServiceDataPojo.class,mappedBy="customerpojo")
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({CascadeType.ALL})
	List<ServiceDataPojo> ServiceDataPojo;

	
	
	public List<ServiceDataPojo> getServiceDataPojo() {
		return ServiceDataPojo;
	}

	public void setServiceDataPojo(List<ServiceDataPojo> serviceDataPojo) {
		ServiceDataPojo = serviceDataPojo;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVno() {
		return vno;
	}

	public void setVno(String vno) {
		this.vno = vno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	
	
	
}
