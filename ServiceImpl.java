package com.ms.master.service.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.master.bikebeans.CustomerDataBean;
import com.ms.master.dao.BikeDao;
import com.ms.master.pojos.bikepojo.CustomerDataPojo;
import com.ms.master.pojos.bikepojo.JobServicePojo;
import com.ms.master.pojos.bikepojo.PaidServicePojo;
import com.ms.master.pojos.bikepojo.ServiceDataPojo;
import com.ms.master.service.*;


@Service
public class ServiceImpl implements ServiceInt{
@Autowired
private BikeDao bkd;

@Override
public List<PaidServicePojo> getitemdata() {
	
	return bkd.getdata();
}

@Override
public boolean savedata(CustomerDataBean cbean) {
	
	if(bkd.checkunique(cbean.getVno()))
	{
		return false;
	}
	else{
		CustomerDataPojo cdata=new CustomerDataPojo();
		cdata.setVno(cbean.getVno());
		cdata.setMobile(cbean.getMob());
		cdata.setName(cbean.getName());
		
		bkd.savedata(cdata);
		
		
		JobServicePojo jdata=new JobServicePojo();
		char nm=cbean.getName().charAt(0);
		int m = Calendar.getInstance().get(Calendar.YEAR);
		int jobid=bkd.getjobid()+1;
		String jobserviceid=nm+""+m+""+jobid;
		jdata.setJobid(jobserviceid);
		jdata.setRegid(cdata.getId());
		jdata.setService(cbean.getRd());
		System.out.println("hello = "+cbean.getRd());
		if(cbean.getRd().equals("Paid"))
		{
			System.out.println("If mein");
			jdata.setSerchrg(320);
		}
		else{
			System.out.println("Else mein");
			jdata.setSerchrg(0);
		}
		jdata.setDate(new Timestamp(System.currentTimeMillis()));
		jdata.setStatus("Pending");
		bkd.createjob(jdata);
		
		
		
		for(int i=0;i<cbean.getSerarr().length;i++)
		{
			ServiceDataPojo sd=new ServiceDataPojo();
			System.out.println("All value ="+cbean.getSerarr()[i]);
			sd.setRegid(cdata.getId());
			sd.setServiceid(cbean.getSerarr()[i]);
			bkd.saveservicedata(sd);
		}
		return true;
		
	}
	
	
}

@Override
public CustomerDataPojo getsearchdata(String reg) {
	String vno=reg;
	CustomerDataPojo cdp=bkd.getsearchdata(vno);
		
	return cdp;
}

@Override
public void updatedata(CustomerDataBean ubean) {
	CustomerDataPojo cdpojo= new CustomerDataPojo();
	
	cdpojo.setVno(ubean.getVno());
	cdpojo.setMobile(ubean.getMob());
	cdpojo.setName(ubean.getName());
	cdpojo.setId(ubean.getRegid());
	bkd.updatedata(cdpojo);
	bkd.deleteolddata(ubean);
	for(int i=0;i<ubean.getSerarr().length;i++)
	{
		ServiceDataPojo sd1=new ServiceDataPojo();
		System.out.println("Updated Service value ="+ubean.getSerarr()[i]);
		System.out.println("Reg id = "+cdpojo.getId());
		sd1.setRegid(ubean.getRegid());
		sd1.setServiceid(ubean.getSerarr()[i]);
		bkd.updateservice(sd1);
	}
	
}

@Override
public JobServicePojo getjobservicedata(int reg) {

	return bkd.getjobservicedata(reg);
}



}
