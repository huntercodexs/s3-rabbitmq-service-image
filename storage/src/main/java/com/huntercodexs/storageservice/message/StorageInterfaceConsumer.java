package com.huntercodexs.storageservice.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface StorageInterfaceConsumer {

	String CHANNEL_DATA_INPUT = "StorageServiceSaveImageChannel";
	@Input("StorageServiceSaveImageChannel")
	SubscribableChannel readImage();
	
}
