package cn.sjxy.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.dao.AdminMapper;
import cn.sjxy.domain.Admin;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	public void insert(Admin admin) {
		//通过MD5加密
		System.out.println("3.admin:"+admin);
		String algorithmName = "MD5";
		Object source = admin.getPassword();
		Object salt = ByteSource.Util.bytes(admin.getUsername());
		int hashIterations = 1024;
		Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println("4.result.toString:"+result.toString());
		System.out.println("5.result:"+result);
		admin.setPassword(result.toString());
		System.out.println("加密过后的admin:"+admin);
		//将加密过的数据存进数据库
		adminMapper.insert(admin);
	}
	
	public Admin selectByName(String username) {
		return adminMapper.selectByName(username);
	} 
}
