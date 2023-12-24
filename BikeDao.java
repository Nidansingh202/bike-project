package com.ms.master.dao;

import java.util.List;

import com.ms.master.bikebeans.CustomerDataBean;
import com.ms.master.pojos.bikepojo.CustomerDataPojo;
import com.ms.master.pojos.bikepojo.JobServicePojo;
import com.ms.master.pojos.bikepojo.PaidServicePojo;
import com.ms.master.pojos.bikepojo.ServiceDataPojo;




public interface BikeDao{

	List<PaidServicePojo> getdata();

	void savedata(CustomerDataPojo cdata);

	void saveservicedata(ServiceDataPojo sd);

	CustomerDataPojo getsearchdata(String vno);

	void updatedata(CustomerDataPojo cdpojo);

	void updateservice(ServiceDataPojo sd1);

	void deleteolddata(CustomerDataBean ubean);

	boolean checkunique(String vno);

	void createjob(JobServicePojo jdata);

	int getjobid();

	JobServicePojo getjobservicedata(int reg);

	



}
