package com.bcp.card.login.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@Table(value = "equipo4.VERIFICATION_CODE")
public class VerificationCode {
  @Id
  private Integer id;
  @Column(value = "user_id")
  private Integer userId;
  @Column(value = "temporal_code")
  private String temporalCode;

}
