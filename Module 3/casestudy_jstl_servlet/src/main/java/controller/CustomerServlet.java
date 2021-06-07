package controller;


import commons.*;
import model.bean.Customer;
import model.bean.CustomerType;
import model.service.ICustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService;
    private List<CustomerType> customerTypeList;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
        customerTypeList = customerService.selectAllCustomerTypes();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteFrom(request, response);
                break;
            case "search":
                findByName(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code;
        do {
            code = request.getParameter("code");
        } while (!Validators.inputValidate(code,Validators.CUSTOMER_REGEX));
        int typeId = Integer.parseInt(request.getParameter("type_id"));
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        Byte gender = Byte.parseByte(request.getParameter("gender"));
        String idNumber;
        do {
            idNumber = request.getParameter("id_number");
        } while (!Validators.inputValidate(idNumber, Validators.ID_NUMBER_REGEX));
        String phoneNumber;
        do {
            phoneNumber = request.getParameter("phone_number");
        } while (!Validators.inputValidate(phoneNumber, Validators.PHONE_NUMBER_REGEX));
        String email;
        do {
            email = request.getParameter("email");
        } while (!Validators.inputValidate(email,Validators.EMAIL_REGEX));
        String address = request.getParameter("address");
        int count = 0;
        List<Customer> customerList = customerService.selectAllCustomer();
        for (Customer customer : customerList) {
            if (id == customer.getId()) {
                count++;
            }
        }
        if (count!=0) {
            request.setAttribute("message_error", "ID is not available!! The creation is not successful!");
        } else {
            Customer newCustomer = new Customer(id, code, typeId, name, birthdate, gender, idNumber, phoneNumber, email, address);
            customerService.insertCustomer(newCustomer);
            request.setAttribute("message", "Successfully Created!");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/create-customer.jsp");
        request.setAttribute("customerTypes", customerTypeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create-customer.jsp");
        request.setAttribute("customerTypes", customerTypeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code;
        do {
           code = request.getParameter("code");
        }  while (!Validators.inputValidate(code,Validators.CUSTOMER_REGEX));
        int typeId = Integer.parseInt(request.getParameter("type_id"));
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        Byte gender = Byte.parseByte(request.getParameter("gender"));
        String idNumber;
        do {
            idNumber = request.getParameter("id_number");
        } while (!Validators.inputValidate(idNumber, Validators.ID_NUMBER_REGEX));
        String phoneNumber;
        do {
            phoneNumber = request.getParameter("phone_number");
        } while (!Validators.inputValidate(phoneNumber, Validators.PHONE_NUMBER_REGEX));
        String email;
        do {
            email = request.getParameter("email");
        } while (!Validators.inputValidate(email,Validators.EMAIL_REGEX));
        String address = request.getParameter("address");
        Customer customer = new Customer(id, code, typeId, name, birthdate, gender, idNumber, phoneNumber, email, address);
        boolean check = customerService.updateCustomer(customer);
        if (check) {
            request.setAttribute("message", "Successfully Edited The Customer!");
        } else {
            request.setAttribute("message", "Not Successful");
        }
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypes", customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/edit-customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/customer/edit-customer.jsp");
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypes", customerTypeList);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer deletedCustomer = customerService.selectCustomer(id);
        RequestDispatcher requestDispatcher;
        if (deletedCustomer == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/customer/list-customer.jsp");
            request.setAttribute("deleted_customer", deletedCustomer);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Customer> customerList = customerService.findByName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list-customer.jsp");
        request.setAttribute("customers", customerList);
        request.setAttribute("customerTypes", customerTypeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list-customer.jsp");
        request.setAttribute("customers", customerList);
        request.setAttribute("customerTypes", customerTypeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

