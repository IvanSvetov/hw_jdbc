import service.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    void add(Employee employee);

    Employee getByID(int id) throws SQLException;

    List<Employee> getAllEmployee();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
