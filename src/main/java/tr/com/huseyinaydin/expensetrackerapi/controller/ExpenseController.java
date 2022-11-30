package tr.com.huseyinaydin.expensetrackerapi.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tr.com.huseyinaydin.expensetrackerapi.entity.Expense;
import tr.com.huseyinaydin.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page) {
		calculateFactoriel(1);
		return this.expenseService.getAllExpenses(page).toList();
	}
	
	@GetMapping("/expense/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id) {
		return this.expenseService.getExpenseById(id);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/expense")
	public void deleteExpenseById(@RequestParam("expenseId") Long expenseId) {
		this.expenseService.deleteExpenseById(expenseId);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/expense")
	public Expense saveExpenseDetail(@Valid @RequestBody Expense expense) {
		return this.expenseService.saveExpenseDetails(expense);
	}
	
	@PutMapping("/expense/{expenseId}")
	public Expense updateExpenseDetail(@PathVariable("expenseId")Long expenseId,@Valid @RequestBody Expense expense) {
		return this.expenseService.updateExpenseDetails(expenseId, expense);
	}
	
	@GetMapping("/expenses/category")
	public List<Expense> findByCategory(@RequestParam String category, Pageable page) {
		return this.expenseService.readByCategory(category, page);
	}
	
	@GetMapping("/expenses/name")
	public List<Expense> getExpensesByName(@RequestParam String keyword, Pageable page) {
		return this.expenseService.readByName(keyword, page);
	}
	
	@GetMapping("/expenses/date")
	public List<Expense> getByDateBetween(@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate, Pageable page){
		return this.expenseService.readByDateBetween(startDate, endDate, page);
	}
	
	private int calculateFactoriel(int number) {
		return number * calculateFactoriel(number - 1);
	}
}
