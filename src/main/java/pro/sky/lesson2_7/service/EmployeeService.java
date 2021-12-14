package pro.sky.lesson2_7.service;

import pro.sky.lesson2_7.data.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Collection<Employee> getEmployeeMap();
}
