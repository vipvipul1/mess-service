package com.nsec.mess.rest.auth;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsec.mess.rest.util.BaseControllerMess;
import com.nsec.mess.service.auth.ILoginUserService;
import com.nsec.mess.vo.UserVo;

@RestController
@RequestMapping("/mess/login")
public class LoginUserController extends BaseControllerMess {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserController.class);
	
	@Autowired
	private ILoginUserService loginUserService;

	@PostMapping("/user")
	public ResponseEntity<?> validateUserLogin(@RequestBody UserVo userVo) {
		LOGGER.info("LoginUserController :: validateUserLogin :: Start");
		ResponseEntity<?> response = null;
		
		try {
			Boolean isUserValid = loginUserService.validateUserLogin(userVo.getUsername(), userVo.getPassword());
			response = ResponseEntity.ok().body(isUserValid);
		} catch(Exception e) {
			LOGGER.error("Error in LoginUserController :: validateUserLogin : {}", e);
			String rootCause = ExceptionUtils.getRootCauseMessage(e);
			response = getResponse(LOGGER, e, rootCause);
		}
		
		LOGGER.info("LoginUserController :: validateUserLogin :: Start");
		return response;
	}
	
}
