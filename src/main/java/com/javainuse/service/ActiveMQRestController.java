package com.javainuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveMQRestController {

	@Autowired
	private MessageProducerComponent messageProducerComponent;

	@GetMapping("/fila")
	public void sendQueue() {
		messageProducerComponent.sendToQueue();
	}

	@GetMapping("/topico")
	public void sendTopic() {
		messageProducerComponent.sendToTopic();
	}
}