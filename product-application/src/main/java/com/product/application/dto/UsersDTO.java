package com.example.application.dto;

import lombok.Data;

@Data
public class UsersDTO {

	private Long userId;

	private String userName;

	private String loginId;

	private String password;

	private Long contactNumber;

	private String email;

	private Integer active=1;
	
	private AddressDTO address;

}
