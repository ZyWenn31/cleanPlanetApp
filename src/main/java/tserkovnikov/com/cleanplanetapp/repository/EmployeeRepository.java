package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFullNameAndPassword(String username, String password);
}
