package com.huntercodexs.serviceimage.service;

import com.huntercodexs.serviceimage.dto.ServiceImageRequestDto;
import com.huntercodexs.serviceimage.dto.ServiceImageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceImage {

	@Autowired
	ServiceImageStorage serviceImageStorage;

	public ServiceImageResponseDto addImageService(ServiceImageRequestDto serviceImageRequestDto) {

		log.info("imageAddService is running");

		String guid = addImage(serviceImageRequestDto);

        log.info("image added: {}", guid);

		return ServiceImageResponseDto.builder().guid(guid).build();
	}

	private String addImage(ServiceImageRequestDto serviceImageRequestDto) {
		try {
			return serviceImageStorage.save(serviceImageRequestDto);
		} catch (RuntimeException re) {
			return null;
		}
	}
}
