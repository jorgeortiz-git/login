package com.bcp.card.login.business.impl;

import com.bcp.card.login.business.SendSmsService;
import com.bcp.card.login.dao.TwilioRepository;
import com.bcp.card.login.model.entity.TwilioAccout;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendSmsServiceImpl implements SendSmsService {

	@Autowired
	TwilioRepository twilioRepository;

	@Override
	public void enviarSms(String codigo, String numeroTelefono) {
		TwilioAccout twilio = twilioRepository.findAll().blockFirst();
		
		String ACCOUNT_SID = twilio.getAccountSid();
		String AUTH_TOKEN = twilio.getAuthToken();
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		String mensaje = "Su codigo de verificacion es: " + codigo;
		Message message = Message.creator(new PhoneNumber("+51" + numeroTelefono), new PhoneNumber(twilio.getPhoneNumber()), mensaje).create();
	}

}
