package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

}
