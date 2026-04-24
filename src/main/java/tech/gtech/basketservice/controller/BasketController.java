package tech.gtech.basketservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.gtech.basketservice.controller.request.BasketRequest;
import tech.gtech.basketservice.entity.Basket;
import tech.gtech.basketservice.service.BasketService;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable String id){
        return ResponseEntity.ok(basketService.getBasketById(id));

    }

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest basketRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.createBasket(basketRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable String id, @RequestBody BasketRequest basketRequest){
        return  ResponseEntity.ok(basketService.updateBasket(id, basketRequest));
    }



}
