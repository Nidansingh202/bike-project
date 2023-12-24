package com.ms.master.pojos.bikepojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paidservice")
public class PaidServicePojo {

	
	@Id
	@GeneratedValue
	@Column(name="ServiceId")
	private int id;


	@Column(name="Name")
	private String name;


	@Column(name="Price")
	private int price;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	} 
	
	
}
