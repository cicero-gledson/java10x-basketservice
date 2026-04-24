package tech.gtech.basketservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.gtech.basketservice.client.PlatziStoreClient;
import tech.gtech.basketservice.client.response.PlatziProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAllProducts() {
        log.info("Getting all products");
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#productId")
    public PlatziProductResponse getProductById(Long productId) {
        log.info("Getting product with id: {}", productId);
        return platziStoreClient.getProductById(productId);
    }

}
