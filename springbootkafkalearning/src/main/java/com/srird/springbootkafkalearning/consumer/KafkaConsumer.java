package com.srird.springbootkafkalearning.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	
	@KafkaListener(topics = "srird", groupId = "myGroup")
	public void consume(String message) {
		LOGGER.info(String.format("Subscribing the message :%s", message));
	}
	
	@KafkaListener(topics = "manjupas", groupId = "myGroup")
	public void consume2(String message) {
		LOGGER.info(String.format("Subscribing the message2 :%s", message));
	}
	
}
