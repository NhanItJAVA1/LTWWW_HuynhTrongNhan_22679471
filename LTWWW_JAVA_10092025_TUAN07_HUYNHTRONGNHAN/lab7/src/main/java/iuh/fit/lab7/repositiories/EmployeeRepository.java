package iuh.fit.lab7.repositiories;

import iuh.fit.lab7.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Employee(
                rs.getString("id"),
                rs.getString("role"),
                rs.getString("name")
        ));
    }

    public void save(Employee employee){
        String sql = "INSERT INTO employee (id, role, name) values (?, ?, ?)";
        jdbcTemplate.update(sql,employee.getId(),employee.getRole(),employee.getName());
    }

    public Employee getById(int id){
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,(rs, rowNum) -> new Employee(
                rs.getString("id"),
                rs.getString("role"),
                rs.getString("name")
        ), id);
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Employee employee) {
        String sql = "UPDATE employee SET role = ?, name = ? WHERE id = ?";
        jdbcTemplate.update(sql,employee.getRole(), employee.getName(), employee.getId());
    }
}
