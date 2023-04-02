package service;

import lombok.*;

@Getter
@Setter

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private City city;


    public Employee(int id, String firstName, String lastName, String gender, int age, City city) {
    }
}
