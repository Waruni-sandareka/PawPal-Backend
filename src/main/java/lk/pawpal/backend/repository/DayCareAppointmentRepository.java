package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.DayCareAppointment;
import lk.pawpal.backend.model.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayCareAppointmentRepository extends CrudRepository<DayCareAppointment, Integer> {

    @Query(value = "SELECT*FROM day_care_appointment WHERE pet_id=:pet_id",nativeQuery = true)
    public List<DayCareAppointment> getDayCareAppointmentDetailsById(@Param(value="pet_id")Integer pet_id);


}
