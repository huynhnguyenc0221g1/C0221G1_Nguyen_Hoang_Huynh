package controller;


import commons.Validators;
import model.bean.Customer;
import model.bean.RentOption;
import model.bean.Service;
import model.bean.ServiceType;
import model.service.IServiceService;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {
    private IServiceService serviceService;
    private List<ServiceType> serviceTypeList;
    private List<RentOption> rentOptionList;

    @Override
    public void init() throws ServletException {
        serviceService = new ServiceServiceImpl();
        serviceTypeList = serviceService.selectAllServiceTypes();
        rentOptionList = serviceService.selectAllRentOption();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                editService(request, response);
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
            default:
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code;
        do {
            code = request.getParameter("code");
        } while (!Validators.inputValidate(code,Validators.SERVICE_REGEX));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxInHouse = Integer.parseInt(request.getParameter("max_in_house"));
        int rentOptionId = Integer.parseInt(request.getParameter("rent_option_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standard = request.getParameter("standard");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
        Service newService = new Service(id,code, name, area, cost, maxInHouse, rentOptionId, serviceTypeId, standard, description, poolArea, numberOfFloors);
        serviceService.insertService(newService);
        request.setAttribute("message", "Successfully Created!");
        request.setAttribute("serviceTypes", serviceTypeList);
        request.setAttribute("rentOptions", rentOptionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/create-service.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("serviceTypes", serviceTypeList);
        request.setAttribute("rentOptions", rentOptionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create-service.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code;
        do {
            code = request.getParameter("code");
        } while (!Validators.inputValidate(code,Validators.SERVICE_REGEX));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxInHouse = Integer.parseInt(request.getParameter("max_in_house"));
        int rentOptionId = Integer.parseInt(request.getParameter("rent_option_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standard = request.getParameter("standard");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
        Service service = new Service(id,code, name, area, cost, maxInHouse, rentOptionId, serviceTypeId, standard, description, poolArea, numberOfFloors);
        boolean check = serviceService.updateService(service);
        if (check) {
            request.setAttribute("message", "Successfully Edited The Service!");
        } else {
            request.setAttribute("message", "Not Successful");
        }
        request.setAttribute("service", service);
        request.setAttribute("serviceTypes", serviceTypeList);
        request.setAttribute("rentOptions", rentOptionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/edit-service.jsp");
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
        Service service = serviceService.selectServiceById(id);
        RequestDispatcher requestDispatcher;
        if (service == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/service/edit-service.jsp");
            request.setAttribute("service", service);
            request.setAttribute("serviceTypes", serviceTypeList);
            request.setAttribute("rentOptions", rentOptionList);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.selectAllService();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/list-service.jsp");
        request.setAttribute("services", serviceList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

