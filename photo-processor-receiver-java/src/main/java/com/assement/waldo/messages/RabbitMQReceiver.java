package com.assement.waldo.messages;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assement.waldo.service.PhotoStatusProcessorService;


@Component
public class RabbitMQReceiver {
	
	@Autowired
	private PhotoStatusProcessorService photoStatusProcessorService;
	
	@RabbitListener(queues = "${rabbitmq.queuename}")
    public void receive(UUID in) {
		System.out.println("Received RabbitMQ msg = " + in);
		photoStatusProcessorService.processPhotoForId(in);
    }
}
