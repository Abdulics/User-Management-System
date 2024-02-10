package com.dultek.ums.controller;

import com.dultek.ums.model.*;
import com.dultek.ums.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeViewController {

//    @Autowired
    private Employee employee;
    private Address address;
    private UserCredentials userCredentials;
    private UserRole userRole;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
   private UserCredentialsService userCredentialsService;
    @Autowired
   private UserRoleService userRoleService;
    @Autowired
    private AddressService addressService;

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
        FormData formData = new FormData();

        model.addAttribute("employee", employee);
        model.addAttribute("address", address);
        model.addAttribute("userCredentials", userCredentials);
        model.addAttribute("userRole", userRole);
        model.addAttribute("formData", formData);
        return "add-employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute FormData formData) {
        // Extract data from the FormData object
        employee = formData.getEmployee();
        address = formData.getAddress();
        userCredentials = formData.getUserCredentials();
        userRole = formData.getUserRole();

        // Associate the address with the employee
        address.setEmployee(employee);
        employee.setAddress(address);

        // Associate the user credentials with the employee
        userCredentials.setEmployee(employee);
        employee.setCredentials(userCredentials);

        // Associate the user role with the user credentials
        userRole.setUserCredentials(userCredentials);
        userCredentials.setRole(userRole);

        // Save the employee, which will cascade the save operation to associated entities
        employeeService.saveEmployee(employee);

        // Redirect to the employee list page
        return "redirect:/employees/list";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        employee = employeeService.getEmployeeById(id);
        userCredentials = userCredentialsService.getUserCredentialsByEmployeeId(employee.getEmployeeId());
        userRole = userRoleService.getUserRolesByUserCredentialsId(userCredentials.getCredentialId());
        address = employee.getAddress();
        userCredentials.setRole(userRole);
        employee.setCredentials(userCredentials);

        model.addAttribute("employee", employee);
        model.addAttribute("credentials",userCredentials);
        //model.addAttribute("userRole",userRole);
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }


}

