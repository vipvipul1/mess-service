package com.nsec.mess.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "BRANCH")
	private String branch;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column
	private String studentId;
	
	@Column(name = "ROLE_ID")
	private Integer roleId;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@Column(name = "IS_DISABLED")
	private Boolean isDisabled;
	
	@Column(name = "IS_VEG")
	private Boolean isVeg;

}
