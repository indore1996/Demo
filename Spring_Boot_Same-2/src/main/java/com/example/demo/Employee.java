package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
	private Departmanet department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Departmanet getDepartment() {
		return department;
	}

	public void setDepartment(Departmanet department) {
		this.department = department;
	}

	public Employee(String name, Departmanet department) {
		super();
		this.name = name;
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
