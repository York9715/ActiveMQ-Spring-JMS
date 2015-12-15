package com.javacodegeeks.spring.jms;

import java.util.Map;

import javax.jms.JMSException;

import org.springframework.jms.core.support.JmsGatewaySupport;

public class SpringJmsPersonConsumer extends JmsGatewaySupport {
	public Person receiveMessage() throws JMSException {
		Map map = (Map) getJmsTemplate().receiveAndConvert();
		Person person = new Person((String) map.get("name"), (Integer) map.get("age"));
		return person;	
	}
}
