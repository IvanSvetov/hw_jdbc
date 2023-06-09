package service;
import lombok.*;


@AllArgsConstructor
@Data

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private City city;
}

