package com.nsec.mess.repository.auth;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nsec.mess.models.User;

@Repository
public class LoginUserRepo implements ILoginUserRepo{

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserRepo.class);
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Boolean validateUserLogin(String username, String password) {
		LOGGER.info("LoginUserRepo :: validateUserLogin :: Start");
		
		Boolean isUserValid = null;
		try {
			entityManager.createQuery("SELECT u FROM User u WHERE u.username =:username and u.password =:password and u.isDisabled=false and u.isActive=true", User.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
			isUserValid = true;
		} catch (NoResultException exc) {
			isUserValid = false;
		} catch (Exception exc) {
			LOGGER.error("Exception in LoginUserRepo :: validateUserLogin : {}", exc);
			throw exc;
		}
		
		LOGGER.info("LoginUserRepo :: validateUserLogin :: End");
		return isUserValid;
	}


}
