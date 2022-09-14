package com.adam.springproject.services;

import com.adam.springproject.dtoas.*;
import com.adam.springproject.repositories.UserDao;
import com.adam.springproject.repositories.entites.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserDao userDao;
    private Optional<User> user;
    private Date lastMessageTime = new Date();

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    private SignUpResponseDto validate(User user) {
        //Entity 有設定 unique = true 該如何使用
        if (isEmailDuplicate(user)) {
            return new SignUpResponseDto(-1, user, "Email already registered");
        }
        if (isLengthOfNameIllegal(user)) {
            return new SignUpResponseDto(-1, user, String.format("Length of name : %d, Length must between 4 and 18.", user.getName().length()));
        }
        if (isGenderSpellingIllegal(user)) {
            return new SignUpResponseDto(-1, user, "Gender must be 'female' or 'male'");
        }
        if (isEmailFormatIllegal(user)) {
            return new SignUpResponseDto(-1, user, "Email format error");
        }
        if (isLengthOfPasswordLegal(user)) {
            return new SignUpResponseDto(-1, user, String.format("Length of password : %d, Length must between 10 and 20.", user.getPassword().length()));
        }
        return new SignUpResponseDto(userDao.save(user).getId(), user, "Register successfully");
    }

    private boolean isEmailDuplicate(User user) {
        return userDao.findUserByEmail(user.getEmail()) != null;
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

    public Object signUp(SignUpRequestDto signUpRequestDto) {
        //return validate(new User(signUpRequestDto));
        User user = new User(signUpRequestDto);
        try {
            return new SignUpResponseDto(userDao.save(user).getId(), user, "Register successfully");
        } catch (ConstraintViolationException e) {
            return new SignUpResponseDto(-1, null, e.getMessage());
        }
    }

    public Object login(LogInRequestDto logInRequestDto) {
        user = userDao.findUserByEmail(logInRequestDto.getEmail());
        if (!user.get().getPassword().equals(logInRequestDto.getPassword())) {
            //登入失敗
            user = Optional.empty();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("login failed");
        }
        return ResponseEntity.ok(new LoginResponseDto(user.get()));
    }

    public Object sendMsg(SendMsgRequestDto sendMsgRequestDto) {
        Date now = new Date();
        long diff = now.getTime() - lastMessageTime.getTime();
        if (TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS) < 5) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Messages are sent every five seconds ");
        }
        lastMessageTime = now;
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please login");
        }
        System.out.println(user.get().getName() + ":" + sendMsgRequestDto.getMessage());
        return ResponseEntity.ok(new SendMsgResponseDto(sendMsgRequestDto.getMessage()));
    }
}
