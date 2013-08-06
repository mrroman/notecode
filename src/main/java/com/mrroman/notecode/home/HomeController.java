package com.mrroman.notecode.home;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@ModelAttribute("users")
	public List<String> users() {
		return Arrays.asList("gienek", "stefka", "jozek");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "homeSignedIn" : "homeNotSignedIn";
	}
	
	@RequestMapping(value = "/hello")
	public String hello(@ModelAttribute("daysBetween") DaysBetweenForm form) {
		return "hello";
	}
	
	public static class DaysBetweenForm {

		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date from,to;
		
		public Date getFrom() {
			return from;
		}
		
		public Date getTo() {
			return to;
		}
		
		public void setFrom(Date from) {
			this.from = from;
		}
		
		public void setTo(Date to) {
			this.to = to;
		}
		
		public Long getDaysBetween() {
			if (from != null && to != null) {
				return (to.getTime() - from.getTime()) / (24*60*60*1000); 
			} else {
				return null;
			}
		}
	}
}
