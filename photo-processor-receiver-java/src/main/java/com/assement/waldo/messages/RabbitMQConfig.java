package com.assement.waldo.messages;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.queuename}")
	String queueName;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Profile("receiver")
	@Bean
	public RabbitMQReceiver receiver() {
		return new RabbitMQReceiver();
	}
}
