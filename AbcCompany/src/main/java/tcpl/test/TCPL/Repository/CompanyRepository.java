package tcpl.test.TCPL.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AbcCompany.test.Abc.Entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
