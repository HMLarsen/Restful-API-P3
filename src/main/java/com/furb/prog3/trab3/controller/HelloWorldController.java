package com.furb.prog3.trab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Say hello to user")
	public String sayHello() {
		return "Hello User!";
	}

}
