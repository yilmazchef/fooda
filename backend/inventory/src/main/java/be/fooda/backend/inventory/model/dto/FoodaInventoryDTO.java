package be.fooda.backend.inventory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class FoodaInventoryDTO {

    private Long id;
    
    private Long productId;
    
    private Long storeId;

    @NotNull
    private String sku;

    private String batchCode;
    
    @Min(value = 1, message = "Stock quantity must be higher than 0")
    private Integer stockQuantity;
}