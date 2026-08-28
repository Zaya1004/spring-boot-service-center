package mn.icode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.AppointmentService;

public interface AppointmentServiceRepository extends JpaRepository<AppointmentService, Long  >{

}
