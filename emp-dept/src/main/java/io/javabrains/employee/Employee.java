package io.javabrains.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javabrains.department.Department;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String contact;
	private String address;
	private String joiningdate;
	
	@ManyToOne
	private Department department;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long id, String name, String contact, String address, String joiningdate,long deptId) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.joiningdate = joiningdate;
		this.department=new Department(deptId,"");
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address
				+ ", joiningdate=" + joiningdate + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}	
	
}
