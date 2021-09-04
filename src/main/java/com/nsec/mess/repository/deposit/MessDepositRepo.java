package com.nsec.mess.repository.deposit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nsec.mess.models.MessDeposit;
import com.nsec.mess.models.User;
import com.nsec.mess.vo.MessDepositVO;

@Repository
public class MessDepositRepo implements IMessDepositRepo {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessDepositRepo.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<MessDepositVO> getAllDepositsByUsernameMonthYear(String username, Integer month, Integer year) {
		LOGGER.info("MessDepositRepo :: getAllDepositsByUsernameMonthYear :: Start");

		List<MessDepositVO> messDeposits = null;
		try {
			User user = entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.userDeposits ud "
					+ "where u.username=:username and ud.month=:month and ud.year=:year", User.class)
						.setParameter("username", username)
						.setParameter("month", month)
						.setParameter("year", year)
						.getSingleResult();
			System.out.println(user.getUserId());
			
			if (user.getUserDeposits().size() > 0) {
				messDeposits = new ArrayList<>();
				for(MessDeposit md : user.getUserDeposits()) {
					MessDepositVO depositVo = new MessDepositVO();
					depositVo.setDepositId(md.getDepositId());
					depositVo.setUserId(md.getPaidUser().getUserId());
					depositVo.setFullName(user.getFullName());
					depositVo.setMonth(md.getMonth());
					depositVo.setYear(md.getYear());
					depositVo.setDepositDate(md.getDepositDate());
					depositVo.setAmount(md.getAmount());
					depositVo.setPaymentByFullName(md.getPaymentBy().getFullName());
					depositVo.setReceivedByFullName(md.getReceivedBy().getFullName());
					depositVo.setPaymentMode(md.getPaymentMode());
					depositVo.setOutstanding(md.getOutstanding());
					depositVo.setComments(md.getComments());
					
					messDeposits.add(depositVo);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in MessDepositRepo :: getAllDepositsByUsernameMonthYear : {}", e.getMessage());
			throw e;
		}

		LOGGER.info("MessDepositRepo :: getAllDepositsByUsernameMonthYear :: Start");
		return messDeposits;
	}
}
