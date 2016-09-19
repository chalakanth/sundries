package com.seonthemon.spbt.controller;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.seonthemon.spbt.Instrumented;
import com.seonthemon.spbt.LogX;
import com.seonthemon.spbt.view.data.converters.USLocalDateConverter;
import com.seonthemon.spbt.view.model.datetranslator.DateTranslationRequest;
import com.seonthemon.spbt.view.model.datetranslator.MinLocale;
import com.seonthemon.spbt.view.model.datetranslator.TranslatedDate;

@Controller
public class DatesFromAroundTheWorldController extends Instrumented {

	
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
		
		uniqueLocales.sort(null);
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
		uiModel.addAttribute("translatedDate", translateDate(translationRequest));
		return "datesFromAroundTheWorld/promptForLocalDate";
	}


	private TranslatedDate translateDate(DateTranslationRequest translationRequest) {
		
		Locale toLocale = makeLocale(translationRequest.getToLocale());

		DateTimeFormatter fullFormatter =  DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(toLocale);
		DateTimeFormatter longFormatter =  DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(toLocale);
		DateTimeFormatter mediumFormatter =  DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(toLocale);
		DateTimeFormatter shortFormatter =  DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(toLocale);
		
		
		Map<FormatStyle, String> translations = ImmutableMap.of(
				FormatStyle.FULL, translationRequest.getLocalDate().format(fullFormatter),
				FormatStyle.LONG, translationRequest.getLocalDate().format(longFormatter),
				FormatStyle.MEDIUM, translationRequest.getLocalDate().format(mediumFormatter),
				FormatStyle.SHORT, translationRequest.getLocalDate().format(shortFormatter)
				);
		
		return new TranslatedDate(translationRequest.getLocalDate(), translations);
	}


	private Locale makeLocale(String toLocale) {
		String[] parts = StringUtils.split(toLocale, '_');
		
		
		return (parts.length == 3) ? 
				new Locale(parts[0], parts[1], parts[2]) :
					(parts.length == 2) ? 
							new Locale(parts[0], parts[1]) :
								(parts.length == 1) ? 
										new Locale(parts[0]) :
											null;
	}
}
