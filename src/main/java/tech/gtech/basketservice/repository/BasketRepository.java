package tech.gtech.basketservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.gtech.basketservice.entity.Basket;
import tech.gtech.basketservice.entity.StatusBasket;

import java.util.Optional;

@Repository
public interface BasketRepository extends MongoRepository<Basket, String> {
    Optional<Basket> findByClientAndStatus(Long client, StatusBasket status);
}
