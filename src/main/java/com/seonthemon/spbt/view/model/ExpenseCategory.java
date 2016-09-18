package com.seonthemon.spbt.view.model;

import java.util.List;

import com.google.common.collect.ImmutableMap;

public class ExpenseCategory {


	public static final ImmutableMap<String, ExpenseCategory> EXPRENSE_CATEGORY_TREE = 
			new ImmutableMap.Builder<String, ExpenseCategory>()
				.put("home", ExpenseCategory.make("home"))
				.put("home.mortgage", ExpenseCategory.make("home.mortgage"))
				.put("home.maintenance", ExpenseCategory.make("home.maintenance"))
				.put("home.improvement", ExpenseCategory.make("home.improvement"))				
				.put("home.utilities", ExpenseCategory.make("home.utilities"))
				.put("home.utilities.water", ExpenseCategory.make("home.utilities.water"))
				.put("home.utilities.gas", ExpenseCategory.make("home.utilities.gas"))
				.put("home.utilities.electricity", ExpenseCategory.make("home.utilities.electricity"))
				
				.put("food", ExpenseCategory.make("food"))
				.put("food.eatingIn", ExpenseCategory.make("food.eatingIn"))
				.put("food.eatingOut", ExpenseCategory.make("food.eatingOut"))

				.put("car", ExpenseCategory.make("car"))
				.put("car.fuel", ExpenseCategory.make("car.fuel"))
				.put("car.insurance", ExpenseCategory.make("car.insurance"))
				.put("car.maintenance", ExpenseCategory.make("car.maintenance"))
				.build();
	
	static {
		// make the tree ...
	}
	
	
	private String name;

	private ExpenseCategory parent;
	
	private List<ExpenseCategory> children;
	
	public ExpenseCategory getParent() {
		return parent;
	}

	public List<ExpenseCategory> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}
	
	public static ExpenseCategory make(String name) {
		ExpenseCategory out = new ExpenseCategory();
		out.name = name;
		return out;
	}
	
}
