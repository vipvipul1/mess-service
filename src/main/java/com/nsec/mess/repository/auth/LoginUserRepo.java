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
	public User validateUserLogin(String username, String password) {
		LOGGER.info("LoginUserRepo :: validateUserLogin :: Start");

		User user = null;
		Object[] record = null;
		try {
			record = (Object[]) entityManager.createNativeQuery("SELECT user_id,username,full_name,phone,email,role_id FROM user "
					+ "WHERE username =:username and password =:password and is_disabled=false and is_active=true")
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
			user = new User();
			user.setUserId((Integer) record[0]);
			user.setUsername((String) record[1]);
			user.setFullName((String) record[2]);
			user.setPhone((String) record[3]);
			user.setEmail((String) record[4]);			
			user.setRoleId((Integer) record[5]);			
		} catch (NoResultException exc) {
			LOGGER.info("User not found with given credentials!");
		} catch (Exception exc) {
			LOGGER.error("Error in LoginUserRepo :: validateUserLogin : {}", exc.getMessage());
			throw exc;
		}
		
		LOGGER.info("LoginUserRepo :: validateUserLogin :: End");
		return user;
	}


}
