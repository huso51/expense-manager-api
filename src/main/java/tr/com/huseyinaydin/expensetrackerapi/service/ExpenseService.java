package tr.com.huseyinaydin.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tr.com.huseyinaydin.expensetrackerapi.entity.Expense;

public interface ExpenseService {
	public Page<Expense> getAllExpenses(Pageable page);
	Expense getExpenseById(Long id);
	void deleteExpenseById(Long id);
	//Expense saveExpenseDetail(Expense expense);
	Expense updateExpenseDetails(Long expenseId, Expense expense);
	List<Expense> readByCategory(String category, Pageable page);
	List<Expense> readByName(String category, Pageable page);
	List<Expense> readByDateBetween(Date startDate, Date endDate, Pageable page);
	Expense saveExpenseDetails(Expense expense);
}
