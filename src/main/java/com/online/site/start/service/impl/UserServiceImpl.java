package com.online.site.start.service.impl;

import com.online.site.start.mapper.UserMapper;
import com.online.site.start.entity.User;
import com.online.site.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveUser(User user) {
       return userMapper.saveUser(user) > 0;
    }

    @Override
    public boolean checkUserNameExist(String userName) {
        return userMapper.getUserName(userName).size() > 0;
    }

    @Override
    public String getPassword(String userName) {
        return userMapper.getPassword(userName);
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public boolean checkMailExist(String mailNumber) {
        return userMapper.getMail(mailNumber).size() > 0;
    }

    @Override
    public boolean findPassword(String newPassword, String mailNumber) {
        return userMapper.updatePassword(newPassword, mailNumber) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUserMessage(user) > 0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public List<User> getUser(String userName) {
        return userMapper.getUserName(userName);
    }
}
