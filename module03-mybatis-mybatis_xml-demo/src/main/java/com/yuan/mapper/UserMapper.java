package com.yuan.mapper;

import com.yuan.pojo.User;

import java.util.List;

/**
 * @className: UserMapper
 * @package: com.yuan.mapper
 * @description:
 * @author: liyuan
 * @create: 2024/01/30 0:51
 * @version: 1.0
 */
public interface UserMapper {
	List<User> selectAll();
}
