package com.le_chatelet.le_chatelet_back.databaseaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@Controller
@RequestMapping(path="/db")
public class DataBaseController {
    @Autowired
    private IpUserRepository ipRepository;

    @PostMapping(path="/addIp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addIp(@RequestBody IpUser ipUser){

        ipRepository.save(ipUser);

        return "Ip Saved";
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<IpUser> getAllIp(){
        return ipRepository.findAll();
    }

}
