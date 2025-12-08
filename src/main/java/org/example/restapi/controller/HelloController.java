package org.example.restapi.controller;

import java.util.List;
import org.example.restapi.dto.MessageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // => 데이터를 반환
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World";
    }

    //@GetMapping("/api/message")
    //public MessageResponse message() {
     //   return new MessageResponse("hello", 200);
   // }

    @GetMapping("/api/message")
    public List<MessageResponse> messages() {
        return List.of(
            new MessageResponse("hello1", 200),
            new MessageResponse("hello2", 200),
            new MessageResponse("hello3", 200)
        );
    }
}
