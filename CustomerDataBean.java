package com.ms.master.bikebeans;

import java.sql.Timestamp;

public class CustomerDataBean {

	private int regid;
	private String vno;
	private String name;
	private String mob;
	private String rd;
	private int[] serarr;
	private Timestamp date;
	
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
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
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getRd() {
		return rd;
	}
	public void setRd(String rd) {
		this.rd = rd;
	}
	public int[] getSerarr() {
		return serarr;
	}
	public void setSerarr(int[] serarr) {
		this.serarr = serarr;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

}
