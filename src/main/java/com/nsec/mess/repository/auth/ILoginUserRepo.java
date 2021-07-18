package com.nsec.mess.repository.auth;

import com.nsec.mess.models.User;

public interface ILoginUserRepo {

	User validateUserLogin(String username, String password);

}
