package com.niliv.service;

import java.util.List;

import com.niliv.entity.Auditing;
import com.niliv.entity.Expense;

public interface ExpenseService {

	void add(Expense expense);

	List<Expense> getToAudit(String auditorId);

	void audit(Auditing auditing);

}
