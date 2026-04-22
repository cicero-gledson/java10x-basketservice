package tech.gtech.basketservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.gtech.basketservice.client.response.PlatziProductResponse;

import java.util.List;

@FeignClient (name = "PlatzStoreClient", url = "${basket.client.platzi}" )
public interface PlatziStoreClient {

    @GetMapping("/products")
    List<PlatziProductResponse> getAllProducts();

    @GetMapping("/products/{id}")
    PlatziProductResponse getProductById(@PathVariable Long id);
}
