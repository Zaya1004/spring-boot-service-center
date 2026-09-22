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
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private Service service;
	
	@Column(name = "service_name", nullable = false)
	private String serviceName;
	
	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

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
		return appointment;
	}

	public void setAppointmentId(Appointment appointmentId) {
		this.appointment = appointmentId;
	}

	public Service getServiceId() {
		return service;
	}

	public void setServiceId(Service serviceId) {
		this.service = serviceId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
