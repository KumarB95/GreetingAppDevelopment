package com.bridgelabz.greetingappdevelopment.service;


import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;

public interface IGreatingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
}
