import service.City;

import java.util.List;

public interface CityDao {
    City add(City city);
    City getByID(int id);
    List<City> getAllCity();
    City updateCity(City city);
    void deleteCity(City city);
}
