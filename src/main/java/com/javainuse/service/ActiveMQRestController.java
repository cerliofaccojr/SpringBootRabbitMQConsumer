package com.javainuse.service;

import com.javainuse.GcpConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveMQRestController {

	@Autowired
	private MessageProducerComponent messageProducerComponent;

	@Autowired
	private GcpConfiguration.PubsubOutboundGateway messagingGateway;


	@GetMapping("/fila")
	public void sendQueue() {
		messageProducerComponent.sendToQueue();
	}

	@GetMapping("/topico")
	public void sendTopic() {
		messageProducerComponent.sendToTopic();
	}

	@GetMapping("/teste")
	public String testeString() {
		return "Ma oi Ma oi";
	}
	
	@GetMapping("/loaderio-b00d107bf5d22f161ea99f9228f3016b")
	public String testeString() {
		return "loaderio-b00d107bf5d22f161ea99f9228f3016b";
	}
	
	




}
