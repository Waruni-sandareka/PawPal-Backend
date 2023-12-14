package lk.pawpal.backend.service;

import lk.pawpal.backend.model.*;
import lk.pawpal.backend.repository.AppointmentRepository;
import lk.pawpal.backend.repository.ClinicAppointmentRepository;
import lk.pawpal.backend.repository.DayCareAppointmentRepository;
import lk.pawpal.backend.response.ClinicAppointmentResponse;
import lk.pawpal.backend.response.DayCareAppointmentResponse;
import lk.pawpal.backend.response.GetClinicAppointmentResponse;
import lk.pawpal.backend.response.GetDayCareAppointmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    ClinicAppointmentRepository clinicAppointmentRepository;

    @Autowired
    DayCareAppointmentRepository dayCareAppointmentRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

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

    public GetDayCareAppointmentResponse getDayCareAppointmentDetailsById(Integer petId) {

        GetDayCareAppointmentResponse response = new GetDayCareAppointmentResponse();

        try {
            List<DayCareAppointment> dayCareAppointments = dayCareAppointmentRepository.getDayCareAppointmentDetailsById(petId);
            LocalDateTime currentDateTime = LocalDateTime.now();

            //Filter Out Upcoming Appointments
            List<DayCareAppointment> upcomingAppointments = new ArrayList<>();

            for (DayCareAppointment appointment : dayCareAppointments) {
                Date appointmentDate = appointment.getAppointmentDate();

                if (appointmentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                        .compareTo(currentDateTime) > 0) {
                    upcomingAppointments.add(appointment);
                }
            }

            if (!upcomingAppointments.isEmpty()) {
                response.setMessage("Upcoming Day Care Appointments Details retrieved successfully!");
                response.setCode(1);
                response.setDayCareAppointments(upcomingAppointments);
            } else {
                response.setMessage("No upcoming Day Care Appointments found!");
                response.setCode(0);
            }
        } catch (Exception e) {
            response.setMessage("Error occurred!");
            response.setCode(-1);
        }
        return response;
    }

    public GetClinicAppointmentResponse getClinicAppointmentDetailsById(Integer petId) {

        GetClinicAppointmentResponse response = new GetClinicAppointmentResponse();

        try {
            List<ClinicAppointment> clinicAppointments = clinicAppointmentRepository.getClinicAppointmentDetailsById(petId);
            LocalDateTime currentDateTime = LocalDateTime.now();

            //Filter Out Upcoming Appointments
            List<ClinicAppointment> upcomingAppointments = new ArrayList<>();

            for (ClinicAppointment appointment : clinicAppointments) {
                Date appointmentDate = appointment.getAppointmentDate();

                if (appointmentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                        .compareTo(currentDateTime) > 0) {
                    upcomingAppointments.add(appointment);
                }
            }

            if (!upcomingAppointments.isEmpty()) {
                response.setMessage("Upcoming Clinic Appointments Details retrieved successfully!");
                response.setCode(1);
                response.setClinicAppointments(upcomingAppointments);
            } else {
                response.setMessage("No upcoming Clinic Appointments found!");
                response.setCode(0);
            }
        } catch (Exception e) {
            response.setMessage("Error occurred!");
            response.setCode(-1);
        }
        return response;

    }

    public Iterable<Appointment> getAllAppointmentList() {
        return  appointmentRepository.findAll();
    }
}



