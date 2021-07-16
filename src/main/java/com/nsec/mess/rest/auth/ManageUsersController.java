package com.nsec.mess.rest.auth;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsec.mess.rest.util.BaseControllerMess;
import com.nsec.mess.service.auth.IManageUsersService;
import com.nsec.mess.vo.UserVo;

@RestController
@RequestMapping("/mess/manage")
public class ManageUsersController extends BaseControllerMess {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageUsersController.class);

	@Autowired
	private IManageUsersService manageUsersService;

	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUserDetails() {
		LOGGER.info("ManageUsersController :: getAllUserDetails :: Start");
		ResponseEntity<?> response = null;

		try {
			List<UserVo> userVoList = manageUsersService.getAllUserDetails();
			response = ResponseEntity.ok().body(userVoList);
		} catch (Exception e) {
			LOGGER.error("Error in ManageUsersController :: getAllUserDetails : {}", e);
			String rootCause = ExceptionUtils.getRootCauseMessage(e);
			response = getResponse(LOGGER, e, rootCause);
		}
		
		LOGGER.info("ManageUsersController :: getAllUserDetails :: End");
		return response;
	}
}
