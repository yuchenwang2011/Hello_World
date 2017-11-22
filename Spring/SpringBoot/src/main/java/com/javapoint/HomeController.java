package com.javapoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//for RestController annotation, you need have spring-boot-starter artifactId in pom.xml
//RestController
@Controller
public class HomeController {
    @RequestMapping("/")  
    public String index(){  
        return"index";  
    }  
	
//	@RequestMapping(value="/info", method=RequestMethod.GET)
//	public String showInfo() {
//		return "This is demo information";
//	}
	
    @RequestMapping(value="/save", method=RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute User user){  
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("user-data");      
        modelAndView.addObject("user", user);    
        return modelAndView;  
    }  
	//Actuator dependency included in pom file also provides a lot of endpoints
	//https://www.javatpoint.com/spring-boot-actuator
}
