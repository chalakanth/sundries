package com.seonthemon.spbt.view.model.datetranslator;

import java.util.Map;

import com.seonthemon.spbt.view.model.BetterDateFormat;

public class TranslatedDate {

	public TranslatedDate(String incoming, Map<BetterDateFormat, String> translations) {
		super();
		this.incoming = incoming;
		this.translations = translations;
	}

	public TranslatedDate() {
		super();
	}

	private String incoming;
	
	private Map<BetterDateFormat, String> translations;

	public String getIncoming() {
		return incoming;
	}

	public Map<BetterDateFormat, String> getTranslations() {
		return translations;
	}
}
