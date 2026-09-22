package mn.icode.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppointmentRequest {
	private LocalDate appointmentDate;
	private LocalTime startTime;
	private Long employeeId;
}
