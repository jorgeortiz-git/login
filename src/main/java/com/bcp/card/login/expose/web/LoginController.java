package com.bcp.card.login.expose.web;

import com.bcp.card.login.business.LoginService;
import com.bcp.card.login.business.SendSmsService;
import com.bcp.card.login.business.VerificationService;
import com.bcp.card.login.model.api.AuthenticationForm;
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

  @Autowired
  SendSmsService sendSmsService;

  @Autowired
  VerificationService verificationService;

  @PostMapping
  public Mono<UserResponse> login(@RequestBody UserForm userFormMono){
    return loginService.userLogin(userFormMono);
  }

  @PostMapping("/sendMessage")
  public void sendMessage(@RequestBody AuthenticationForm authenticationForm){

    sendSmsService.sendSms(authenticationForm)
            .map(s -> verificationService.saveCode(s, authenticationForm.getId()));
    //return
            //sendSmsService.sendSms(authenticationForm);
  }


}
