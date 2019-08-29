package cn.sjxy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sjxy.domain.Employee;
import cn.sjxy.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("/findAll")
	public String findAll(@RequestParam(value="pn",required=false,defaultValue="1")int pn,Map<String,Object>map) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pn,5);
		List<Employee> list = employeeService.findAll();
		PageInfo pageInfo = new PageInfo<>(list,5);
		map.put("pageInfo", pageInfo);
		return "success";
	}
	
}
