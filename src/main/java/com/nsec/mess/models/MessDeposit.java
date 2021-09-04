package com.nsec.mess.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MESS_DEPOSIT")
public class MessDeposit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPOSIT_ID")
	private Integer depositId;

	@ManyToOne
	@JoinColumn(name = "PAID_USER")
	private User paidUser;
	
	@Column(name = "MONTH")
	private Integer month;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "DEPOSIT_DATE")
	private Date depositDate;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "PAYMENT_BY")
	private User paymentBy;
	
	@ManyToOne
	@JoinColumn(name = "RECEIVED_BY")
	private User receivedBy;
	
	@Column(name = "PAYMENT_MODE")
	private String paymentMode;
	
	@Column(name = "OUTSTANDING")
	private Double outstanding;	
	
	@Column(name = "COMMENTS")
	private String comments;	
	
}
