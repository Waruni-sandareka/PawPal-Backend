package lk.pawpal.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    public Product() {

    }

    public Product(String productImg, String productName, String description, Double price) {

        this.productImg = productImg;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productImg;
    private String productName;
    private String description;
    private Double price;

}
