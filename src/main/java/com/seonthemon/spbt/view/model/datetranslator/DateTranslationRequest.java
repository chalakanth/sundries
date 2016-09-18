package com.seonthemon.spbt.view.model.datetranslator;

import java.time.LocalDate;

public class DateTranslationRequest {

	private LocalDate localDate;
	
	private String toLocale;

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public String getToLocale() {
		return toLocale;
	}

	public void setToLocale(String toLocale) {
		this.toLocale = toLocale;
	}
	
	
}
