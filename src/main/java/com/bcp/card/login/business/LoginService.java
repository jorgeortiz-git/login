package com.bcp.card.login.business;

import com.bcp.card.login.model.api.UserForm;
import com.bcp.card.login.model.api.UserResponse;
import com.bcp.card.login.model.entity.User;
import reactor.core.publisher.Mono;

public interface LoginService {
  Mono<UserResponse> userLogin(UserForm userForm);
}
