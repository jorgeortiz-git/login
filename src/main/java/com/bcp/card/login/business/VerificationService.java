package com.bcp.card.login.business;

import reactor.core.publisher.Mono;

public interface VerificationService {
  Mono<String> saveCode(String code, Integer userId);

}
