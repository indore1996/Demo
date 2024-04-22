package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepo departRepo;
	
	@GetMapping("/{pageNo}/{size}")
	public Page<Employee> getAlldepartment(@PathVariable int pageNo,@PathVariable int size, @RequestParam(defaultValue="id") String sortBy){
		Pageable p = PageRequest.of(pageNo,size,Sort.by(sortBy));
		return departRepo.findAll(p);
	}
	
	@PostMapping
	public Employee createDepart(@RequestBody Employee department) {
		return departRepo.save(department);
	}
	
	@GetMapping("/{id}")
	public Employee getByIdDepart(@PathVariable Long id) throws Exception {
		return departRepo.findById(id).orElseThrow(()-> new Exception("id"+ id));
	}
	
	@PutMapping("/{id}")
	public Employee UpdateDepart(@RequestBody Employee department, @PathVariable Long id) throws Exception {
		Employee depart = departRepo.findById(id).orElseThrow(()-> new Exception("id"+ id));
		
		depart.setName(department.getName());
		
		return departRepo.save(depart);
	}
	
	@DeleteMapping("/{id}")
	public void delDepart(@PathVariable Long id) {
		departRepo.deleteById(id);
	}
}
