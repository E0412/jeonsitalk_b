package com.jeonsitalk.member.controller;

import com.jeonsitalk.member.service.RegisterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//회원가입 controller
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterServiceImpl registerService;


}
