package proSky.EmployeeBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proSky.EmployeeBook.model.Employee;
import proSky.EmployeeBook.service.EmployeeService;
import proSky.EmployeeBook.service.EmployeeServiceImpl;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void testAddEmployee() {
        Employee employee = employeeService.add("Ivan", "Ivanov", 2, 12345.6f);
        assertNotNull(employee);
        assertEquals("Ivan", employee.getFirstName());
        assertEquals("Ivanov", employee.getLastName());
        assertEquals(2, employee.getDep());
        assertEquals(12345.6f, employee.getSalary());
    }

    @Test
    void testRemoveEmployee() {
        employeeService.add("Ivan", "Ivanov", 2, 12345.6f);
        Employee removed = employeeService.remove("Ivan", "Ivanov", 2, 12345.6f);
        assertNotNull(removed);
        assertEquals("Ivan", removed.getFirstName());
        assertEquals("Ivanov", removed.getLastName());
        assertEquals(2, removed.getDep());
        assertEquals(12345.6f, removed.getSalary());
    }

    @Test
    void testFindEmployee() {
        employeeService.add("Ivan", "Ivanov", 2, 12345.6f);
        Employee find = employeeService.find("Ivan", "Ivanov", 2, 12345.6f);
        assertNotNull(find);
        assertEquals("Ivan", find.getFirstName());
        assertEquals("Ivanov", find.getLastName());
        assertEquals(2, find.getDep());
        assertEquals(12345.6f, find.getSalary());
    }

    @Test
    void testEmployeeException() {
        employeeService.add("Ivan", "Ivanov", 2, 12345.6f);

        assertThrows(RuntimeException.class, () -> employeeService.add("Ivan", "Ivanov", 2, 12345.6f));
        assertThrows(RuntimeException.class, () -> employeeService.find("Petr", "Petrov", 2, 12345.6f));
        assertThrows(RuntimeException.class, () -> employeeService.remove("Petr", "Petrov", 2, 12345.6f));
    }

    @Test
    void testFindAll() {
        employeeService.add("Ivan", "Ivanov", 1, 12345.6f);
        employeeService.add("Petr", "Petrov", 2, 234.5f);

        Collection<Employee> employees = employeeService.findAll();
        assertEquals(2, employees.size());
    }
}
