package com.huntercodexs.storageservice.services;

import com.huntercodexs.storageservice.dto.StorageRequestDto;
import com.huntercodexs.storageservice.dto.StorageResponseDto;
import com.huntercodexs.storageservice.repository.S3ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageService {

	@Autowired
	S3ImageRepository s3ImageRepository;

	public void storageImageS3(StorageRequestDto storageRequestDto) {
		try {
			s3ImageRepository.save(storageRequestDto);
			log.info("Image saved success");
		} catch (RuntimeException re) {
			log.error("Error on try saving image");
			log.error(re.getMessage());
		}
	}

	public StorageResponseDto readImageS3(String guid) {
        log.info("readImageS3 is running {}", guid);
		StorageResponseDto storageResponseDto = new StorageResponseDto();
		String reader = s3ImageRepository.read(guid);
		log.info("readImageS3 is OK {}", guid);
		storageResponseDto.setFile(reader);
		return storageResponseDto;
	}
}
