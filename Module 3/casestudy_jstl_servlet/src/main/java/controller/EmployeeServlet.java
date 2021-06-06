package controller;

import model.bean.Department;
import model.bean.Employee;
import model.bean.Position;
import model.bean.Qualification;
import model.service.IEmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService;
    private List<Position> positionList;
    private List<Qualification> qualificationList;
    private List<Department> departmentList;
    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
        positionList = employeeService.selectAllPositions();
        qualificationList = employeeService.selectAllQualifications();
        departmentList = employeeService.selectAllDepartments();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
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

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int qualificationId = Integer.parseInt(request.getParameter("qualification_id"));
        int departmentId = Integer.parseInt(request.getParameter("department_id"));
        String birthdate = request.getParameter("birthdate");
        String idNumber = request.getParameter("id_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        Employee newEmployee = new Employee(id,name,positionId,qualificationId,departmentId,birthdate,idNumber,salary,phoneNumber,email,address,username);
        employeeService.insertEmployee(newEmployee);
        request.setAttribute("message","Successfully Created!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/create-employee.jsp");
        request.setAttribute("positions",positionList);
        request.setAttribute("qualifications",qualificationList);
        request.setAttribute("departments",departmentList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create-employee.jsp");
        request.setAttribute("positions",positionList);
        request.setAttribute("qualifications",qualificationList);
        request.setAttribute("departments",departmentList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int qualificationId = Integer.parseInt(request.getParameter("qualification_id"));
        int departmentId = Integer.parseInt(request.getParameter("department_id"));
        String birthdate = request.getParameter("birthdate");
        String idNumber = request.getParameter("id_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        Employee employee = new Employee(id,name,positionId,qualificationId,departmentId,birthdate,idNumber,salary,phoneNumber,email,address,username);
        boolean check = employeeService.updateEmployee(employee);
        if (check) {
            request.setAttribute("message","Successfully Edited The Customer!");
        } else {
            request.setAttribute("message","Not Successful");
        }
        request.setAttribute("employee",employee);
        request.setAttribute("positions",positionList);
        request.setAttribute("qualifications",qualificationList);
        request.setAttribute("departments",departmentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/edit-employee.jsp");
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
        Employee employee = employeeService.selectEmployee(id);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/employee/edit-employee.jsp");
            request.setAttribute("employees",employee);
            request.setAttribute("positions",positionList);
            request.setAttribute("qualifications",qualificationList);
            request.setAttribute("departments",departmentList);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee deletedEmployee = employeeService.selectEmployee(id);
        RequestDispatcher requestDispatcher;
        if (deletedEmployee == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/employee/list-employee.jsp");
            request.setAttribute("deleted_employee",deletedEmployee);
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
        List<Employee> employeeList = employeeService.findByName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/list-employee.jsp");
        request.setAttribute("employees",employeeList);
        request.setAttribute("positions",positionList);
        request.setAttribute("qualifications",qualificationList);
        request.setAttribute("departments",departmentList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/list-employee.jsp");
        request.setAttribute("employees",employeeList);
        request.setAttribute("positions",positionList);
        request.setAttribute("qualifications",qualificationList);
        request.setAttribute("departments",departmentList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

