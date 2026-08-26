package mn.icode.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employeeId;
}
