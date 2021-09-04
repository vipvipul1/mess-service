package com.nsec.mess.service.deposit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsec.mess.repository.deposit.IMessDepositRepo;
import com.nsec.mess.vo.MessDepositVO;

@Service
public class MessDepositService implements IMessDepositService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessDepositService.class);
	
	@Autowired
	private IMessDepositRepo iMessDepositRepo;
	
	@Override
	public List<MessDepositVO> getAllDepositsByUsernameMonthYear(String username, Integer month, Integer year) {
		LOGGER.info("MessDepositController :: getAllDepositsByUsernameMonthYear :: Start");
		
		List<MessDepositVO> messDeposits = iMessDepositRepo.getAllDepositsByUsernameMonthYear(username, month, year);
		
		LOGGER.info("MessDepositController :: getAllDepositsByUsernameMonthYear :: Start");
		return messDeposits;
	}

}
