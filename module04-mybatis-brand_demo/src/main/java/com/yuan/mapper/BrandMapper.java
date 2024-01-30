package com.yuan.mapper;

import com.yuan.pojo.Brand;

import java.util.List;

/**
 * @className: BrandMapper
 * @package: com.yuan.mapper
 * @description:
 * @author: liyuan
 * @create: 2024/01/30 11:47
 * @version: 1.0
 */
public interface BrandMapper {
	// select All
	List<Brand> selectAll();
}
