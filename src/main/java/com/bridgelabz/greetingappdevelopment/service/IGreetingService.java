package com.bridgelabz.greetingappdevelopment.service;


import com.bridgelabz.greetingappdevelopment.dto.UserDto;
import com.bridgelabz.greetingappdevelopment.model.Greeting;
import com.bridgelabz.greetingappdevelopment.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
    User getById(long id);
    List<User> getAllGreetingMessages();
    User updateGreetMessage(long id, UserDto userDto);
    String deleteGreetMessage(long id);
}
