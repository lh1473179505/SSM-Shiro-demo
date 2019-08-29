package cn.sjxy.test;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cn.sjxy.dao.DepartmentMapper;
import cn.sjxy.dao.EmployeeMapper;
import cn.sjxy.domain.Department;
import cn.sjxy.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class BatchInsertTest {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;

	
	@Test
	public void test1() {
		
		departmentMapper.insertSelective(new Department(1,"java开发部"));
		departmentMapper.insertSelective(new Department(2,"html开发部"));
		departmentMapper.insertSelective(new Department(3,"php开发部"));
		departmentMapper.insertSelective(new Department(4,"python开发部"));
	}
	@Test
	
	public void test2() {
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		Random random = new Random();
		for(int i=0;i<200;i++) {
			int age = random.nextInt(100)+1;
			int did = random.nextInt(4)+1;
			String name = UUID.randomUUID().toString().substring(0,3);
			mapper.insertSelective(new Employee(null, name, age, did,null));
		}
		System.out.println("插入完成");
	}
	
	@Test
	public void test3() {
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.selectWithDept(null);
		for(Employee e:list) {
			System.out.println(e);
		}
	}
	
}
