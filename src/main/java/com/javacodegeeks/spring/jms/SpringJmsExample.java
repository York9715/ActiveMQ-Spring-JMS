package com.javacodegeeks.spring.jms;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsExample {
	public static void main(String[] args) throws URISyntaxException, Exception {
		BrokerService broker = BrokerFactory.createBroker(new URI(
				"broker:(tcp://localhost:61616)"));
		broker.start();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		try {
			SpringJmsProducer springJmsProducer = (SpringJmsProducer) context.getBean("springJmsProducer");

			SpringJmsPersonProducer springJmsPersonProducer =(SpringJmsPersonProducer) context.getBean("springJmsPersonProducer");
			SpringJmsPersonConsumer springJmsPersonConsumer =(SpringJmsPersonConsumer) context.getBean("springJmsPersonConsumer");
			
			Person person = new Person("york",12);
			springJmsPersonProducer.sendMessage(person);

			System.out.println("Consumer Person" );
			Person p=springJmsPersonConsumer.receiveMessage();
			System.out.println("Consumer receives: " + p.toString());
		
		} finally {
			broker.stop();
			context.close();
		}
	}
}
