package com.bcp.card.login.business.impl;

import com.bcp.card.login.business.VerificationService;
import com.bcp.card.login.dao.VerificationCodeRepository;
import com.bcp.card.login.model.entity.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VerificationServiceImpl implements VerificationService {

  @Autowired
  VerificationCodeRepository verificationCodeRepository;

  @Override
  public Mono<String> saveCode(String code, Integer userId) {

    verificationCodeRepository.save(VerificationCode.builder().userId(userId).temporalCode(code).build());
    return null;
  }
}
