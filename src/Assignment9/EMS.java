package Assignment9;

import java.util.ArrayList;
import java.util.List;

public class EMS {
    private List<Employee> employees;

    public EMS() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(int id, String name, double salary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setSalary(salary);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void deleteEmployee(int id) {
        List<Employee> employeeList = employees.stream().filter(employee -> String.valueOf(employee.getId()).equals(String.valueOf(id))).toList();
        if (employeeList.isEmpty()) {
            System.out.println("Employee doesn't exist with ID: " + id);
        } else {
            employees.removeIf(employee -> employee.getId() == id);
            System.out.println("Employee with ID " + id + " deleted.");
        }
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees present!");
        } else {
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Salary: " + employee.getSalary());
            }
        }
    }
}
