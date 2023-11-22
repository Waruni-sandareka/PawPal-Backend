package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet,Integer> {

    @Query(value = "SELECT*FROM pet WHERE user_id=:user_id",nativeQuery = true)
    public List<Pet> getAllPetsByUserId(@Param(value="user_id")Integer user_id);

    //getPets()

}
