package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private String name;
    private String category;
    private String quantity;
    private String unit;
    private Double purchasePrice;
    private Double sellingPrice;
    private String description;
}
