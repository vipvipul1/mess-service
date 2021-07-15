package com.nsec.mess.service.auth;

import com.nsec.mess.vo.UserVo;

public interface IRegisterUserService {

	Integer registerUser(UserVo userVo);

	Boolean validateUserBeforeRegister(String data);

}
