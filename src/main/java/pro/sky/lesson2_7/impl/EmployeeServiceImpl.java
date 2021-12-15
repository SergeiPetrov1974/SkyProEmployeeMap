package pro.sky.lesson2_7.impl;

import org.springframework.stereotype.Service;
import pro.sky.lesson2_7.data.Employee;
import pro.sky.lesson2_7.exception.DuplicateEmployeeException;
import pro.sky.lesson2_7.exception.EmployeeNotFoundException;
import pro.sky.lesson2_7.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap = new HashMap<>();



    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(firstName + " " + lastName);
        if (employee == null) {
            Employee newEmployee = new Employee(firstName, lastName);
            employeeMap.put(firstName + " " + lastName, newEmployee);
            return newEmployee;
        }

        throw new DuplicateEmployeeException("Такой сотрудник есть");
    }


    @Override
    public Employee getEmployee(String firstName, String lastName) {
        String key = getKeyString(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKeyString(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.remove(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getEmployeeMap() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

    private String getKeyString(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}