package lk.pawpal.backend.service;

import lk.pawpal.backend.model.ClinicAppointment;
import lk.pawpal.backend.model.DayCareAppointment;
import lk.pawpal.backend.model.PetSupply;
import lk.pawpal.backend.repository.ClinicAppointmentRepository;
import lk.pawpal.backend.repository.DayCareAppointmentRepository;
import lk.pawpal.backend.response.ClinicAppointmentResponse;
import lk.pawpal.backend.response.DayCareAppointmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    ClinicAppointmentRepository clinicAppointmentRepository;

    @Autowired
    DayCareAppointmentRepository dayCareAppointmentRepository;

    public ClinicAppointmentResponse bookClinicAppointment(ClinicAppointment clinicAppointment) {

        ClinicAppointmentResponse response = new ClinicAppointmentResponse();
        ClinicAppointment ca = new ClinicAppointment(clinicAppointment.getAppointmentType(),clinicAppointment.getAppointmentDate(),clinicAppointment.getAppointmentTime(),clinicAppointment.getPet(), clinicAppointment.getUrgencyLevel());

        try{
            ClinicAppointment savedClinicAppointment = clinicAppointmentRepository.save(clinicAppointment);
            response.setCode(1);
            response.setMessage("Successfully Booked Clinic Appointment");
            response.setClinicAppointment(savedClinicAppointment);
            return response;
        } catch (Exception e) {
            System.out.println(e.toString());
            response.setCode(-1);
            response.setMessage("Something went wrong");
            response.setClinicAppointment(null);
            return response;
        }
    }

    public DayCareAppointmentResponse bookDayCareAppointment(DayCareAppointment dayCareAppointment) {

        DayCareAppointmentResponse response = new DayCareAppointmentResponse();

        try {

            DayCareAppointment appointment = new DayCareAppointment(dayCareAppointment.getAppointmentType(),
                                                                    dayCareAppointment.getAppointmentDate(),
                                                                    dayCareAppointment.getAppointmentTime(),
                                                                    dayCareAppointment.getPet(),
                                                                    dayCareAppointment.isVaccinationConfirmation());

            // Set the dayCareAppointment in each PetSupply to establish the relationship
            List<PetSupply> petSupplies = dayCareAppointment.getPetSupplies();

            if (petSupplies != null) {
                for (PetSupply petSupply : petSupplies) {
                    PetSupply ps = new PetSupply(petSupply.getSupplyName());
                    appointment.getPetSupplies().add(ps);
                }
            }

            DayCareAppointment savedDayCareAppointment = dayCareAppointmentRepository.save(appointment);

            response.setCode(1);
            response.setMessage("Successfully Booked Day Care Appointment");
            response.setDayCareAppointment(savedDayCareAppointment);
            return response;

        } catch (Exception e) {
            System.out.println(e.toString());
            response.setCode(-1);
            response.setMessage("Something went wrong");
            response.setDayCareAppointment(null);
            return response;
        }

    }
}



