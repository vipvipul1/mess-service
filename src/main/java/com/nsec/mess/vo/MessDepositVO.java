package com.nsec.mess.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessDepositVO {
	
	private Integer depositId;
	private Integer userId;
	private String fullName;
	private Integer month;
	private Integer year;
	private Date depositDate;
	private Double amount;
	private String paymentByFullName;
	private String receivedByFullName;
	private String paymentMode;
	private Double outstanding;	
	private String comments;
	
}