package com.seonthemon.spbt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seonthemon.spbt.Instrumented;
import com.seonthemon.spbt.uiservice.UiBudgetManager;

@Controller
public class BudgetManagerController extends Instrumented {
	
	private UiBudgetManager budgetManager;
	
	@Autowired
	public BudgetManagerController(UiBudgetManager budgetManager) {
		this.budgetManager = budgetManager;
	}

	
	@RequestMapping(value = "/start") 
	public String start() { 
		return "start";
	}

	
	@RequestMapping(value = "/result") 
	public String searchResult(
			@RequestParam(value="searchArg", defaultValue="all") String searchArg, 
			Model model) {
		log.debug("> searchResult");
		log.debug("Search Arg: " + searchArg);
		
		try {
			model.addAttribute("expenseCategories", this.budgetManager.findExpenseCategories(searchArg));
			return "searchResult";
		}
		finally {
			log.debug("< searchResult");				
		}
	}
	
}
