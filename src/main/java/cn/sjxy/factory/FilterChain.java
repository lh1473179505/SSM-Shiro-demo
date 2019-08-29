package cn.sjxy.factory;

import java.util.LinkedHashMap;

public class FilterChain {

	public LinkedHashMap<String, String> buildFilter(){
		LinkedHashMap<String,String> map = new LinkedHashMap<>();
		/**
		 * /admin/insert = anon
                /login.jsp = anon
                /admin/login = anon
                /register.jsp = anon
                /logout = logout
                
                /user.jsp = roles[user]
                /admin.jsp = roles[admin]
                # everything else requires authentication:
                /** = authc
		 */
		map.put("/admin/insert", "anon");
		map.put("/login.jsp", "anon");
		map.put("/admin/login", "anon");
		map.put("/register.jsp", "anon");
		map.put("/logout", "logout");
		map.put("/user.jsp", "authc,roles[user]");
		map.put("/admin.jsp", "authc,roles[admin]");
		map.put("/success.jsp", "user");
		
		map.put("/**", "authc");
		
		return map;
	}
}
