package com.le_chatelet.le_chatelet_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LeChateletBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeChateletBackApplication.class, args);
    }

}
