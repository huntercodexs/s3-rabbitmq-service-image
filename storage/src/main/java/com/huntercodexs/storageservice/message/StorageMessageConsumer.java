package com.huntercodexs.storageservice.message;

import com.huntercodexs.storageservice.dto.StorageRequestDto;
import com.huntercodexs.storageservice.services.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import static com.huntercodexs.storageservice.message.StorageInterfaceConsumer.CHANNEL_DATA_INPUT;

@Slf4j
@Component
public class StorageMessageConsumer {

	@Autowired
	StorageService storageService;
	
	@StreamListener(target = CHANNEL_DATA_INPUT)
	public void channelProcess(StorageRequestDto storageRequestDto) {
		log.info("Starting read channel " + CHANNEL_DATA_INPUT);
		log.info(storageRequestDto.getFilename());
		storageService.storageImageS3(storageRequestDto);
		log.info("Finishing read channel " + CHANNEL_DATA_INPUT);
	}
	
}
