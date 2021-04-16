package com.bcp.card.login.expose.web;

import com.bcp.card.login.business.LoginService;
import com.bcp.card.login.model.api.UserForm;
import com.bcp.card.login.model.api.UserResponse;
import com.bcp.card.login.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("login")
public class LoginController {

  @Autowired
  LoginService loginService;

  @PostMapping
  public Mono<UserResponse> login(@RequestBody UserForm userFormMono){
    return loginService.userLogin(userFormMono);
  }


}
