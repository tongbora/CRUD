package org.istad.crud.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductBody(
        @NotNull
        String name,
        String brand,
        String category,
        @NotNull @Min(1)
        Double price,
        @Column(columnDefinition = "TEXT")
        String description,
        String imageFileName
) {
}
