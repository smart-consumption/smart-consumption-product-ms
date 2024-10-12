package com.unicauca.smart_consumption.domain.product;

import java.util.Objects;

public record Detail(String description, String specifications) {

    public Detail {
        if (!Objects.nonNull(description) || description.trim().isEmpty()) {
            throw new IllegalArgumentException("The description cannot be null or empty.");
        }
    }
}
