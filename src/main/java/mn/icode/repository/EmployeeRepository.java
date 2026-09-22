package mn.icode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee updateEmployee(Long id, Employee employee);

}
