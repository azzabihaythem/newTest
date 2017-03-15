package com.haythem.integration;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class TcpListener {
	@ServiceActivator
	public void handleTcp(Message<?> message) {
		System.out.println("*** TCP Message: " + message);
		System.out.println("*** TCP Message Payload: "
				+ new String((byte[]) message.getPayload()));
	}
}