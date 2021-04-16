package com.bcp.card.login.business;

public interface SendSmsService {
	void enviarSms(String codigo, String numeroTelefono);
}
