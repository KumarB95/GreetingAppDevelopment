package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;

    @Service
    public class GreetingService implements IGreatingService{
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

        @Override
        public String greetingMessageByName(UserDto userDto) {
            User user = new User();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(userDto, user);
            return ("Hello " + user.getFirstName() + " " + user.getLastName());
        }
}
