package com.adam.springproject.services;

import com.adam.springproject.dtoas.LogInRequestDto;
import com.adam.springproject.dtoas.LoginResponseDto;
import com.adam.springproject.dtoas.SignUpRequestDto;
import com.adam.springproject.dtoas.SignUpResponseDto;
import com.adam.springproject.repositories.UserDao;
import com.adam.springproject.repositories.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Object signUp(SignUpRequestDto signUpRequestDto) {
        return validate(new User(signUpRequestDto));
    }

    private SignUpResponseDto validate(User user) {
        //Entity 有設定 unique = true 該如何使用
        if (isEmailDuplicate(user)) {
            return new SignUpResponseDto(-1, user, "Email already registered");
        }
        if (isLengthOfNameIllegal(user)) {
            return new SignUpResponseDto(-1, user, String.format("Length of name : %d, Length must between 4 and 18.",user.getName().length() ));
        }
        if (isGenderSpellingIllegal(user)) {
            return new SignUpResponseDto(-1, user, "Gender must be 'female' or 'male'");
        }
        if (isEmailFormatIllegal(user)) {
            return new SignUpResponseDto(-1, user, "Email format error");
        }
        if (isLengthOfPasswordLegal(user)) {
            return new SignUpResponseDto(-1, user, String.format("Length of password : %d, Length must between 10 and 20.",user.getPassword().length() ));
        }
        return new SignUpResponseDto(userDao.save(user).getId(), user, "Register successfully");
    }

    private boolean isEmailDuplicate(User user) {
        if (userDao.findUserByEmail(user.getEmail()) != null) {
            return true;
        }
        return false;
    }

    private boolean isLengthOfNameIllegal(User user) {
        return !(user.getName().length() >= 4 && user.getName().length() <= 18);
    }

    private boolean isGenderSpellingIllegal(User user) {
        return !(user.getGender().equals("female") || user.getGender().equals("male"));
    }

    private boolean isEmailFormatIllegal(User user) {
        return !Pattern.compile("^(.+)@(.+)$").matcher(user.getEmail()).matches();
    }

    private boolean isLengthOfPasswordLegal(User user) {
        return !(user.getPassword().length() >= 10 && user.getPassword().length() <= 20);
    }

    public Object login(LogInRequestDto logInRequestDto) {
        User user = userDao.findUserByEmail(logInRequestDto.getEmail());
        if (user == null || !user.getPassword().equals(logInRequestDto.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("login failed");
        }
        return ResponseEntity.ok(new LoginResponseDto(user));
    }
}
