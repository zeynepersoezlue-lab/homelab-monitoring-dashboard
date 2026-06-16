package de.zeynep.homelab.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{

    @GetMapping("/home")

    public String home(){
        String ausgabe = "Home Lab Monitoring Dashboard läuft";
        return ausgabe;
    }
}