package lk.pawpal.backend.response;

import lk.pawpal.backend.model.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String message;
    private Integer code;
    private User user;
}
