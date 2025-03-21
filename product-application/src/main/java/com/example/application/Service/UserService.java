package com.example.application.Service;

import java.util.List;

import com.example.application.dto.UsersDTO;
import com.example.application.entity.UserEntity;

public interface UserService {

	public UsersDTO createUser(UsersDTO users);

	public List<UserEntity> getUserList(UsersDTO users);

}
