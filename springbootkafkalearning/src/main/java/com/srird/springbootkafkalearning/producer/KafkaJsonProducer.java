package com.srird.springbootkafkalearning.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.srird.springbootkafkalearning.payload.User;

@Service
public class KafkaJsonProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User user) {
		
		LOGGER.info(String.format("Sending the JSON message %s", user));
		
		Message<User> message = MessageBuilder.
				withPayload(user).
				setHeader(KafkaHeaders.TOPIC, "srird_json").
				build();
		
		kafkaTemplate.send(message);
	}
	
	
}
