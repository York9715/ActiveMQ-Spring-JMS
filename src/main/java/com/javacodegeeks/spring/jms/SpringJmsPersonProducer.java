package com.javacodegeeks.spring.jms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jms.core.support.JmsGatewaySupport;

public class SpringJmsPersonProducer extends JmsGatewaySupport {
	public void sendMessage(final Person person) {
		System.out.println("Producer sends " + person);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", person.getName());
		map.put("age", person.getAge());
		getJmsTemplate().convertAndSend(map);	
	}
}
