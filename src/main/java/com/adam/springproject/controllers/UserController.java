package com.adam.springproject.controllers;

import com.adam.springproject.MessageTimer;
import com.adam.springproject.dtoas.LogInRequestDto;
import com.adam.springproject.dtoas.SendMsgRequestDto;
import com.adam.springproject.dtoas.SignUpRequestDto;
import com.adam.springproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;

//Http Service 的進入點
//@Controller
//進入點的位置
@RequestMapping(value = "/api")
@RestController
public class UserController {

    private final UserService userService;
    private MessageTimer messageTimer = new MessageTimer();
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
        進入點的位置，若 value 值與其他的 GetMapping 相同
        Caused by: java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'userController' method
        com.adam.springproject.controllers.UserController#hello()
        to {GET [/api/hello]}: There is already 'userController' bean method
        com.adam.springproject.controllers.UserController#hello2() mapped.
    */

    @GetMapping(value = "/hello")
    //回應 hello 這個函數!
    //@ResponseBody
    public String hello() {
        return "Hello!";
    }

    @GetMapping(value = "/hello2")
    //@ResponseBody
    public Object hello2() {
        return Collections.singletonMap("key", "Hello!2");
    }

    @PostMapping(value = "/signup")
    public Object signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        return userService.signUp(signUpRequestDto);
    }

    @PostMapping(value = "/login")
    public Object signIn(@RequestBody LogInRequestDto logInRequestDto) {
        return userService.login(logInRequestDto);
    }

    @PostMapping(value = "/sendMsg")
    public Object sendMsg(@RequestBody @Valid SendMsgRequestDto sendMsgRequestDto) {
        return userService.sendMsg(sendMsgRequestDto);
    }
}