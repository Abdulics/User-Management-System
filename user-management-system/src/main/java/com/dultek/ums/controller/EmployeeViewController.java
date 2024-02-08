package com.dultek.ums.controller;

import com.dultek.ums.model.Address;
import com.dultek.ums.model.Employee;
import com.dultek.ums.model.UserCredentials;
import com.dultek.ums.model.UserRole;
import com.dultek.ums.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeViewController {

//    @Autowired
//    private Employee employee;
//    private Address address;
//    private UserCredentials userCredentials;
//    private UserRole userRole;

    @Autowired
    private EmployeeService employeeService;

//    @Autowired
//    public EmployeeViewController(Employee employee,
//                                  Address address,
//                                  UserCredentials userCredentials,
//                                  UserRole userRole,
//                                  EmployeeService employeeService) {
//        this.employee = employee;
//        this.address = address;
//        this.userCredentials = userCredentials;
//        this.userRole = userRole;
//        this.employeeService = employeeService;
//    }

    @GetMapping("/profile")
    public String profile() {
        return "emp_welcome";
    }

    @PostMapping("/login")
    public String loginPageInitial() {
        return "welcomeBar";
    }
    @GetMapping("/list")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list";
    }

    @GetMapping("/{employeeId}")
    public String getEmployeeById(@PathVariable Long employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "employee-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/addEmployee")
    public String createNewUser(Model model) {
        Employee employee = new Employee();
        Address address = new Address();
        UserCredentials userCredentials = new UserCredentials();
        UserRole userRole = new UserRole();

        model.addAttribute("employee", employee);
        model.addAttribute("address", address);
        model.addAttribute("userCredentials", userCredentials);
        model.addAttribute("userRole", userRole);
        return "add-employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }


}

