package iuh.fit.lab7.daos;

import iuh.fit.lab7.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    void update(Employee employee);
    List<Employee> getAll();
    Employee getById(int id);
    void deleteById(int id);
    void save(Employee employee);

}
