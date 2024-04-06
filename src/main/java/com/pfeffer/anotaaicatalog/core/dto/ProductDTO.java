package com.pfeffer.anotaaicatalog.core.dto;

import java.math.BigDecimal;

public record ProductDTO(String id, String title, String description, BigDecimal price, String categoryId, String ownerId) {
}
