package com.bcp.card.login.model.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table(value = "equipo4.USUARIO")
public class User {
  @Id
  private Integer id;
  private String username;
  private String password;
  private String email;
  private String phoneNumber;

}
