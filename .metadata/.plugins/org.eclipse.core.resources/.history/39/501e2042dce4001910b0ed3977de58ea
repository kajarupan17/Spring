package com.Rupan.springmvchibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("unused")
@Controller
public class ProjCntrl {
	
	ApplicationContext conx = new ClassPathXmlApplicationContext("applicationContext.xml");

	@RequestMapping("/") 
	public String home(){
	    return "project"; 
	} 
	
	@RequestMapping(value="/save", method=RequestMethod.POST )
	public ModelAndView saveProject(Project proj) {
		
		@SuppressWarnings("resource")
		ApplicationContext conx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProjDao dao = (ProjDao)conx.getBean("pdao");
		
		if(dao.saveProject(proj)) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success");
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("failed");
			return mv;
		}		
		
	}
	
	
}
