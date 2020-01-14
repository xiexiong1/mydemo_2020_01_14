package com.trs.test.demo.mapper;

import com.trs.test.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  AppHotMapper {

    User selectAppHotById(int id);
}
