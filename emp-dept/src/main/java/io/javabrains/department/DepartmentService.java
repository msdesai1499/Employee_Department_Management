package io.javabrains.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			departmentRepository.save(department);
			return "Successful";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error "+e;
		}
	}

	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		
		List<Department> d=new ArrayList<>();
		departmentRepository.findAll().forEach(d::add);
		return d;
	}

	public Department getDepartment(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).get();
	}

	public String updateDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			departmentRepository.save(department);
			return "Successful";
		} catch (Exception e) {
			// TODO: handle exception
			
			return "Error "+e;
		}
	}

	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		try {
			Department d=departmentRepository.findById(id).get();
			departmentRepository.delete(d);
			return "Successful";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error "+e;
		}
	}

}
