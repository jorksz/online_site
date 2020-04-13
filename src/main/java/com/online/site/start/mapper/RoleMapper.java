package com.online.site.start.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {

    /**
     * 获取用户的权限名
     * @param id
     * @return
     */
    String getRole(Integer id);
}
