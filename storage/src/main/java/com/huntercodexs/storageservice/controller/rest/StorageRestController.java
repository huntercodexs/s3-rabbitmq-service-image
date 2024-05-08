package com.huntercodexs.storageservice.controller.rest;

import com.huntercodexs.storageservice.dto.ImageDataResponseDto;
import com.huntercodexs.storageservice.services.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StorageRestController {

	@Autowired
	StorageService storageService;

	@GetMapping(path = "${api.endpoint-read:/storage/api/rest/read}/{guid}")
	@ResponseBody
	public ResponseEntity<ImageDataResponseDto> read(@PathVariable String guid) {
        log.info("Request received to read image: {}", guid);
		return new ResponseEntity<>(storageService.readImageS3(guid), HttpStatus.OK);
	}

}
