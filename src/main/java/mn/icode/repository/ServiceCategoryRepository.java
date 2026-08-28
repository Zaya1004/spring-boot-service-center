package mn.icode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.ServiceCategory;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long>{

}
