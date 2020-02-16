package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ashish on 13/5/17.
 */
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto getUserById(Integer userId) {
		return UserConverter.entityToDto(userRepository.getOne(userId));
	}

	@Override
	public void saveUser(UserDto userDto) {
		userRepository.save(UserConverter.dtoToEntity(userDto));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
	}
	
	public JsonNode getUserScoreById(String userId) {
		ObjectMapper objectMapper = new ObjectMapper();
		File from = new File(System.getProperty("user.dir") + "/restApiResponses/getScore.json");
		JsonNode jsonNode = null;

		try {
			jsonNode = objectMapper.readTree(from);
			System.out.println(jsonNode.path(userId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonNode.path(userId);
	}

	public JsonNode getUserSkills(String userId) {
		ObjectMapper objectMapper = new ObjectMapper();
		File from = new File(System.getProperty("user.dir") + "/restApiResponses/getSkills.json");
		JsonNode jsonNode = null;

		try {
			jsonNode = objectMapper.readTree(from);

			System.out.println(jsonNode.path(userId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonNode.path(userId);
	}

	public JsonNode getScore(String jd, String userId) {
		ObjectMapper objectMapper = new ObjectMapper();
		File from = new File(System.getProperty("user.dir") + "/restApiResponses/getProfileMatch.json");
		JsonNode jsonNode = null;

		try {
			jsonNode = objectMapper.readTree(from);

			System.out.println(jsonNode.path(userId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonNode.path(userId);
	}
}


