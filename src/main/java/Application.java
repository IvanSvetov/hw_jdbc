import service.Employee;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao cityDao = new CityDaoImpl();


        /*employeeDao.getByID(2);
        cityDao.add(new City(1, "Moscow", null));*/
        /*employeeDao.add(new Employee(3, "TEST", "TEST", "m", 32, cityDao.getByID(1)));*/
        /*employeeDao.add(new Employee(3, "Tom", "Holland", "m", 26, cityDao.getByID(2)));*/

        /*cityDao.updateCity(cityDao.getByID(1));*/

        employeeDao.getAllEmployee().forEach(System.out::println);

        Employee test = employeeDao.getByID(7);
                test.setCity(cityDao.getByID(2));
        employeeDao.updateEmployee(7, test);

        System.out.println(cityDao.getAllCity());

        /*cityDao.getByID(2).setCity_name("SPB)");
        cityDao.updateCity(new City(2, "Saint-Petersburg", null));*/

    }
}
