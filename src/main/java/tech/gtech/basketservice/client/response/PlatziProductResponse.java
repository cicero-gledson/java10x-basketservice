package tech.gtech.basketservice.client.response;

import java.math.BigDecimal;

public record PlatziProductResponse(Long id, String title, BigDecimal price) {
}
