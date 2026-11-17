package com.example.SpringFeatures.dtos;

import com.example.SpringFeatures.Annotations.NameCheckerAnnotation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long productId;

    @NotEmpty
    @NameCheckerAnnotation
    private String name;

    @Size(max = 100)
    private String category;

    private LocalDateTime creationTime;

    private LocalDateTime updationTime;
}
