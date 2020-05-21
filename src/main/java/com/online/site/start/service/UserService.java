package com.online.site.start.service;

import com.github.pagehelper.Page;
import com.online.site.start.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 保存用户信息
     * @param user 用户实体
     */
    boolean saveUser(User user);

    /**
     * 检查该用户名是否存在
     * @param userName 用户名
     * @return 用户名
     */
    boolean checkUserNameExist(String userName);

    /**
     * 查询密码
     * @param userName 用户名或邮箱
     * @return 密码
     */
    String getPassword(String userName);

    /**
     * 查询全部用户
     * @return
     */
    Page<User> listUser();

    /**
     * 检查用户邮箱是否存在
     * @param mailNumber
     * @return
     */
    boolean checkMailExist(String mailNumber);

    /**
     * 找回密码
     * @param newPassword 新密码
     * @param mailNumber 邮箱
     * @return
     */
    boolean findPassword(String newPassword, String mailNumber);

    /**
     * 更新用户信息
     * @param user 用户
     * @return
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUser(Integer id);

    /**
     * 查询用户详细信息
     * @param userName 邮箱或者用户名
     * @return
     */
    List<User> getUser(String userName);
}
