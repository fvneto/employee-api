package com.vicente.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vicente.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	List<Employee> findByAge(int age);
}
