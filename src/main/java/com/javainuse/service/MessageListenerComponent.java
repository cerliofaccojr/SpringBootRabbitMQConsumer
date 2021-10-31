package com.javainuse.service;

import com.javainuse.model.Entidade;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageListenerComponent {

	@JmsListener(destination = "minha.fila")
	public void onReceiverQueue(Message<Entidade> str, @Headers Map<String, Object> headers) {
		System.out.println( headers );
	}

	@JmsListener(destination = "meu.topico", containerFactory = "jmsFactoryTopic")
	public void onReceiverTopic(Entidade str) {
		System.out.println( str.getUser() );
	}

}
