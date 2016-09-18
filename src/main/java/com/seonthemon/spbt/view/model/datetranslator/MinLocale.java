package com.seonthemon.spbt.view.model.datetranslator;

public class MinLocale implements Comparable<MinLocale> {

	public MinLocale() {
		super();
	}

	public MinLocale(String displayName, String hiddenValue) {
		super();
		this.displayName = displayName;
		this.hiddenValue = hiddenValue;
	}

	private String displayName;
	
	public String getDisplayName() {
		return displayName;
	}

	public String getHiddenValue() {
		return hiddenValue;
	}

	private String hiddenValue;

	@Override
	public int compareTo(MinLocale o) {
		return this.displayName.compareToIgnoreCase(o.displayName);
	}
}
