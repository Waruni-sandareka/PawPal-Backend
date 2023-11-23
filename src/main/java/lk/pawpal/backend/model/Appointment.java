package lk.pawpal.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;


@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Appointment {

    public Appointment() {
    }

    public Appointment(String appointmentType, Date appointmentDate, Time appointmentTime, Pet pet) {
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.pet = pet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Integer appointmentId;
    private String appointmentType;
    private Date appointmentDate;
    private Time appointmentTime;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    private Pet pet;

}
