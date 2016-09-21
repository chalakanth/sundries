package com.seonthemon.spbt.view.data.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class USLocalDateConverter implements Formatter<Date> {

	public static final String US_PATTERN = "MM/dd/yyyy"; 
	public static final String NORMAL_PATTERN = "dd/MM/yyyy";

	
	@Override
	public String print(Date object, Locale locale) {		
		return new SimpleDateFormat(getPattern(locale), locale).format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {		
		return new SimpleDateFormat(getPattern(locale), locale).parse(text);
	}
	
	
	public static String getPattern(Locale locale) { 
		return isUnitedStates(locale) ? US_PATTERN : NORMAL_PATTERN; 
	} 
	
	private static boolean isUnitedStates(Locale locale) { 
		return Locale.US.getCountry().equals(locale.getCountry()); 
	}


}
