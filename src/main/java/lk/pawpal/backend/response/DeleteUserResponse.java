package lk.pawpal.backend.response;

import lk.pawpal.backend.model.User;
import lombok.Data;

@Data
public class DeleteUserResponse {
    private String message;
    private Integer code;
    private User user;
}
