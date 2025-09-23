package iuh.fit.tuan_javabeann.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    public String password;
    private Group group;
}
