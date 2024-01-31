package com.yuan.test;

import com.yuan.mapper.BrandMapper;
import com.yuan.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * 引数があるの場合
	 * @throws Exception
	 */
	@Test
	public void testSelectById() throws Exception {
		int id = 1;

		//SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		Brand brand = brandMapper.selectById(id);

		System.out.println(brand);
		//後処理（sqlSessionのクローズ）
		sqlSession.close();
	}

	/**
	 * 複数の引数(普通引数)
	 * @throws IOException
	 */
	//@Test
	//public void testSelectByCondition1() throws IOException {
	//	//引数
	//	int status = 1;
	//	String companyName = "トヨタ";
	//	String brandName = "トヨタ";
	//
	//	// 引数を加工
	//	companyName = "%" + companyName + "%";
	//	brandName = "%" + brandName + "%";
	//
	//	//1.SqlSessionFactoryを取得
	//	String resource = "mybatis-config.xml";
	//	InputStream inputStream = Resources.getResourceAsStream(resource);
	//	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	//
	//	//2. sqlを実行する為に、sqlSessionを取得
	//	SqlSession sqlSession = sqlSessionFactory.openSession();
	//
	//	//3. Mapperを取得
	//	BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
	//
	//	//4. 実行
	//
	//	List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
	//
	//	System.out.println(brands);
	//
	//	//5. 後処理（sqlSessionのクローズ）
	//	sqlSession.close();
	//
	//}

	/**
	 * オブジェクト引数:
	 * @throws IOException
	 */
	//@Test
	//public void testSelectByCondition2() throws IOException {
	//	//引数
	//	int status = 1;
	//	String companyName = "トヨタ";
	//	String brandName = "トヨタ";
	//
	//	// 引数を加工
	//	companyName = "%" + companyName + "%";
	//	brandName = "%" + brandName + "%";
	//
	//	Brand brand = new Brand();
	//	brand.setStatus(status);
	//	brand.setCompanyName(companyName);
	//	brand.setBrandName(brandName);
	//
	//	//1.SqlSessionFactoryを取得
	//	String resource = "mybatis-config.xml";
	//	InputStream inputStream = Resources.getResourceAsStream(resource);
	//	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	//
	//	//2. sqlを実行する為に、sqlSessionを取得
	//	SqlSession sqlSession = sqlSessionFactory.openSession();
	//
	//	//3. Mapperを取得
	//	BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
	//
	//	//4. 実行
	//
	//	List<Brand> brands = brandMapper.selectByCondition(brand);
	//
	//	System.out.println(brands);
	//
	//	//5. 後処理（sqlSessionのクローズ）
	//	sqlSession.close();
	//
	//}

	/**
	 * map引数
	 * @throws IOException
	 */
	@Test
	public void testSelectByCondition3() throws IOException {
		//引数
		int status = 1;
		String companyName = "トヨタ";
		String brandName = "トヨタ";

		// 引数を処理
		companyName = "%" + companyName + "%";
		brandName = "%" + brandName + "%";

		Map map = new HashMap();
		map.put("status", status);
		map.put("companyName", companyName);
		map.put("brandName", brandName);

		//1.SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2. sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3. Mapperを取得
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		//4. 実行

		List<Brand> brands = brandMapper.selectByCondition(map);

		System.out.println(brands);

		//5. 後処理（sqlSessionのクローズ）
		sqlSession.close();

	}

	@Test
	public void testSelectByConditionSingle() throws IOException {
		//引数
		int status = 1;
		String companyName = "トヨタ";
		String brandName = "トヨタ";

		// 引数を処理
		companyName = "%" + companyName + "%";
		brandName = "%" + brandName + "%";

		//Brandに格納する
		Brand brand = new Brand();
		//brand.setStatus(status);
		brand.setCompanyName(companyName);
		//brand.setBrandName(brandName);

		//1.SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2. sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3. Mapperを取得
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		//4. 実行

		List<Brand> brands = brandMapper.selectByConditionSingle(brand);
		System.out.println(brands);

		//5. 释放资源
		sqlSession.close();

	}

	/**
	 * 登録
	 * @throws IOException
	 */
	@Test
	public void testAdd() throws IOException {
		//引数
		int status = 1;
		String companyName = "ホンダ";
		String brandName = "ホンダ";
		String description = "二番目の車メーカー";
		int ordered = 100;

		//Brandに格納する
		Brand brand = new Brand();
		brand.setStatus(status);
		brand.setCompanyName(companyName);
		brand.setBrandName(brandName);
		brand.setDescription(description);
		brand.setOrdered(ordered);

		//1.SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2. sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3. Mapperを取得
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		//4. 実行
		brandMapper.add(brand);
		//主キーの取得
		Integer id = brand.getId();
		System.out.println(id);

		//提交事务
		sqlSession.commit();

		//5. 释放资源
		sqlSession.close();

	}

	/**
	 * 更新
	 * @throws IOException
	 */
	@Test
	public void testUpdate() throws IOException {
		//引数
		int status = 1;
		String companyName = "ホンダ";
		String brandName = "ホンダ";
		String description = "二番目の車メーカー,Updateテスト,Updateテスト2";
		int ordered = 200;
		int id = 4;

		//Brandに格納する
		Brand brand = new Brand();
		//brand.setStatus(status);
		//brand.setCompanyName(companyName);
		//brand.setBrandName(brandName);
		brand.setDescription(description);
		//brand.setOrdered(ordered);
		brand.setId(id);

		//1.SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2. sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3. Mapperを取得
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		//4. 実行
		int count = brandMapper.update(brand);
		System.out.println(count);

		//提交事务
		sqlSession.commit();

		//5. 释放资源
		sqlSession.close();

	}

	/**
	 * idによって削除
	 * @throws IOException
	 */
	@Test
	public void testDeleteById() throws IOException {
		//引数
		int id = 5;


		//1.SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2. sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3. Mapperを取得
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		//4. 実行
		brandMapper.deleteById(id);

		//提交事务
		sqlSession.commit();

		//5. 释放资源
		sqlSession.close();

	}

	/**
	 * 複数削除
	 * @throws IOException
	 */
	@Test
	public void testDeleteByIds() throws IOException {
		//引数
		int[] ids = {4, 5, 6};


		//1.SqlSessionFactoryを取得
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//2. sqlを実行する為に、sqlSessionを取得
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//3. Mapperを取得
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		//4. 実行
		brandMapper.deleteByIds(ids);

		//提交事务
		sqlSession.commit();

		//5. 释放资源
		sqlSession.close();

	}
}
