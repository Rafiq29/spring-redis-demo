package com.herb.springredisdemo.repo;

import com.herb.springredisdemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface EmployeeDao {
    void saveEmployee(Employee emp);
    Employee getOneEmployee(Integer id);
    void updateEmployee(Employee emp);
    Map<Integer, Employee> getAllEmployees();
    void deleteEmployee(Integer id);
    void saveAllEmployees(Map<Integer, Employee> map);
}
