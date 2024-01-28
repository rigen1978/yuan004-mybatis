package com.yuan;

import com.yuan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @className: MybatisDemo
 * @package: com.yuan
 * @description:
 * @author: liyuan
 * @create: 2024/01/28 21:44
 * @version: 1.0
 */
public class MybatisDemo {
	/**
	 * mybatisの快速入門
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> users = sqlSession.selectList("test.selectAll");

		System.out.println(users);
		sqlSession.close();
	}
}
