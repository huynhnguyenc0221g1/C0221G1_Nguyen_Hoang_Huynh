package controller;


import model.bean.*;
import model.repository.ContractDetailRepository;
import model.repository.ContractRepository;
import model.service.IContractDetailService;
import model.service.impl.ContractDetailServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = {"/contract-detail"})
public class ContractDetailServlet extends HttpServlet {
    private IContractDetailService contractDetailService;
    private List<Contract> contractList;
    private List<AdditionalService> additionalServiceList;

    @Override
    public void init() throws ServletException {
        contractDetailService = new ContractDetailServiceImpl();
        contractList = new ContractRepository().selectAllContracts();
        additionalServiceList = new ContractDetailRepository().selectAllAdditionalServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
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

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int contractId = Integer.parseInt(request.getParameter("contract_id"));
        int additionalServiceId = Integer.parseInt(request.getParameter("additional_service_id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        ContractDetail newContractDetail = new ContractDetail(id, contractId, additionalServiceId, amount);
        contractDetailService.insertContractDetail(newContractDetail);
        request.setAttribute("message", "Successfully Created!");
        request.setAttribute("contracts", contractList);
        request.setAttribute("additionalServices", additionalServiceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/contract_detail/create-contract-detail.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contracts", contractList);
        request.setAttribute("additionalServices", additionalServiceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract_detail/create-contract-detail.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}

