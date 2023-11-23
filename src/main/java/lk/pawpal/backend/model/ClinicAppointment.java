package lk.pawpal.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
public class ClinicAppointment extends Appointment{

    public ClinicAppointment(){

    }

    public ClinicAppointment(String appointmentType, Date appointmentDate, Time appointmentTime, Pet pet, String urgencyLevel) {
        super(appointmentType, appointmentDate, appointmentTime, pet);
        this.urgencyLevel = urgencyLevel;
    }

    private String urgencyLevel;

}
