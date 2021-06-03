package controller;


import model.bean.Customer;
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
    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
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
                showDeleteFrom(request,response);
                break;
            case "search":
                findByName(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        Byte gender = Byte.parseByte(request.getParameter("gender"));
        String id_number = request.getParameter("id_number");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id,type_id,name,birthdate,gender,id_number,phone_number,email,address);
        customerService.insertCustomer(newCustomer);
        request.setAttribute("message","Successfully Created!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/create-customer.jsp");
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
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        Byte gender = Byte.parseByte(request.getParameter("gender"));
        String id_number = request.getParameter("id_number");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id,type_id,name,birthdate,gender,id_number,phone_number,email,address);
        boolean check = customerService.updateCustomer(customer);
        if (check) {
            request.setAttribute("message","Successfully Edited The Customer!");
        } else {
            request.setAttribute("message","Not Successful");
        }
        request.setAttribute("customer",customer);
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
            request.setAttribute("customer",customer);
        }
        try {
            requestDispatcher.forward(request,response);
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
            request.setAttribute("deleted_customer",deletedCustomer);
        }
        try {
            requestDispatcher.forward(request,response);
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
        request.setAttribute("customers",customerList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list-customer.jsp");
        request.setAttribute("customers",customerList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

