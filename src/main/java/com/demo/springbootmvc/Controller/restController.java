package com.demo.springbootmvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootmvc.Model.DemoUser;
import com.demo.springbootmvc.Repository.JpaRepo;

@RestController
public class restController {
	
	@Autowired
	private JpaRepo repo;
	
	//To get the data
	@GetMapping("/")
	public String getData() {
		return "welcome";
	}
	
	@GetMapping(path = "/users", produces = "application/xml")
	public List<DemoUser> getUsers(){
		return repo.findAll();
	}
	//creating a new user
	@PostMapping("/saveuser")
	public String postUser(@RequestBody DemoUser user) {
		
		repo.save(user);
		return "saved";
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable long id,@RequestBody DemoUser user) {
		
		
		DemoUser UpdatedUser=repo.findById(id).get();
		 UpdatedUser.setAddress(UpdatedUser.getAddress());
		 UpdatedUser.setName(UpdatedUser.getName());
		 UpdatedUser.setPno(UpdatedUser.getPno());
		 UpdatedUser.setId(UpdatedUser.getId());
		 repo.save(UpdatedUser);
		 repo.save(user);
		return "updated";
	}
	@DeleteMapping("/deleteuser/{id}")
	public String DeleteUser(@PathVariable long id, DemoUser user) {
		repo.deleteById(id);		
		return "User Deleted";
	}
}
