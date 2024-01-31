package com.yuan.mapper;

import com.yuan.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

	// selectById
	Brand selectById(int id);

	/**
	 * 条件查询
	 * * 参数接收
	 * 1. 普通引数：引数が多い場合，@Paramを使い("SQL引数プレースホルダ")
	 * 2. オブジェクト引数:
	 * 3. map引数
	 */

	//List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

	//List<Brand> selectByCondition(Brand brand);

	List<Brand> selectByCondition(Map map);

	/**
	 * 单条件动态查询
	 * @param brand
	 * @return
	 */
	List<Brand> selectByConditionSingle(Brand brand);

	/**
	 * 登録
	 */
	void add(Brand brand);

	/**
	 * 更新
	 */
	int update(Brand brand);


	/**
	 * idによって削除
	 */
	void deleteById(int id);


	/**
	 * 複数削除
	 */
	//void deleteByIds(int[] ids);
	void deleteByIds(@Param("ids") int[] ids);
}
