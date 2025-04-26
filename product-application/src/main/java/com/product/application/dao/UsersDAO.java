package com.product.application.dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.application.Expection.ApplicationExpection;
import com.product.application.config.EmailSender;
import com.product.application.dto.UsersDTO;
import com.product.application.entity.UserEntity;
import com.product.application.repo.UsersRepository;

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

	public UserEntity findById(Long userId) throws ApplicationExpection {
		// TODO Auto-generated method stub
		return repo.findById(userId).orElseThrow(() -> new ApplicationExpection("User not found"));
	}

}
