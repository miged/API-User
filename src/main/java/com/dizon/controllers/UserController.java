package com.dizon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dizon.models.User;
import com.dizon.models.UserUpdate;
import com.dizon.services.UserService;
import com.dizon.services.UserUpdateService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserUpdateService userUpdateService;

	// user/123
	@GetMapping("/user/{id}")
	public int getUserId(@PathVariable(value = "id") int id) {
		return 1;
	}

	// user?id=123
	@GetMapping("/user")
	public User getUser(@RequestParam("id") int id) {
		User usr = userService.getUser(id);
		return usr;
	}

	// userUpdate/123
	@GetMapping("/userUpdate/{id}")
	public UserUpdate getUserUpdateId(@PathVariable(value = "id") int id) {
		UserUpdate usr = userUpdateService.getUserUpdate(id);
		return usr;
	}

	// userUpdate?id=123
	@GetMapping("/userUpdate")
	public UserUpdate getUserUpdate(@RequestParam("id") int id) {
		UserUpdate usr = userUpdateService.getUserUpdate(id);
		return usr;
	}

	// userUpdate
	@PostMapping("/userUpdate")
	public long updateUserUpdate(@RequestBody User user) {
		long usrId = userUpdateService.updateUserUpdate(user);
		return usrId;
	}

	/*
	 * //Post Form
	 *
	 * @PostMapping(path = "/user/{id}", consumes =
	 * {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	 *
	 * @ResponseBody
	 * public String PostUser(
	 *
	 * @PathVariable(value = "id") int id,
	 *
	 * @RequestParam MultiValueMap<String, String> paramMap) throws Exception
	 * {
	 * return "ok";
	 * }
	 */

	// Post JSON
	@PostMapping("/user/{id}")
	@ResponseBody
	public long updateUser(
			@PathVariable(value = "id") int id,
			@RequestBody User usr) {
		long userId = userService.updateUser(usr);
		return userId;
	}
}
