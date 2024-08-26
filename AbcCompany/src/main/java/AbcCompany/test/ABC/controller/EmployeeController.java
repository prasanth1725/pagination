package AbcCompany.test.ABC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import AbcCompany.test.Abc.Entity.Employee;
import tcpl.test.TCPL.Service.EmployeeService;

@RestController
@RequestMapping("api/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/company/{companyId}")
    public Page<Employee> getEmployeeByCompany(
            @PathVariable Long companyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return employeeService.getEmployeeByCompany(companyId, page, size);
    }
}
