package com.seonthemon.spbt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * The index view is the form that lets you search for docs ....
 * 
 * Actions ....
 * 	Search for docs to tinker with
 *  
 *  Retrieve docs ...
 *  
 *  Preview docs ....
 *  
 *  Generate docs ....
 *  
 * 
 */
@Controller
@RequestMapping("/manual-docs")
public class ManualDocsController {

	/**
	 * 
	 * @param searchInputs
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String getDocs(Map<String, String> searchInputs, Model model) {
		return null;
	}
	
}
