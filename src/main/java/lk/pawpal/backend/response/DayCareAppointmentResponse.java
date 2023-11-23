package lk.pawpal.backend.response;

import lk.pawpal.backend.model.DayCareAppointment;
import lombok.Data;

@Data
public class DayCareAppointmentResponse {
    private String message;
    private Integer code;
    private DayCareAppointment dayCareAppointment;
}
