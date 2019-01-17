package com.leena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.leena.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({//for enabling configuration properties
    FileStorageProperties.class
})
public class FileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}

}

