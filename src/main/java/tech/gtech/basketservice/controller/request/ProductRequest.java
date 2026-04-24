package tech.gtech.basketservice.controller.request;

import lombok.Builder;

@Builder
public record ProductRequest (Long id, Integer quantity) {
}
