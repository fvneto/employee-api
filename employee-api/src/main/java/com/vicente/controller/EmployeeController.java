package com.vicente.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vicente.model.Employee;
import com.vicente.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		List<Employee> employee = new ArrayList<>();
		try {

			repository.findAll().forEach(employee::add);

			if (employee.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employee, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {

		Optional<Employee> employeeData = repository.findById(id);

		if (employeeData.isPresent()) {
			
			return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/employees/create")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {

		try {
			
			Employee emp = repository.save(new Employee(employee.getName(), 
					employee.getAge(), employee.getFunction()));
			
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		
		try {
			
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteAllEmployees() {
		
		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	@GetMapping(value = "employees/age/{age}")
	public ResponseEntity<List<Employee>> findByAge(@PathVariable int age) {
		
		try {
			
			List<Employee> employees = repository.findByAge(age);

			if (employees.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(employees, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		
		Optional<Employee> employeeData = repository.findById(id);

		if (employeeData.isPresent()) {
			
			Employee emplo = employeeData.get();
			emplo.setName(employee.getName());
			emplo.setAge(employee.getAge());
			
			emplo.setActive(employee.isActive());
			return new ResponseEntity<>(repository.save(emplo), HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
