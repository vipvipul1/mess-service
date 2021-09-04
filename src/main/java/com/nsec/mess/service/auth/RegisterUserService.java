package com.nsec.mess.service.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsec.mess.models.User;
import com.nsec.mess.repository.auth.IRegisterUserRepo;
import com.nsec.mess.vo.UserVO;

@Service
public class RegisterUserService implements IRegisterUserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserService.class);
	
	@Autowired
	private IRegisterUserRepo iRegisterUserRepo;
	
	@Override
	@Transactional
	public Integer registerUser(UserVO userVo) {
		LOGGER.info("RegisterUserService :: registerUser :: Start");
		
		User userEntity = new User();
		BeanUtils.copyProperties(userVo, userEntity);
		try {
			userEntity = iRegisterUserRepo.registerUser(userEntity);
		} catch(Exception e) {
			LOGGER.error("Error in RegisterUserService :: registerUser : {}", e.getMessage());
			throw e;
		}
		LOGGER.info("RegisterUserService :: registerUser :: End");
		
		return userEntity.getUserId();
	}

	@Override
	@Transactional
	public Boolean validateUserBeforeRegister(String data) {
		LOGGER.info("RegisterUserService :: validateUserBeforeRegister :: Start");
		
		Boolean isAvailable = null;
		try {
			isAvailable = iRegisterUserRepo.validateUserBeforeRegister(data);
		} catch(Exception e) {
			LOGGER.error("Error in RegisterUserService :: validateUserBeforeRegister : {}", e.getMessage());
			throw e;
		}
		LOGGER.info("RegisterUserService :: validateUserBeforeRegister :: End");
		
		return isAvailable;
	}

}
