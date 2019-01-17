package com.leena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import com.leena.payload.UploadFileResponse;
import com.leena.property.FileStorageProperties;
import com.leena.service.FileStorageService;


@RestController
public class FileController {
	
	//Read File Content
    String content;
    String ReadPath=".uploads/";
    File file1;
    
	 @Autowired
	 private FileStorageService fileStorageService;
	 
	 @Autowired
	 FileStorageProperties fileStorageProperties;
	 
	 @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) 
	{
		 
        String fileName = fileStorageService.storeFile(file);

		try
		{
			file1 = ResourceUtils.getFile(fileStorageProperties.getUploadDir()+"/"+fileName);
			
			//File is found
	        System.out.println("File Found : " + file1.exists());
	        
			content = new String(Files.readAllBytes(file1.toPath()));
			
			System.out.println(content);
		}
		catch(FileNotFoundException e1)
		{
			System.out.println("file not found");
			e1.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
       
        return new UploadFileResponse(fileName,file.getContentType(), file.getSize());//return response
    }
}
