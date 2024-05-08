package com.huntercodexs.serviceimage.service;

import com.huntercodexs.serviceimage.dto.ImageDataDto;
import com.huntercodexs.serviceimage.dto.ServiceImageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceImage {

	@Autowired
	ServiceImageStorage serviceImageStorage;

	public ServiceImageResponseDto addImageService(ImageDataDto imageDataDto) {

		log.info("imageAddService is running");

		String guid = addImage(imageDataDto);

        log.info("image added: {}", guid);

		return ServiceImageResponseDto.builder().guid(guid).build();
	}

	private String addImage(ImageDataDto imageDataDto) {
		try {
			return serviceImageStorage.save(imageDataDto);
		} catch (RuntimeException re) {
			return null;
		}
	}
}
