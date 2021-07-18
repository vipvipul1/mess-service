package com.nsec.mess.service.auth;

import java.util.List;

import com.nsec.mess.vo.UserVo;

public interface IManageUsersService {

	List<UserVo> getAllUserDetails();

	Integer grantOrRevokeAccess(Integer userId, String action);

}
