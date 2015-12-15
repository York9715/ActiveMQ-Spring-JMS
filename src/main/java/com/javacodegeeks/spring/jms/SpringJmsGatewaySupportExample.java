package com.javacodegeeks.spring.jms;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsGatewaySupportExample {
	public static void main(String[] args) throws URISyntaxException, Exception {
		BrokerService broker = BrokerFactory.createBroker(new URI(
				"broker:(tcp://localhost:61616)"));
		broker.start();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		try {
			SpringJmsGatewayProducer springJmsProducer = (SpringJmsGatewayProducer) context
					.getBean("springJmsGatewayProducer");
			springJmsProducer.sendMessage("Hi");

			SpringJmsGatewayConsumer springJmsConsumer = (SpringJmsGatewayConsumer) context
					.getBean("springJmsGatewayConsumer");
			System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
		} finally {
			broker.stop();
			context.close();
		}
	}
}
