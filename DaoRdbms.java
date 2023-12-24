package com.ms.master.dao.rdbms;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ms.master.bikebeans.CustomerDataBean;
import com.ms.master.dao.BikeDao;
import com.ms.master.pojos.bikepojo.CustomerDataPojo;
import com.ms.master.pojos.bikepojo.JobServicePojo;
import com.ms.master.pojos.bikepojo.PaidServicePojo;
import com.ms.master.pojos.bikepojo.ServiceDataPojo;

@Repository
public class DaoRdbms extends DBConnectionDao implements BikeDao{

	@Override
	public List<PaidServicePojo> getdata() {
		DetachedCriteria cre=DetachedCriteria.forClass(PaidServicePojo.class);
		List<PaidServicePojo> li=hibernateTemplate.findByCriteria(cre);	
		return li;
	}

	@Override
	public void savedata(CustomerDataPojo cdata) {
		System.out.println("Hi Dao data is ="+cdata.getVno()+" "+cdata.getName()+" "+cdata.getMobile());
		hibernateTemplate.save(cdata);
		
	}

	@Override
	public void saveservicedata(ServiceDataPojo sd) {
		
		hibernateTemplate.save(sd);
		
	}

	@Override
	public CustomerDataPojo getsearchdata(String vno) {
		
		DetachedCriteria cre=DetachedCriteria.forClass(CustomerDataPojo.class);
		cre.add(Restrictions.eq("vno",vno));
		CustomerDataPojo li=(CustomerDataPojo) hibernateTemplate.findByCriteria(cre).get(0);	
		return li;
		}

	@Override
	public void updatedata(CustomerDataPojo cdpojo) {
		hibernateTemplate.update(cdpojo);
		
	}

	@Override
	public void updateservice(ServiceDataPojo sd1) {
		hibernateTemplate.save(sd1);
		
	}

	@Override
	public void deleteolddata(CustomerDataBean ubean) {
		Session session = sessionFactory.openSession();		
        Query qry = session.createQuery("DELETE FROM ServiceDataPojo sp where sp.regid=:java4s");
        qry.setParameter("java4s",ubean.getRegid());
        qry.executeUpdate();
    	System.out.println("Delete Command successfully executed....");
        session.close();
        sessionFactory.close();
	}

	@Override
	public boolean checkunique(String vno) {
		System.out.println(vno);
		DetachedCriteria cre=DetachedCriteria.forClass(CustomerDataPojo.class);
		cre.add(Restrictions.eq("vno",vno));
		List<CustomerDataPojo> li= hibernateTemplate.findByCriteria(cre);	
		if(li.size()==0){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public void createjob(JobServicePojo jdata) {
		hibernateTemplate.save(jdata);
		
	}

	@Override
	public int getjobid() {
		DetachedCriteria cre=DetachedCriteria.forClass(JobServicePojo.class);
		 List<JobServicePojo> li= hibernateTemplate.findByCriteria(cre);
		 return li.size();
		
	}

	@Override
	public JobServicePojo getjobservicedata(int reg) {
		DetachedCriteria cre=DetachedCriteria.forClass(JobServicePojo.class);
		cre.add(Restrictions.eq("regid",reg));
		JobServicePojo li=(JobServicePojo) hibernateTemplate.findByCriteria(cre).get(0);	
		return li;
	}


	
	
	
}
