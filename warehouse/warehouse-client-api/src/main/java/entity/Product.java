package entity;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private String name;
    private String category;
    //TODO lehet szám
    private String quantity;
    private String unit;
    private BigDecimal purchasePrice;
    private BigDecimal sellingPrice;
    private String description;

}
