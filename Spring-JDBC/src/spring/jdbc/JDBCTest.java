package spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	
	/**
	 * 测试 NamedParameterJdbcTemplate 的具名参数
	 * 可以使用这个方法，直接传入对象而不是Map
	 * update(String sql, SqlParameterSource paramSource)
	 * 要求：
	 * values(:id, :name, :age, :sex)里面的名称和JavaBean的属性名称一样
	 */
	@Test
	public void testNamedParameterJdbcTemplate2() {
		String sql = "insert into student(id,name,age,sex) values(:id, :name, :age, :sex)";

		Student student = new Student(50, "CC", 100, 1);
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(student);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	/**
	 * 测试 NamedParameterJdbcTemplate 的具名参数
	 * 可以根据属性名来设置参数
	 * 如果参数数量庞大的时候，则更容易维护
	 */
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "insert into student(name,age,sex) values(:name,:age,:sex)";
		Map<String,Object> map = new HashMap<>();
		map.put("name", "xiaohuang");
		map.put("age", 10);
		map.put("sex", 1);
		namedParameterJdbcTemplate.update(sql, map);
	}
	
	/**
	 * 统计查询,获取单个列的值
	 */
	@Test
	public void testQueryForObject2(){
		String sql = "select count(*) from student";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	/**
	 * 查到实体类的集合 
	 */
	@Test
	public void testQueryForList() {
		
		String sql = "select * from student where id > ?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
		List<Student> list = jdbcTemplate.query(sql, rowMapper,1);
		System.out.println(list);
	}
	
	
	/**
	 * 从数据库中获取一条数据，获得实际的对象
	 * 不是这个方法：
	 * queryForObject(String sql, Class<Student> requiredType, Object... args)
	 * 而是：
	 * queryForObject(String sql, RowMapper<Student> rowMapper, Object... args)
	 * 
	 * 1.RowMapper 指定映射器，常用的实现类为BeanPropertyRowMapper
	 * 2.使用 sql 列的别名和类的属性名的映射，或者让 列名直接和 javaBean的属性名相同
	 * 3.不支持级联属性
	 */
	@Test
	public void testQueryForObject(){
		String sql = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
		Student student = jdbcTemplate.queryForObject(sql, rowMapper,1);
		System.out.println(student);
	}
	
	/**
	 * 执行批量 操作
	 */
	@Test
	public void testBatchUpdate() {
		String sql = "insert into student(name,sex,age) values(?,?,?)";
		
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{"AA",1,10});
		list.add(new Object[]{"BB",1,10});
		
		jdbcTemplate.batchUpdate(sql,list);
	}
	
	/**
	 * 执行 数据 库的 select 、insert 、update
	 */
	@Test
	public void testUpdate() {
		String sql = "update student set name = ? where id = ?";
		jdbcTemplate.update(sql,"xiaohua", 5);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
}
