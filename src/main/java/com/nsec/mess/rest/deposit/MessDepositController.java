package com.nsec.mess.rest.deposit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nsec.mess.rest.util.BaseControllerMess;
import com.nsec.mess.service.deposit.IMessDepositService;
import com.nsec.mess.vo.MessDepositVO;

@Controller
@RequestMapping("/mess/deposit")
public class MessDepositController extends BaseControllerMess {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessDepositController.class);

	@Autowired
	private IMessDepositService iMessDepositService;
	
	@GetMapping("/viewDeposit/{username}/{month}/{year}")
	public ResponseEntity<?> getAllDepositsByUsernameMonthYear(@PathVariable String username, @PathVariable Integer month,
			@PathVariable Integer year) {
		LOGGER.info("MessDepositController :: getAllDepositsByUsernameMonthYear :: Start");
		ResponseEntity<?> response = null;
		
		List<MessDepositVO> messDeposits = iMessDepositService.getAllDepositsByUsernameMonthYear(username, month, year);
		response = ResponseEntity.ok().body(messDeposits);
		
		LOGGER.info("MessDepositController :: getAllDepositsByUsernameMonthYear :: End");
		return response;
	}
}
