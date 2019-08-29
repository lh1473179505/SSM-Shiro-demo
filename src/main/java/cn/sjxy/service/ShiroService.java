package cn.sjxy.service;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class ShiroService {

	@RequiresRoles({"admin"})
	public void MethodTest() {
		
		System.out.println("method time:"+new Date());
		
		Session session = SecurityUtils.getSubject().getSession();
		Object object = session.getAttribute("dog");
		System.out.println("dog是："+object);
	}
}
