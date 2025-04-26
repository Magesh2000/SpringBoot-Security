package com.product.application.Service;

import java.util.List;

import com.product.application.Expection.ApplicationExpection;
import com.product.application.dto.UsersDTO;
import com.product.application.entity.UserEntity;

public interface UserService {

	public UsersDTO createUser(UsersDTO users);

	public List<UserEntity> getUserList(UsersDTO users) throws ApplicationExpection;

}
