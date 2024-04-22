package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/depart")
public class DepartmentController {

	@Autowired
	private DepartRepo departRepo;
	
	@GetMapping("/{pageNo}/{size}")
	public Page<Departmanet> getAlldepartment(@PathVariable int pageNo,@PathVariable int size, @RequestParam(defaultValue="id") String sortBy){
		Pageable p = PageRequest.of(pageNo,size,Sort.by(sortBy));
		return departRepo.findAll(p);
	}
	
	@PostMapping
	public Departmanet createDepart(@RequestBody Departmanet department) {
		return departRepo.save(department);
	}
	
	@GetMapping("/{id}")
	public Departmanet getByIdDepart(@PathVariable Long id) throws Exception {
		return departRepo.findById(id).orElseThrow(()-> new Exception("id"+ id));
	}
	
	@PutMapping("/{id}")
	public Departmanet UpdateDepart(@RequestBody Departmanet department, @PathVariable Long id) throws Exception {
		Departmanet depart = departRepo.findById(id).orElseThrow(()-> new Exception("id"+ id));
		depart.setDepartmentName(department.getDepartmentName());
		return departRepo.save(depart);
	}
	
	@DeleteMapping("/{id}")
	public void delDepart(@PathVariable Long id) {
		departRepo.deleteById(id);
	}
}
