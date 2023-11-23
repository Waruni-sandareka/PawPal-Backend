package lk.pawpal.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class PetSupply {

    public PetSupply() {

    }


    public PetSupply(Integer id, String supplyName, DayCareAppointment dayCareAppointment) {
        this.id = id;
        this.supplyName = supplyName;
        this.dayCareAppointment = dayCareAppointment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String supplyName;

    @ManyToOne
    @JoinColumn(name = "daycare_appointment_id", referencedColumnName = "appointment_id")
    private DayCareAppointment dayCareAppointment;

}
