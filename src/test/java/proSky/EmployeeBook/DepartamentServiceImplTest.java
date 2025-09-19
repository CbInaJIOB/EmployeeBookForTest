package proSky.EmployeeBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import proSky.EmployeeBook.model.Employee;
import proSky.EmployeeBook.service.DepartamentServiceImpl;
import proSky.EmployeeBook.service.EmployeeServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartamentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartamentServiceImpl departamentService;

    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = new ArrayList<>(List.of(
                new Employee("Люк", "Бессон", 1, 120.0F),
                new Employee("Джейсон", "Стетхем", 1, 130.0F),
                new Employee("Жан", "Рено", 2, 120.0F),
                new Employee("Жерар", "Депардье", 2, 100.0F)));
    }

    @Test
    void testSumSalary() {
        when(departamentService.byDep(1)).thenReturn(Arrays.asList(employees.get(0), employees.get(1)));
        String result = departamentService.sumSalary(1);

        assertEquals("Сумма зарплат по департаменту №" + 1 + " составляет " + 250.0, result);
    }

    @Test
    void testMaxSalary() {
        when(departamentService.byDep(1)).thenReturn(Arrays.asList(employees.get(0), employees.get(1)));
        Employee result = departamentService.max(1);

        assertEquals(employees.get(1), result);
    }

    @Test
    void testMaxSalaryByEmptyDep() {
        when(departamentService.byDep(48)).thenReturn(Arrays.asList(employees.get(0), employees.get(1)));

        assertThrows(RuntimeException.class, () -> departamentService.max(48));
    }

    @Test
    void testMinSalary() {
        when(departamentService.byDep(1)).thenReturn(Arrays.asList(employees.get(0), employees.get(1)));
        Employee result = departamentService.min(1);

        assertEquals(employees.get(0), result);
    }

    @Test
    void testMinSalaryByEmptyDep() {
        when(departamentService.byDep(48)).thenReturn(Arrays.asList(employees.get(0), employees.get(1)));

        assertThrows(RuntimeException.class, () -> departamentService.min(48));
    }

    @Test
    void testByDep() {
        when(departamentService.byDep(1)).thenReturn(Arrays.asList(employees.get(0), employees.get(1)));
        Collection<Employee> result = departamentService.byDep(1);

        assertEquals(departamentService.byDep(1), result);
    }

    @Test
    void testAll() {
        when(employeeService.getEmployeeList()).thenReturn(employees);
        Map<Integer, List<Employee>> result = departamentService.all();

        assertEquals(departamentService.all(),result);
    }

}
