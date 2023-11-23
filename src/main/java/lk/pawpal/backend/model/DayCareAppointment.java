package lk.pawpal.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class DayCareAppointment extends Appointment{

    public DayCareAppointment(){

    }

    public DayCareAppointment(String appointmentType, Date appointmentDate, Time appointmentTime, Pet pet, boolean vaccinationConfirmation, List<PetSupply> petSupplies) {
        super(appointmentType, appointmentDate, appointmentTime, pet);
        this.vaccinationConfirmation = vaccinationConfirmation;
        this.petSupplies = petSupplies;
    }

    private boolean vaccinationConfirmation;

    @OneToMany(mappedBy = "dayCareAppointment")
    private List<PetSupply> petSupplies;

}
