package com.nsec.mess.service.auth;

import com.nsec.mess.models.User;

public interface ILoginUserService {

	User validateUserLogin(String username, String password);

}
