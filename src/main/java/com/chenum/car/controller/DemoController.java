package com.chenum.car.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenum.car.service.UserService;

/**
 * Demo
 */
@Controller
@RequestMapping("demo")
public class DemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Resource
	private UserService userService;

	@RequestMapping(value = "{theme}")
	public String page(@PathVariable String theme) {
		return "demo/" + theme;
	}
}