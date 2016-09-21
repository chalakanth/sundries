package com.seonthemon.spbt.view.model;

import java.text.DateFormat;

public enum BetterDateFormat {

	FULL(DateFormat.FULL),
	LONG(DateFormat.LONG),
	MEDIUM(DateFormat.MEDIUM),
	SHORT(DateFormat.SHORT);
	
	/**
	 * @see DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT
	 */
	private int oldJavaDateFormat;
	
	private BetterDateFormat(int dateFormatCode) {
		this.oldJavaDateFormat = dateFormatCode;
	}

	public int getDateFormatCode() {
		return oldJavaDateFormat;
	}
	
	
	
}
