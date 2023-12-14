package lk.pawpal.backend.response;

import lk.pawpal.backend.model.DayCareAppointment;
import lombok.Data;

import java.util.List;

@Data
public class GetDayCareAppointmentResponse {
        private String message;
        private Integer code;
        private List<DayCareAppointment> dayCareAppointments;

}
