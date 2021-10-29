package com.skilldistillery.enginex.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.enginex.entities.User;
import com.skilldistillery.enginex.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4300" })
public class UserController {

	@Autowired
	private UserService userServ;

	@GetMapping(path = "users")
	private List<User> index(HttpServletRequest req, HttpServletResponse res) {
		return userServ.index();
	}

	@GetMapping(path = "users/{id}")
	private User show(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) {
		User user = userServ.show(id);
		if (user == null) {
			res.setStatus(404);
			return null;
		} else {
			res.setStatus(200);
			return user;
		}
	}

	@DeleteMapping(path = "/users/{id}")
	public void delete(@PathVariable int id, HttpServletRequest req, HttpServletResponse res,
			Principal principal) {
		userServ.destroy(principal.getName(), id);
	}

	@PutMapping(path = "/users/{id}")
	public User update(@PathVariable int id, @RequestBody User user, HttpServletRequest req
			, HttpServletResponse res, Principal principal) {
		
		user = userServ.update(principal.getName(), id, user);
		return user;
	}
}
