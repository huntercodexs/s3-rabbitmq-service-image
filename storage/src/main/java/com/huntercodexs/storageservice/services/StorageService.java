package com.huntercodexs.storageservice.services;

import com.huntercodexs.storageservice.dto.ImageDataDto;
import com.huntercodexs.storageservice.dto.ImageDataResponseDto;
import com.huntercodexs.storageservice.repository.S3ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class StorageService {

	@Autowired
	S3ImageRepository s3ImageRepository;

	public void storageImageS3(ImageDataDto imageDataDto) {
		try {
			s3ImageRepository.save(imageDataDto);
			log.info("Image saved success");
		} catch (RuntimeException re) {
			log.error("Error on try saving image");
			log.error(re.getMessage());
		}
	}

	public ImageDataResponseDto readImageS3(String guid) {
        log.info("readImageS3 is running {}", guid);
		ImageDataResponseDto imageDataResponseDto = new ImageDataResponseDto();
		String reader = s3ImageRepository.read(guid);
		log.info("readImageS3 is OK {}", guid);
		imageDataResponseDto.setFile(reader);
		return imageDataResponseDto;
	}
}
