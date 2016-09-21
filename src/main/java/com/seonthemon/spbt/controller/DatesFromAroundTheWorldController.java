package com.seonthemon.spbt.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.ImmutableList;
import com.seonthemon.spbt.Instrumented;
import com.seonthemon.spbt.LogX;
import com.seonthemon.spbt.uiservice.DatesFromAroundTheWorld;
import com.seonthemon.spbt.view.data.converters.USLocalDateConverter;
import com.seonthemon.spbt.view.model.datetranslator.DateTranslationRequest;
import com.seonthemon.spbt.view.model.datetranslator.MinLocale;

@Controller
public class DatesFromAroundTheWorldController extends Instrumented {

	@Autowired
	private DatesFromAroundTheWorld dateService;
	
	private List<MinLocale> allAvailableLocales = null;

	@Autowired
	private void makeAllLocales() {
		List<MinLocale> uniqueLocales = new ArrayList<MinLocale>();
		
		for (Locale aLocale : Locale.getAvailableLocales()) {
			if (StringUtils.isNotBlank(aLocale.getDisplayCountry())) {
				String displayItem = StringUtils.join(ImmutableList.of(aLocale.getDisplayLanguage(), aLocale.getDisplayCountry(), aLocale.getVariant()), ':');
				String value = StringUtils.join(ImmutableList.of(aLocale.getLanguage(), aLocale.getCountry(), aLocale.getVariant()), '_');
				
				uniqueLocales.add(new MinLocale(displayItem, value));
			}
		}
		
		Collections.sort(uniqueLocales);
		allAvailableLocales = uniqueLocales;
	}

	
	@ModelAttribute("dateFormat") 
	public String localeFormat( Locale locale) {	
		return USLocalDateConverter.getPattern( locale);
	}

	
	@RequestMapping("/datesFromAroundTheWorld")
	public String startDatesFromAroundTheWorld(DateTranslationRequest translationRequest, Model uiModel) {
		uiModel.addAttribute("allLocales", allAvailableLocales);
		return "datesFromAroundTheWorld/promptForLocalDate";
	}
	


	@RequestMapping("/datesFromAroundTheWorld/translateDate")
	public String translateDate(DateTranslationRequest translationRequest, Model uiModel) {
		LogX.debug(log, "Got this from the web: ", translationRequest);
				
		uiModel.addAttribute("allLocales", allAvailableLocales);
		uiModel.addAttribute("dateTranslationRequest", translationRequest);
		uiModel.addAttribute("translatedDate", this.dateService.translateDate(translationRequest));
		return "datesFromAroundTheWorld/promptForLocalDate";
	}

}
