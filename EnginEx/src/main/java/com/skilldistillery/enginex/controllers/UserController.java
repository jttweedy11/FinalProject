package com.skilldistillery.enginex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.enginex.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userServ;
}
