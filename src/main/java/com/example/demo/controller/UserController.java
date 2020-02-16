package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.utils.Constants;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by ashish on 13/5/17.
 */
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(Constants.GET_USER_BY_ID)
	public UserDto getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping(Constants.GET_ALL_USERS)
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value= Constants.SAVE_USER, method= RequestMethod.POST)
	public void saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
	}
	
	@RequestMapping(Constants.GET_USER_SCORE_ID)
	@GetMapping(value = "/getUser/score/{userName}")
	public JsonNode getUserScoreId(@PathVariable String userName) {
		return userService.getUserScoreById(userName);
	}

	@RequestMapping(Constants.GET_SKILLS_PER_USER)
	@GetMapping(value = "/getUser/skills/{userName}")
	public JsonNode getUserSkills(@PathVariable String userName) {
		return userService.getUserSkills(userName);
	}

	@RequestMapping(Constants.GET_PROFIL_MATCH_SCORE)
	@GetMapping(value = "/getUser/profile_match_score/{jd}/{userName}")
	public JsonNode getProfileMatchScore(@PathVariable("jd") String jd, @PathVariable("userName") String userName) {
		System.out.println("0000000000");
		return userService.getScore(jd, userName);
	}


}
