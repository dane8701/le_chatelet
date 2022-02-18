package com.le_chatelet.le_chatelet_back.services;

import com.le_chatelet.le_chatelet_back.model.SmsRequest;
import com.le_chatelet.le_chatelet_back.model.SmsSenderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SenderService {
    private final SmsSenderInterface smsSender;

    @Autowired
    public SenderService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.smsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
