package com.le_chatelet.le_chatelet_back.controller;

import com.le_chatelet.le_chatelet_back.model.SmsRequest;
import com.le_chatelet.le_chatelet_back.services.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/authentification/sms")
public class SmsController {
    private final SenderService senderService;

    @Autowired
    public SmsController(SenderService senderService) {
        this.senderService = senderService;
    }

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest){
        senderService.sendSms(smsRequest);
    }
}