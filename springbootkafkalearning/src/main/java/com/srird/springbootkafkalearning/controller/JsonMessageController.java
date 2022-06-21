package com.srird.springbootkafkalearning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srird.springbootkafkalearning.payload.User;
import com.srird.springbootkafkalearning.producer.KafkaJsonProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	
	private KafkaJsonProducer kafkaJsonProducer;
	
	
	
	public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
		super();
		this.kafkaJsonProducer = kafkaJsonProducer;
	}



	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user) {
		
		kafkaJsonProducer.sendMessage(user);
		
		return ResponseEntity.ok("Json Message sent to the Topic");
		
	}

}
