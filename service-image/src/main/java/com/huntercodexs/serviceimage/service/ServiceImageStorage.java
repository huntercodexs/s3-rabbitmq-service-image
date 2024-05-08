package com.huntercodexs.serviceimage.service;

import com.huntercodexs.serviceimage.dto.ServiceImageRequestDto;
import com.huntercodexs.serviceimage.message.ServiceImageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class ServiceImageStorage {

    @Autowired
    ServiceImageProducer serviceImageProducer;

    public String save(ServiceImageRequestDto serviceImageRequestDto) {

        log.info("ServiceImageStorage is running");

        String guidId = UUID.randomUUID().toString();
        String imageFilename = guidId+".jpg";
        serviceImageRequestDto.setFilename(imageFilename);

        log.info("ImageFilename to save {}", imageFilename);

        serviceImageProducer.saveImage().send(MessageBuilder.withPayload(serviceImageRequestDto).build());

        return guidId;
    }

}
