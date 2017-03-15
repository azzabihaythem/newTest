package com.haythem.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.haythem.service.MesureService;

@Component
public class UdpListener {
	
	
	@Autowired
	private MesureService mesureService;
	
	
	@ServiceActivator
	public void handleUdp(Message<?> message) {
		System.out.println("*** UDP Message: " + message);
		String msg = new String( (byte[]) message.getPayload());
		System.out.println("*** UDP Message Payload: "
				+ msg);
		
		
		mesureService.saveMesureUdp(msg);
		
		
	}
	
	
	
	
}