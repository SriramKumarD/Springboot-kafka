package com.srird.springbootkafkalearning.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.srird.springbootkafkalearning.payload.User;

@Service
public class JsonKafkaConsumer {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "srird_json", groupId="myGroup")
	public void consume(User user) {
		
		LOGGER.info(String.format("Subscribing the Json from Topic %s", user.toString()));
	}
}
