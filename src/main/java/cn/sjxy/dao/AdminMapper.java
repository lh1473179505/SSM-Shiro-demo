package cn.sjxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sjxy.domain.Admin;

public interface AdminMapper {

	void insert(Admin admin);
	
	void deleteById(int id);
	
	void update(Admin admin);
	
	Admin selectById(int id);
	
	Admin selectByName(String username);
	
	List<Admin> selectAll();
}
