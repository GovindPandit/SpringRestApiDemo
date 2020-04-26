package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.User;
import com.niit.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class IndexController 
{
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = {"/"})
	public ResponseEntity<List<User>> m1()
	{
		return new ResponseEntity<List<User>>(userRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/id/{userid}")
	public ResponseEntity<User> m2(@PathVariable("userid") int userid)
	{
		return new  ResponseEntity<User>(userRepository.findByUserid(userid),HttpStatus.OK);
	}
	
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> m3(@PathVariable("username") String username)
	{
		return new  ResponseEntity<User>(userRepository.findByUsername(username),HttpStatus.OK);
	}
	
	
	@GetMapping("/email/{email}")
	public ResponseEntity<User> m4(@PathVariable("email") String email)
	{
		return new  ResponseEntity<User>(userRepository.findByEmail(email),HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Void> m5(@RequestBody User user)
	{
		userRepository.save(user);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<Void> m6(@PathVariable("userid") int userid)
	{
		User u=new User();
		u.setUserid(userid);
		userRepository.delete(u);
		return new  ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> m7(@RequestBody User user)
	{
		userRepository.save(user);
		return new  ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
}
