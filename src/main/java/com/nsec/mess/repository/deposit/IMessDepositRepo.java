package com.nsec.mess.repository.deposit;

import java.util.List;

import com.nsec.mess.vo.MessDepositVO;

public interface IMessDepositRepo {

	List<MessDepositVO> getAllDepositsByUsernameMonthYear(String username, Integer month, Integer year);

	
}
