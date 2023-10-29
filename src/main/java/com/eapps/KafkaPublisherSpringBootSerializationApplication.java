package com.eapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eapps.spring.kafka.api.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherSpringBootSerializationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherSpringBootSerializationApplication.class, args);
	}

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "eapps-topic";

	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		template.send(topic, "Hi " + name + " Welcome to kafka eapps");
		System.out.println("Published data {}: "+name);
		return "Data published";
	}

	@GetMapping("/publishJson")
	public String publishMessage() {
		User user = new User(312, "rtls-net", new String[] { "HYD", "KON", "PLOT 34" });
		template.send(topic, user);
		System.out.println("Published data {}: "+user);
		return "Json Data published";
	}

}
