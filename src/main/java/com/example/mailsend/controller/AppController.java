package com.example.mailsend.controller;

import com.example.mailsend.service.EmailService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class AppController {
    private EmailService emailService;

    public AppController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/apps")
    @CrossOrigin(origins = "http://localhost:3000")
    public AppDataResp getApps() {

        var c1 = new AppDataResp.ConsumerData("chetan");
        var c2 = new AppDataResp.ConsumerData("ankit");
        var c3 = new AppDataResp.ConsumerData("vishal");
        var c4 = new AppDataResp.ConsumerData("snehith");
        var data = new AppDataResp.Data("INCS", List.of(c1, c2, c3, c4));
        return new AppDataResp(data);
    }

}

record AppDataResp(Data data) {

    record Data(String appName, List<ConsumerData> consumers) {}

    record ConsumerData(String name) {}

}
