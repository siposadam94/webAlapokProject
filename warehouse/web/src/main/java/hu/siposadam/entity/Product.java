package hu.siposadam.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
//    @SequenceGenerator(name="product_generator", sequenceName = "prod_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "név mező közelező")
    private String name;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;

    //TODO lehet szám
    private String quantity;

    @ManyToOne()
    @JoinColumn(name="unit_id")
    private Unit unit;

    @Column(name = "purchase_price")
    @DecimalMin(value = "0.0", message = "purchase price must positive number")
    private BigDecimal purchasePrice;

    @Column(name = "selling_price")
    @DecimalMin(value = "0.0", inclusive = false, message = "selling price must be greater than 0$")
    private BigDecimal sellingPrice;

    private String description;
}
