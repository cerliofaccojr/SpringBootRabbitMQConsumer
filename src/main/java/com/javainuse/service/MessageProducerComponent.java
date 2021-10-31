package com.javainuse.service;

import com.javainuse.model.Entidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducerComponent {

	private JmsTemplate jmsTemplate;
	private JmsTemplate jmsTemplateTopic;

	@Autowired
	public MessageProducerComponent(JmsTemplate jmsTemplate, JmsTemplate jmsTemplateTopic) {
		this.jmsTemplate = jmsTemplate;
		this.jmsTemplateTopic = jmsTemplateTopic;
	}


	public void sendToTopic() {
		Entidade entidade = new Entidade();
		entidade.setId(1);
		entidade.setUser("cerlio");
		jmsTemplateTopic.convertAndSend("meu.topico", entidade);
	}

	public void sendToQueue() {
		Entidade entidade = new Entidade();
		entidade.setId(1);
		entidade.setUser("cerlio");
		jmsTemplate.convertAndSend("minha.fila", entidade, m -> {
			System.out.println( "setting standard JMS headers before sending");
			m.setStringProperty("jms-custom-header", "this is a custom jms property");
			m.setBooleanProperty("jms-custom-property", true);
			m.setDoubleProperty("jms-custom-property-price", 0.0);
			return m;
		});
	}

}
