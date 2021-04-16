package com.bcp.card.login.model.api;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserResponse {
  private Integer status;
  private String email;
  private String phoneNumber;

}
