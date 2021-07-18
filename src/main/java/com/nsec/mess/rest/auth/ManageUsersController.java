package com.nsec.mess.rest.auth;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsec.mess.exception.AppException;
import com.nsec.mess.rest.util.BaseControllerMess;
import com.nsec.mess.service.auth.IManageUsersService;
import com.nsec.mess.vo.UserVo;

@RestController
@RequestMapping("/mess/manage")
public class ManageUsersController extends BaseControllerMess {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageUsersController.class);

	@Autowired
	private IManageUsersService manageUsersService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUserDetails() {
		LOGGER.info("ManageUsersController :: getAllUserDetails :: Start");
		ResponseEntity<?> response = null;

		try {
			List<UserVo> userVoList = manageUsersService.getAllUserDetails();
			response = ResponseEntity.ok().body(userVoList);
		} catch (Exception e) {
			LOGGER.error("Error in ManageUsersController :: getAllUserDetails : {}", e);
			String rootCause = ExceptionUtils.getRootCauseMessage(e);
			response = getResponse(e, rootCause, LOGGER);
		}

		LOGGER.info("ManageUsersController :: getAllUserDetails :: End");
		return response;
	}

	@PutMapping("/access/{action}")
	public ResponseEntity<?> grantOrRevokeAccess(@PathVariable("action") String action, @RequestBody UserVo userVo) {
		LOGGER.info("ManageUsersController :: grantOrRevokeAccess :: Start");
		ResponseEntity<?> response = null;

		try {
			Integer rowsUpdated = manageUsersService.grantOrRevokeAccess(userVo.getUserId(), action);
			if (rowsUpdated > 0)
				response = ResponseEntity.ok().body(true);
			else if (rowsUpdated == 0)
				response = ResponseEntity.ok().body(false);
			else
				throw new AppException("Invalid Request Parameters!");
		} catch (AppException e) {
			LOGGER.error("Error in ManageUsersController :: grantOrRevokeAccess : {}", e);
			String rootCause = ExceptionUtils.getRootCauseMessage(e);
			response = getResponse(HttpStatus.BAD_REQUEST, e, rootCause, LOGGER);
		} catch (Exception e) {
			LOGGER.error("Error in ManageUsersController :: grantOrRevokeAccess : {}", e);
			String rootCause = ExceptionUtils.getRootCauseMessage(e);
			response = getResponse(e, rootCause, LOGGER);
		}

		LOGGER.info("ManageUsersController :: grantOrRevokeAccess :: End");
		return response;
	}
}
