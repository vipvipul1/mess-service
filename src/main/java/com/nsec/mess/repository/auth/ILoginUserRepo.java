package com.nsec.mess.repository.auth;

public interface ILoginUserRepo {

	Boolean validateUserLogin(String username, String password);

}
