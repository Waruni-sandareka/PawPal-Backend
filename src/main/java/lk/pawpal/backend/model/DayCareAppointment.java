package lk.pawpal.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class DayCareAppointment extends Appointment{

    public DayCareAppointment(){

    }

    public DayCareAppointment(String appointmentType, Date appointmentDate, Time appointmentTime, Pet pet, boolean vaccinationConfirmation) {
        super(appointmentType, appointmentDate, appointmentTime, pet);
        this.vaccinationConfirmation = vaccinationConfirmation;
    }

    private boolean vaccinationConfirmation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "daycare_appointment_id", referencedColumnName = "appointment_id")
    List<PetSupply> petSupplies = new ArrayList<>();

}
