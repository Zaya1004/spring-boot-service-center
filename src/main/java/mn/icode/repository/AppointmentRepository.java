package mn.icode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
