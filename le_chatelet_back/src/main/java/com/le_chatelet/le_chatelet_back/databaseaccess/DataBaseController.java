package com.le_chatelet.le_chatelet_back.databaseaccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/db")
public class DataBaseController {
    private final Logger logger = LoggerFactory.getLogger(DataBaseController.class);
    
    @Autowired
    private IpUserRepository ipRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping(path="/addIp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addIp(@RequestBody IpUser ipSent){
        IpUser ipUser = new IpUser();

        ipUser.setLogin(ipSent.getLogin());
        ipUser.setIp(ipSent.getIp());

        ipRepository.save(ipUser);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(ipUser.getLogin()+"@chatelet.com");
        message.setSubject("IP de connexion différente");
        message.setText("Une connexion à votre compte à été effectué via une adresse IP inhabituelle : "+ ipUser.getIp()+ ". " +
                "Ce n'est pas vous ? Adressez vous au plus vite à votre administrateur ou à votre manager !");

        javaMailSender.send(message);

        return "Email sent";
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<IpUser> getAllIp(){
        return ipRepository.findAll();
    }
}