package io.javabrains.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.department.Department;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/department/{departmentId}/employee")
	public String addEmployee(@RequestBody Employee employee,@PathVariable String departmentId) {
		employee.setDepartment(new Department(Long.parseLong(departmentId),""));
		return employeeService.addEmployee(employee);
	}
	
	@RequestMapping("/department/{id}/employees")
	public List<Employee> getEmployees(@PathVariable String id){
		return employeeService.getEmployees(Long.parseLong(id));
	}
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployeses();
	}

	
	@RequestMapping("/department/{deptId}/employee/{id}")
	public Employee getEmployee(@PathVariable String deptId,@PathVariable String id) {
		return employeeService.getEmployee(Long.parseLong(deptId),Long.parseLong(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/employee")
	public String updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/employee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(Long.parseLong(id));
	}
	
}
