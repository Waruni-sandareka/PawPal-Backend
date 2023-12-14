package lk.pawpal.backend.controller;

import lk.pawpal.backend.model.Product;
import lk.pawpal.backend.response.DeleteProductResponse;
import lk.pawpal.backend.response.ProductAddResponse;
import lk.pawpal.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ProductAddResponse addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getAllProductList")
    public Iterable<Product> getAllProductList(){

        return productService.getAllProductList();
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public DeleteProductResponse deleteProductById(@PathVariable Integer productId){
        return productService.deleteProductById(productId);
    }

    @PutMapping("/updateProduct/{productId}")
    public ProductAddResponse updateProduct(@PathVariable Integer productId, @RequestBody Product updatedProduct) {
        return productService.updateProduct(productId, updatedProduct);
    }

}
