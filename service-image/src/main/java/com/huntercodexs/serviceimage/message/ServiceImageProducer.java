package com.huntercodexs.serviceimage.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ServiceImageProducer {

	@Output("ServiceImageChannel")
	MessageChannel saveImage();

}
