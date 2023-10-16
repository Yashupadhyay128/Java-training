package Assignment2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculator App");
        System.out.println("Enter the first number:");
        int num1 = sc.nextInt();
        System.out.println("Enter the second number:");
        int num2 = sc.nextInt();
        System.out.println("+ : Addition");
        System.out.println("- : Subtraction");
        System.out.println("* : Multiplication");
        System.out.println("/ : Division");
        System.out.println("Select the operation you want to perform: ");
        String choice = sc.next();
        try {
            switch (choice) {
                case "+":
                    System.out.println("Result of " + num1 + " " + choice + " " + num2 + " is " + (num1+num2));
                    break;
                case "-":
                    System.out.println("Result of " + num1 + " " + choice + " " + num2 + " is " + (num1-num2));
                    break;
                case "*":
                    System.out.println("Result of " + num1 + " " + choice + " " + num2 + " is " + (num1*num2));
                    break;
                case "/":
                    System.out.println("Result of " + num1 + " " + choice + " " + num2 + " is " + (num1/num2));
                    break;
                default:
                    System.out.println("Enter a Valid Input");
            }
        } catch (ArithmeticException e){
            System.out.println("An ArithmeticException occurred: " + e.getMessage());
        }
    }
}
