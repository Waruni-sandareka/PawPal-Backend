package lk.pawpal.backend.response;

import lk.pawpal.backend.model.Appointment;
import lombok.Data;

@Data
public class BookAppointmentResponse {
    private String message;
    private Integer code;
    private Appointment appointment;
}
