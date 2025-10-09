package iuh.fit.lab7;

import iuh.fit.lab7.models.Employee;
import iuh.fit.lab7.repositiories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Lab7Application {
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab7Application.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            List<Employee> allEmployees = employeeRepository.getAll();
            allEmployees.forEach(e -> System.out.println(e));
        };
    }

}
