package com.le_chatelet.le_chatelet_back.configurations;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {
    private final TwilioConfiguration twilioConfiguration;
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(twilioConfiguration.getTwilioAccountSid(), twilioConfiguration.getTwilioAuthToken());
        LOGGER.info("Twilio account sid {} has been initialized", twilioConfiguration.getTwilioAccountSid());
        LOGGER.info("Twilio number {}", twilioConfiguration.getPhoneNumber());
        LOGGER.info("Twilio auth token {}", twilioConfiguration.getTwilioAuthToken());
    }
}
