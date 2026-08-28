package mn.icode.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "appointment_service")
public class AppointmentService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "appointment_id", nullable = false)
	private Appointment appointmentId;
	
	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private Service serviceId;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal price;
	
	public AppointmentService() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Appointment getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Appointment appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Service getServiceId() {
		return serviceId;
	}

	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
