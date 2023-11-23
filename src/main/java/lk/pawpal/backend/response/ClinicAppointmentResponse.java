package lk.pawpal.backend.response;

import lk.pawpal.backend.model.ClinicAppointment;
import lombok.Data;

@Data
public class ClinicAppointmentResponse {
    private String message;
    private Integer code;
    private ClinicAppointment clinicAppointment;
}
