package lk.pawpal.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class PetSupply {

    public PetSupply() {

    }

    public PetSupply(String supplyName) {
        this.supplyName = supplyName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String supplyName;

}
