package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.ClinicAppointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicAppointmentRepository extends CrudRepository<ClinicAppointment, Integer> {

    @Query(value = "SELECT*FROM clinic_appointment WHERE pet_id=:pet_id",nativeQuery = true)
    public List<ClinicAppointment> getClinicAppointmentDetailsById(@Param(value="pet_id")Integer pet_id);
}
