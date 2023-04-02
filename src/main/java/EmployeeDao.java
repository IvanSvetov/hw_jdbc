import service.Employee;

import java.util.List;

public interface EmployeeDao {

    void add(Employee employee);

    Employee getByID(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
