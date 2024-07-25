package com.myspringboot.springbootfirst.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myspringboot.springbootfirst.helpers.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploader;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file) {
        if (file.isEmpty() || !file.getContentType().equals("image/jpeg")) {
            return ResponseEntity.badRequest().body("Invalid file: must be a non-empty JPEG image");
        }

        try {
            boolean uploadSuccess = fileUploader.getUploadImage(file);
            if (uploadSuccess) {
                return ResponseEntity.ok().body("File uploaded successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading file: " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again later");
    }
}