package iuh.fit.tuan_javabeann;

import iuh.fit.tuan_javabeann.models.User;
import iuh.fit.tuan_javabeann.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserService.class);
        User user = (User) context.getBean("Nhan");
        System.out.println(user);
        ArrayList<User> users = (ArrayList<User>) context.getBean("userServiceList");
        System.out.println(users);

    }
}
