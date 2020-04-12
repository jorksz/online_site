package com.online.site.start.mapper;

import com.online.site.start.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * 保存用户信息
     * @param user 用户实体
     */
    Integer saveUser(User user);

    /**
     * 根据用户名获取用户信息
     * @param userName 用户名
     * @return 用户名
     */
    List<User> getUserName(String userName);

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
    List<User> listUser();

    /**
     * 根据邮箱获取用户信息
     * @param mailNumber 邮箱
     * @return
     */
    List<User> getMail(String mailNumber);

    /**
     * 修改密码
     * @param password 密码
     * @param userMail 邮箱
     * @return
     */
    Integer updatePassword(String password, String userMail);

    /**
     * 更新用户信息
     * @param user 用户
     * @return
     */
    Integer updateUserMessage(User user);

    /**
     * 删除用户
     * @param userId 用户ID
     * @return
     */
    Integer deleteUser(Integer userId);

}
