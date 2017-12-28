package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Address_MTM")
public class Address {
	
	private int addrId;
	private String location;
	private Set<Employee> emps=new HashSet<Employee>();
	
	@Id
	//@Column(name="ADDRID")
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	
	//@Column(name="LOCATION")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@ManyToMany(targetEntity=Employee.class,cascade=CascadeType.ALL,mappedBy="addr")
	
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", location=" + location + ", emps=" + emps + "]";
	}

	
	
}
