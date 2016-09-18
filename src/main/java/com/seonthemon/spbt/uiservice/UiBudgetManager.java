package com.seonthemon.spbt.uiservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.seonthemon.spbt.Instrumented;
import com.seonthemon.spbt.LogX;
import com.seonthemon.spbt.view.model.ExpenseCategory;

@Service
public class UiBudgetManager extends Instrumented {

	public List<ExpenseCategory> findExpenseCategories() {

		return ImmutableList.copyOf(ExpenseCategory.EXPRENSE_CATEGORY_TREE.values());
		
	}

	public List<ExpenseCategory> findExpenseCategories(String searchArg) {
		log.debug("> findExpenseCategories");
		log.debug("Search Arg: " + searchArg);

		try {
			if (StringUtils.equalsIgnoreCase(searchArg, "all")) return findExpenseCategories();
			
			Iterable<ExpenseCategory> iterable = Iterables.filter(
					ImmutableList.copyOf(ExpenseCategory.EXPRENSE_CATEGORY_TREE.values()), 

					new Predicate<ExpenseCategory>() {

						@Override
						public boolean apply(ExpenseCategory input) {
							return input.getName().contains(searchArg);
						}					
					});

			List<ExpenseCategory> out = ImmutableList.copyOf(iterable);
			LogX.debug(log, "Result: ", out);
			return out;
		}
		finally {
			log.debug("< findExpenseCategories");			
		}
	}
}
