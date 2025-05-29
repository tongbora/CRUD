package org.istad.crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    @NotBlank
    private String name;
    private String brand;
    private String category;
    @NotNull @Min(0)
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime createdAt;
    private String imageFileName;
}