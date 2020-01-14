package com.trs.test.demo.service;

import com.trs.test.demo.entity.Permissions;
import com.trs.test.demo.entity.Role;
import com.trs.test.demo.entity.User;
import com.trs.test.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public User getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByName1(getMapByName);
    }


    private User getMapByName1(String userName){
        //用户拥有的角色
        List<Role> roleList = userMapper.getRolesByUsername(userName);
        //User user = userMapper.getUserByUsername(userName);
        final User user = new User();

        Set<Role> roleSet = new HashSet<>();
        for (Role role:roleList) {
            //角色拥有的权限
            List<Permissions> permissionsList = userMapper.getPermissionsByRole(role.getId());
            for (Permissions permission:permissionsList) {
             //  role.setPermissions(permissionsList);
            }



           user.setUserName(userName);
          // user.setRoles();
        }
        return user;
    }


    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permissions permissions1 = new Permissions("1","query");
        Permissions permissions2 = new Permissions("2","add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role("1","admin",permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User("1","zhangsan","123456",roleSet);
        Map<String ,User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Permissions permissions3 = new Permissions("3","query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role("2","user",permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User("2","lisi","123456",roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }

}
