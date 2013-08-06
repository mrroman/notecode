package com.mrroman.notecode.vcs;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mrroman.notecode.account.Account;
import com.mrroman.notecode.account.AccountRepository;

@Controller
@RequestMapping("/repository")
public class RepositoryController {

	@Autowired
	private RepositoryRepository repositoryRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	@ModelAttribute("accounts")
	public List<Account> accounts() {
		return accountRepository.findAll();
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String repoNew(@ModelAttribute("repository") Repository repository) {
		return "repository/form";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String repoNewSubmit(@Valid @ModelAttribute("repository") Repository repository, Errors errors) {
		if (errors.hasErrors()) {
			return "repository/form";
		} else {
			Repository newRepository = repositoryRepository.saveAndFlush(repository);
			return "redirect:" + newRepository.getId();
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String repoView(@PathVariable("id") Repository repository, Model model) {
		model.addAttribute("repository", repository);
		return "repository/form";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String repoUpdate(@PathVariable("id") int id, @Valid @ModelAttribute("repository") Repository repository, Errors errors) {
		repository.setId(id);

		if (!errors.hasErrors()) {
			repositoryRepository.saveAndFlush(repository);
		}
		return "repository/form";
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String repoUpdate(@PathVariable("id") int id) {
				return "repository/form";
	}
	
}
