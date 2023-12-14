package lk.pawpal.backend.response;

import lk.pawpal.backend.model.Product;
import lombok.Data;

@Data
public class ProductAddResponse {
    private String message;
    private Integer code;
    private Product product;
}
