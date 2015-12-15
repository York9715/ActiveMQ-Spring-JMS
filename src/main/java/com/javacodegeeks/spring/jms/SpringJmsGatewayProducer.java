package com.javacodegeeks.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

public class SpringJmsGatewayProducer extends JmsGatewaySupport {
	public void sendMessage(final String msg) {
		System.out.println("Producer sends " + msg);
		getJmsTemplate().send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}});		
	}
}
