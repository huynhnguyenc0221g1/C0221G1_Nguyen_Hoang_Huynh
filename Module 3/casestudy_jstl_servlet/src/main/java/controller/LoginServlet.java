package controller;


import model.bean.AdditionalService;
import model.service.IAdditionalServiceService;
import model.service.impl.AdditionalServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("itphutran".equals(username)){
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/main.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login.jsp?error=0");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
    }

}

