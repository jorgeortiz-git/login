package com.bcp.card.login.dao;

import com.bcp.card.login.model.entity.User;
import com.bcp.card.login.model.entity.VerificationCode;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VerificationCodeRepository extends ReactiveCrudRepository<VerificationCode, Integer> {
}
