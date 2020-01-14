package com.trs.test.demo.service;


import com.trs.test.demo.entity.User;
import com.trs.test.demo.mapper.AppHotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class AppHotService {

    @Autowired
    private AppHotMapper appHotMapper;

    @RequestMapping("/select")
    public User selectAppHotById(int id){
        User user = appHotMapper.selectAppHotById(id);
        return user;
    };
}
