package com.nsec.mess.service.auth;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsec.mess.models.User;
import com.nsec.mess.repository.auth.IRegisterUserRepo;
import com.nsec.mess.vo.UserVo;

@Service
public class RegisterUserService implements IRegisterUserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserService.class);
	
	@Autowired
	private IRegisterUserRepo registerUserRepo;
	
	@Override
	@Transactional
	public Integer registerUser(UserVo userVo) {
		LOGGER.info("RegisterUserService :: registerUser :: Start");
		
		User userEntity = new User();
		BeanUtils.copyProperties(userVo, userEntity);
		try {
			userEntity = registerUserRepo.registerUser(userEntity);
		} catch(Exception e) {
			LOGGER.error("Exception in RegisterUserService :: registerUser : {}", e);
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
			isAvailable = registerUserRepo.validateUserBeforeRegister(data);
		} catch(Exception e) {
			LOGGER.error("Exception in RegisterUserService :: validateUserBeforeRegister : {}", e);
			throw e;
		}
		LOGGER.info("RegisterUserService :: validateUserBeforeRegister :: End");
		
		return isAvailable;
	}

}
