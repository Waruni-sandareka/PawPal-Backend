package lk.pawpal.backend.response;

import lk.pawpal.backend.model.Owner;
import lombok.Data;

@Data
public class OwnerResponse {
    private String message;
    private String code;
    private Owner owner;

}
