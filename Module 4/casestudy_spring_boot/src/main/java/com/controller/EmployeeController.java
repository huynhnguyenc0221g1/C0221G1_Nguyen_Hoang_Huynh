package com.controller;

import com.dto.EmployeeDto;
import com.model.entity.employee.Division;
import com.model.entity.employee.Education;
import com.model.entity.employee.Employee;
import com.model.entity.employee.Position;
import com.model.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("divisions")
    public List<Division> divisionList(){
        return employeeService.listDivision();
    }
    @ModelAttribute("positions")
    public List<Position> positionList(){
        return employeeService.listPosition();
    }
    @ModelAttribute("educations")
    public List<Education> educationDegreeList(){
        return employeeService.listEducation();
    }

    @GetMapping(value = "")
    public ModelAndView goList(@RequestParam("keyWord") Optional<String> keyWork,
                               @RequestParam("page") Optional<Integer> page){
        Pageable pageable = PageRequest.of(page.orElse(0),5);
        Page<Employee> employees = this.employeeService.findAll(keyWork.orElse(""),pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list","employees",employees);
        modelAndView.addObject("keyWord",keyWork.orElse(""));
        return modelAndView;
    }

    @GetMapping(value = "create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("employee/create",
                "employeeDto",new EmployeeDto());
        return modelAndView;
    }

    @PostMapping(value = "create")
    public String createEmployee(@ModelAttribute @Valid EmployeeDto employeeDto,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","create successfully");
        return "redirect:/employees";
    }

    @GetMapping(value = "edit")
    public String showFormEdit(@RequestParam Long id, Model model){
        Employee employee = this.employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "employee/edit";
    }

    @PostMapping(value = "edit")
    public String editEmployee(@ModelAttribute @Valid EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","edit successfully");
        return "redirect:/employees";
    }

    @PostMapping(value = "delete")
    public String deleteEmployee(@RequestParam Long id,RedirectAttributes redirectAttributes){
        this.employeeService.remove(id);
        redirectAttributes.addFlashAttribute("msg","delete successfully");
        return "redirect:/employees";
    }
}
