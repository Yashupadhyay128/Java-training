package Assignment9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EMS empManagement = new EMS();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Employee Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    empManagement.addEmployee(new Employee(id, name, salary));
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.println("All Employees:");
                    empManagement.displayAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new Employee Name: ");
                    sc.nextLine();
                    String updateName = sc.nextLine();
                    System.out.print("Enter new Employee Salary: ");
                    double updateSalary = sc.nextDouble();
                    empManagement.updateEmployee(updateId, updateName, updateSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    empManagement.deleteEmployee(deleteId);
                    System.out.println("Employee with ID " + deleteId + " deleted.");
                    break;

                case 5:
                    System.out.println("Exiting Employee Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

