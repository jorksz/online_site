package com.online.site.start.service.impl;

import com.online.site.start.mapper.RoleMapper;
import com.online.site.start.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String getRole(Integer id) {
        return roleMapper.getRole(id);
    }
}
