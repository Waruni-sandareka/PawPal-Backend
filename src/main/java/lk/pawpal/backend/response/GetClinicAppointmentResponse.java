package lk.pawpal.backend.response;

import lk.pawpal.backend.model.ClinicAppointment;
import lombok.Data;

import java.util.List;
@Data
public class GetClinicAppointmentResponse {
    private String message;
    private Integer code;
    private List<ClinicAppointment> clinicAppointments;
}
