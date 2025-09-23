package iuh.fit.tuan_javabeann.service;

import iuh.fit.tuan_javabeann.models.Group;
import iuh.fit.tuan_javabeann.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserService {
    @Bean
    public Group groupService() {
        return new Group(1, "HEHEHE");
    }

    @Bean(name = "Nhan")
    public User userService() {
        return new User(1, "Nhan", "sapassword", groupService());
    }
    @Bean
    public List<User> userServiceList() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "Nhan", "sapassword", groupService()));
        users.add(new User(2, "Nhan2", "sapassword", groupService()));
        return users;
    }


}
