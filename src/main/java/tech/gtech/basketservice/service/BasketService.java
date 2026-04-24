package tech.gtech.basketservice.service;

import io.micrometer.observation.ObservationFilter;
import org.springframework.stereotype.Service;
import tech.gtech.basketservice.client.response.PlatziProductResponse;
import tech.gtech.basketservice.controller.request.BasketRequest;
import tech.gtech.basketservice.entity.Basket;
import tech.gtech.basketservice.entity.Product;
import tech.gtech.basketservice.entity.StatusBasket;
import tech.gtech.basketservice.repository.BasketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    private final BasketRepository basketRepository;
    private final ProductService productService;

    public BasketService(BasketRepository basketRepository, ProductService productService) {
        this.basketRepository = basketRepository;
        this.productService = productService;
    }

    public Basket createBasket(BasketRequest basketRequest) {

        basketRepository.findByClientAndStatus(basketRequest.clientId(), StatusBasket.OPEN)
                .ifPresent(basket -> {
                    throw new RuntimeException("The client already has an open basket");
                });

        List<Product> products = new ArrayList<>();

        basketRequest.products().forEach(productRequest -> {
            PlatziProductResponse platziProductResponse = productService.getProductById(productRequest.id());
            products.add(Product.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(productRequest.quantity())
                    .build());

        });

        Basket basket = Basket.builder()
                .client(basketRequest.clientId())
                .status(StatusBasket.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }


    public Basket getBasketById(String id) {
        return basketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Basket updateBasket(String basketId, BasketRequest basketRequest) {
        Basket basket = getBasketById(basketId);

        List<Product> products = new ArrayList<>();

        basketRequest.products().forEach(productRequest -> {
            PlatziProductResponse platziProductResponse = productService.getProductById(productRequest.id());
            products.add(Product.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(productRequest.quantity())
                    .build());

        });

        basket.setProducts(products);
        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }
}
