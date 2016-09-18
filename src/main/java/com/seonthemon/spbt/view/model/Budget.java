package com.seonthemon.spbt.view.model;

import java.math.BigDecimal;

public class Budget {

	private BudgetDuration duration;
	
	private BigDecimal amountRolledOver;
	
	private BigDecimal amountForThisDuration;
	
	private ExpenseCategory whatBudgetIsFor;
	
	public BudgetDuration getDuration() {
		return duration;
	}

	public BigDecimal getRolledOverBudget() {
		return amountRolledOver;
	}

	public BigDecimal getThisDurationBudget() {
		return amountForThisDuration;
	}

	public ExpenseCategory getWhatBudgetIsFor() {
		return whatBudgetIsFor;
	}

	public static Budget make(BudgetDuration duration, BigDecimal rolledOverBudget, BigDecimal thisDurationBudget, ExpenseCategory whatBudgetIsFor) {
		
		Budget out = new Budget();
		
		out.duration = duration;
		out.amountRolledOver = rolledOverBudget;
		out.amountForThisDuration = thisDurationBudget;
		out.whatBudgetIsFor = whatBudgetIsFor;

		return out;
	}


}
