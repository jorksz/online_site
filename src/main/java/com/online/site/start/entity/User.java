package com.online.site.start.entity;

/**
 * 用户表
 * @author ljt
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String mailNumber;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String sex;
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailNumber() {
        return mailNumber;
    }

    public void setMailNumber(String mailNumber) {
        this.mailNumber = mailNumber;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
