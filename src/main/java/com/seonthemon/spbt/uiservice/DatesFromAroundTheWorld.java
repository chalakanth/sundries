package com.seonthemon.spbt.uiservice;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;
import com.seonthemon.spbt.Instrumented;
import com.seonthemon.spbt.view.data.converters.USLocalDateConverter;
import com.seonthemon.spbt.view.model.BetterDateFormat;
import com.seonthemon.spbt.view.model.datetranslator.DateTranslationRequest;
import com.seonthemon.spbt.view.model.datetranslator.TranslatedDate;

@Service
public class DatesFromAroundTheWorld extends Instrumented {

	
	
	public TranslatedDate translateDate(DateTranslationRequest translationRequest) {
		
		Locale toLocale = makeLocale(translationRequest.getToLocale());

		DateFormat fullFormatter =  DateFormat.getDateInstance(BetterDateFormat.FULL.getDateFormatCode(), toLocale);
		DateFormat longFormatter =  DateFormat.getDateInstance(BetterDateFormat.LONG.getDateFormatCode(), toLocale);
		DateFormat mediumFormatter =  DateFormat.getDateInstance(BetterDateFormat.MEDIUM.getDateFormatCode(), toLocale);
		DateFormat shortFormatter =  DateFormat.getDateInstance(BetterDateFormat.SHORT.getDateFormatCode(), toLocale);
				
		Map<BetterDateFormat, String> translations = ImmutableMap.of(
				BetterDateFormat.FULL, fullFormatter.format(translationRequest.getLocalDate()),
				BetterDateFormat.LONG, longFormatter.format(translationRequest.getLocalDate()),
				BetterDateFormat.MEDIUM, mediumFormatter.format(translationRequest.getLocalDate()),
				BetterDateFormat.SHORT, shortFormatter.format(translationRequest.getLocalDate())
				);

		return new TranslatedDate(
				new USLocalDateConverter().print(translationRequest.getLocalDate(), Locale.US), 
				translations);
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
