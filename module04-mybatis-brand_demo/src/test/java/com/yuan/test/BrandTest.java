package com.yuan.test;

import com.yuan.mapper.BrandMapper;
import com.yuan.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @className: BrandTest
 * @package: com.yuan.test
 * @description:
 * @author: liyuan
 * @create: 2024/01/30 11:49
 * @version: 1.0
 */
public class BrandTest {
	/**
	 * すべてのデータを取得
	 * @throws Exception
	 */
	@Test
	public void testSelectAll() throws Exception {
		//SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		List<Brand> brandList = brandMapper.selectAll();

		System.out.println(brandList);

		sqlSession.close();
	}
}
