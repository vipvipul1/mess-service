package com.nsec.mess.service.auth;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsec.mess.models.User;
import com.nsec.mess.repository.auth.ILoginUserRepo;
import com.nsec.mess.rest.auth.LoginUserController;

@Service
public class LoginUserService implements ILoginUserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserController.class);
	
	@Autowired
	private ILoginUserRepo iLoginUserRepo;
	
	@Override
	@Transactional
	public User validateUserLogin(String username, String password) {
		LOGGER.info("LoginUserService :: validateUserLogin :: Start");
		
		User user = null;
		try {
			user = iLoginUserRepo.validateUserLogin(username, password);
		} catch(Exception e) {
			LOGGER.error("Error in LoginUserService :: validateUserLogin : {}", e.getMessage());
			throw e;
		}
		LOGGER.info("LoginUserService :: validateUserLogin :: End");
		
		return user;
	}

}
