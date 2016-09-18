package com.seonthemon.spbt.view.model;

public class ExpenseCategoryForDuration {

	private ExpenseCategory category;
	
	private Budget budgetForDuration;

	public ExpenseCategory getCategory() {
		return category;
	}

	public Budget getBudgetForDuration() {
		return budgetForDuration;
	}
	
	public static ExpenseCategoryForDuration make(ExpenseCategory category, Budget budgetForDuration) {
		
		ExpenseCategoryForDuration out = new ExpenseCategoryForDuration();
		
		out.category = category;
		out.budgetForDuration = budgetForDuration;

		return out;
	}
}
