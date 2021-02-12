package com.punisher;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.punisher.model.Student;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentRepo repo;
	
	@GetMapping("")
	public List<Student> getStudent(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudent(@PathVariable int id){
		return repo.findById(id);
	}
	
	@PostMapping(consumes= {"application/json"})
	public Student addStudent(@RequestBody Student st) {
		return repo.save(st);
	}
	
	@PutMapping(consumes= {"application/json"})
	public Student addOrUpdateStudent(@RequestBody Student st) {
		return repo.save(st);
	}
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		Optional<Student> st = repo.findById(id);
		if(st.isPresent()) {
			repo.delete(st.get());
			return true;
		}else return false;
	}
}
