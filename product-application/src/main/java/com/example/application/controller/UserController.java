package com.example.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.Expection.ApplicationExpection;
import com.example.application.Service.UserService;
import com.example.application.dto.JsonObject;
import com.example.application.dto.UsersDTO;
import com.example.application.entity.UserEntity;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/user")
public class UserController {

	//@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	

	@PostMapping(value = "/create")
	public ResponseEntity<JsonObject> createUser(@Valid @RequestBody UsersDTO users) throws ApplicationExpection {
		JsonObject jsonObject= new JsonObject();
		try {
			UsersDTO userDetails = userService.createUser(users);
			
			jsonObject.setSuccess(userDetails);

			return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			jsonObject.setErrorMesgg(e.toString());
			return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.GATEWAY_TIMEOUT);
		}

	}
	
	


	@GetMapping(value="/list")
	public ResponseEntity<JsonObject> getUserList(@RequestBody UsersDTO users) {
		
		
		JsonObject jsonObject= new JsonObject();
		try {
			List<UserEntity> userDetails = userService.getUserList(users);
			
			jsonObject.setSuccess(userDetails);

			return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			System.out.println(e);
			jsonObject.setErrorMesgg(e.toString());
			return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.NOT_FOUND);
		}
	}
	
	
}
