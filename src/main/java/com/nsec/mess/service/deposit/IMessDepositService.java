package com.nsec.mess.service.deposit;

import java.util.List;

import com.nsec.mess.vo.MessDepositVO;

public interface IMessDepositService {

	List<MessDepositVO> getAllDepositsByUsernameMonthYear(String username, Integer month, Integer year);

}
