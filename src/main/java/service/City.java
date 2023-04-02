package service;

import lombok.*;

@Getter
@Setter

public class City {
    private int city_id;
    private String city_name;

    public City(int city_id, String city_name) {
    }
}
