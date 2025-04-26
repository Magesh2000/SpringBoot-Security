package com.product.application.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.application.entity.UserEntity;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUserName(String userName);

}
