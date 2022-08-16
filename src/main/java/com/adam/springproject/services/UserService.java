package com.adam.springproject.services;

import com.adam.springproject.dtoas.LogInRequestDto;
import com.adam.springproject.dtoas.LoginResponseDto;
import com.adam.springproject.dtoas.SignUpRequestDto;
import com.adam.springproject.dtoas.SignUpResponseDto;
import com.adam.springproject.repositories.UserDao;
import com.adam.springproject.repositories.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Object signUp(SignUpRequestDto signUpRequestDto) {
        User user = new User(signUpRequestDto.getAccount(), signUpRequestDto.getPassword());
        return new SignUpResponseDto(userDao.save(user).getId(), user.getAccount());
    }

    public Object login(LogInRequestDto logInRequestDto) {
        User user = userDao.findUserByAccount(logInRequestDto.getAccount());
        if (user == null) {
            return new LoginResponseDto(0, "", "User doesn't exist");
        }
        if (!user.getPassword().equals(logInRequestDto.getPassword())) {
            return new LoginResponseDto(user.getId(), user.getAccount(), "Password incorrect");
        }
        return new LoginResponseDto(user.getId(), user.getAccount(), "Login success");
    }
}
