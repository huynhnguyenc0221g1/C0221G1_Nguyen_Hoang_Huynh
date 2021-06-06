package controller;


import model.bean.Customer;
import model.bean.CustomerWithServices;
import model.service.ICustomerWithServicesService;
import model.service.impl.CustomerWithServicesServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerWithServicesServlet", urlPatterns = {"/customer-with-services"})
public class CustomerWithServicesServlet extends HttpServlet {
    private ICustomerWithServicesService customerWithServicesService;
    @Override
    public void init() throws ServletException {
        customerWithServicesService = new CustomerWithServicesServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
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
            case "search":
                findByName(request,response);
                break;
            default:
                listCustomerWithServices(request,response);
                break;
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<CustomerWithServices> customerWithServicesList = customerWithServicesService.selectAllCustomerWithServices();
        List<CustomerWithServices> searchedList = new ArrayList<>();
        for (CustomerWithServices customer : customerWithServicesList) {
            if (customer.getCustomerName().equals(search)) {
                searchedList.add(customer);
            }
        }
        request.setAttribute("customers",searchedList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/customer-with-services.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void listCustomerWithServices(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerWithServices> customerWithServicesList = customerWithServicesService.selectAllCustomerWithServices();
        request.setAttribute("customers",customerWithServicesList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/customer-with-services.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

