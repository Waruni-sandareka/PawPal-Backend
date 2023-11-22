package lk.pawpal.backend.response;

import lk.pawpal.backend.model.Pet;
import lombok.Data;

@Data
public class AddPetResponse {
    private String message;
    private Integer code;
    private Pet pet;
}
