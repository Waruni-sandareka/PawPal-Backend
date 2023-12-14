package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.Appointment;
import lk.pawpal.backend.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

    void deleteByPet(Pet pet);
}
