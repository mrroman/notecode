package com.mrroman.notecode.home;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String hello(@RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "age", required = false) Integer age, 
			@RequestParam(value = "date", required = false) Date date, 
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("inMillis", date.getTime());
		return "hello";
	}
	
	@InitBinder
	public void setupBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			@Override
			public String getAsText() {
				return format.format((Date)getValue());
			}
			
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				try {
					setValue(format.parse(text));
				} catch (ParseException e) {
					setValue(null);
				}
			}
		});
	}
	
}
