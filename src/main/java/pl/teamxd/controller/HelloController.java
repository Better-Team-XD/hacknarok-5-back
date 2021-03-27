package pl.teamxd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String getHello(){
        return "Hello World!";
    }

    @GetMapping
    @RequestMapping("/private")
    public String getPrivate(){
        return "Private";
    }
}
