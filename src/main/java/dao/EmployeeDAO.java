package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    void save(Employee employee);

    Employee getEmployeeById(int id);

    void update(Employee employee);

    void delete(Employee employee);
}
