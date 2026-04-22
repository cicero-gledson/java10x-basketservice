package tech.gtech.basketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.gtech.basketservice.client.PlatziStoreClient;
import tech.gtech.basketservice.client.response.PlatziProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    public List<PlatziProductResponse> getAllProducts() {
        return platziStoreClient.getAllProducts();
    }

    public PlatziProductResponse getProductById(Long id) {
        return platziStoreClient.getProductById(id);
    }

}
