package com.mrroman.notecode.vcs;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepositoryController {

	@Autowired
	private RepositoryRepository repositoryRepository;
	
	@RequestMapping(value = "/repository/new", method = RequestMethod.GET)
	public String repoNew(@ModelAttribute("repository") Repository repository) {
		return "repository/form";
	}
	
	@RequestMapping(value = "/repository/new", method = RequestMethod.POST)
	public String repoNewSubmit(@Valid @ModelAttribute("repository") Repository repository, Errors errors) {
		if (errors.hasErrors()) {
			return "repository/form";
		} else {
			Repository newRepository = repositoryRepository.saveAndFlush(repository);
			return "redirect:" + newRepository.getId();
		}
	}
	
	@RequestMapping(value = "/repository/{id}")
	public String repoView(@PathVariable("id") int id, Model model) {
		Repository repository = repositoryRepository.findOne(id);
		
		model.addAttribute("repository", repository);
		return "repository/form";
	}
	
}
