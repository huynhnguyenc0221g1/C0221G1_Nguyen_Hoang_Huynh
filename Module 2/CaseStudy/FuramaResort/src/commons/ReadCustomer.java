package commons;

import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class ReadCustomer {
    private static String CUSTOMER = "customer";

    public static List<Customer> readCustomer(String fileName) {
        IOFile.setFilePath(fileName);
        List<String> dataCustomer = IOFile.readFile();
        List<Customer> customersList = new ArrayList<>();
        String[] arrayDataCustomer = null;
        Customer customer = null;
        for (String data : dataCustomer) {
            arrayDataCustomer = data.split(IOString.COMMA);
            customer = new Customer();
            customer.setFullName(arrayDataCustomer[0]);
            customer.setDateOfBirth(arrayDataCustomer[1]);
            customer.setGender(arrayDataCustomer[2]);
            customer.setIdNumber(arrayDataCustomer[3]);
            customer.setPhoneNumber(arrayDataCustomer[4]);
            customer.setEmail(arrayDataCustomer[5]);
            customer.setTypeOfCustomer(arrayDataCustomer[6]);
            customer.setAddress(arrayDataCustomer[7]);
            customersList.add(customer);
        }
        return customersList;
    }
}
