package com.le_chatelet.le_chatelet_back.services;

import com.le_chatelet.le_chatelet_back.configurations.TwilioConfiguration;
import com.le_chatelet.le_chatelet_back.model.SmsRequest;
import com.le_chatelet.le_chatelet_back.model.SmsSenderInterface;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSenderInterface {
    private final TwilioConfiguration twilioConfiguration;
    private final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        PhoneNumber to = new PhoneNumber(smsRequest.getUser().getNumber());
        PhoneNumber from = new PhoneNumber(this.twilioConfiguration.getPhoneNumber());
        String messageToSend = smsRequest.getUser().getMessage();
        LOGGER.info("Your message :{} is ready to be sended", messageToSend);
        Message message = Message.creator(to, from,messageToSend).create();
        LOGGER.info("Send SMS {}", smsRequest);
    }

}
