package mn.icode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Service;

public interface ServiceRepository  extends JpaRepository<Service, Long>{

}
