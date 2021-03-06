package com.example.springbootchat.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootChatApplication.class, args);
    }

    @Controller
    public static class MainController {
        @GetMapping("/")
        public String main() {
            return "redirect:/chat/room";
        }
    }
}