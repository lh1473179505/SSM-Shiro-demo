package cn.sjxy.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sjxy.domain.Admin;
import cn.sjxy.service.AdminService;

public class SecondRrealm extends AuthenticatingRealm  {

	@Autowired
	private AdminService adminService;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("第二Realm");
		//1.把AuthenticationToken对象强转为UsernamePasswordToken对象
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		
		//2.从UsernamePasswordToken中获取name
		String name = upToken.getUsername();
		
		//3.调用数据库方法，从数据库查询name对应的用户记录
		Admin admin = adminService.selectByName(name);
		//4.若用户不存在，就抛出账号不存在异常
		if(admin==null) {
			System.out.println("用户不存在");
		}
		
		//5.根据用户情况决定是否要抛出其他异常
		if("dog".equals(name)) {
			System.out.println("狗子异常");
		}
		
		//6.根据用户情况，构建AuthenticationInfo对并返回,常用他的子类SimpleAuthenticationInfo
		//下面参数来自于数据库
		//1.principal:认证的实体信息，可以是name或者实体对象
		Object principal = admin;
		//2.credentials:来自数据库中的密码
		Object credentials = admin.getPassword(); //"fc1709d0a95a6be30bc5926fdb7f22f4";
		//加盐
		ByteSource credentialsSalt = ByteSource.Util.bytes(name);
		//3.realmName:当前realm的名字，调用父类的getRealm方法即可
		String realmName = getName();
		SimpleAuthenticationInfo info = null;  //new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}
	
	public static void main(String[] args) {
		String algorithmName = "SHA1";
		Object source = "123456";
		Object salt = ByteSource.Util.bytes("cat");
		int hashIterations = 1024;
		Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
		
		System.out.println(result);
	}

	
}
