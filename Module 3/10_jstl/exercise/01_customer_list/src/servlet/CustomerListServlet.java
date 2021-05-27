package servlet;

import models.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet", urlPatterns = {"/customer" , ""})
public class CustomerListServlet extends HttpServlet {
    List<Customer> customerList = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Chau","24-07-2000","Daklak","https://cdn2.iconfinder.com/data/icons/user-23/512/User_Generic_3.png"));
        customerList.add(new Customer("Hoa","19-11-1999","Danang","https://icon-library.com/images/generic-user-icon/generic-user-icon-10.jpg"));
        customerList.add(new Customer("Hien","19-05-2000","Quang Tri","https://cdn4.iconfinder.com/data/icons/isometrix/28/user-512.png"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers",customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer-list.jsp");
        requestDispatcher.forward(request,response);
    }
}
