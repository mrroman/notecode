package com.mrroman.notecode.vcs;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepositoryController {

	@RequestMapping(value = "/repository/new", method = RequestMethod.GET)
	public String repoNew(@ModelAttribute("repository") Repository repository) {
		return "repository/form";
	}
	
	@RequestMapping(value = "/repository/new", method = RequestMethod.POST)
	public String repoNewSubmit(@Valid @ModelAttribute("repository") Repository repository, Errors errors) {
		return "repository/form";
	}
	
}
