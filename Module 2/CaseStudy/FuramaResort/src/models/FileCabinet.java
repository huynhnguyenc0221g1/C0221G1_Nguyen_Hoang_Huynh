package models;

import commons.ReadEmployee;

import java.util.List;
import java.util.Stack;

public class FileCabinet {
    private static String EMPLOYEE = "employee";
    public static Stack<Employee> getFileCabinet() {
        Stack<Employee> fileCabinet = new Stack<>();
        List<Employee> employeeList = ReadEmployee.readEmployee(EMPLOYEE);
        for (Employee employee : employeeList) {
            fileCabinet.push(employee);
        }
        return fileCabinet;
        }
    }
