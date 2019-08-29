package cn.sjxy.domain;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer eid;

    private String name;

    private Integer age;

    private Integer deptId;
    
    private Department dept;
    
    

    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer eid, String name, Integer age, Integer deptId, Department dept) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.deptId = deptId;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", age=" + age + ", deptId=" + deptId + ", dept=" + dept
				+ "]";
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}