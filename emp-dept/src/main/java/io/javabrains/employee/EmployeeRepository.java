package io.javabrains.employee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
			public List<Employee> findByDepartmentId(Long deptId);
			public Employee findByDepartmentIdAndId(Long id,Long eid);
}
