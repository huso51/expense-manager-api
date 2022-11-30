package tr.com.huseyinaydin.expensetrackerapi.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.huseyinaydin.expensetrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	//select * from tbl_expenses where category = ?
	Page<Expense> findByUserIdAndCategory(Long userId, String category, Pageable page);
	
	Page<Expense> findByUserIdAndNameContaining(Long userId, String keyword, Pageable page);
	
	Page<Expense> findByUserIdAndDateBetween(Long userId, Date startDate, Date endDate, Pageable page);
	
	/*
	//select * from tbl_expenses where name like '%keyword%';
	Page<Expense> findByNameContaining(String keyword, Pageable page);*/
	
	/*
	//select * from tbl_expenses where date between 'startDate' and 'endDate';
	Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);*/
	
	Page<Expense> findByUserId(Long userId, Pageable page);
	
	Optional<Expense> findByUserIdAndId(Long userId, Long expenseId);
}
