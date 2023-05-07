package com.gridscape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.exceptions.NoUserFoundException;
import com.gridscape.models.Organization;
import com.gridscape.models.User;
import com.gridscape.userservice.UserService;

@RestController
@RequestMapping("/gridscape")
public class UserController {
	
	@Autowired
	private UserService uSer;
	
	@GetMapping("/registerUser")
	public ModelAndView registerUser() {
		return new ModelAndView("index");
	}
	
	@PostMapping("/saveUser")
	public ModelAndView registerUser(@RequestBody User user) {
		User regUser = uSer.registerUser(user);
		ModelAndView mv=new ModelAndView("View_User", "registerUser", regUser);
		return mv;
	}
	
	@PutMapping("/updateOrganization")
	public ModelAndView changeOrganization(@RequestBody Organization org) throws NoUserFoundException{
		User updatedUser = uSer.changeOrganization(org);
		ModelAndView mv=new ModelAndView("", "updatedUser", updatedUser);
		return mv;
	}
	
	@GetMapping("/allUser")
	public ModelAndView getAllUser() {
		List<User> allUser=uSer.getAllUser();
		ModelAndView mv=new ModelAndView("","allUser", allUser);
		return mv;
	}

}
