package lk.pawpal.backend.repository;

import lk.pawpal.backend.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    @Query("SELECT o FROM Owner o WHERE email=:email")
    public Owner getDetails(@Param(value = "email")String email);


}
