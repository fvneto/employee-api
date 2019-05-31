package com.vicente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;
	
	@Column(name = "profession") 
	private String function;

	@Column(name = "active")
	private boolean active;
	
	public Employee() {
	}

	public Employee(String name, int age, String function) {
		this.name = name;
		this.age = age;
		this.function = function;
		this.active = false;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getFunction() {
		return function;
	}
	 
	public void setFunction(String function) {
		this.function = function;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", function=" + function + 
			", age=" + age +", active=" + active + "]";
	}
}
