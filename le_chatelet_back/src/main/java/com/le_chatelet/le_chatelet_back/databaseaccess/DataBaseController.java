package com.le_chatelet.le_chatelet_back.databaseaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@Controller
@RequestMapping(path="/db")
public class DataBaseController {
    @Autowired
    private IpUserRepository ipRepository;

    @PostMapping(path="/addIp")
    public @ResponseBody String addIp(@RequestParam String login, @RequestParam String ip){
        IpUser ipUser = new IpUser();

        ipUser.setLogin(login);
        ipUser.setIp(ip);

        ipRepository.save(ipUser);

        return "Ip Saved";
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<IpUser> getAllIp(){
        return ipRepository.findAll();
    }

}
