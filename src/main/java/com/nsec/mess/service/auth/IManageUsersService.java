package com.nsec.mess.service.auth;

import java.util.List;

import com.nsec.mess.vo.UserVO;

public interface IManageUsersService {

	List<UserVO> getAllUserDetails();

	Integer grantOrRevokeAccess(Integer userId, String action);

}
