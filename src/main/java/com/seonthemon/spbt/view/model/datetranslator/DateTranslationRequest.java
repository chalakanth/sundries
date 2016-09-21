package com.seonthemon.spbt.view.model.datetranslator;

import java.util.Date;

public class DateTranslationRequest {

	private Date localDate;
	
	private String toLocale;

	public Date getLocalDate() {
		return localDate;
	}

	public void setLocalDate(Date localDate) {
		this.localDate = localDate;
	}

	public String getToLocale() {
		return toLocale;
	}

	public void setToLocale(String toLocale) {
		this.toLocale = toLocale;
	}
	
	
}
