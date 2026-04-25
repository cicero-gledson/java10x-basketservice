package tech.gtech.basketservice.controller;

import feign.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.gtech.basketservice.controller.request.BasketRequest;
import tech.gtech.basketservice.controller.request.PaymentRequest;
import tech.gtech.basketservice.entity.Basket;
import tech.gtech.basketservice.service.BasketService;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Basket>> getBasketById(){
        return ResponseEntity.ok(basketService.getBaskets());
    }

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest basketRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.createBasket(basketRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable String id, @RequestBody BasketRequest basketRequest){
        return  ResponseEntity.ok(basketService.updateBasket(id, basketRequest));
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Basket> payBasket(@PathVariable String id, @RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.status(HttpStatus.OK).body(basketService.payBasket(id, paymentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable String id){
        basketService.deleteBasket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
