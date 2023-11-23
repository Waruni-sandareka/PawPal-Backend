package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.ClinicAppointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicAppointmentRepository extends CrudRepository<ClinicAppointment, Integer> {
}
