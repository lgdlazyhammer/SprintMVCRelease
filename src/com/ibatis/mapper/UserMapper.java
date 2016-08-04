package com.ibatis.mapper;

import com.entity.UserEntity;

public interface UserMapper {
	
	public UserEntity selectUser(int id);

}
