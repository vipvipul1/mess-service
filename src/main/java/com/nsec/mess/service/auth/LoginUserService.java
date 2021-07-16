package com.nsec.mess.service.auth;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsec.mess.repository.auth.ILoginUserRepo;
import com.nsec.mess.rest.auth.LoginUserController;

@Service
public class LoginUserService implements ILoginUserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserController.class);
	
	@Autowired
	private ILoginUserRepo loginUserRepo;
	
	@Override
	@Transactional
	public Boolean validateUserLogin(String username, String password) {
		LOGGER.info("LoginUserService :: validateUserLogin :: Start");
		
		Boolean isUserValid = null;
		try {
			isUserValid = loginUserRepo.validateUserLogin(username, password);
		} catch(Exception e) {
			LOGGER.error("Error in LoginUserService :: validateUserLogin : {}", e.getMessage());
			throw e;
		}
		LOGGER.info("LoginUserService :: validateUserLogin :: End");
		
		return isUserValid;
	}

}
