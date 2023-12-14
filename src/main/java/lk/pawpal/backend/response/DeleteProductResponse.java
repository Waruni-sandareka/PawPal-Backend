package lk.pawpal.backend.response;

import lk.pawpal.backend.model.Product;
import lk.pawpal.backend.model.User;
import lombok.Data;

@Data
public class DeleteProductResponse {
    private String message;
    private Integer code;
    private Product product;
}
