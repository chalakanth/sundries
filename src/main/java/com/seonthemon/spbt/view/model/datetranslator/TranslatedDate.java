package com.seonthemon.spbt.view.model.datetranslator;

import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.Map;

public class TranslatedDate {

	public TranslatedDate(LocalDate incoming, Map<FormatStyle, String> translations) {
		super();
		this.incoming = incoming;
		this.translations = translations;
	}

	public TranslatedDate() {
		super();
	}

	private LocalDate incoming;
	
	private Map<FormatStyle, String> translations;

	public LocalDate getIncoming() {
		return incoming;
	}

	public Map<FormatStyle, String> getTranslations() {
		return translations;
	}
}
