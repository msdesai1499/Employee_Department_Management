package io.javabrains.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/department")
	public String addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	
	@RequestMapping("/departments")
	public List<Department> getDepartments(){
		return departmentService.getDepartments();
	}
	
	@RequestMapping("/department/{id}")
	public Department getDepartment(@PathVariable String id) {
		return departmentService.getDepartment(Long.parseLong(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/department")
	public String updateDepartment(@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/department/{id}")
	public String deleteDepartment(@PathVariable String id) {
		return departmentService.deleteDepartment(Long.parseLong(id));
	}
	
}
