package be.fooda.backend.inventory.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class FoodaInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long productId;
    
    private Long storeId;

    @NotNull
    private String sku;

    private String batchCode;
    
    @Min(value = 1, message = "Stock quantity must be higher than 0")
    private Integer stockQuantity;
}