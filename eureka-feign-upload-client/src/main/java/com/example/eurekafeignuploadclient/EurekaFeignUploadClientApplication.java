package com.example.eurekafeignuploadclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class EurekaFeignUploadClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignUploadClientApplication.class, args);
	}

}
