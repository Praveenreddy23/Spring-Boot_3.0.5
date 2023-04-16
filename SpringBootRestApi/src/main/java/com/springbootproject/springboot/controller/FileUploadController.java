package com.springbootproject.springboot.controller;

import com.springbootproject.springboot.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;


    @PostMapping("/upload")
    public ResponseEntity<String> fileUpload(@RequestParam("file")MultipartFile file){

      /*  System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getName());
        System.out.println(file.getContentType());*/

//        Validation
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request Must Contain File");
            }

            if (!Objects.equals(file.getContentType(), "image/jpeg/png")) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only JPEG content type are allowed");
            }
//        file upload code
           boolean b= fileUploadHelper.uploadFile(file);
            if (b){
                return ResponseEntity.ok("File Upload Successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try Again");
    }
}
