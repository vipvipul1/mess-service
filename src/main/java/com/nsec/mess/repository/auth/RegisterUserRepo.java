package com.nsec.mess.repository.auth;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nsec.mess.models.User;
import com.nsec.mess.service.auth.RegisterUserService;

@Repository
public class RegisterUserRepo implements IRegisterUserRepo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserService.class);
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User registerUser(User user) {
		LOGGER.info("RegisterUserRepo :: registerUser :: Start");
		
		user = entityManager.merge(user);
		
		LOGGER.info("RegisterUserRepo :: registerUser :: End");
		return user;
	}

	@Override
	public Boolean validateUserBeforeRegister(String data) {
		LOGGER.info("RegisterUserRepo :: validateUserBeforeRegister :: Start");
		
		Boolean isAvailable = null;
		try {
			entityManager.createQuery(
					"SELECT u FROM User u WHERE u.username =:username OR u.phone =:phone OR u.email =:email OR u.studentId =:studentId", User.class)
					.setParameter("username", data)
					.setParameter("phone", data)
					.setParameter("email", data)
					.setParameter("studentId", data).getSingleResult();
			isAvailable = true;
		} catch (NoResultException e) {
			isAvailable = false;
		} catch (Exception e) {
			LOGGER.error("Error in RegisterUserRepo :: validateUserBeforeRegister : {}", e.getMessage());
			throw e;
		}

		LOGGER.info("RegisterUserRepo :: validateUserBeforeRegister :: End");
		return isAvailable;
	}
}
