package lk.pawpal.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Pet {

    public Pet() {
    }

    public Pet(String name, String type, String breed, String sex, Double weight, String size, Integer age, String energyLevel, String medicationType, Boolean isHouseTrained, Boolean isFriendlyWithChildren, User user) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.sex = sex;
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.energyLevel = energyLevel;
        this.medicationType = medicationType;
        this.isHouseTrained = isHouseTrained;
        this.isFriendlyWithChildren = isFriendlyWithChildren;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pet_id")
    private Integer petId;
    private String name;
    private String type;
    private String breed;
    private String sex;
    private Double weight;
    private String size;
    private Integer age;
    private String energyLevel;
    private String medicationType;
    private Boolean isHouseTrained;
    private Boolean isFriendlyWithChildren;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

}
