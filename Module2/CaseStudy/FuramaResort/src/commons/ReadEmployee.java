package commons;

import models.Customer;
import models.Employee;

import java.util.ArrayList;
import java.util.List;

public class ReadEmployee {
    private static String CUSTOMER = "customer";
    public static List<Employee> readEmployee(String fileName) {
        IOFile.setFilePath(fileName);
        List<String> dataEmployee = IOFile.readFile();
        List<Employee> employeeList = new ArrayList<>();
        String[] arrayDataEmployee = null;
        Employee employee = null;
        for (String data : dataEmployee) {
            arrayDataEmployee = data.split(IOString.COMMA);
            employee = new Employee();
            employee.setEmployeeName(arrayDataEmployee[0]);
            employee.setEmployeeAge(Integer.parseInt(arrayDataEmployee[1]));
            employee.setEmployeeAddress(arrayDataEmployee[2]);
            employeeList.add(employee);
        }
        return employeeList;
    }
}
