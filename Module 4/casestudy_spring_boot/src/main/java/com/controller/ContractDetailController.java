package com.controller;

import com.model.entity.contract.Contract;
import com.model.entity.contractDetail.AttachService;
import com.model.entity.contractDetail.ContractDetail;
import com.model.repository.contract.IContractRepository;
import com.model.service.IContractDetailService;
import com.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "details")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IContractService contractService;

    @ModelAttribute("contracts")
    public Iterable<Contract> contractLists(){
        return contractService.fillAll();
    }

    @ModelAttribute("attachServices")
    public List<AttachService> attachServices(){
        return contractDetailService.listAttachService();
    }

    @GetMapping(value = "create")
    public String showFormCreate(Model model){
        model.addAttribute("contractDetail",new ContractDetail());
        return "contractDetail/create";
    }

    @PostMapping(value = "create")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail,
                                       Model model){
        this.contractDetailService.save(contractDetail);
        model.addAttribute("msg","create successfully");
        return "contractDetail/create";
    }

}
