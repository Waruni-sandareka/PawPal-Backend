package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.DayCareAppointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayCareAppointmentRepository extends CrudRepository<DayCareAppointment, Integer> {
}
