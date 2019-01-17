package com.leena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leena.payload.UploadFileResponse;
import com.leena.service.FileStorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FileController {
	 
	 @Autowired
	 private FileStorageService fileStorageService;
	 
	 @PostMapping("/uploadFile")
	    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);

	        return new UploadFileResponse(fileName,file.getContentType(), file.getSize());//return response
	    }
}
