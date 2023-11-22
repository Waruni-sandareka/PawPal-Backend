package lk.pawpal.backend.response;

import lk.pawpal.backend.model.Pet;
import lombok.Data;

import java.util.List;

@Data
public class GetPetResponse {
    private String message;
    private Integer code;
    private List<Pet> pets;
}
