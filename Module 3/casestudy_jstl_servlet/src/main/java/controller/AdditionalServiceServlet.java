package controller;


import model.bean.AdditionalService;
import model.bean.Customer;
import model.service.IAdditionalServiceService;
import model.service.impl.AdditionalServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdditionalServiceServlet", urlPatterns = {"/additional-service"})
public class AdditionalServiceServlet extends HttpServlet {
    private IAdditionalServiceService additionalServiceService;
    @Override
    public void init() throws ServletException {
        additionalServiceService = new AdditionalServiceServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editAdditionalService(request,response);
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
            case "edit":
                showEditForm(request, response);
                break;
            default:
                break;
        }
    }

    private void editAdditionalService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int unit = Integer.parseInt(request.getParameter("unit"));
        String status = request.getParameter("status");
        AdditionalService additionalService = new AdditionalService(id,name,price,unit,status);
        boolean check = additionalServiceService.updateAdditionalService(additionalService);
        if (check) {
            request.setAttribute("message","Successfully Edited The Additional Service!");
        } else {
            request.setAttribute("message","Not Successful");
        }
        request.setAttribute("additional_service",additionalService);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/additional_service/edit-additional-service.jsp");
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
        AdditionalService additionalService = additionalServiceService.selectAdditionalService(id);
        RequestDispatcher requestDispatcher;
        if (additionalService == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/additional_service/edit-additional-service.jsp");
            request.setAttribute("additional_service",additionalService);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

