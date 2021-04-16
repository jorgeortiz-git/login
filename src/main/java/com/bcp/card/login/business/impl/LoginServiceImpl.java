package com.bcp.card.login.business.impl;

import com.bcp.card.login.business.LoginService;
import com.bcp.card.login.business.SendSmsService;
import com.bcp.card.login.dao.UserRepository;
import com.bcp.card.login.model.api.UserForm;
import com.bcp.card.login.model.api.UserResponse;
import com.bcp.card.login.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  SendSmsService sendSmsService;

  @Override
  public Mono<UserResponse> userLogin(UserForm userForm) {
    return this.userRepository
            .findByUsernameAndPassword(userForm.getUsername(), userForm.getPassword())
            .map(this::responseUserOk)
            .switchIfEmpty(responseUserDenied());
  }

  private UserResponse responseUserOk(User user) {
    return UserResponse.builder()
            .status(200)
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .build();
  }

  private Mono<UserResponse> responseUserDenied() {
    Mono<UserResponse> userResponseMono = Mono.just(UserResponse.builder()
            .status(500)
            .build());
    return userResponseMono;
  }

}
