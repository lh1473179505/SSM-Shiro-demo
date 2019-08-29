package cn.sjxy.dao;

import cn.sjxy.domain.Employee;
import cn.sjxy.domain.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(Employee record);       

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);
    
    List<Employee> selectWithDept(EmployeeExample example );
    
    Employee selectByPrimaryKey(Integer eid);
    
    Employee selectWithDeptByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}