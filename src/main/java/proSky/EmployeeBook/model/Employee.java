package proSky.EmployeeBook.model;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private String firstName;
    private String lastName;// фамилия
    private int dep;
    private float salary;

    // Конструктор
    public Employee(String firstName, String lastName, int dep, float salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.dep = dep;
        this.salary = salary;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDep() {
        return dep;
    }

    public float getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return dep == employee.dep && Float.compare(employee.salary, salary) == 0 && Objects.equals(firstName,
                employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dep, salary);
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", departament=" + dep + ", salary=" + salary + '}';
    }
}

