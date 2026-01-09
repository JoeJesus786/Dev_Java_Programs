package com.hackerrank.files;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RequestController {
    public static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/uploader")
    public ResponseEntity<Void> uploader(@RequestParam("fileName") String fileName, @RequestParam("file") MultipartFile file) {



try {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File destinationFile = new File(UPLOAD_DIR + fileName);
        if (destinationFile.exists()) {
            destinationFile.delete(); // allow overwrite
        }

        file.transferTo(destinationFile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }



    }

    @GetMapping("/downloader")
    public ResponseEntity downloader(@RequestParam String fileName) {
        return null;
    }
}
