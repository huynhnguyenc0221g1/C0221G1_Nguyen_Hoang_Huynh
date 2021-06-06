package controller;


import model.bean.Contract;
import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.repository.CustomerRepository;
import model.repository.EmployeeRepository;
import model.repository.ServiceRepository;
import model.service.IContractService;
import model.service.impl.ContractServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = {"/contract"})
public class ContractServlet extends HttpServlet {
    private IContractService contractService;
    private List<Service> serviceList;
    private List<Employee> employeeList;
    private List<Customer> customerList;
    @Override
    public void init() throws ServletException {
        contractService = new ContractServiceImpl();
        serviceList = new ServiceRepository().selectAllService();
        employeeList = new EmployeeRepository().selectAllEmployee();
        customerList = new CustomerRepository().selectAllCustomers();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request,response);
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
            default:
                break;
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        int serviceId = Integer.parseInt(request.getParameter("service_id"));
        String madeDate = request.getParameter("made_date");
        String endDate = request.getParameter("end_date");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("total_money"));
        Contract newContract = new Contract(id,employeeId,customerId,serviceId,madeDate,endDate,deposit,totalMoney);
        contractService.insertContract(newContract);
        request.setAttribute("message","Successfully Created!");
        request.setAttribute("services", serviceList);
        request.setAttribute("employees", employeeList);
        request.setAttribute("customers", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/contract/create-contract.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/create-contract.jsp");
        request.setAttribute("services", serviceList);
        request.setAttribute("employees", employeeList);
        request.setAttribute("customers", customerList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}

