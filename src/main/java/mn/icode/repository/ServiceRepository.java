package mn.icode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Service;

public interface ServiceRepository  extends JpaRepository<Service, Long>{

	List<Service> findByActiveTrue();

    List<Service> findByCategoryId(Long categoryId);

    List<Service> findByNameContainingIgnoreCase(String name);
}
