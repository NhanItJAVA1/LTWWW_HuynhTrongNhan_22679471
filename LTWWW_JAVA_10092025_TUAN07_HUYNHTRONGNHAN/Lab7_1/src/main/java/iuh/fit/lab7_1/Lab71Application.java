package iuh.fit.lab7_1;

import iuh.fit.lab7_1.models.Employee;
import iuh.fit.lab7_1.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab71Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab71Application.class, args);
    }

    @Bean
    CommandLineRunner run(EmployeeRepository employeeRepository) {
        return args -> {
            Employee emp = new Employee("N9824", "Developer", "Nhan");
            if (!employeeRepository.existsById(emp.getId())) {
                employeeRepository.save(emp);
                System.out.println("Saved: " + emp);
            }

            List<Employee> employees = employeeRepository.findAll();
            System.out.println("All employees:");
            employees.forEach(System.out::println);

            Optional<Employee> found = employeeRepository.findById("N9824");
            found.ifPresent(e -> System.out.println("Found by ID: " + e));

            found.ifPresent(e -> {
                e.setName("Alice Updated");
                employeeRepository.save(e);
                System.out.println("Updated: " + e);
            });

//            employeeRepository.deleteById("N9824");
//            System.out.println("Deleted employee with ID E001");
        };
    }
}
