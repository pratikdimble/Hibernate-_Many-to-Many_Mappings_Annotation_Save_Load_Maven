package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee_MTM")
public class Employee {

	private int empId;
	private String empName;
	private Set<Address> addr=new HashSet<Address>();
	
	@Id
	//@Column(name="EMPID")
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
///	@Column(name="EMPNAME")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@ManyToMany(targetEntity=Address.class,cascade=CascadeType.ALL)
	@JoinTable(name="emp_addr",
			joinColumns=@JoinColumn(name="eidFK",referencedColumnName="empId"),
			inverseJoinColumns=@JoinColumn(name="aidFK",referencedColumnName="addrId")
			)
	
	public Set<Address> getAddr() {
		return addr;
	}
	public void setAddr(Set<Address> addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", addr=" + addr + "]";
	}
	
	
	
}
