package mn.icode.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	
	@Column(name = "appointment_date", nullable = false)
	private Date appointmentDate;
	
	@Column(name = "start_time", nullable = false)
	private LocalDate startTime;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private AppointmentStatus status = AppointmentStatus.Requested;
	
	@Column(length = 1000)
	private String notes;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal totalAmount = BigDecimal.ZERO;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "appointment",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<AppointmentService> appointmentServices = new ArrayList<>();
	
	public Appointment() {}
	
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<AppointmentService> getAppointmentServices() {
		return appointmentServices;
	}

	public void setAppointmentServices(List<AppointmentService> appointmentServices) {
		this.appointmentServices = appointmentServices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}
}
