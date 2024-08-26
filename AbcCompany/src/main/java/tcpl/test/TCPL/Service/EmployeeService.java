package tcpl.test.TCPL.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import AbcCompany.test.Abc.Entity.Company;
import AbcCompany.test.Abc.Entity.Employee;
import tcpl.test.TCPL.Repository.CompanyRepository;
import tcpl.test.TCPL.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getEmployeeByCompany(Long companyId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        return employeeRepository.findByCompanies_Id(companyId, pageable);
    }
}
