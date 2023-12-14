package lk.pawpal.backend.controller;

import lk.pawpal.backend.model.Appointment;
import lk.pawpal.backend.model.ClinicAppointment;
import lk.pawpal.backend.model.DayCareAppointment;
import lk.pawpal.backend.response.ClinicAppointmentResponse;
import lk.pawpal.backend.response.DayCareAppointmentResponse;
import lk.pawpal.backend.response.GetClinicAppointmentResponse;
import lk.pawpal.backend.response.GetDayCareAppointmentResponse;
import lk.pawpal.backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book-clinic-appointment")
    public ClinicAppointmentResponse bookClinicAppointment(@RequestBody ClinicAppointment clinicAppointment){
        return appointmentService.bookClinicAppointment(clinicAppointment);
    }

    @PostMapping("/book-daycare-appointment")
    public DayCareAppointmentResponse dayCareAppointment(@RequestBody DayCareAppointment dayCareAppointment){
        return appointmentService.bookDayCareAppointment(dayCareAppointment);
    }

    @GetMapping("/getAppointmentDetailsById/{petId}")
    public GetDayCareAppointmentResponse getDayCareAppointmentDetailsById(@PathVariable Integer petId){
        return appointmentService.getDayCareAppointmentDetailsById(petId);
    }

    @GetMapping("/getClinicAppointmentDetailsById/{petId}")
    public GetClinicAppointmentResponse getClinicAppointmentDetailsById(@PathVariable Integer petId){
        return appointmentService.getClinicAppointmentDetailsById(petId);
    }

    @GetMapping("/getAllAppointmentList")
    public Iterable<Appointment> getAllAppointmentList(){
        return appointmentService.getAllAppointmentList();
    }

}
