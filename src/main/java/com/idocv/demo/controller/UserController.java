package com.idocv.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idocv.demo.po.User;
import com.idocv.demo.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Resource
	private UserService userService;

	@RequestMapping(value = "page")
	public String page() {
		return "user";
	}

	/**
	 * Create user
	 */
	@RequestMapping(value = "create")
	public String create(Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user = userService.save(user);
		model.addAttribute("user", user);
		return "user";
	}
	
	/**
	 * Delete user
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{id}")
	public Map<String, Object> delete(Model model, @PathVariable int id) {
		userService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "success");
		return map;
	}

	/**
	 * update user
	 */
	@ResponseBody
	@RequestMapping(value = "update/{id}")
	public User update(Model model, @PathVariable int id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "age", required = false) int age) {
		User user = new User();
		user.setId(id);
		if (null != name) {
			user.setName(name);
		}
		if (0 < age) {
			user.setAge(age);
		}
		userService.update(user);
		return user;
	}

	/**
	 * get user
	 */
	@ResponseBody
	@RequestMapping(value = "get/{id}")
	public User get(Model model, @PathVariable int id) {
		User user = userService.get(id);
		return user;
	}

	/**
	 * list user
	 */
	@ResponseBody
	@RequestMapping(value = "list")
	public List<User> list(Model model) {
		List<User> users = userService.list("");
		return users;
	}

}
