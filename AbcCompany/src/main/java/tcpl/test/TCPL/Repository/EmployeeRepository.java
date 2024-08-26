package tcpl.test.TCPL.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AbcCompany.test.Abc.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByCompanies_Id(Long companyId, Pageable pageable);
}
