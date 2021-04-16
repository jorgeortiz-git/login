package com.bcp.card.login.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthenticationForm {
  private String phoneNumber;
  private Integer id;
}
