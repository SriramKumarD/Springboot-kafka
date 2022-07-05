package com.srird.springbootkafkalearning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srird.springbootkafkalearning.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
	

	private KafkaProducer kafkaProducer;

	public KafkaController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	//http:localhost:8080/api/v1/kafka/publish/hell world
	@GetMapping("/publish")
	public ResponseEntity<String> publishMessage(@RequestParam ("message") String message) {
		
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the Topic");
	}
	
	@GetMapping("/publish2")
	public ResponseEntity<String> publishMessage1(@RequestParam ("message2") String message) {
		
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the Topic");
	}
	
	
	
}
