package com.online.site.start.controller;

import com.online.site.start.entity.User;
import com.online.site.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public boolean checkUserExist(@PathVariable String userName){
        return userService.checkUserNameExist(userName);
    }

    @RequestMapping(value = "/login/{userName}/{password}", method = RequestMethod.GET)
    public boolean login(@PathVariable String userName, @PathVariable String password){
            String loginPassword = Optional.ofNullable(userService.getPassword(userName)).orElse("");
            return password.equals(loginPassword);
    }

    @RequestMapping(value = "/send/{mailNumber}")
    public boolean checkMailExist(@PathVariable String mailNumber){
        return userService.checkMailExist(mailNumber);
    }

    @RequestMapping(value = "/register")
    public boolean register(User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public boolean deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/update")
    public boolean updateUser(User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/find/{password}/{mailNumber}")
    public boolean updateUser(@PathVariable String password, @PathVariable String mailNumber){
        return userService.findPassword(password, mailNumber);
    }

    @RequestMapping(value = "/all")
    public List<User> queryAll(){
        return userService.listUser();
    }

}
