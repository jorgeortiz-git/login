package com.bcp.card.login.model.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;


@Data
@ToString
@Table("TWILIO_ACCOUNT")
public class TwilioAccout implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	@Column(value = "account_sid")
	private String accountSid;
	@Column(value = "auth_token")
	private String authToken;
	@Column(value = "phone_number")
	private String phoneNumber;
	
	
}
