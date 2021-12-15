package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import com.bridgelabz.greetingappdevelopment.repository.IGreetingRepository;
import com.bridgelabz.greetingappdevelopment.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreeatingController {
    private static final String template = "Hello, %s!";
    private static final String template2 = "Hello, %s , %s!";
    private final AtomicLong counter = new AtomicLong();
//  UC1
    /*
     *curl localhost:8080/greeting
     @return={id =1 , content="hello world!}
     * curllocalhost:8080/greeting?name=Naval
     * @return= { id=2, content="hello Naval!
     */
    @GetMapping(value={"/greeting","/greeting/","/greeting/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    /*
    *curl localhost:8080/greeting/Naval
    @return={id =1 , content="hello Naval!}
     */
    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

//  UC2
    @Autowired
    IGreetingService greetingService;
////    /*
//       *curl localhost:8080/greeting/service
//       @return={id =1 , content="hello world!}
//    */
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();
    }
//  UC3
    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody UserDto userDto) {
        
        return greetingService.greetingMessageByName(userDto);
    }

//    public void save(User user){
//            IGreetingRepository.save(user);
//    }
    @GetMapping("/find")
    public User findGreetById(@RequestParam long id) {
    return greetingService.getById(id);
    }
}
