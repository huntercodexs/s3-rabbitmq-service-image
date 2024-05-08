package com.huntercodexs.storageservice.repository;

import com.huntercodexs.storageservice.dto.ImageDataDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@Service
public class S3ImageRepository {

	@Value("${bucket.name}")
	String bucketName;

	@Autowired
	ResourceLoader resourceLoader;

	public void save(ImageDataDto imageDataDto) {

		log.info("Starting save in S3");

		String path = "s3://"+bucketName+"/"+imageDataDto.getFilename();

		log.info("S3 path: " + imageDataDto.getFilename());

		Resource resource = resourceLoader.getResource(path);

        WritableResource writableResource = (WritableResource) resource;

        try (OutputStream outputStream = writableResource.getOutputStream()) {

            outputStream.write(imageDataDto.getData());

			log.info("Image saved successfully in the S3");

        } catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public String read(String guidId) {

		String path = "s3://"+bucketName+"/"+guidId+".jpg";

        log.info("Reading image from S3: {}", path);

		Resource resource = resourceLoader.getResource(path);

		try {

			InputStream inputStream = resource.getInputStream();
			return new String(Base64.getEncoder().encode(IOUtils.toByteArray(inputStream)), StandardCharsets.UTF_8);

		} catch (IOException e) {
			return null;
		}
	}
}
