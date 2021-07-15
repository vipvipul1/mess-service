package com.nsec.mess.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVo {

	private Integer userId;
	private String username;
	private String name;
	private String phone;
	private String email;
	private String password;
	private String address;
	private String branch;
	private Date dob;
	private String studentId;
	private Integer roleId;
	private Boolean isActive;
	private Boolean isDisabled;
	private Boolean isVeg;
	
}
