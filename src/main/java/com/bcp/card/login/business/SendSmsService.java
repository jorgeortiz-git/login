package com.bcp.card.login.business;

import com.bcp.card.login.model.api.AuthenticationForm;
import reactor.core.publisher.Mono;

public interface SendSmsService {
	Mono<String> sendSms(AuthenticationForm authenticationForm);
}
