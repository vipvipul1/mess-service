package com.nsec.mess.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsec.mess.models.User;
import com.nsec.mess.repository.auth.IManageUsersRepo;
import com.nsec.mess.vo.UserVo;

@Service
public class ManageUsersService implements IManageUsersService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageUsersService.class);

	@Autowired
	private IManageUsersRepo manageUsersRepo;
	
	public List<UserVo> getAllUserDetails() {
		LOGGER.info("ManageUsersService :: getAllUserDetails :: Start");
		
		List<UserVo> userVoList = new ArrayList<>();
		try {
			List<User> userList = manageUsersRepo.getAllUserDetails();
			for (User user: userList) {
				UserVo userVo = new UserVo();
				BeanUtils.copyProperties(user, userVo);
				userVoList.add(userVo);
			}
		} catch (Exception e) {
			LOGGER.error("Error in ManageUsersService :: getAllUserDetails : {}", e.getMessage());
			throw e;
		}
		
		LOGGER.info("ManageUsersService :: getAllUserDetails :: End");
		return userVoList;
	}

}
