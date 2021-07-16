package com.nsec.mess.rest.auth;

import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsec.mess.rest.util.BaseControllerMess;
import com.nsec.mess.service.auth.IRegisterUserService;
import com.nsec.mess.vo.UserVo;

@RestController
@RequestMapping("/mess/register")
public class RegisterUserController extends BaseControllerMess {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserController.class);

	@Autowired
	private IRegisterUserService registerUserService;

	@PostMapping("/user")
	public ResponseEntity<?> registerUser(@RequestBody UserVo userVo) {
		LOGGER.info("RegisterUserController :: registerUser :: Start");

		ResponseEntity<?> response = null;
		if (userVo.getUserId() == -1) {
			userVo.setRoleId(2);
			userVo.setIsDisabled(true);
			userVo.setIsActive(true);
			userVo.setIsNew(true);
			userVo.setRegDate(new Date());
		}
		try {
			Integer userId = registerUserService.registerUser(userVo);
			response = ResponseEntity.ok().body(userId);
		} catch (Exception e) {
			LOGGER.error("Error in RegisterUserController :: registerUser : {}", e);
			String rootCause = ExceptionUtils.getRootCauseMessage(e);
			response = getResponse(LOGGER, e, rootCause);
		}

		LOGGER.info("RegisterUserController :: registerUser :: End");
		return response;
	}

	@GetMapping("/user/validate/{data}")
	public ResponseEntity<?> validateUserBeforeRegister(@PathVariable("data") String data) {
		LOGGER.info("RegisterUserController :: validateUserBeforeRegister :: Start");

		ResponseEntity<?> response = null;
		try {
			Boolean isAvailable = registerUserService.validateUserBeforeRegister(data);
			response = ResponseEntity.ok().body(isAvailable);
		} catch (Exception e) {
			LOGGER.error("Error in RegisterUserController :: validateUserBeforeRegister : {}", e);
			String rootCause = ExceptionUtils.getRootCauseMessage(e);
			response = getResponse(LOGGER, e, rootCause);
		}

		LOGGER.info("RegisterUserController :: validateUserBeforeRegister :: End");
		return response;
	}

}
