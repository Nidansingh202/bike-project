package com.ms.master.service;

import java.util.List;

import com.ms.master.bikebeans.CustomerDataBean;
import com.ms.master.pojos.bikepojo.CustomerDataPojo;
import com.ms.master.pojos.bikepojo.JobServicePojo;
import com.ms.master.pojos.bikepojo.PaidServicePojo;




public interface ServiceInt {

	List<PaidServicePojo> getitemdata();

	boolean savedata(CustomerDataBean cbean);

	CustomerDataPojo getsearchdata(String reg);

	void updatedata(CustomerDataBean ubean);

	JobServicePojo getjobservicedata(int reg);

	

	

	

	

}
