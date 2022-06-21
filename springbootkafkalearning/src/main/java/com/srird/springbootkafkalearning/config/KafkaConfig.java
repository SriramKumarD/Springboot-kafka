package com.srird.springbootkafkalearning.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopic srirdTopics() {
		return TopicBuilder.name("srird").build();
		
	}
	
	@Bean
	public NewTopic srirdJsonTopics() {
		return TopicBuilder.name("srird_json").build();
		
	}

}
