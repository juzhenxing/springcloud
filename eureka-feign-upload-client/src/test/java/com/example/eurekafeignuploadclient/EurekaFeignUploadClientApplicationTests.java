package com.example.eurekafeignuploadclient;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaFeignUploadClientApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UploadService uploadService;

	@Test
	@SneakyThrows
	public void testFileUpload() {
		File file = new File("d:/新建文本文档.txt");
		FileItem diskFileItem = new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE,  true, file.getName());
		try(InputStream inputStream = new FileInputStream(file);
			OutputStream outputStream = diskFileItem.getOutputStream();
		){
			IOUtils.copy(inputStream, outputStream);
		}catch (Exception e){
			throw new IllegalArgumentException("e: [{}]", e);
		}
		MultipartFile multipartFile = new CommonsMultipartFile(diskFileItem);
		log.info(uploadService.handleFileUpload(multipartFile));
	}

}
