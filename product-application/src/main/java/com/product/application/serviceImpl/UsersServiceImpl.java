package com.product.application.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.product.application.Expection.ApplicationExpection;
import com.product.application.Service.UserService;
import com.product.application.dao.UsersDAO;
import com.product.application.dto.UsersDTO;
import com.product.application.entity.AddressEntity;
import com.product.application.entity.UserEntity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class UsersServiceImpl implements UserService {

	@Autowired
	private UsersDAO usersDAO;

	private final Validator validator;

	public UsersServiceImpl(Validator validator) {
		this.validator = validator;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UsersDTO createUser(UsersDTO users) {
		UserEntity userEntity = new UserEntity();
		AddressEntity adress = new AddressEntity();

		BeanUtils.copyProperties(users.getAddress(), adress);
		
		BeanUtils.copyProperties(users, userEntity);
		userEntity.setAddress(adress);
		adress.setUser(userEntity);
		userEntity.setPassword(passwordEncoder.encode(users.getPassword()));

		Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}

		UsersDTO userDeatails = usersDAO.createUser(userEntity);

		return userDeatails;
	}

	@Override
	public List<UserEntity> getUserList(UsersDTO users) throws ApplicationExpection {
		List<UserEntity> userList = new ArrayList<>();
		if (users.getUserId() == null) {
			userList = usersDAO.getUserList();
		} else {
			UserEntity user = usersDAO.findById(users.getUserId());
			userList.add(user);
		}

		return userList;
	}

}
