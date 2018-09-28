package com.example.eurekafeignuploadserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class EurekaFeignUploadServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignUploadServerApplication.class, args);
	}

	@RestController
	public class UploadController {

		@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
			return file.getName();
		}

	}
}
