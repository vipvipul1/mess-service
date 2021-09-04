package com.nsec.mess.service.auth;

import com.nsec.mess.vo.UserVO;

public interface IRegisterUserService {

	Integer registerUser(UserVO userVo);

	Boolean validateUserBeforeRegister(String data);

}
