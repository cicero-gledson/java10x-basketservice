package tech.gtech.basketservice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Getter @Setter
public class Product {
    private Long id;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
