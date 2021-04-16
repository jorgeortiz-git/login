package com.bcp.card.login.business.impl;

import com.bcp.card.login.business.LoginService;
import com.bcp.card.login.dao.UserRepository;
import com.bcp.card.login.model.api.UserForm;
import com.bcp.card.login.model.api.UserResponse;
import com.bcp.card.login.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

  @Autowired
  UserRepository userRepository;

  @Override
  public Mono<UserResponse> userLogin(UserForm userForm) {
    return this.userRepository
            .findByUsernameAndPassword(userForm.getUsername(), userForm.getPassword())
            .map(this::usertoUserResponse);
  }

  private UserResponse usertoUserResponse(User user) {
    return UserResponse.builder()
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .build();
  }
}
