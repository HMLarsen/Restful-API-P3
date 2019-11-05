package com.furb.prog3.trab3.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.furb.prog3.trab3.repository.UserRepository;

@Controller
@RequestMapping(value = "/secure/user", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController extends BaseSecureCrudController<UserRepository> {
}
