package tech.gtech.basketservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.gtech.basketservice.client.response.PlatziProductResponse;
import tech.gtech.basketservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<PlatziProductResponse>> getAllProductcs(){
        List<PlatziProductResponse> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatziProductResponse> getProductById(@PathVariable Long id){
        PlatziProductResponse productById = productService.getProductById(id);
        return ResponseEntity.ok(productById);
    }

}
