package com.product.application.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotNull
	@Column(name = "user_name")
	@NotNull
	private String userName;

	@NotBlank(message = "login id must be 4 charcters")
	@NotNull
	@Column(name = "login_id")
	private String loginId;

	@NotNull
	@Column(name = "password")
	private String password;

	@Column(name = "number")
	private Long contactNumber;

	@Email
	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "active", columnDefinition = "Integer DEFAULT 1 ")
	private Integer active;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderEntity> orders;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id") // Foreign Key
	private AddressEntity address;

}
