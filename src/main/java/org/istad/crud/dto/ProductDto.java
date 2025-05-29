package org.istad.crud.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDto(
        @Column(unique = true, nullable = false)
        Integer id,
        @NotNull
        String name,
        String brand,
        String category,
        @NotNull @Size(min = 1)
        Double price,
        String description,
        String imageFileName
) {
}
