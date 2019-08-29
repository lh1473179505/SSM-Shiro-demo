package cn.sjxy.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sjxy.domain.Admin;
import cn.sjxy.service.AdminService;
import cn.sjxy.service.ShiroService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ShiroService shiroService;

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/testShiro")
	public String testShiro(HttpSession session) {
		session.setAttribute("dog", "xiaobai");
		shiroService.MethodTest();
		return "index";
	}
	@RequestMapping("/insert")
	public String insert(Admin admin) {
		adminService.insert(admin);
		System.out.println("1.插入————");
		System.out.println("2.admin:"+admin);
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password) {
		Subject currentAdmin = SecurityUtils.getSubject();
		if(!currentAdmin.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
			currentAdmin.login(token);
			}catch (AuthenticationException ae) {
				
				System.out.println("登录失败！"+ae.getMessage());
			}
		}
		
		return "redirect:/success.jsp";
	}
	
}
