package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.Employee;
import tserkovnikov.com.cleanplanetapp.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Employee getByNameAndPassword(String name, String password) {
        return repository.findByFullNameAndPassword(name, password);
    }
}
