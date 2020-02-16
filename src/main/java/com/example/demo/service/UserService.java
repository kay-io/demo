package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.databind.JsonNode;


public interface UserService {
    UserDto getUserById(Integer userId);
    void saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
	JsonNode getUserScoreById(String userName);
}
