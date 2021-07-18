package com.nsec.mess.repository.auth;

import java.util.List;

import com.nsec.mess.models.User;

public interface IManageUsersRepo {

	List<User> getAllUserDetails();

	Integer grantAccess(Integer userId);

	Integer revokeAccess(Integer userId);

}
