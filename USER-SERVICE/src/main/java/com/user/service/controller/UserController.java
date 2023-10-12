package com.user.service.controller;

import com.user.service.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/user/*")
public class UserController {

    @PostMapping(value = "register")
    public String userRegister(@RequestParam(name = "file") MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();

        File dir = new File("/upload");

        if (!dir.exists())
            dir.mkdir();

        File newFile = new File(dir + File.separator + fileName);


        file.transferTo(newFile);


        String filePath = newFile.getPath();


        return filePath;
    }
}
