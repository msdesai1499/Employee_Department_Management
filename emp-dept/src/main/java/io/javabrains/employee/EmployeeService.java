package io.javabrains.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.exceptions.ApiRequestException;
import io.javabrains.exceptions.DataNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			employeeRepository.save(employee);
			return "Successful";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error "+e;
		}
	}

	public List<Employee> getEmployees(long id) {
		// TODO Auto-generated method stub
		
		List<Employee> d=new ArrayList<>();
		employeeRepository.findByDepartmentId(id).forEach(d::add);
		return d;
	}

	public Employee getEmployee(long deptid,long id) {
		// TODO Auto-generated method stub
		
		Employee e=employeeRepository.findByDepartmentIdAndId(deptid, id);
		if(e==null) {
			throw new DataNotFoundException("Employee you are trying yo get Doesn't Exist");
		}
		return e;
	}

	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			employeeRepository.save(employee);
			return "Successful";
		} catch (Exception e) {
			// TODO: handle exception
			
			return "Error "+e;
		}
	}

	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
			Employee d=employeeRepository.findById(id).get();
			if(d==null) {
				throw new ApiRequestException("Employee you are trying to delete does not exist");
			}
			employeeRepository.delete(d);
			return "Successful";
			// TODO: handle exception
		
	}

	public List<Employee> getAllEmployeses() {
		// TODO Auto-generated method stub
		List<Employee> d=new ArrayList<>();
		employeeRepository.findAll().forEach(d::add);
		return d;
	}

}
