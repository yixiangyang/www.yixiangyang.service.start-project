package com.yixiangyang.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.yixiangyang.model.User;

public interface UserMapper {
	@Insert("insert into user(name,create_time) values(#{u.name},#{u.createTime})")
	public void inserUser(@Param("u")User user);
}
