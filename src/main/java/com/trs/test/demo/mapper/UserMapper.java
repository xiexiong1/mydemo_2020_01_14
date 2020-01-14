package com.trs.test.demo.mapper;

import com.trs.test.demo.entity.Permissions;
import com.trs.test.demo.entity.Role;
import com.trs.test.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  UserMapper {

    User getUserByUsername(String username);

    List<Role> getRolesByUsername(String username);

    List<Permissions> getPermissionsByRole(String roleId);
}
