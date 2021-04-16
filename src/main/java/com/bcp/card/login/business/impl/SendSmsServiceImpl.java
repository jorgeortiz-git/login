package com.bcp.card.login.business.impl;

import com.bcp.card.login.business.SendSmsService;
import com.bcp.card.login.dao.TwilioRepository;
import com.bcp.card.login.model.api.AuthenticationForm;
import com.bcp.card.login.model.entity.TwilioAccout;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
public class SendSmsServiceImpl implements SendSmsService {

	@Autowired
	TwilioRepository twilioRepository;

	@Override
	public Mono<String> sendSms(AuthenticationForm authenticationForm) {
		
		String codigo = generateRandomCode();
		return twilioRepository.findById(1)
						.map(twilioAccout -> {
							Twilio.init(twilioAccout.getAccountSid(),
											twilioAccout.getAuthToken());
							String mensaje = "Su codigo de verificacion es: " + codigo;
							Message.creator(new PhoneNumber("+51" + authenticationForm.getPhoneNumber()),
											new PhoneNumber(twilioAccout.getPhoneNumber()), mensaje)
											.create();
							return codigo;
						});
	}

	private String generateRandomCode() {
		UUID uuid = UUID.randomUUID();
		String randomId = uuid.toString();
		return randomId.substring(randomId.length() - 6).toUpperCase();
	}

}
