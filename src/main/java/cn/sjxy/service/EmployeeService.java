package cn.sjxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sjxy.dao.EmployeeMapper;
import cn.sjxy.domain.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> findAll(){
		return employeeMapper.selectWithDept(null);
	}
}
