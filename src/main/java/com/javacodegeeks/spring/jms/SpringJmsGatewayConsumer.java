package com.javacodegeeks.spring.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.support.JmsGatewaySupport;

public class SpringJmsGatewayConsumer extends JmsGatewaySupport {
	public String receiveMessage() throws JMSException {
		TextMessage textMessage = (TextMessage) getJmsTemplate().receive();		
		return textMessage.getText();		
	}
}
