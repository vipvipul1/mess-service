package com.nsec.mess.repository.auth;

import com.nsec.mess.models.User;

public interface IRegisterUserRepo {

	public User registerUser(User user);

	public Boolean validateUserBeforeRegister(String phoneEmailStudId);
	
}
