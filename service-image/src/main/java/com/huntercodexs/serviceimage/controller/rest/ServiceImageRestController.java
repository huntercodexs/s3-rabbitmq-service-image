package com.huntercodexs.serviceimage.controller.rest;

import com.huntercodexs.serviceimage.dto.ServiceImageRequestDto;
import com.huntercodexs.serviceimage.dto.ServiceImageResponseDto;
import com.huntercodexs.serviceimage.service.ServiceImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ServiceImageRestController {

	@Autowired
	ServiceImage serviceImage;

	@PostMapping(path = "${api.endpoint-add:/service-image/api/rest/add}")
	@ResponseBody
	public ResponseEntity<ServiceImageResponseDto> add(@RequestBody ServiceImageRequestDto serviceImageRequestDto) {
		log.info("Request received to add image");
		return new ResponseEntity<>(serviceImage.addImageService(serviceImageRequestDto), HttpStatus.ACCEPTED);
	}

}
