package AbcCompany.test.ABC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import AbcCompany.test.Abc.Entity.Company;
import AbcCompany.test.Abc.Entity.Employee;
import tcpl.test.TCPL.Repository.CompanyRepository;
import tcpl.test.TCPL.Repository.EmployeeRepository;

@Configuration
public class Config {

    @Autowired 
    private EmployeeRepository employeeRepository;
    
    @Autowired 
    private CompanyRepository companyRepository;
    
    @Bean 
    public CommandLineRunner loadData() {
        return args -> { 
            // Create company
            Company comp = new Company(); 
            comp.setName("ABC company");
            comp.setCity("chennai");
            
            // Create employees
            Employee emp1 = new Employee();
            emp1.setName("Prasanth");
            emp1.setAge(25);
            emp1.setCity("chennai");
            
            Employee emp2 = new Employee();
            emp2.setName("Manoj");
            emp2.setAge(25);
            emp2.setCity("chennai");
            
            // Establish relationships
            comp.getEmployees().add(emp1);
            comp.getEmployees().add(emp2);
            
            emp1.getCompanies().add(comp);
            emp2.getCompanies().add(comp);
            
            // Save entities
            companyRepository.save(comp);
            employeeRepository.save(emp1);
            employeeRepository.save(emp2);
        };
    }
}
