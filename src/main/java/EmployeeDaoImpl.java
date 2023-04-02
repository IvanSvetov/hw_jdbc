import service.City;
import service.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    final String user = "postgres";
    final String password = "16534708";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void add(Employee employee) {
        try (
                PreparedStatement statement = DriverManager.getConnection(url, user, password).prepareStatement(
                        "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ( (?), (?), (?), (?), (?))");) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getByID(int id) {

        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (
                PreparedStatement statement= DriverManager.getConnection(url, user, password). prepareStatement(
                        "SELECT * FROM employee INNER JOIN city " +
                        "ON employee.city_id = city.city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = Integer.parseInt(resultSet.getString("age"));
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name"));
                employees.add(new Employee(id, firstName, lastName, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try (
                PreparedStatement statement = DriverManager.getConnection(url, user, password).prepareStatement(
                        "UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?), WHERE id = (?)")) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (
                PreparedStatement statement = DriverManager.getConnection(url, user, password).prepareStatement(
                        "DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
