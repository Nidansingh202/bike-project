package com.ms.master.controllers;

import java.util.List;










import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.master.bikebeans.CustomerDataBean;
import com.ms.master.pojos.bikepojo.CustomerDataPojo;
import com.ms.master.pojos.bikepojo.JobServicePojo;
import com.ms.master.pojos.bikepojo.PaidServicePojo;
import com.ms.master.pojos.bikepojo.ServiceDataPojo;
import com.ms.master.service.ServiceInt;


@Controller
public class HomeController {
	@Autowired
	private ServiceInt ser;
	
	@RequestMapping(value = "/AgentLogin")
	public String login()
	{
		System.out.println( "login..");
		return "AgentLogin";
	}
	
	@RequestMapping(value = "/search")
	public String search(String reg,Model map,HttpSession sess)
	{
		
		System.out.println( "search and update.."+reg);
		CustomerDataPojo cs=ser.getsearchdata(reg);
		for (ServiceDataPojo c : cs.getServiceDataPojo()) {
			System.out.println("HI = "+c.getServiceid());
		}
		map.addAttribute("tmp",cs);
		sess.setAttribute("temp", cs);
		
		JobServicePojo jb=ser.getjobservicedata(cs.getId());
		map.addAttribute("job",jb);
		sess.setAttribute("jobs", jb);
		
		
		List<PaidServicePojo> pj=ser.getitemdata();
		
		map.addAttribute("item",pj);
		sess.setAttribute("items", pj);
		return "fetchdata";
	}
	
	@RequestMapping(value = "/panel")
	public String panelstart()
	{
		System.out.println( "starting panel..");
		
		return "panel";
	}
	@RequestMapping(value = "/searchdata")
	public String searchdata()
	{
		System.out.println( "Searching data..");
		
		return "searchpage";
	}
	
	@RequestMapping(value = "/loadpanel")
	public String loadpanel()
	{
		System.out.println( "loading panel..");
		
		return "panel";
	}
	
	
	
	@RequestMapping(value = "/home")
	public String homepage()
	{
		System.out.println( "HomePage..");
		
		return "home";
	}
	@RequestMapping(value = "/loadservice")
	public String servicestart(Model map)
	{
		System.out.println( "fill new service details..");
		List<PaidServicePojo> pj=ser.getitemdata();
		map.addAttribute("item",pj);
		return "newservice";
	}
	@RequestMapping(value = "/generatebill")
	public String bill()
	{
		System.out.println( "generating bill..");
		return "getbillsearch";
	}
	@RequestMapping(value = "/savedata")
	public @ResponseBody String savedata(CustomerDataBean cbean)
	{
		System.out.println("Hi all data is ="+cbean.getVno()+" "+cbean.getName()+" "+cbean.getMob()+" "+cbean.getRd()+"Array "+cbean.getSerarr());
		
	
		boolean b=ser.savedata(cbean);
		if(b)
		{
		return "success";
		}
		return "fail";
	}
	
	@RequestMapping(value = "/updatedata")
	public String updatedata(CustomerDataBean ubean)
	{
		System.out.println("Updating this");
		System.out.println("Hi new data to be updated ="+ubean.getVno()+" "+ubean.getName()+" "+ubean.getMob()+" "+ubean.getRd()+"  Array -> "+ubean.getSerarr());
		ser.updatedata(ubean);
		System.out.println("Finished Updation");
		return "searchpage";
	}
	
	@RequestMapping(value = "/getbill")
	public String getbill(String reg,Model map)
	{
	
		System.out.println("Generating Bill");
		
		
		return "bill";
	}
	
	
	
	
}
