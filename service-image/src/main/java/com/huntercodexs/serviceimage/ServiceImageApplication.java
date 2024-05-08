package com.huntercodexs.serviceimage;

import com.huntercodexs.serviceimage.message.ServiceImageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({ServiceImageProducer.class})
public class ServiceImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceImageApplication.class, args);
	}
}
