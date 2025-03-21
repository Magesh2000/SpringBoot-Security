package com.example.application.dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.application.config.EmailSender;
import com.example.application.dto.UsersDTO;
import com.example.application.entity.UserEntity;
import com.example.application.repo.UsersRepository;

@Component
public class UsersDAO {

	@Autowired
	private UsersRepository repo;

	@Autowired
	private EmailSender emailSender;
	


	public UsersDTO createUser(UserEntity userEntity) {
		UsersDTO usersDTO = new UsersDTO();
		try {

			
			BeanUtils.copyProperties(repo.save(userEntity), usersDTO);

			if (usersDTO.getEmail() != null) {
				emailSender.mailSender(usersDTO);
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return usersDTO;
	}

	public List<UserEntity> getUserList() {

		List<UserEntity> list= repo.findAll();
		
		return list;
	}

	public UserEntity findById(Long userId) {
		// TODO Auto-generated method stub
		return repo.findById(userId).orElse(null);
	}

}
