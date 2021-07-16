package com.nsec.mess.repository.auth;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nsec.mess.models.User;
import com.nsec.mess.service.auth.ManageUsersService;

@Repository
public class ManageUsersRepo implements IManageUsersRepo {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageUsersService.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<User> getAllUserDetails() {
		LOGGER.info("ManageUsersRepo :: getAllUserDetails :: Start");
		List<User> userList = null;

		try {
			userList = entityManager.createQuery("SELECT u FROM User u WHERE u.isActive=true", User.class).getResultList();
		} catch (Exception e) {
			LOGGER.error("Error in ManageUsersRepo :: getAllUserDetails : {}", e.getMessage());
			throw e;
		}

		LOGGER.info("ManageUsersRepo :: getAllUserDetails :: End");
		return userList;
	}

}
