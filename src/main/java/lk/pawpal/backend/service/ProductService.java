package lk.pawpal.backend.service;

import lk.pawpal.backend.model.Product;
import lk.pawpal.backend.model.User;
import lk.pawpal.backend.repository.ProductRepository;
import lk.pawpal.backend.response.DeleteProductResponse;
import lk.pawpal.backend.response.DeleteUserResponse;
import lk.pawpal.backend.response.ProductAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductAddResponse addProduct(Product product) {
        ProductAddResponse response = new ProductAddResponse();

        Product pro = new Product(product.getProductImg(),product.getProductName(),product.getDescription(),product.getPrice());

        try {
            Product savedProduct = productRepository.save(pro);

            response.setCode(1);
            response.setMessage("Successfully Added a Product");
            response.setProduct(savedProduct);
            return response;

        } catch (Exception e) {
            System.out.println(e.toString());
            response.setCode(-1);
            response.setMessage("Something went wrong");
            response.setProduct(null);
            return response;
        }
    }

    public Iterable<Product> getAllProductList() {

        return  productRepository.findAll();
    }

    public DeleteProductResponse deleteProductById(Integer productId) {
        DeleteProductResponse response = new DeleteProductResponse();

        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product productToDelete = productOptional.get();

            //  delete the product
            productRepository.delete(productToDelete);

            response.setMessage("product deleted successfully");
            response.setCode(200);
            response.setProduct(productToDelete);
        } else {
            response.setMessage("Product not found with ID: " + productId);
            response.setCode(404);
            response.setProduct(null);
        }

        return response;
    }

    public ProductAddResponse updateProduct(Integer productId, Product updatedProduct) {
        ProductAddResponse response = new ProductAddResponse();

        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();

            // Update the existing product with the new details
            existingProduct.setProductImg(updatedProduct.getProductImg());
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());

            try {
                // Save the updated product
                Product savedProduct = productRepository.save(existingProduct);

                response.setCode(1);
                response.setMessage("Successfully Updated the Product");
                response.setProduct(savedProduct);
                return response;

            } catch (Exception e) {
                System.out.println(e.toString());
                response.setCode(-1);
                response.setMessage("Something went wrong");
                response.setProduct(null);
                return response;
            }
        } else {
            response.setMessage("Product not found with ID: " + productId);
            response.setCode(404);
            response.setProduct(null);
            return response;
        }
    }

}
