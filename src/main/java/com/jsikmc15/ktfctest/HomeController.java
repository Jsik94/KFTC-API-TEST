package com.jsikmc15.ktfctest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	
	@RequestMapping("/auth/authTest.do")
	public String authTest(@RequestParam Map map,HttpServletRequest req) {
		if(req.getHeader("Location")!=null) {
			System.out.println(req.getHeader("Location"));
		}
		System.out.println("여기 통과함 ?");
		if(map.get("code")!=null) {
			System.out.println("Code 값 들어옴!!");
			System.out.println(map.get("code"));
			return "forward:/auth/RequestAuth.do";
		}else if(map.get("location")!=null) {
			System.out.println("응답값 제대로 들어옴!");
		}
		
		return "auth/AuthPage";
	}
	
}
